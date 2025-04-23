package com.itacademy.desafio.interfaceAdaptadora.repositorios.implementRepositorios;

import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Avaliacao;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Startup;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.interfacesJpa.StartupRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor

public class StartupREPJpa implements IStartupRepositorio {
    private final StartupRepositorio startupRepositorio;

    public List<StartupModel> buscarTodos(){
        List<Startup> startups = this.startupRepositorio.findAll();
        return startups.stream().
                map(startup -> new StartupModel(startup.getId(),startup.getNome(),
                        Avaliacao.toAvaliacaoModel(startup.getAv()),startup.getSlogan(),
                        startup.getFundacao(),
                        startup.getPontuacao()))
                        .toList();
    }

    public StartupModel add(StartupModel st){
        Startup s = Startup.fromStartupModel(st);
        return Startup.toStartupModel(startupRepositorio.save(s));
    }

    public StartupModel buscarPorId(long id){
        return Startup.toStartupModel(startupRepositorio.findById(id));
    }

    public StartupModel atualizarPontos(long id, int pts){
            Startup st = this.startupRepositorio.findById(id);
            Avaliacao avl = st.getAv();
            boolean [] som = avl.isSomado();
            int [] av = avl.getAtributos();
            int pontos = 0;
            for(int i = 0; i < av.length; i++){
                if(!som[i]){
                    pontos += av[i];
                    som[i] = true;
                }
            }
            avl.setSomadoPitch(som[0]);
            avl.setSomadoBugs(som[1]);
            avl.setSomadoUsuarios(som[2]);
            avl.setSomadoInvestidor(som[3]);
            avl.setSomadoFakeNews(som[4]);


            pontos += st.getPontuacao();
            st.setAv(avl);
            st.setPontuacao(pontos + pts);


            this.startupRepositorio.save(st);
            return Startup.toStartupModel(st);
    }

}
