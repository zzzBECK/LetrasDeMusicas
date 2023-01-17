package view.musica.cadastro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import controller.Controle;
import model.Album;

public class TelaAdicionarAlbum implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;

    private JLabel titulo = new JLabel("Adicionar Album:");

    private DefaultListModel<Album> model = new DefaultListModel<>();
    private JList<Album> list = new JList<>();

    private JButton botaoCadastrar = new JButton("Cadastrar");
    private JButton botaoCancelar = new JButton("Cancelar");

    private JScrollPane scrollPane = new JScrollPane();

    private String nomeDigitado;
    private String duracaoDigitado;
    private DefaultListModel<Album> model1;
    private String letra;


    public TelaAdicionarAlbum(Controle controle, JFrame janela, boolean isArtista, String nomeDigitado,
                              String duracaoDigitado, DefaultListModel<Album> model, String letra){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.nomeDigitado = nomeDigitado;
        this.duracaoDigitado = duracaoDigitado;
        this.model1 = model;
        this.letra = letra;
    }

    public JButton getBotaoCadastrar(){
        return botaoCadastrar;
    }

    public JButton getBotaoCancelar(){
        return botaoCancelar;
    }


    public void show(){

        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 24));
		titulo.setForeground(Color.white);
		titulo.setBounds(300, 15, 300, 48);

        for (Album album : controle.getPesquisa().getAlbuns()){
            model.addElement(album);
        }
        list.setModel(model);
        scrollPane.setViewportView(list);

        list.setForeground(Color.white);
        list.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        list.setBackground(Color.gray);
        list.setBounds(110, 60, 579, 400);

        DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
        renderer.setHorizontalAlignment(JLabel.CENTER);

        scrollPane.setBounds(110, 60, 579, 400);

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
        janela.add(botaoCadastrar);
        janela.add(botaoCancelar);
        janela.add(scrollPane);


        janela.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoCancelar){
            janela.remove(titulo);
            janela.remove(botaoCadastrar);
            janela.remove(botaoCancelar);
            janela.remove(scrollPane);

            TelaCadastroMusica telaCadastroMusica = new TelaCadastroMusica(controle, janela, isArtista, null, nomeDigitado, duracaoDigitado, model1, letra);
			
            telaCadastroMusica.show();
    
			telaCadastroMusica.getBotaoCadastrar().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoCancelar().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoAlbum().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoLetra().addActionListener(telaCadastroMusica);
        }

        if (src == botaoCadastrar){
            if (list.getSelectedValue() != null){
                janela.remove(titulo);
                janela.remove(botaoCadastrar);
                janela.remove(botaoCancelar);
                janela.remove(scrollPane);
    
                TelaCadastroMusica telaCadastroMusica = new TelaCadastroMusica(controle, janela, isArtista, list.getSelectedValue(), nomeDigitado, duracaoDigitado, model1, letra);
                
                telaCadastroMusica.show();
    
                telaCadastroMusica.getBotaoCadastrar().addActionListener(telaCadastroMusica);
                telaCadastroMusica.getBotaoCancelar().addActionListener(telaCadastroMusica);
                telaCadastroMusica.getBotaoAlbum().addActionListener(telaCadastroMusica);
                telaCadastroMusica.getBotaoLetra().addActionListener(telaCadastroMusica);
            }
        }
        
    }
}