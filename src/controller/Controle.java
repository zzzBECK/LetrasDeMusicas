package controller;

import java.util.Date;
import java.util.List;

import model.Album;
import model.Artista;
import model.Pesquisa;
import model.Usuario;

public class Controle{
    
    private Pesquisa pesquisa = new Pesquisa();

    public Controle(){

        for (int i = 0; i < 40; i++){
            artista(null, null, null);
        }
    }

    public void usuario(String nome, String rg){
        pesquisa.adicionarUsuario(new Usuario(nome, rg));
    }

    public void artista(String nome, String rg, String estiloMusical){
        pesquisa.adicionarArtista(new Artista(nome, rg, 0, estiloMusical));
    }

    public void album(String nome, Date data, List<Artista> artistas){
        pesquisa.adicionarAlbum(new Album(nome, data, artistas));
    }

    public Pesquisa getPesquisa(){
        return pesquisa;
    }

}