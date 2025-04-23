const btnCriarStartup = document.getElementById("btnCriarStartup");
const btnSortear = document.getElementById("btnSortear");
const btnAleatorio = document.getElementById("btnAleatorio");



const paginaInicial = document.getElementById("paginaInicial");
const paginaCriar = document.getElementById("paginaCriarStartup");
const paginaSorteio = document.getElementById("paginaSorteio");
const paginaAleatorio = document.getElementById("paginaAleatorio");

let startupsCriadas = 0;


let vencedores = [];

const formCriarStartup = document.getElementById("formCriarStartup");

function escolherBatalha(idBatalha) {
    fetch("/sorteio/escolherBatalha", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ id: idBatalha })
    })
    .then(response => {
        if (!response.ok) throw new Error("Erro ao escolher a batalha");
    })
    .catch(error => {
        console.error("Erro ao enviar ID da batalha:", error);
    });
}

function exibirStartups() {
    fetch("/listarStartups")
        .then(response => response.json())
        .then(startups => {
            const container = document.querySelector(".startup-grid");
            container.innerHTML = "";
            startups.forEach(st => {
                const card = document.createElement("div");
                card.className = "startup-card";
                card.innerHTML = `
                    <h2>${st.nome}</h2>
                    <p><strong>Slogan:</strong> ${st.slogan}</p>
                    <p><strong>Fundação:</strong> ${st.fundacao}</p>
                    <p><strong>Pontuação:</strong> ${st.pontuacao}</p>
                `;
                container.appendChild(card);
            });


        })
        .catch(error => {
            console.error("Erro ao buscar startups:", error);
        });
}
function sortear() {
    if(startupsCriadas !== 8 && startupsCriadas !== 4){
        alert(`Erro ao realizar o sorteio, é necessário ter 4 ou 8 startups criadas. Atualmente o sistema possui ${startupsCriadas}.`);
    }
   fetch("/sorteio")
       .then(response => {
           if (!response.ok) {
               return response.text().then(text => { throw new Error(text) });
           }
           return response.json();
       })
       .then(batalhas => {
           if (batalhas.length === 0) {
               alert("Não há startups criadas para o sorteio.");
               return;
           }

           const container = document.querySelector(".batalhas-grid");
           container.innerHTML = "";

           batalhas.forEach(bt => {
               const card = document.createElement("div");
               card.className = "batalhas-card";
               card.dataset.batalhaid = bt.id;
               card.dataset.st1Id = bt.st1Id;
               card.dataset.st2Id = bt.st2Id;
               console.log(card.dataset.batalhaid);
               console.log(card.dataset.st1Id);
               console.log(card.dataset.st2Id);



               card.innerHTML = `
                  <div class="startup-box">
                      <h3>${bt.name1}</h3>
                      <div class="atributos">
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="1" value="pitch">
                              Pitch convincente
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="1" value="bugs">
                              Produto com bugs
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="1" value="usuarios">
                              Boa tração de usuários
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="1" value="investidorIrritado">
                              Investidor irritado
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="1" value="fakeNews">
                              Fake news no pit
                          </label>
                      </div>
                  </div>
                  <div class="versus">VS</div>
                  <div class="startup-box">
                      <h3>${bt.name2}</h3>
                      <div class="atributos">
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="2" value="pitch">
                              Pitch convincente
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="2" value="bugs">
                              Produto com bugs
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="2" value="usuarios">
                              Boa tração de usuários
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="2" value="investidorIrritado">
                              Investidor irritado
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="2" value="fakeNews">
                              Fake news no pit
                          </label>
                      </div>
                  </div>

                  <button class="btn-submit">Enviar</button>
               `;
               container.appendChild(card);
           });
           mostrarPagina(paginaSorteio);
           return batalhas;
       })
       .catch(error => {
            console.log(error)
       });
}

function pegarDadosBatalha(card) {

    const checkbox1 = card.querySelectorAll('input[type="checkbox"][data-startup="1"]');

    const atributo1 = {};
    atributo1["id"] = card.dataset.st1Id;

    checkbox1.forEach(checkbox => {
        atributo1[checkbox.value] = checkbox.checked ? 1 : 0;
    });

    const checkbox2 = card.querySelectorAll('input[type="checkbox"][data-startup="2"]');
    const atributo2 = {};
    atributo2["id"] = card.dataset.st2Id;

    checkbox2.forEach(checkbox => {
            atributo2[checkbox.value] = checkbox.checked ? 1 : 0;
    });


    return [atributo1,atributo2];
}

