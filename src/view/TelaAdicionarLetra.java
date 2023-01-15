package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.Controle;
import model.Album;

public class TelaAdicionarLetra implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;

    private JLabel titulo = new JLabel("Letra:");

    private JScrollPane scrollPane = new JScrollPane();
    private JTextArea entradaLetra = new JTextArea();

    private JButton botaoSalvar = new JButton("Salvar");
    private JButton botaoCancelar = new JButton("Cancelar");

    private String nomeDigitado;
    private String duracaoDigitado;
    private DefaultListModel<Album> model;
    private Album album;


    public TelaAdicionarLetra(Controle controle, JFrame janela, boolean isArtista, String nomeDigitado,
                              String duracaoDigitado, DefaultListModel<Album> model, Album album){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.nomeDigitado = nomeDigitado;
        this.duracaoDigitado = duracaoDigitado;
        this.model = model;
        this.album = album;
    }

    public JButton getButaoSalvar(){
        return botaoSalvar;
    }

    public JButton getBotaoCancelar(){
        return botaoCancelar;
    }

    public void show(){
        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 24));
		titulo.setForeground(Color.white);
		titulo.setBounds(350, 15, 300, 48);

        entradaLetra.setToolTipText("Digite a letra");
        entradaLetra.setText("Digite a Letra:");
        entradaLetra.setBounds(110, 60, 579, 400); 
        entradaLetra.setLineWrap(true);

        scrollPane.getViewport().add(entradaLetra);
        scrollPane.setBounds(110, 60, 579, 400);

        botaoSalvar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoSalvar.setBackground(Color.decode("#A020F0"));
        botaoSalvar.setForeground(Color.WHITE);
		botaoSalvar.setBounds(416, 494, 125, 35);
        botaoSalvar.setBorder(null);
        botaoSalvar.setFocusPainted(false);

        botaoCancelar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoCancelar.setBackground(Color.decode("#A020F0"));
        botaoCancelar.setForeground(Color.WHITE);
		botaoCancelar.setBounds(272, 494, 125, 35);
        botaoCancelar.setBorder(null);
        botaoCancelar.setFocusPainted(false);

        janela.add(titulo);
        janela.add(scrollPane);
        janela.add(botaoSalvar);
        janela.add(botaoCancelar);

        janela.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoCancelar){
            janela.remove(titulo);
            janela.remove(scrollPane);
            janela.remove(botaoSalvar);
            janela.remove(botaoCancelar);

            TelaCadastroMusica telaCadastroMusica = new TelaCadastroMusica(controle, janela, isArtista, album, nomeDigitado, duracaoDigitado, model, null);
			
            telaCadastroMusica.show();
    
			telaCadastroMusica.getBotaoCadastrar().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoCancelar().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoAlbum().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoLetra().addActionListener(telaCadastroMusica);
        }

        if (src == botaoSalvar){
            janela.remove(titulo);
            janela.remove(scrollPane);
            janela.remove(botaoSalvar);
            janela.remove(botaoCancelar);

            TelaCadastroMusica telaCadastroMusica = new TelaCadastroMusica(controle, janela, isArtista, album, nomeDigitado, duracaoDigitado, model, entradaLetra.getText());
			
            telaCadastroMusica.show();
    
			telaCadastroMusica.getBotaoCadastrar().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoCancelar().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoAlbum().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoLetra().addActionListener(telaCadastroMusica);
        }
        
    }
}