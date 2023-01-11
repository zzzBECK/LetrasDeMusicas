package view;

import java.awt.Color;

import javax.swing.JFrame;

public class TelaCadastro {
    private static JFrame janela = new JFrame("Aplicativo");
    
    public TelaCadastro(){
        janela.getContentPane().setBackground(Color.darkGray);
		janela.setResizable(false);
    }
}