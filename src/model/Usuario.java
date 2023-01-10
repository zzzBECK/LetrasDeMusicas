package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    
    private Integer id;
    private String nome;
    private String rg;

    private List<Artista> artistasSeguidos = new ArrayList<>();

    public Usuario(){

    }

    public Usuario(Integer id, String nome, String rg){

        this.id = id;
        this.nome = nome;
        this.rg = rg;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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