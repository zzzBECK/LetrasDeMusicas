import entities.Album;
import entities.Artista;
import entities.Musica;
import entities.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        

        Usuario user1 = new Usuario(1, "Alexandre", "373183");
        Artista art1 = new Artista(2, "Michael Jackson", "8742659", 1000, "pop");

        Artista art2 = new Artista(3, "Drake", "3743183", 123124, "rap");


        Album alb1 = new Album(1, "nomeIncorreto", null, art1);

        Musica mus1 = new Musica(1, "coracao", "gelo", 2.4, false, alb1);

        Musica mus2 = new Musica(1, "obrabo", "fogo", 2.6, false, alb1);
        Musica mus3 = new Musica(1, "liw", "agua", 2.3, false, alb1);


        art1.editarAlbum();


        System.out.println(art1);
        System.out.println();

        System.out.println(alb1);
        System.out.println();

        mus1.setStatusTocando(true);
        mus1.setNome("Vitor");
        System.out.println(mus1);
        System.out.println();

    
        System.out.print("Get Alubuns: ");
        System.out.println(art1.getAlbuns());
        System.out.println();

        System.out.print("Get Artistas: ");
        System.out.println(alb1.getArtista());
        System.out.println();

        user1.seguirArtista(art1);

        System.out.println(user1);
        System.out.println();

        user1.pararDeSeguirArtista(art1);
        System.out.println(user1);
        System.out.println();

    }
}