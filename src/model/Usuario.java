package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    
    private String nome;
    private String cpf;

    private List<Artista> artistasSeguidos = new ArrayList<>();

    public Usuario(){

    }

    public Usuario(String nome, String cpf){

        this.nome = nome;
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

        @Override
    public String toString(){
        return "Nome: " + nome + " cpf: " + cpf + " Seguindo: " + artistasSeguidos;
    }

    public void seguirArtista(Artista artista){
        artistasSeguidos.add(artista);
    }

    public void pararDeSeguirArtista(Artista artista){
        artistasSeguidos.remove(artista);
    }


}