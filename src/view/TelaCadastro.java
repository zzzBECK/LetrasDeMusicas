package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaCadastro{
    private static JFrame janela = new JFrame("Cadastro");
    private static JLabel titulo = new JLabel("Cadastro:");
    
    public void show(){
        janela.getContentPane().setBackground(Color.darkGray);
		janela.setResizable(false);
        janela.setSize(800, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(null);

        titulo.setFont(new TelaPrincipal().getFonte());
		titulo.setForeground(Color.white);
        titulo.setBounds(285, 116, 345, 48);


        janela.add(titulo);
        janela.setVisible(true);
    }
}