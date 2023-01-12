package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaAplicativo {
    private static JFrame janela = new JFrame("Aplicativo");

	private static JButton musBotao = new JButton("Músicas");
	private static JButton albBotao = new JButton("Álbuns");
	private static JButton artBotao = new JButton("Artistas");
	private static JButton cAlbmBotao = new JButton("Cadastrar Álbum");
	private static JButton cMusBotao = new JButton("Cadastrar Música");

	private Font fonte = new Font("Ms Gothic", Font.BOLD, 16);

	
	public void show(boolean artista){
        janela.getContentPane().setBackground(Color.darkGray);
		janela.setResizable(false);
        janela.setSize(800, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(null);
		
		musBotao.setFont(fonte);
		musBotao.setBackground(Color.decode("#A020F0"));
        musBotao.setForeground(Color.WHITE);
		musBotao.setBounds(73, 123, 187, 62);
        musBotao.setBorder(null);
        musBotao.setFocusPainted(false);

		albBotao.setFont(fonte);
		albBotao.setBackground(Color.decode("#A020F0"));
        albBotao.setForeground(Color.WHITE);
		albBotao.setBounds(306, 123, 187, 62);
        albBotao.setBorder(null);
       	albBotao.setFocusPainted(false);

		artBotao.setFont(fonte);
		artBotao.setBackground(Color.decode("#A020F0"));
        artBotao.setForeground(Color.WHITE);
		artBotao.setBounds(539, 123, 187, 62);
        artBotao.setBorder(null);
        artBotao.setFocusPainted(false);

		cAlbmBotao.setFont(fonte);
		cAlbmBotao.setBackground(Color.decode("#A020F0"));
        cAlbmBotao.setForeground(Color.WHITE);
		cAlbmBotao.setBounds(190, 387, 187, 62);
        cAlbmBotao.setBorder(null);
        cAlbmBotao.setFocusPainted(false);

		cMusBotao.setFont(fonte);
		cMusBotao.setBackground(Color.decode("#A020F0"));
        cMusBotao.setForeground(Color.WHITE);
		cMusBotao.setBounds(432, 387, 187, 62);
        cMusBotao.setBorder(null);
        cMusBotao.setFocusPainted(false);
	
		janela.add(musBotao);
		janela.add(albBotao);
		janela.add(artBotao);


		if (artista){
			janela.add(cAlbmBotao);
			janela.add(cMusBotao);
		}


        janela.setVisible(true);
    }
	

}