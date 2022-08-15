package br.edu.ifsp.aula3.repository;

import java.util.ArrayList;

import br.edu.ifsp.aula3.model.Perfil;

public class PerfilRepository {
    private static PerfilRepository repo;

    private ArrayList<Perfil> perfis;

    private PerfilRepository() {
        this.perfis = new ArrayList<>();
    }

    public static void init() {
        if (PerfilRepository.repo == null) {

            // Criando repositório
            PerfilRepository.repo = new PerfilRepository();

            // Adicionando perfis iniciais
            PerfilRepository.add(
                    new Perfil(
                            170,
                            100,
                            "Menino Ney",
                            "https://i.em.com.br/-oIsOGI00TKL1E2pb-wVc4GxRZs=/790x/smart/imgsapp.em.com.br/app/noticia_127983242361/2022/08/13/1386519/neymar-e-presidente-jair-bolsonaro-pl_1_37517.jpg",                            
                            "São Paulo, Brasil",
                            "ednaldo pereira"));
            PerfilRepository.add(
                    new Perfil(
                            120,
                            10,
                            "Bruno Diferente",
                            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTs0b4QMjAo2wVe2VA9f_clUuqLw08br5P7t4th2UuUyA&s",
                            "São Paulo, Brasil",
                            "messi careca"));
            PerfilRepository.add(
                    new Perfil(
                            90,
                            300,
                            "Kira",
                            "https://i.ytimg.com/vi/Ud5dCb8BiCk/hqdefault.jpg",                            
                            "São Paulo, Brasil",
                            "cavalo"));

        } else {
            System.out.println("O banco já foi inicializado!");
        }
    }

    public static void add(Perfil perfil) {
        PerfilRepository.repo.perfis.add(perfil);
    }

    public static ArrayList<Perfil> all(){
        return PerfilRepository.repo.perfis;
    }

    //Recupera um perfil pelo seu id
    public static Perfil getById(int id) {
        //Usando Collection Stream
        return  PerfilRepository.repo.perfis.stream().filter((perfil) -> perfil.getId() == id).toList().get(0);
    }
}
