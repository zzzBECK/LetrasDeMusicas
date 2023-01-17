package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Controle;

public class TelaInicial implements ActionListener{
    private Controle controle = new Controle();
    private JFrame janela = new JFrame("Letras de Músicas");

	private JLabel titulo = new JLabel("Letras de Músicas");
	private JButton botao = new JButton("Entrar");
	private Font fonte = new Font("Ms Gothic", Font.BOLD, 24);


    public void show(){

        janela.getContentPane().setBackground(Color.darkGray);
		janela.setResizable(false);
		janela.setSize(800, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titulo.setFont(fonte);
		titulo.setForeground(Color.white);
		titulo.setBounds(285, 116, 345, 48);
		 
		botao.setFont(fonte);
		botao.setBackground(Color.decode("#A020F0"));
        botao.setForeground(Color.WHITE);
		botao.setBounds(342, 404, 125, 35);
        botao.setBorder(null);
        botao.setFocusPainted(false);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(botao);
		

        janela.setVisible(true);

    }

	public JButton getBotao(){
		return botao;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Object src = e.getSource();

		if (src == botao){

			janela.remove(titulo);
			janela.remove(botao);

			TelaCadastro telaCadastro = new TelaCadastro(controle, janela);
			telaCadastro.show();

			telaCadastro.getCheckBox().addActionListener(telaCadastro);
			telaCadastro.getButton().addActionListener(telaCadastro);
		}

	}
}