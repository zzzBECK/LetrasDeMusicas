package view;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import controller.Controle;
import model.Artista;

public class TelaArtistas {
    private Controle controle;
    
    private static JFrame janela = new JFrame();
    private static JList<Artista> jList = new JList<>();

    private static JLabel artista = new JLabel();

    
    public TelaArtistas(Controle controle){
        this.controle = controle;
    }

    public void show(){
        janela.getContentPane().setBackground(Color.darkGray);
		janela.setResizable(false);
        janela.setSize(800, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(null);

        artista.setText(controle.getPesquisa().getArtistas().get(0).toString());
        artista.setBounds(200, 200, 800, 600);
        artista.setForeground(Color.white);
        // jList.

        // jList.add(controle.getPesquisa().getArtistas());
    
        janela.add(artista);

        janela.setVisible(true);
    }
}   