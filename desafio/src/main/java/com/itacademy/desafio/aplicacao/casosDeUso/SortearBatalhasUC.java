package com.itacademy.desafio.aplicacao.casosDeUso;

import com.itacademy.desafio.aplicacao.dtos.BatalhaDto;
import com.itacademy.desafio.aplicacao.dtos.StartupDto;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.dominio.servicos.AvaliacaoServico;
import com.itacademy.desafio.dominio.servicos.SorteioServico;
import com.itacademy.desafio.dominio.servicos.ValidadorServico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SortearBatalhasUC {
    private final ValidadorServico validadorServico;
    private final AvaliacaoServico avaliacaoServico;
    private final SorteioServico sorteioServico;

    public SortearBatalhasUC(ValidadorServico validadorServico, AvaliacaoServico avaliacaoServico, SorteioServico sorteioServico) {
        this.validadorServico = validadorServico;
        this.avaliacaoServico = avaliacaoServico;
        this.sorteioServico = sorteioServico;
    }

    public List<BatalhaDto> run(){
        if(!validadorServico.valida()){
            throw new IllegalArgumentException("Deve haver 4 ou 8 startups para iniciar a batalha.");
        }
        return sorteioServico.sortear().stream().map(BatalhaDto::fromModel).toList();
    }

    public List<BatalhaDto> run(List<StartupDto> startupDtos){
        List<StartupModel> models = startupDtos.
                                                stream()
                                                .map(st -> new StartupModel(st.getId()
                                                                        ,st.getNome()
                                                                        ,this.avaliacaoServico.buscarPorId(st.getAvaliacao().getId())
                                                                        ,st.getSlogan(),
                                                                        st.getFundacao(),
                                                                        st.getPontuacao())).toList();
        if(!validadorServico.valida()){
            throw new IllegalArgumentException("As batalhas encerraram.");
        }
        return sorteioServico.sortear(models).stream().map(BatalhaDto::fromModel).toList();
    }



    //TODO: CRIAR UM SERVIÇO QUE LIDA COM A FASE DE BATALHA, CRIAR UM ENDPOINT DE BATALHA
}

