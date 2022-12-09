package entities;

public class Musica {
    
    private Integer id;
    private String nome;
    private String letra;
    private Double duracao;
    private boolean statusTocando;

    public Musica(){

    }

    public Musica(Integer id, String nome, String letra, Double duracao, boolean statusTocando){
        
        this.id = id;
        this.nome = nome;
        this.letra = letra;
        this.duracao = duracao;
        this.statusTocando = statusTocando;
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

}