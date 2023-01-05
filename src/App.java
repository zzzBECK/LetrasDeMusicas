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


        art1.editarAlbum("her loss", "teste");

        alb1.editarMusica("coracao de gelo", "2022");

        System.out.println(mus1.getNome());


    }
}