const container = document.querySelector('.batalhas-grid');

container.addEventListener('click', function(event) {
    if (event.target && event.target.classList.contains('btn-submit')) {
        const card = event.target.closest('.batalhas-card');
        enviarBatalha(card);
    }
});

async function enviarBatalha(card) {
    const batalhaid = card.dataset.batalhaid;
    console.log(`Batalha Id: ${batalhaid}`)
    const dados = pegarDadosBatalha(card);


        try {
            const response = await fetch(`/sorteio/rodada/${batalhaid}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(dados),
            });

            if (!response.ok) throw new Error("Erro ao enviar dados.");

            const data = await response.json();
            alert("Enviado!");
            await getVencedor(batalhaid);
            verificarSeBatalhasFinalizaram();
        } catch (error) {
            alert(error);
        }
}

async function getVencedor(id){
     try {
            const response = await fetch(`/sorteio/rodada/ganhador/${id}`);
            if (!response.ok) throw new Error("Erro ao obter vencedor.");
            const data = await response.json();
            console.log('Ganhador:', data);
            vencedores.push(data);
        } catch (error) {
            console.log(error);
        }

}

function exibirVencedor(vencedor) {
    carregarAvaliacoesETabela();
    const container = document.querySelector(".startup-card-vencedor");
    container.innerHTML = `
        <h2>Vencedor da Batalha</h2>
        <h2>${vencedor.nome}</h2>
        <p><strong>Slogan:</strong> ${vencedor.slogan}</p>
        <p><strong>Fundação:</strong> ${vencedor.fundacao}</p>
        <p><strong>Pontuação:</strong> ${vencedor.pontuacao}</p>
    `;
    mostrarPagina(document.getElementById("paginaVencedor"));

}

function sortearNovamente(listaDeVencedores) {

   console.log("Vencedores: ", vencedores);
   vencedores = [];

  fetch("/sorteio/novo", {
         method: "PUT",
         headers: {
             'Content-Type': 'application/json',
         },
         body: JSON.stringify(listaDeVencedores)
     })
     .then(response => {
         if (!response.ok) {
             return response.text().then(text => { throw new Error(text) });
         }
         return response.json();
     })
       .then(batalhas => {
           if (batalhas.length === 0) {
               alert("Não há startups criadas para o sorteio.");
               return;
           }

           const container = document.querySelector(".batalhas-grid");
           container.innerHTML = "";

           batalhas.forEach(bt => {
               const card = document.createElement("div");
               card.className = "batalhas-card";
               card.dataset.batalhaid = bt.id;
               card.dataset.st1Id = bt.st1Id;
               card.dataset.st2Id = bt.st2Id;
               console.log(card.dataset.batalhaid);
               console.log(card.dataset.st1Id);
               console.log(card.dataset.st2Id);



               card.innerHTML = `
                  <div class="startup-box">
                      <h3>${bt.name1}</h3>
                      <div class="atributos">
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="1" value="pitch">
                              Pitch convincente
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="1" value="bugs">
                              Produto com bugs
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="1" value="usuarios">
                              Boa tração de usuários
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="1" value="investidorIrritado">
                              Investidor irritado
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="1" value="fakeNews">
                              Fake news no pit
                          </label>
                      </div>
                  </div>
                  <div class="versus">VS</div>
                  <div class="startup-box">
                      <h3>${bt.name2}</h3>
                      <div class="atributos">
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="2" value="pitch">
                              Pitch convincente
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="2" value="bugs">
                              Produto com bugs
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="2" value="usuarios">
                              Boa tração de usuários
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="2" value="investidorIrritado">
                              Investidor irritado
                          </label>
                          <label>
                              <input type="checkbox" class="atributos-checkbox" data-startup="2" value="fakeNews">
                              Fake news no pit
                          </label>
                      </div>
                  </div>
                  <button class="btn-submit">Enviar</button>
               `;
               container.appendChild(card);
           });
           mostrarPagina(paginaSorteio);


           return batalhas;
       })
       .catch(error => {
            console.log(error)
       });
}




function verificarSeBatalhasFinalizaram() {
    fetch("/batalhas/finalizadas")
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao verificar batalhas finalizadas.");
            }
            return response.json();
        })
        .then(finalizadas => {
            if (finalizadas) {
                console.log(Array.isArray(vencedores), vencedores);
                 if (vencedores.length === 1) {
                    console.log(vencedores);
                    exibirVencedor(vencedores[0]);
                 }else {
                    sortearNovamente(vencedores);
                 }
            }
        })
        .catch(error => {
            console.error(error);
        });
}

function getCheckboxValue(card, value) {
    const checkbox = card.querySelector(`input[type="checkbox"][value="${value}"]`);
    return checkbox.checked ? 1 : 0;
}

function iniciarBatalha(){
     paginaStartups.style.display = "none";
     paginaSorteio.style.display = "none";

}
function mostrarPagina(pagina) {
    paginaInicial.style.display = "none";
    paginaCriar.style.display = "none";
    paginaSorteio.style.display = "none";
    paginaVencedor.style.display = "none";
    paginaAleatorio.style.display = "none";

    pagina.style.display = "block";
}


btnCriarStartup.addEventListener("click", () => {
    exibirStartups();
    mostrarPagina(paginaCriar);
});

let batalhas = []

btnSortear.addEventListener("click", () => {
   batalhas = sortear();
});



btnAleatorio.addEventListener("click", ()=>{
    if(startupsCriadas !== 4 && startupsCriadas !==8){
       alert(`Erro ao usar o modo aleatório, é necessário ter 4 ou 8 startups criadas. Atualmente o sistema possui ${startupsCriadas}.`);
    }
    fetch("/aleatorio").
    then(response => {
        if (!response.ok) {
            throw new Error('Erro ao buscar startup aleatória');
        }
        return response.json();
    })
    .then(vencedor => {
         const container = document.querySelector(".startup-card-aleatorio");
                 container.innerHTML = `
                     <h2>Vencedor da Batalha</h2>
                     <h2>${vencedor.nome}</h2>
                     <p><strong>Slogan:</strong> ${vencedor.slogan}</p>
                     <p><strong>Fundação:</strong> ${vencedor.fundacao}</p>
                     <p><strong>Pontuação:</strong> ${vencedor.pontuacao}</p>
                 `;
         mostrarPagina(paginaAleatorio);

    })
    .catch(error => {
         console.error('Erro na requisição:', error);
    });

})

formCriarStartup.addEventListener("submit", (e) => {
    e.preventDefault();

    const nome = document.getElementById("nome").value;
    const slogan = document.getElementById("slogan").value;
    const fundacao = document.getElementById("fundacao").value;

    const novaStartup = {
        nome: nome,
        slogan: slogan,
        fundacao: fundacao
    };

    fetch("/criarStartup", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(novaStartup),
        })
        .then(response => response.json())
        .then(data => {
            console.log("Startup criada:", data);
            alert("Startup Criada.");
            startupsCriadas++;
            exibirStartups();
            document.getElementById("formCriarStartup").reset();
        })
        .catch(error => {
            console.error("Erro ao criar startup:", error);
            alert("Erro ao criar startup.");
        });
    });

function carregarAvaliacoesETabela() {
    fetch("/listarStartups")
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao buscar avaliações.");
            }
            return response.json();
        })
        .then(startups => {
            const tabela = document.getElementById("tabelaAvaliacoes");
            tabela.innerHTML = `
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Pitch</th>
                        <th>Bugs</th>
                        <th>Boa Tração de Usuários</th>
                        <th>Investidor Irritado</th>
                        <th>Fake News</th>
                        <th>Pontuação</th>

                    </tr>
                </thead>
                <tbody>
                    ${startups.map(st => `
                        <tr>
                            <td>${st.nome}</td>
                            <td>${st.avaliacao.pitch}</td>
                            <td>${st.avaliacao.bugs}</td>
                            <td>${st.avaliacao.usuarios}</td>
                            <td>${st.avaliacao.investidorIrritado}</td>
                            <td>${st.avaliacao.fakeNews}</td>
                            <td>${st.pontuacao}</td>

                        </tr>
                    `).join("")}
                </tbody>
            `;
        })
        .catch(error => {
            console.error("Erro ao montar a tabela de avaliações:", error);
        });
}

