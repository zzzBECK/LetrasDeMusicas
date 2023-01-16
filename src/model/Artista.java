package model;

import java.util.ArrayList;
import java.util.List;

public class Artista extends Usuario{
    
    private Integer qtdSeguidores;
    private String estiloMusical;

    private List<Album> albuns = new ArrayList<>();

    public Artista(){
        super();
    }

    public Artista(String nome, String cpf, Integer qtdSeguidores, String estiloMusical){
        super(nome, cpf);
        this.qtdSeguidores = qtdSeguidores;
        this.estiloMusical = estiloMusical;

    }

    
    public Integer getQtdSeguidores() {
        return qtdSeguidores;
    }

    public void setQtdSeguidores(Integer qtdSeguidores) {
        this.qtdSeguidores = qtdSeguidores;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public List<Album> getAlbuns(){
        return albuns;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s ", super.getNome()) +  
                            " Qtd Seguidores: " + qtdSeguidores + 
                            " Estilo Musical: " + estiloMusical;
    }

    public void adicionarAlbum(Album album){
        albuns.add(album);
    }

    public void removerAlbum(Album album){
        albuns.remove(album);
    }

    public void editarAlbum(String nomeAlbum, String novoNome){
        Album alb;
        
        alb = albuns.stream().filter(x -> x.getNome().toLowerCase().equals(nomeAlbum.toLowerCase())).findAny().orElse(null);

        if (alb == null)
            System.out.println("Album inexistente!");

        for (Album y : albuns){
            if (alb == y){
                y.setNome(novoNome);
            }
        }

    }

}