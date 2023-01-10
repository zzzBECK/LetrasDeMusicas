// import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Album;
import entities.Artista;
import entities.Musica;
import entities.Pesquisa;
import entities.Usuario;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        List<Artista> artistas1 = new ArrayList<>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date y1 = sdf.parse("25/12/2022");

        Usuario user1 = new Usuario(1, "Alexandre", "373183");

        Artista art1 = new Artista(2, "Michael Jackson", "8742659", 1000, "pop");
        Artista art2 = new Artista(3, "Drake", "3743183", 123124, "rap");
        
        artistas1.add(art1);
        artistas1.add(art2);

        Album alb1 = new Album(1, "Her Loss", y1, artistas1);
        Album alb2 = new Album(1, "Indestructible", y1, artistas1);

        Musica mus1 = new Musica(1, "coracao de gelo", "letras da musica1", 2.4, false, alb1);

        Musica mus2 = new Musica(1, "danger zone", "letras da musicas2", 2.6, false, alb1);
        Musica mus3 = new Musica(1, "nightmare", "letras da musica3", 2.3, false, alb1);


        // art1.editarAlbum("her loss", "teste");

        // alb1.editarMusica("coracao de gelo", "2022");

        // user1.seguirArtista(art1);
        // user1.seguirArtista(art2);

        // System.out.println(user1);

        // System.out.println(alb1);
        // System.out.println(art1);

        System.out.print("Digite o nome do artista: ");
        Pesquisa pesquisa = new Pesquisa();

        System.out.println(pesquisa.procurarArtista(sc.nextLine()));

    }
}