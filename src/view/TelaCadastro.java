package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastro{
    private static JFrame janela = new JFrame("Cadastro");
    private static JLabel titulo = new JLabel("Cadastro:");
    private static JLabel nome = new JLabel("Nome:");
    private static JTextField entradaNome = new JTextField();
    
    private Font fonte = new TelaPrincipal().getFonte();


    public void show(){
        janela.getContentPane().setBackground(Color.darkGray);
		janela.setResizable(false);
        janela.setSize(800, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(null);

        titulo.setFont(fonte);
		titulo.setForeground(Color.white);
        titulo.setBounds(330, 121, 360, 60);

        nome.setBounds(145, 218, 100, 29);
        nome.setFont(fonte);

        entradaNome.setBounds(248, 221, 350, 23);
        entradaNome.setLayout(null);
        entradaNome.setEnabled(false);


        janela.add(titulo);
        janela.add(nome);
        janela.add(entradaNome);

        janela.setVisible(true);
    }
}