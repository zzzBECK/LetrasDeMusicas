package entities;

public class Musica{
    
    private Integer id;
    private String nome;
    private String letra;
    private Double duracao;
    private boolean statusTocando;

    private Album album;

    public Musica(Integer id, String nome, String letra, Double duracao, boolean statusTocando, Album album){
        this.id = id;
        this.nome = nome;
        this.letra = letra;
        this.duracao = duracao;
        this.statusTocando = statusTocando;
        this.album = album;
        album.adicionarMusica(this);
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

    @Override
    public String toString(){
        return "Nome: " + nome + " Letra: " + letra + " duracao: " + duracao + " Status: " + statusTocando + " | ";
    }
    
    public void tocarOuPausar(){

        if (statusTocando == true)
            statusTocando = false;

        else
            statusTocando = true;
    }

}