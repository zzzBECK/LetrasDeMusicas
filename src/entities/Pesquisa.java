package entities;

import java.util.ArrayList;
import java.util.List;

public class Pesquisa {
    private List<Artista> artistas = new ArrayList<>();
    {
        System.out.println(artistas);
    }

    public Pesquisa(){

    }

    public void adicionarArtista(Artista artista){
        artistas.add(artista);
    }

    public Artista procurarArtista(String nome){
        Artista art = artistas.stream().filter(x -> x.getNome().toLowerCase().equals(nome.toLowerCase())).findAny().orElse(null);

        return art;
    }
}