package controller;

import model.Artista;
import model.Pesquisa;
import model.Usuario;

public class Controle{
    
    private Pesquisa pesquisa = new Pesquisa();

    public Controle(){

    }

    public void usuario(String nome, String rg){
        pesquisa.adicionarUsuario(new Usuario(nome, rg));
    }

    public void artista(String nome, String rg, String estiloMusical){
        pesquisa.adicionarArtista(new Artista(nome, rg, 0, estiloMusical));
    }


}