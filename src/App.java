// import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Album;
import entities.Artista;
import entities.Musica;
import entities.Usuario;

public class App {
    public static void main(String[] args) throws Exception {

        // DateFormat f = DateFormat.getDateInstance();
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date y1 = sdf2.parse("25/12/2022 12:56:37");

        Usuario user1 = new Usuario(1, "Alexandre", "373183");
        Artista art1 = new Artista(2, "Michael Jackson", "8742659", 1000, "pop");

        Artista art2 = new Artista(3, "Drake", "3743183", 123124, "rap");


        Album alb1 = new Album(1, "Her Loss", y1, art1);
        Album alb2 = new Album(1, "Indestructible", null, art1);

        Musica mus1 = new Musica(1, "coracao de gelo", "letras da musica1", 2.4, false, alb1);

        Musica mus2 = new Musica(1, "danger zone", "letras da musicas2", 2.6, false, alb1);
        Musica mus3 = new Musica(1, "nightmare", "letras da musica3", 2.3, false, alb1);



        // System.out.println(mus1.getAlbum().getArtista());
        art1.editarAlbum();



        System.out.println(art1);
        System.out.println();

        System.out.println(alb1);
        System.out.println();

        mus1.tocarOuPausar();
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
        user1.seguirArtista(art2);
        
        System.out.println(user1);
        System.out.println();

    }
}