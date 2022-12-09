package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album {
    
    private Integer id;
    private String nome;
    private Date dataLancamento;

    private Artista artista;
    private List<Musica> musicas = new ArrayList<>();


    public Album(Integer id, String nome, Date dataLancamento, Artista artista){

        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.artista = artista;
        artista.adicionarAlbum(this);
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

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Artista getArtista(){
        return artista;
    }

    public void setArtista(Artista artista){
        this.artista = artista;
    }

    public void adicionarMusica(Musica musica){
        musicas.add(musica);
    }

    public void removerMusica(Musica musica){
        musicas.remove(musica);
    }

    @Override
    public String toString(){
        return String.format("Nome: %s ", nome) + "Musicas: " + musicas;
    }

}