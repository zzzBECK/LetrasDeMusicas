import entities.Album;
import entities.Artista;
import entities.Musica;
import entities.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        

        Usuario user1 = new Usuario(1, "Alexandre", "373183");
        Artista art1 = new Artista(2, "Hungria", "8742659", 1000, "rap");

        Artista art2 = new Artista(3, "Justin", "3743183", 123124, "pop");


        Album alb1 = new Album(1, "pedra", null, art1);
        Musica mus1 = new Musica(1, "coracao", "gelo", 2.4, false, alb1);
        // Musica mus2 = new Musica(1, "obrabo", "fogo", 2.6, false, alb1);
        // Musica mus3 = new Musica(1, "liw", "agua", 2.3, false, alb1);


        // System.out.println(art1);
        // System.out.println(alb1);

        mus1.setStatusTocando(true);

        // System.out.println(mus1);
    
        // System.out.print("Get Alubuns: ");
        // System.out.println(art1.getAlbuns());

        // System.out.print("Get Artistas: ");
        // System.out.println(alb1.getArtista());

        user1.seguirArtista(art1);

        System.out.println(user1);

        user1.pararDeSeguirArtista(art2);

    }
}