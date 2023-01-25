package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que armazena todos os dados do sistema temporariamente na memoria
 * @author Alexandre de Santana Beck
 * @since 2023
 * @version 1.0
 */
public class Dados {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Artista> artistas = new ArrayList<>();
    private List<Album> albuns = new ArrayList<>();
    private List<Musica> musicas = new ArrayList<>();

    /**
     * Contrutor vazio da classe
     */
    public Dados(){

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

    /**
     * Adiciona usuarios instanciados na Controle na lista de usuarios
     * @param usuario
     */
    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    /**
     * Adiciona artistas instancioados na Controle na lista de artistas
     * @param artista
     */
    public void adicionarArtista(Artista artista){
        artistas.add(artista);
    }

    /**
     * Adiciona albuns instancioados na Controle na lista de albuns
     * @param album
     */
    public void adicionarAlbum(Album album){
        albuns.add(album);
    }

    /**
     * Adiciona musicas instancioados na Controle na lista de musicas
     * @param musica
     */
    public void adicionarMusica(Musica musica){
        musicas.add(musica);
    }

}