package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Usuario, o qual possui um nome e cpf
 * @author Alexandre de Santana Beck
 * @since 2022
 * @version 1.0
 */
public class Usuario {

    private String nome;
    private String cpf;

    private List<Artista> artistasSeguidos = new ArrayList<>();

    /**
     * Contrutor vazio de usuario pra facilitar no codigo
     */
    public Usuario(){

    }

    /**
     * Contrutor padrao do Usuario
     * @param nome
     * @param cpf
     */
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

    /**
     * Método que adiciona na lista o artista que o usuário seguiu
     * @param artista
     */
    public void seguirArtista(Artista artista){
        artistasSeguidos.add(artista);
    }

    /**
     * Método que remove da lista o artista que o usuário parou de seguir
     * @param artista
     */
    public void pararDeSeguirArtista(Artista artista){
        artistasSeguidos.remove(artista);
    }


}