package controller;

import java.util.Date;
import java.util.List;

import model.Album;
import model.Artista;
import model.Dados;
import model.Musica;
import model.Usuario;

public class Controle{
    
    private Dados dados = new Dados();

    public Controle(){

        for (int i = 0; i < 40; i++){
            artista(String.format("%s %d", "Ricardo", i+1), String.format("%s", i), null);
        }

    }

    public void usuario(String nome, String rg){
        dados.adicionarUsuario(new Usuario(nome, rg));
    }

    public void artista(String nome, String rg, String estiloMusical){
        dados.adicionarArtista(new Artista(nome, rg, 0, estiloMusical));
    }

    public void album(String nome, Date data, List<Artista> artistas){
        dados.adicionarAlbum(new Album(nome, data, artistas));
    }

    public void musica(String nome, String letra, Double duracao, Album album){
        dados.adicionarMusica(new Musica(nome, letra, duracao, false, album));
    }

    public Dados getDados(){
        return dados;
    }

}