const btnCriarStartup = document.getElementById("btnCriarStartup");
const btnVoltarSorteio = document.getElementById("btnVoltarSorteio");

const paginaInicial = document.getElementById("paginaInicial");
const paginaCriar = document.getElementById("paginaCriarStartup");
const paginaSorteio = document.getElementById("paginaSorteio");
const paginaBatalha = document.getElementById("paginaBatalha");

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
    fetch("/sorteio")
        .then(response => response.json())
        .then(batalhas => {
            const container = document.querySelector(".batalhas-grid");
            container.innerHTML = "";
            batalhas.forEach(bt => {
                const card = document.createElement("div");
                card.className = "batalhas-card";
                card.innerHTML = `
                    <div class="startup">
                        <h3>${bt.name1}</h3>
                        <p>${bt.slogan1 || ""}</p>
                    </div>
                    <div class="versus">X</div>
                    <div class="startup">
                        <h3>${bt.name2}</h3>
                        <p>${bt.slogan2 || ""}</p>
                    </div>
                    <button class="btn-iniciar-batalha" onclick="iniciarBatalha(${bt.id})">Iniciar Batalha</button>

                `;
                container.appendChild(card);
            });
        })
        .catch(error => {
            console.error("Erro ao realizar o sorteio:", error);
        });
}

function iniciarBatalha(){
     paginaStartups.style.display = "none";
     paginaSorteio.style.display = "none";
     paginaBatalha.style.display = "block";

}
function mostrarPagina(pagina) {
    paginaInicial.style.display = "none";
    paginaCriar.style.display = "none";
    paginaSorteio.style.display = "none";
    paginaBatalha.style.display = "none";
    pagina.style.display = "block";
}

btnCriarStartup.addEventListener("click", () => {
    mostrarPagina(paginaCriar);
});


btnVoltarSorteio.addEventListener("click", () => {
    mostrarPagina(paginaInicial);
});

document.getElementById("btnVoltarBatalha").addEventListener("click", () => {
    mostrarPagina(paginaInicial);
});

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
            exibirStartups();
            document.getElementById("formCriarStartup").reset();
        })
        .catch(error => {
            console.error("Erro ao criar startup:", error);
            alert("Erro ao criar startup.");
        });
    });