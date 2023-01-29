package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Album;
import model.Artista;
import model.Dados;
import model.Musica;
import model.Usuario;

/**
 * Classe que faz a conexão do model com a view e armazena os dados
 * @author Alexandre de Santana Beck
 * @since 2022
 * @version 1.0
 */
public class Controle{
    
    private Dados dados = new Dados();

    public Controle(){

        String enterSandman = """
                Say your prayers, little one
                Don't forget, my son
                To include everyone
                Tuck you in, warm within
                Keep you free from sin
                'Til the sandman, he comes
                Sleep with one eye open
                Gripping your pillow tight
                Exit light
                Enter night
                Take my hand
                We're off to never-never land
                Somethings wrong, shut the light
                Heavy thoughts tonight
                And they aren't of Snow White
                Dreams of war, dreams of liars
                Dreams of dragon's fire
                And of things that will bite, yeah
                Sleep with one eye open
                Gripping your pillow tight
                Exit light
                Enter night
                Take my hand
                We're off to never-never land
                Now I lay me down to sleep
                Now I lay me down to sleep
                I pray the Lord my soul to keep
                I pray the Lord my soul to keep
                If I die before I wake
                If I die before I wake
                I pray the Lord my soul to take
                I pray the Lord my soul to take
                Hush, little baby, don't say a word
                And never mind that noise you heard
                It's just the beasts under your bed
                In your closet, in your head
                Exit light
                Enter night
                Grain of sand
                Exit light
                Enter night
                Take my hand
                We're off to never-never land, yeah
                Uh
                Yeah, yeah
                Yo, oh
                We're off to never-never land
                Take my hand
                We're off to never-never land
                Take my hand
                We're off to never-never land
                """;

        String sadButTrue = """
                Hey
                I'm your life
                I'm the one who takes you there
                Hey
                I'm your life
                I'm the one who cares
                They
                They betray
                I'm your only true friend now
                They
                They'll betray
                I'm forever there
                                
                I'm your dream, make you real
                I'm your eyes when you must steal
                I'm your pain when you can't feel
                Sad, but true
                                
                I'm your dream, mind astray
                I'm your eyes while you're away
                I'm your pain while you repay
                You know it's sad, but true
                                
                Sad, but true
                                
                You
                You're my mask
                You're my cover, my shelter
                You
                You're my mask
                You're the one who's blamed
                Do
                Do my work
                Do my dirty work, scapegoat
                Do
                Do my deeds
                For you're the one who's shamed
                                
                I'm your dream, make you real
                I'm your eyes when you must steal
                I'm your pain when you can't feel
                Sad, but true
                                
                I'm your dream, mind astray
                I'm your eyes while you're away
                I'm your pain while you repay
                You know it's sad, but true
                                
                Sad, but true
                                
                I'm your dream
                I'm your eyes
                I'm your pain
                                
                I'm your dream (I'm your dream)
                I'm your eyes (I'm your eyes)
                I'm your pain (I'm your pain)
                You know it's sad, but true
                                
                Hate
                I'm your hate
                I'm your hate when you want love
                Pay
                Pay the price
                Pay, for nothing's fair
                Hey
                I'm your life
                I'm the one who took you there
                Hey
                I'm your life
                And I no longer care
                                
                I'm your dream, make you real
                I'm your eyes when you must steal
                I'm your pain when you can't feel
                Sad, but true
                                
                I'm your truth, telling lies
                I'm your reasoned alibis
                I'm inside, open your eyes
                I'm you
                                
                Sad, but true
                """;

        String imprevisto = """
                Tava andando de quebrada
                Sendo o centro da cidade
                Quando cê resolveu dar um salve pelo meu radin'
                Eu já tenho compromisso
                Mas posso chegar mais tarde
                Prefiro ter você assim
                Bem pertinho de mim
                De manhã, de madrugada
                Te quero também de tarde
                Quando nóis fica junto
                Somo' inimigo do fim
                Sabe que eu sou correria
                Em todas as quilometragem'
                Independentemente
                Se quiser, eu tô a fim
                Chego na postura, ninguém segura
                Eu só te trouxe esse buquê
                Porque a vida é dura
                Nunca foi questão só de pressa
                Entende na conversa
                Só cheguei suado pela viatura
                Sempre na caruda, ninguém segura
                Eu vivo a vida de dublê
                Mas sem atadura
                O que é raso num interessa
                Só beijin' na testa
                Aqueles que o malandro já perde a postura
                E eu entenderia pra falar
                Meu gesto pra te enfeitiçar
                Fico sentindo o batimento do seu peito
                De um modo tão particular
                Sem muita coisa pra falar
                Só um silêncio e transmissão de pensamento
                Me juntaria pra te amar
                Nos seus cabelos, me enrolar
                Mais enrolado que eu já tô nesse momento
                Tem um mundão pra aventurar
                Eu sei, seu ascendente é mar
                E a nossa foto aumentou meu engajamento
                Eu 'tava andando de quebrada
                Sendo o centro da cidade
                Quando cê resolveu dar um salve pelo meu radin'
                Eu já tenho compromisso
                Mas posso chegar mais tarde
                Prefiro ter você assim
                Bem pertinho de mim
                De manhã, de madrugada
                Te quero também de tarde
                Quando nóis fica junto
                Somo' inimigo do fim
                Sabe que eu sou correria
                Em todas as quilometragem'
                Independentemente
                Se quiser, eu tô a fim
                """;


         String masterOfPuppets = """
             End of passion play, crumbling away
             I'm your source of self-destruction
             Veins that pump with fear, sucking darkest clear
             Leading on your death's construction
             Taste me, you will see
             More is all you need
             Dedicated to
             How I'm killing you
             Come crawling faster (faster)
             Obey your master (master)
             Your life burns faster (faster)
             Obey your master, master
             Master of puppets, I'm pulling your strings
             Twisting your mind and smashing your dreams
             Blinded by me, you can't see a thing
             Just call my name 'cause I'll hear you scream
             Master, master
             Just call my name 'cause I'll hear you scream
             Master, master
             Needlework the way, never you betray
             Life of death becoming clearer
             Pain monopoly, ritual misery
             Chop your breakfast on a mirror
             Taste me, you will see
             More is all you need
             Dedicated to
             How I'm killing you
             Come crawling faster (faster)
             Obey your master (master)
             Your life burns faster (faster)
             Obey your master, master
             Master of puppets, I'm pulling your strings
             Twisting your mind and smashing your dreams
             Blinded by me, you can't see a thing
             Just call my name 'cause I'll hear you scream
             Master, master
             Just call my name 'cause I'll hear you scream
             Master, master
             (Master, master, master, master)
             Master, master, where's the dreams that I've been after?
             Master, master, you promised only lies
             Laughter, laughter, all I hear or see is laughter
             Laughter, laughter, laughing at my cries
             Fix me!
             Hell is worth all that, natural habitat
             Just a rhyme without a reason
             Never-ending maze, drift on numbered days
             Now your life is out of season
             I will occupy
             I will help you die
             I will run through you
             Now I rule you too
             Come crawling faster (faster)
             Obey your master (master)
             Your life burns faster (faster)
             Obey your master, master
             Master of puppets, I'm pulling your strings
             Twisting your mind and smashing your dreams
             Blinded by me, you can't see a thing
             Just call my name 'cause I'll hear you scream
             Master, master
             Just call my name 'cause I'll hear you scream
             Master, master
                 """;

         Artista gabriel =  new Artista("Gabriel Richa", "76431380010", 9, "Hip-Hop");
         List<Artista> list = new ArrayList<>();
         list.add(gabriel);
         Album albumGabriel = new Album("Imprevisto", new Date(), list);
         Musica musicaGabriel = new Musica("Imprevisto", imprevisto, 2.2, false, albumGabriel);

         dados.adicionarArtista(gabriel);
         dados.adicionarAlbum(albumGabriel);
         dados.adicionarMusica(musicaGabriel);

         Artista art1 = new Artista("Metallica", "94190914061", 78, "Heavy-Metal");
         List<Artista> list1 = new ArrayList<>();
         list1.add(art1);
         Album alb1 = new Album("Master of Puppets", new Date(), list1);
         Album alb2 = new Album("Metallica", new Date(), list1);
         Musica mus1 = new Musica("Master of Puppets", masterOfPuppets, 8.35, false, alb1);
         Musica mus2 = new Musica("Enter Sandman", enterSandman, 5.31, false, alb2);
         Musica mus3 = new Musica("Sad But True", sadButTrue, 5.23, false, alb2);

         dados.adicionarArtista(art1);
         dados.adicionarAlbum(alb1);
         dados.adicionarMusica(mus1);
         dados.adicionarAlbum(alb2);
         dados.adicionarMusica(mus2);
         dados.adicionarMusica(mus3);

    }

