package com.itacademy.desafio.interfaceAdaptadora.repositorios.implementRepositorios;

import com.itacademy.desafio.dominio.interfaceRepositorios.IStartupRepositorio;
import com.itacademy.desafio.dominio.modelos.AvaliacaoModel;
import com.itacademy.desafio.dominio.modelos.StartupModel;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Avaliacao;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.entidades.Startup;
import com.itacademy.desafio.interfaceAdaptadora.repositorios.interfacesJpa.StartupRepositorio;
import org.hibernate.sql.ast.tree.expression.Star;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@Primary
public class StartupREPJpa implements IStartupRepositorio {
    private final StartupRepositorio startupRepositorio;
    private static long id;

    public StartupREPJpa(StartupRepositorio startupRepositorio) {
        this.startupRepositorio = startupRepositorio;
        id = 0;
    }

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
