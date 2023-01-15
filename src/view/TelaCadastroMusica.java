package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.Controle;
import model.Album;

public class TelaCadastroMusica implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;

    private JLabel titulo = new JLabel("Cadastro:");

    private JLabel nome = new JLabel("Nome:");
    private JTextField entradaNome = new JTextField();

    private JLabel duracao = new JLabel("Duração:");
    private JTextField entradaDuracao = new JTextField();

    private JButton botaoCadastrar = new JButton("Cadastrar");
    private JButton botaoCancelar = new JButton("Cancelar");

    private DefaultListModel<Album> model = new DefaultListModel<>();
    private JScrollPane scrollPane = new JScrollPane();
    private JList<Album> list = new JList<>();

    private Album album;
    private List<Album> albuns = new ArrayList<>();
    private String nomeDigitado;
    private String duracaoDigitado;

    private JButton botaoAlbum = new JButton("Adicionar Album");


    public TelaCadastroMusica(Controle controle, JFrame janela, boolean isArtista){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
    }
    
    public TelaCadastroMusica(Controle controle, JFrame janela, boolean isArtista, Album album, String nomeDigitado,
                              String duracaoDigitado, DefaultListModel<Album> model, List<Album> albuns){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.album = album;
        this.nomeDigitado = nomeDigitado;
        this.duracaoDigitado = duracaoDigitado;
        this.model = model;
        this.albuns = albuns;
    }

    public JButton getBotaoCadastrar(){
        return botaoCadastrar;
    }

    public JButton getBotaoCancelar(){
        return botaoCancelar;
    }

    public JButton getBotaoAlbum(){
        return botaoAlbum;
    }

    public void show(){
        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 24));
		titulo.setForeground(Color.white);
        titulo.setBounds(330, 121, 360, 60);

        nome.setBounds(145, 218, 100, 29);
        nome.setFont(new Font("Ms Gothic", Font.BOLD, 24));
        nome.setForeground(Color.white);

        entradaNome.setBounds(248, 221, 350, 23);
        entradaNome.setLayout(null);
        entradaNome.setText(nomeDigitado);

        duracao.setBounds(125, 250, 300, 29);
        duracao.setFont(new Font("Ms Gothic", Font.BOLD, 24));
        duracao.setForeground(Color.white);
        
        entradaDuracao.setBounds(248, 253, 350, 23);
        entradaDuracao.setLayout(null);
        entradaDuracao.setText(duracaoDigitado);


        if (album != null)
            albuns.add(album);

        model.addElement(album);
        list.setModel(model);
        scrollPane.setViewportView(list);

        list.setForeground(Color.white);
        list.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        list.setBackground(Color.gray);

        list.setBounds(250, 350, 350, 128);
        scrollPane.setBounds(250, 350, 350, 128);


        botaoAlbum.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoAlbum.setBackground(Color.decode("#A020F0"));
        botaoAlbum.setForeground(Color.WHITE);
		botaoAlbum.setBounds(306, 300, 220, 35);
        botaoAlbum.setBorder(null);
        botaoAlbum.setFocusPainted(false);

		botaoCadastrar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoCadastrar.setBackground(Color.decode("#A020F0"));
        botaoCadastrar.setForeground(Color.WHITE);
		botaoCadastrar.setBounds(416, 494, 125, 35);
        botaoCadastrar.setBorder(null);
        botaoCadastrar.setFocusPainted(false);

        botaoCancelar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoCancelar.setBackground(Color.decode("#A020F0"));
        botaoCancelar.setForeground(Color.WHITE);
		botaoCancelar.setBounds(272, 494, 125, 35);
        botaoCancelar.setBorder(null);
        botaoCancelar.setFocusPainted(false);

        janela.add(titulo);
        janela.add(nome);
        janela.add(entradaNome);
        janela.add(duracao);
        janela.add(entradaDuracao);
        janela.add(scrollPane);
        janela.add(botaoAlbum);
        janela.add(botaoCadastrar);
        janela.add(botaoCancelar);

        janela.repaint();
    }




    @Override
    public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

        if (src == botaoCadastrar){

        }

        if (src == botaoAlbum){
            janela.remove(titulo);
            janela.remove(nome);
            janela.remove(entradaNome);
            janela.remove(duracao);
            janela.remove(entradaDuracao);
            janela.remove(scrollPane);
            janela.remove(botaoAlbum);
            janela.remove(botaoCadastrar);
            janela.remove(botaoCancelar);

            TelaAdicionarAlbum telaAdicionarAlbum = new TelaAdicionarAlbum(controle, janela, isArtista, entradaNome.getText(), entradaDuracao.getText(), model, albuns);

            telaAdicionarAlbum.show();

            telaAdicionarAlbum.getBotaoCadastrar().addActionListener(telaAdicionarAlbum);
            telaAdicionarAlbum.getBotaoCancelar().addActionListener(telaAdicionarAlbum);
        }

        if (src == botaoCancelar){
            janela.remove(titulo);
            janela.remove(nome);
            janela.remove(entradaNome);
            janela.remove(duracao);
            janela.remove(entradaDuracao);
            janela.remove(scrollPane);
            janela.remove(botaoAlbum);
            janela.remove(botaoCadastrar);
            janela.remove(botaoCancelar);

            TelaAplicativo telaAplicativo = new TelaAplicativo(controle, janela, isArtista);

            telaAplicativo.show();

            telaAplicativo.getArtBotao().addActionListener(telaAplicativo);
            telaAplicativo.getAlbBotao().addActionListener(telaAplicativo);
            telaAplicativo.getMusBotao().addActionListener(telaAplicativo);
            telaAplicativo.getCAlbmBotao().addActionListener(telaAplicativo);
            telaAplicativo.getCMusBotao().addActionListener(telaAplicativo);
            telaAplicativo.getBotaoVoltar().addActionListener(telaAplicativo);
        }
        
    }

}