    public Dados getDados(){
        return dados;
    }

    /**
     * metodo utilizado pra instanciar um usuario e salva-lo nos dados
     * @param nome
     * @param cpf
     */
    public void usuario(String nome, String cpf){
        dados.adicionarUsuario(new Usuario(nome, cpf));
    }

    /**
     * metodo utilizado pra instanciar um artista e salva-lo nos dados
     * @param nome
     * @param rg
     * @param estiloMusical
     */
    public void artista(String nome, String rg, String estiloMusical){
        dados.adicionarArtista(new Artista(nome, rg, 0, estiloMusical));
    }

    /**
     * metodo utilizado pra instanciar um album e salva-lo nos dados
     * @param nome
     * @param data
     * @param artistas
     */
    public void album(String nome, Date data, List<Artista> artistas){
        dados.adicionarAlbum(new Album(nome, data, artistas));
    }

    /**
     * metodo utilizado para instanciar uma musica e salva-la nos dados
     * @param nome
     * @param letra
     * @param duracao
     * @param album
     */
    public void musica(String nome, String letra, Double duracao, Album album){
        dados.adicionarMusica(new Musica(nome, letra, duracao, false, album));
    }

    /**
     * metodo utilizado para remover a musica do "banco de dados"
     * @param musica
     */
    public void removerMusica(Musica musica){
        musica.getAlbum().removerMusica(musica);
        dados.getMusicas().remove(musica);
    }

    /**
     * metodo utilizado para remover o album do "banco de dados"
     * @param album
     */
    public void removerAlbum(Album album){

        for (Musica musica : album.getMusicas()){
            dados.getMusicas().remove(musica);
        }

        for (Artista artista : album.getArtistas()){
            artista.removerAlbum(album);
        }

        dados.getAlbuns().remove(album);
    }

    /**
     * meotodo que verifica se o cpf digitado é valido
     * @param cpf
     * @return
     */
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


    /**
     * metodo que verifica se o cpf a ser cadastrado ja existe no sistema
     * @param cpf
     * @return
     */
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

    /**
     * Metodo que verifica se o nome da album a ser cadastrado ja existe no sistema
     * @param nome
     * @return
     */
    public boolean albumIsCadastrado(String nome){

        for (Album album : getDados().getAlbuns()){
            if (album.getNome().equalsIgnoreCase(nome)){
                return true;
            }
        }

        return false;
    }

}   