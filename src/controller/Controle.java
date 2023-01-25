package controller;

import java.util.Date;
import java.util.List;

import model.Album;
import model.Artista;
import model.Dados;
import model.Musica;
import model.Usuario;

public class Controle{
    
    private Dados dados = new Dados();

    public Controle(){


        // String letra = """
        //     End of passion play, crumbling away
        //     I'm your source of self-destruction
        //     Veins that pump with fear, sucking darkest clear
        //     Leading on your death's construction
        //     Taste me, you will see
        //     More is all you need
        //     Dedicated to
        //     How I'm killing you
        //     Come crawling faster (faster)
        //     Obey your master (master)
        //     Your life burns faster (faster)
        //     Obey your master, master
        //     Master of puppets, I'm pulling your strings
        //     Twisting your mind and smashing your dreams
        //     Blinded by me, you can't see a thing
        //     Just call my name 'cause I'll hear you scream
        //     Master, master
        //     Just call my name 'cause I'll hear you scream
        //     Master, master
        //     Needlework the way, never you betray
        //     Life of death becoming clearer
        //     Pain monopoly, ritual misery
        //     Chop your breakfast on a mirror
        //     Taste me, you will see
        //     More is all you need
        //     Dedicated to
        //     How I'm killing you
        //     Come crawling faster (faster)
        //     Obey your master (master)
        //     Your life burns faster (faster)
        //     Obey your master, master
        //     Master of puppets, I'm pulling your strings
        //     Twisting your mind and smashing your dreams
        //     Blinded by me, you can't see a thing
        //     Just call my name 'cause I'll hear you scream
        //     Master, master
        //     Just call my name 'cause I'll hear you scream
        //     Master, master
        //     (Master, master, master, master)
        //     Master, master, where's the dreams that I've been after?
        //     Master, master, you promised only lies
        //     Laughter, laughter, all I hear or see is laughter
        //     Laughter, laughter, laughing at my cries
        //     Fix me!
        //     Hell is worth all that, natural habitat
        //     Just a rhyme without a reason
        //     Never-ending maze, drift on numbered days
        //     Now your life is out of season
        //     I will occupy
        //     I will help you die
        //     I will run through you
        //     Now I rule you too
        //     Come crawling faster (faster)
        //     Obey your master (master)
        //     Your life burns faster (faster)
        //     Obey your master, master
        //     Master of puppets, I'm pulling your strings
        //     Twisting your mind and smashing your dreams
        //     Blinded by me, you can't see a thing
        //     Just call my name 'cause I'll hear you scream
        //     Master, master
        //     Just call my name 'cause I'll hear you scream
        //     Master, master
        //         """;

        // Artista gabriel =  new Artista("Gabriel Richa", "03780715544", 9, "Rock");
        // List<Artista> list = new ArrayList<>();
        // list.add(gabriel);
        // Album albumGabriel = new Album("baitola", new Date(), list);
        // Musica musicaGabriel = new Musica("viado", letra, 2.0, false, albumGabriel);

        // dados.adicionarArtista(gabriel);
        // dados.adicionarAlbum(albumGabriel);
        // dados.adicionarMusica(musicaGabriel);

    }

    public Dados getDados(){
        return dados;
    }

    public void usuario(String nome, String cpf){
        dados.adicionarUsuario(new Usuario(nome, cpf));
    }

    public void artista(String nome, String rg, String estiloMusical){
        dados.adicionarArtista(new Artista(nome, rg, 0, estiloMusical));
    }

    public void album(String nome, Date data, List<Artista> artistas){
        dados.adicionarAlbum(new Album(nome, data, artistas));
    }

    public void musica(String nome, String letra, Double duracao, Album album){
        dados.adicionarMusica(new Musica(nome, letra, duracao, false, album));
    }

    public void removerMusica(Musica musica){
        musica.getAlbum().removerMusica(musica);
        dados.getMusicas().remove(musica);
    }

    public void removerAlbum(Album album){

        for (Musica musica : album.getMusicas()){
            dados.getMusicas().remove(musica);
        }

        for (Artista artista : album.getArtistas()){
            artista.removerAlbum(album);
        }

        dados.getAlbuns().remove(album);
    }

    public boolean checkCpf(String cpf){

        try{
            int soma1 = 0, soma2 = 0, n1 = Character.getNumericValue(cpf.charAt(9)), n2 = Character.getNumericValue(cpf.charAt(10));

            int[] lista1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] lista2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        

            if (cpf.length() != 11){

                return false;
            }
            else{
                for (int i = 0; i < 10; i++){
                    if (i != 9){
                        soma1 += Character.getNumericValue(cpf.charAt(i)) * lista1[i];
                    }
                    soma2 += Character.getNumericValue(cpf.charAt(i)) * lista2[i];
                }

                if ((soma1 % 11 < 2 && n1 == 0) || (n1 == 11 - (soma1 % 11))){
                    return (soma2 % 11 < 2 && n2 == 0) || (n2 == 11 - (soma2 % 11));
                }
            }

            return false;
        }
        catch (Exception e){
            System.out.println("Erro no cpf");
        }

        return false;
    }

    public boolean cpfIsCadastrado(String cpf){

        for (Usuario usuario : dados.getUsuarios()){
            if (usuario.getCpf().equals(cpf)){
                return true;
            }
        }

        for (Artista artista : dados.getArtistas()){
            if (artista.getCpf().equals(cpf)){
                return true;
            }
        }

        return false;
    }
}   