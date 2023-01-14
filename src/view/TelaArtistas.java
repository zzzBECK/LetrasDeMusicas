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

import controller.Controle;
import model.Artista;

public class TelaArtistas implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;
    
    private JList<Artista> jList = new JList<>();

    private JLabel artista = new JLabel();

    private JButton botaoVoltar = new JButton("Voltar");

    
    public TelaArtistas(Controle controle, JFrame janela, boolean isArtista){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
    }

    public JButton getBotaoVoltar(){
        return botaoVoltar;
    }

    public void show(){

        try{
            artista.setText(controle.getPesquisa().getArtistas().get(0).toString());
        
        }
        catch(RuntimeException e){
            artista.setText("Não há artistas cadastrados");
            System.out.println(e.getMessage());
        }
        finally{
            artista.setBounds(200, 100, 800, 600);
            artista.setForeground(Color.white);
            janela.add(artista);
        }

        botaoVoltar.setFont( new Font("Ms Gothic", Font.BOLD, 16));
		botaoVoltar.setBackground(Color.decode("#A020F0"));
        botaoVoltar.setForeground(Color.WHITE);
		botaoVoltar.setBounds(337, 494, 125, 35);
        botaoVoltar.setBorder(null);
        botaoVoltar.setFocusPainted(false);

        janela.add(botaoVoltar);

        janela.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoVoltar){
            janela.remove(artista);
            janela.remove(botaoVoltar);

            TelaAplicativo telaAplicativo = new TelaAplicativo(controle, janela, isArtista);

            telaAplicativo.show();

            telaAplicativo.getArtBotao().addActionListener(telaAplicativo);
            telaAplicativo.getBotaoVoltar().addActionListener(telaAplicativo);
        }
        
    }
}   