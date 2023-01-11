package model;

import java.util.ArrayList;
import java.util.List;

public class Pesquisa {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Artista> artistas = new ArrayList<>();
    private List<Album> albuns = new ArrayList<>();
    private List<Musica> musicas = new ArrayList<>();

    public Pesquisa(){

    }

    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void adicionarArtista(Artista artista){
        artistas.add(artista);
    }

    public void adicionarAlbum(Album album){
        albuns.add(album);
    }

    public void adicionarMusica(Musica musica){
        musicas.add(musica);
    }

    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    public List<Artista> getArtistas(){
        return artistas;
    }

    public List<Album> getAlbuns(){
        return albuns;
    }

    public List<Musica> getMusicas(){
        return musicas;
    }

    public Artista procurarArtista(String nome){
        Artista art = artistas.stream().filter(x -> x.getNome().toLowerCase().equals(nome.toLowerCase())).findAny().orElse(null);
        return art;
    }
}