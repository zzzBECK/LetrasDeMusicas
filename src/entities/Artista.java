package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public List<Album> getAlbuns(){
        return albuns;
    }

    public void adicionarAlbum(Album album){
        albuns.add(album);
    }

    public void removerAlbum(Album album){
        albuns.remove(album);
    }

    public void editarAlbum(){
        Scanner sc = new Scanner(System.in);
        Album alb;

        do{
            System.out.println(albuns);
            System.out.print("Escolha o album para editar o nome: ");
            String nomeAlbum = sc.nextLine();
            alb = albuns.stream().filter(x -> x.getNome().equals(nomeAlbum)).findAny().orElse(null);

            if (alb == null){
                System.out.println("Album inexistente!");
            }
        } while (alb == null);

        for (Album y : albuns){
            if (alb == y){
                System.out.print("Digite o novo nome: ");
                y.setNome(sc.nextLine());
            }
        }
        
        sc.close();

    }

    @Override
    public String toString(){
        return String.format("Nome: %s ", super.getNome()) + "RG: " 
                            + super.getRg() + " Qtd Seguidores: " 
                            + qtdSeguidores + " Estilo Musical: " 
                            + estiloMusical + " Albuns: " +  albuns;
    }

}