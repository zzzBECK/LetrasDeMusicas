package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    
    private String nome;
    private String rg;

    private List<Artista> artistasSeguidos = new ArrayList<>();

    public Usuario(){

    }

    public Usuario(String nome, String rg){

        this.nome = nome;
        this.rg = rg;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

        @Override
    public String toString(){
        return "Nome: " + nome + " RG: " + rg + " Seguindo: " + artistasSeguidos;
    }

    public void seguirArtista(Artista artista){
        artistasSeguidos.add(artista);
    }

    public void pararDeSeguirArtista(Artista artista){
        artistasSeguidos.remove(artista);
    }


}