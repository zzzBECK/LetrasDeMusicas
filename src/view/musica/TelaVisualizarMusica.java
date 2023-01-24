package view.musica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.Controle;
import model.Artista;
import model.Musica;
import view.album.TelaVisualizarAlbum;

public class TelaVisualizarMusica implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;

    private JLabel nome = new JLabel();
    private JLabel alb = new JLabel();
    private JLabel arts = new JLabel();
    private JLabel titulo = new JLabel();
    private JLabel duracao = new JLabel();


    private JButton botaoVoltar = new JButton("Voltar");
    private JButton botaoVoltarAlbum = new JButton("Voltar");
    private JButton botaoVoltarArtista = new JButton("Voltar");

    private JTextArea letra = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane();

    private Musica musica;

    private Artista art;

    public TelaVisualizarMusica(Controle controle, JFrame janela, Boolean isArtista, Musica musica){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.musica = musica;
    }

    public JButton getBotaoVoltar(){
        return botaoVoltar;
    }

    public JButton getBotaoVoltarAlbum(){
        return botaoVoltarAlbum;
    }

    public JButton getBotaoVoltarArtista(){
        return botaoVoltarArtista;
    }

    public void show(){
        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 20));
		titulo.setForeground(Color.decode("#A020F0"));
        titulo.setBounds(360, 118, 400, 30);
        titulo.setText("Letra");

        nome.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		nome.setForeground(Color.white);
        nome.setBounds(50, 30, 400, 30);
        nome.setText("Música: " + musica.getNome());

        duracao.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		duracao.setForeground(Color.white);
        duracao.setBounds(450, 70, 400, 30);
        duracao.setText("Duração: " + musica.getDuracao());

        alb.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		alb.setForeground(Color.white);
        alb.setBounds(50, 70, 400, 30);
        alb.setText("Álbum: " + musica.getAlbum().getNome());

        arts.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		arts.setForeground(Color.white);
        arts.setBounds(450, 30, 700, 30);

        String nomeArtistas = new String();
        for (Artista artista : musica.getAlbum().getArtistas()){
            nomeArtistas += artista.getNome();
            nomeArtistas += " ";
        }
        arts.setText("Artistas: " + nomeArtistas);


        letra.setBounds(110, 150, 579, 300); 
        letra.setLineWrap(true);
        letra.setText(musica.getLetra());
        letra.setEditable(false);

        scrollPane.getViewport().add(letra);
        scrollPane.setBounds(110, 150, 579, 300);
        
        botaoVoltar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoVoltar.setBackground(Color.decode("#A020F0"));
        botaoVoltar.setForeground(Color.WHITE);
		botaoVoltar.setBounds(337, 494, 125, 35);
        botaoVoltar.setBorder(null);
        botaoVoltar.setFocusPainted(false);

        janela.add(nome);
        janela.add(alb);
        janela.add(arts);
        janela.add(scrollPane);
        janela.add(botaoVoltar);
        janela.add(titulo);
        janela.add(duracao);


        janela.repaint();
    }

    public void showToAlbum(){
        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 20));
		titulo.setForeground(Color.decode("#A020F0"));
        titulo.setBounds(360, 118, 400, 30);
        titulo.setText("Letra");

        nome.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		nome.setForeground(Color.white);
        nome.setBounds(50, 30, 400, 30);
        nome.setText("Música: " + musica.getNome());

        duracao.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		duracao.setForeground(Color.white);
        duracao.setBounds(450, 70, 400, 30);
        duracao.setText("Duração: " + musica.getDuracao());

        alb.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		alb.setForeground(Color.white);
        alb.setBounds(50, 70, 400, 30);
        alb.setText("Álbum: " + musica.getAlbum().getNome());

        arts.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		arts.setForeground(Color.white);
        arts.setBounds(450, 30, 700, 30);

        String nomeArtistas = new String();
        for (Artista artista : musica.getAlbum().getArtistas()){
            nomeArtistas += artista.getNome();
            nomeArtistas += " ";
        }
        arts.setText("Artistas: " + nomeArtistas);


        letra.setBounds(110, 150, 579, 300); 
        letra.setLineWrap(true);
        letra.setText(musica.getLetra());
        letra.setEditable(false);

        scrollPane.getViewport().add(letra);
        scrollPane.setBounds(110, 150, 579, 300);
        
        botaoVoltarAlbum.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoVoltarAlbum.setBackground(Color.decode("#A020F0"));
        botaoVoltarAlbum.setForeground(Color.WHITE);
		botaoVoltarAlbum.setBounds(337, 494, 125, 35);
        botaoVoltarAlbum.setBorder(null);
        botaoVoltarAlbum.setFocusPainted(false);

        janela.add(nome);
        janela.add(alb);
        janela.add(arts);
        janela.add(scrollPane);
        janela.add(botaoVoltarAlbum);
        janela.add(titulo);
        janela.add(duracao);


        janela.repaint();
    }

    public void showToArtista(Artista art){
        this.art = art;
        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 20));
		titulo.setForeground(Color.decode("#A020F0"));
        titulo.setBounds(360, 118, 400, 30);
        titulo.setText("Letra");

        nome.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		nome.setForeground(Color.white);
        nome.setBounds(50, 30, 400, 30);
        nome.setText("Música: " + musica.getNome());

        duracao.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		duracao.setForeground(Color.white);
        duracao.setBounds(450, 70, 400, 30);
        duracao.setText("Duração: " + musica.getDuracao());

        alb.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		alb.setForeground(Color.white);
        alb.setBounds(50, 70, 400, 30);
        alb.setText("Álbum: " + musica.getAlbum().getNome());

        arts.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		arts.setForeground(Color.white);
        arts.setBounds(450, 30, 700, 30);

        String nomeArtistas = new String();
        for (Artista artista : musica.getAlbum().getArtistas()){
            nomeArtistas += artista.getNome();
            nomeArtistas += " ";
        }
        arts.setText("Artistas: " + nomeArtistas);


        letra.setBounds(110, 150, 579, 300); 
        letra.setLineWrap(true);
        letra.setText(musica.getLetra());
        letra.setEditable(false);

        scrollPane.getViewport().add(letra);
        scrollPane.setBounds(110, 150, 579, 300);
        
        botaoVoltarArtista.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoVoltarArtista.setBackground(Color.decode("#A020F0"));
        botaoVoltarArtista.setForeground(Color.WHITE);
		botaoVoltarArtista.setBounds(337, 494, 125, 35);
        botaoVoltarArtista.setBorder(null);
        botaoVoltarArtista.setFocusPainted(false);

        janela.add(nome);
        janela.add(alb);
        janela.add(arts);
        janela.add(scrollPane);
        janela.add(botaoVoltarArtista);
        janela.add(titulo);
        janela.add(duracao);


        janela.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if (src == botaoVoltar){
            janela.remove(nome);
			janela.remove(alb);
			janela.remove(arts);
            janela.remove(scrollPane);
			janela.remove(botaoVoltar);
            janela.remove(titulo);
            janela.remove(duracao);


			TelaMusicas telaMusicas = new TelaMusicas(controle, janela, isArtista);

			telaMusicas.show();

			telaMusicas.getBotaoVoltar().addActionListener(telaMusicas);
			telaMusicas.getBotaoVisualizar().addActionListener(telaMusicas);
			telaMusicas.getBotaoTocar().addActionListener(telaMusicas);
			telaMusicas.getBotaoAvancar().addActionListener(telaMusicas);
			telaMusicas.getBotaoRetroceder().addActionListener(telaMusicas);
			telaMusicas.getBotaoPlay().addActionListener(telaMusicas);
        }

        if (src == botaoVoltarAlbum){
            janela.remove(nome);
            janela.remove(alb);
            janela.remove(arts);
            janela.remove(scrollPane);
            janela.remove(botaoVoltarAlbum);
            janela.remove(titulo);
            janela.remove(duracao);

            TelaVisualizarAlbum telaVisualizarAlbum = new TelaVisualizarAlbum(controle, janela, isArtista, musica.getAlbum());

			telaVisualizarAlbum.show();

			telaVisualizarAlbum.getBotaoVoltar().addActionListener(telaVisualizarAlbum);
			telaVisualizarAlbum.getBotaoVisualizar().addActionListener(telaVisualizarAlbum);
        }

        if (src == botaoVoltarArtista){
            janela.remove(nome);
            janela.remove(alb);
            janela.remove(arts);
            janela.remove(scrollPane);
            janela.remove(botaoVoltarArtista);
            janela.remove(titulo);
            janela.remove(duracao);

            TelaVisualizarAlbum telaVisualizarAlbum = new TelaVisualizarAlbum(controle, janela, isArtista, musica.getAlbum());

			telaVisualizarAlbum.showToArtista(art);

			telaVisualizarAlbum.getBotaoVoltarArtista().addActionListener(telaVisualizarAlbum);
			telaVisualizarAlbum.getBotaoVisualizarArtista().addActionListener(telaVisualizarAlbum);
        }
    }
}