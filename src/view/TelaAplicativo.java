package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Controle;

public class TelaAplicativo implements ActionListener{
    private static JFrame janela = new JFrame("Aplicativo");

	private static JButton musBotao = new JButton("Músicas");
	private static JButton albBotao = new JButton("Álbuns");
	private static JButton artBotao = new JButton("Artistas");
	private static JButton cAlbmBotao = new JButton("Cadastrar Álbum");
	private static JButton cMusBotao = new JButton("Cadastrar Música");

	private static JButton botaoVoltar = new JButton("Voltar");

	private Font fonte = new Font("Ms Gothic", Font.BOLD, 16);

	private Controle controle;
	public TelaAplicativo(Controle controle){
		this.controle = controle;
	}

	public Controle getControle(){
		return controle;
	}
	
	public JButton getMusBotao() {
		return musBotao;
	}

	public JButton getAlbBotao() {
		return albBotao;
	}

	public JButton getArtBotao() {
		return artBotao;
	}

	public JButton getcAlbmBotao() {
		return cAlbmBotao;
	}

	public JButton getcMusBotao() {
		return cMusBotao;
	}

	public JButton getBotaoVoltar(){
		return botaoVoltar;
	}

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

		botaoVoltar.setFont(fonte);
		botaoVoltar.setBackground(Color.decode("#A020F0"));
        botaoVoltar.setForeground(Color.WHITE);
		botaoVoltar.setBounds(337, 494, 125, 35);
        botaoVoltar.setBorder(null);
        botaoVoltar.setFocusPainted(false);
	
		janela.add(musBotao);
		janela.add(albBotao);
		janela.add(artBotao);
		janela.add(botaoVoltar);


		if (artista){
			janela.add(cAlbmBotao);
			janela.add(cMusBotao);
		}


        janela.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
		Object src = e.getSource();

		if (src == artBotao){
			janela.dispose();
			TelaArtistas telaArtistas = new TelaArtistas(controle);

			telaArtistas.show();
		}

		if (src == botaoVoltar){
			janela.dispose();
			
			TelaCadastro telaCadastro = new TelaCadastro(controle);

			telaCadastro.getCheckBox().setSelected(false);

			telaCadastro.show();
			telaCadastro.showEstilo();

		}
	}	

}