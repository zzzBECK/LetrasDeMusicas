package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Artista musical, o qual possui um nome, albuns e musicas e um numero de seguidores
 * @author Alexandre de Santana Beck
 * @since 2022
 * @version 1.0
 */
public class Artista extends Usuario{
    
    private Integer qtdSeguidores;
    private String estiloMusical;

    private List<Album> albuns = new ArrayList<>();

    /**
     * Contrutor vazio do Artista para facilicar na hora de codar
     */
    public Artista(){
        super();
    }

    /**
     * Contrutor padrao do Artista
     * @param nome
     * @param cpf
     * @param qtdSeguidores
     * @param estiloMusical
     */
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

    /**
     * Adiciona um album na lista de albuns do artitsa
     * @param album
     */
    public void adicionarAlbum(Album album){
        albuns.add(album);
    }

    /**
     * remove um album da lista de albuns do artista
     * @param album
     */
    public void removerAlbum(Album album){
        albuns.remove(album);
    }


}