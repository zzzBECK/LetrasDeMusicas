package view;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
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

    private static JButton botaoVoltar = new JButton("Voltar");

    
    public TelaArtistas(Controle controle){
        this.controle = controle;
    }

    public void show(){
        janela.getContentPane().setBackground(Color.darkGray);
		janela.setResizable(false);
        janela.setSize(800, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(null);

        try{
            artista.setText(controle.getPesquisa().getArtistas().get(0).toString());

            // jList.

            // jList.add(controle.getPesquisa().getArtistas());
        
        }
        catch(RuntimeException e){
            artista.setText("Não há artistas cadastrados");
            System.out.println(e.getMessage());
        }
        finally{
            artista.setBounds(200, 200, 800, 600);
            artista.setForeground(Color.white);
            janela.add(artista);
        }

        

        janela.setVisible(true);
    }
}   