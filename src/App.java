import entities.Album;
import entities.Artista;
import entities.Musica;
import entities.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        

        Usuario user1 = new Usuario(1, "Alexandre", "373183");
        Artista art1 = new Artista(2, "Hungria", "8742659", 1000, "rap");

        Album alb1 = new Album(1, "pedra", null);
        Musica mus1 = new Musica(1, "coracao", "gelo", 2.4, false);
        Musica mus2 = new Musica(1, "obrabo", "fogo", 2.6, false);
        Musica mus3 = new Musica(1, "liw", "agua", 2.3, false);


        art1.adicionarAlbum(alb1);

        alb1.adicionarMusica(mus1);
        alb1.adicionarMusica(mus2);
        alb1.adicionarMusica(mus3);


        System.out.println(alb1);
    

    }
}
