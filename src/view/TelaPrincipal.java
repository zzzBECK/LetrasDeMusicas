package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaPrincipal {

    private static JFrame janela = new JFrame("Letras de Músicas");
	private static JLabel titulo = new JLabel("Letras de Músicas");
	private static JButton botao = new JButton("Entrar");

    public TelaPrincipal(){
        janela.getContentPane().setBackground(Color.darkGray);
		janela.setResizable(false);
		
		titulo.setFont(new Font("MS Gothic", Font.BOLD, 24));
		titulo.setForeground(Color.white);
		titulo.setBounds(285, 116, 345, 48);
		 
		
		botao.setBackground(Color.magenta);
        botao.setForeground(Color.WHITE);
		botao.setBounds(342, 404, 125, 35);
        botao.setBorder(null);
        botao.setFocusPainted(false);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(botao);
		
		janela.setSize(800, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

    }
    
}