package model;

/**
 * Classe que representa uma musica, a qual possui um nome, letra, duracao, album e artista
 * @author Alexandre de Santana Beck
 * @since 2022
 * @version 1.0
 */
public class Musica{
    
    private String nome;
    private String letra;
    private Double duracao;
    private boolean statusTocando;

    private Album album;

    public Musica(String nome, String letra, Double duracao, boolean statusTocando, Album album){
        this.nome = nome;
        this.letra = letra;
        this.duracao = duracao;
        this.statusTocando = statusTocando;
        this.album = album;
        album.adicionarMusica(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Double getDuracao() {
        return duracao;
    }

    public void setDuracao(Double duracao) {
        this.duracao = duracao;
    }

    public boolean isStatusTocando() {
        return statusTocando;
    }

    public void setStatusTocando(boolean statusTocando) {
        this.statusTocando = statusTocando;
    }

    public Album getAlbum(){
        return album;
    }  

    public void setAlbum(Album album){
        this.getAlbum().removerMusica(this);
        this.album = album;
        this.album.adicionarMusica(this);
    }

    @Override
    public String toString(){
        if (!statusTocando){
            return "Nome: " + nome + " Duracao: " + duracao + " Artista: " + getAlbum().getArtistas().get(0).getNome();
        }
        else{
            return "Nome: " + nome + " Duracao: " + duracao + " Artista: " + getAlbum().getArtistas().get(0).getNome() + " (Tocando)";
        }
    }
    
    public void tocarOuPausar(){

        if (statusTocando == true)
            statusTocando = false;

        else
            statusTocando = true;
    }

}