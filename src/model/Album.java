package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album {
    
    private String nome;
    private Date dataLancamento;

    private List<Artista> artistas;
    private List<Musica> musicas = new ArrayList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


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

    public List<Musica> getMusicas(){
        return musicas;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s ", nome) + " Data: " + sdf.format(dataLancamento) + " Artista: " + getArtistas().get(0).getNome();
    }

    
    public void adicionarMusica(Musica musica){
        musicas.add(musica);
    }

    public void removerMusica(Musica musica){
        musicas.remove(musica);
    }

    public void editarMusica(String nomeMusica, String novoNome){
        Musica mus;
    
        mus = musicas.stream().filter(y -> y.getNome().equals(nomeMusica)).findAny().orElse(null);

        if (mus.equals(null)){
            System.out.println("Musica inexistente!");
        }

        for (Musica x : musicas){
            if (mus == x){
                x.setNome(novoNome);
            }
        }
    }

}