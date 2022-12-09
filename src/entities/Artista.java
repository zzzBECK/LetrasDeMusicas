package entities;

import java.util.ArrayList;
import java.util.List;

public class Artista extends Usuario{
    
    private Integer qtdSeguidores;
    private String estiloMusical;

    private List<Album> albuns = new ArrayList<>();

    public Artista(){
        super();
    }

    public Artista(Integer id, String nome, String rg, Integer qtdSeguidores, String estiloMusical){
        super(id, nome, rg);
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

    public void adicionarAlbum(Album album){
        albuns.add(album);
    }

    public void removerAlbum(Album album){
        albuns.remove(album);
    }

    @Override
    public String toString(){
        return String.format("Nome: %s ", super.getNome()) + "RG: " 
                            + super.getRg() + " Qtd Seguidores: " 
                            + qtdSeguidores + " Estilo Musical: " 
                            + estiloMusical + " Albuns: " +  albuns;
    }

}