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

public class TelaVisualizarMusica implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;

    private JLabel nome = new JLabel();
    private JLabel alb = new JLabel();
    private JLabel arts = new JLabel();

    private JButton botaoVoltar = new JButton("Voltar");

    private JTextArea letra = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane();

    private Musica musica;

    public TelaVisualizarMusica(Controle controle, JFrame janela, Boolean isArtista, Musica musica){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.musica = musica;
    }

    public JButton getBotaoVoltar(){
        return botaoVoltar;
    }

    public void show(){
        nome.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		nome.setForeground(Color.white);
        nome.setBounds(50, 30, 400, 30);
        nome.setText("Nome: " + musica.getNome());

        alb.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		alb.setForeground(Color.white);
        alb.setBounds(50, 70, 400, 30);
        alb.setText("Álbum: " + musica.getAlbum().getNome());

        arts.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		arts.setForeground(Color.white);
        arts.setBounds(50, 110, 700, 30);

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


			TelaMusicas telaMusicas = new TelaMusicas(controle, janela, isArtista);

			telaMusicas.show();

			telaMusicas.getBotaoVoltar().addActionListener(telaMusicas);
			telaMusicas.getBotaoVisualizar().addActionListener(telaMusicas);
        }
    }
}