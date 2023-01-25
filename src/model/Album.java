package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que representa um album de musica, a qual possui um nome, data de lançamento, artistas e musicas
 * @author Alexandre de Santana Beck
 * @since 2022
 * @version 1.0
 */
public class Album {
    
    private String nome;
    private Date dataLancamento;

    private List<Artista> artistas;
    private List<Musica> musicas = new ArrayList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Construtor da classe Album
     * @param nome
     * @param dataLancamento
     * @param artistas
     */
    public Album(String nome, Date dataLancamento, List<Artista> artistas){

        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.artistas = artistas;

        for (Artista art : artistas){
            art.adicionarAlbum(this);
        }

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

    public List<Artista> getArtistas(){
        return artistas;
    }

    public void setArtistas(List<Artista> artistas){
        this.artistas = artistas;
    }

    public List<Musica> getMusicas(){
        return musicas;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s ", nome) + " Data: " + sdf.format(dataLancamento) + " Artista: " + getArtistas().get(0).getNome();
    }

    /**
     * Adiciona uma musica na lista de musicas do album
     * @param musica
     */
    public void adicionarMusica(Musica musica){
        musicas.add(musica);
    }

    /**
     * Remove uma musica na lista de musicas do album
     * @param musica
     */
    public void removerMusica(Musica musica){
        musicas.remove(musica);
    }

}