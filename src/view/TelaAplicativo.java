package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaAplicativo {
    private static JFrame janela = new JFrame("Aplicativo");
	private static JLabel titulo = new JLabel("Letras de Músicas");
	
	public TelaAplicativo(){
        janela.getContentPane().setBackground(Color.darkGray);
        
		janela.setResizable(false);
		
		titulo.setFont(new Font("MS Gothic", Font.BOLD, 24));
		titulo.setForeground(Color.white);
		titulo.setBounds(285, 116, 345, 48);

        janela.setLayout(null);
		
		janela.add(titulo);
		
		janela.setSize(800, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
	

}