package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import controller.Controle;
import model.Artista;

public class TelaAdicionarArtista implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;

    private JLabel titulo = new JLabel("Adicionar Artista:");

    private DefaultListModel<Artista> model = new DefaultListModel<>();
    private JList<Artista> list = new JList<>();

    private JButton botaoCadastrar = new JButton("Cadastrar");
    private JButton botaoCancelar = new JButton("Cancelar");

    private JScrollPane scrollPane = new JScrollPane();

    private String nomeDigitado;
    private String dataDigitado;
    private DefaultListModel<Artista> model1;

    public TelaAdicionarArtista(Controle controle, JFrame janela, boolean isArtista, String nomeDigitado, String dataDigitado, DefaultListModel<Artista> model){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.nomeDigitado = nomeDigitado;
        this.dataDigitado = dataDigitado;
        this.model1 = model;
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

        for (Artista artista : controle.getPesquisa().getArtistas()){
            model.addElement(artista);
        }
        list.setModel(model);
        scrollPane.setViewportView(list);

        list.setForeground(Color.white);
        list.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        list.setBackground(Color.gray);

        list.setBounds(110, 60, 579, 400);
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

            TelaCadastroAlbum telaCadastroAlbum = new TelaCadastroAlbum(controle, janela, isArtista, null, nomeDigitado, dataDigitado, model1);
			
			telaCadastroAlbum.show();

			telaCadastroAlbum.getBotaoCadastrar().addActionListener(telaCadastroAlbum);
			telaCadastroAlbum.getBotaoCancelar().addActionListener(telaCadastroAlbum);
			telaCadastroAlbum.getBotaoArtista().addActionListener(telaCadastroAlbum);
        }

        if (src == botaoCadastrar){
            if (src == botaoCadastrar){
                janela.remove(titulo);
                janela.remove(botaoCadastrar);
                janela.remove(botaoCancelar);
                janela.remove(scrollPane);
    
                TelaCadastroAlbum telaCadastroAlbum = new TelaCadastroAlbum(controle, janela, isArtista, list.getSelectedValue(), nomeDigitado, dataDigitado, model1);
                
                telaCadastroAlbum.show();
    
                telaCadastroAlbum.getBotaoCadastrar().addActionListener(telaCadastroAlbum);
                telaCadastroAlbum.getBotaoCancelar().addActionListener(telaCadastroAlbum);
                telaCadastroAlbum.getBotaoArtista().addActionListener(telaCadastroAlbum);
            }
        }
        
    }
}