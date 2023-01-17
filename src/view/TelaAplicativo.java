package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Controle;
import view.album.TelaAlbuns;
import view.album.cadastro.TelaCadastroAlbum;
import view.artista.TelaArtistas;
import view.musica.TelaMusicas;
import view.musica.cadastro.TelaCadastroMusica;

public class TelaAplicativo implements ActionListener{
	private Controle controle;
    private JFrame janela;
	private boolean isArtista;

	private JButton musBotao = new JButton("Músicas");
	private JButton albBotao = new JButton("Álbuns");
	private JButton artBotao = new JButton("Artistas");
	private JButton cAlbmBotao = new JButton("Cadastrar Álbum");
	private JButton cMusBotao = new JButton("Cadastrar Música");

	private JButton botaoVoltar = new JButton("Voltar");

	private Font fonte = new Font("Ms Gothic", Font.BOLD, 16);


	public TelaAplicativo(Controle controle, JFrame janela, boolean isArtista){
		this.controle = controle;
		this.janela = janela;
		this.isArtista = isArtista;
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

	public JButton getCAlbmBotao() {
		return cAlbmBotao;
	}

	public JButton getCMusBotao() {
		return cMusBotao;
	}

	public JButton getBotaoVoltar(){
		return botaoVoltar;
	}

	public void show(){
		
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
		cAlbmBotao.setBounds(190, 300, 187, 62);
        cAlbmBotao.setBorder(null);
        cAlbmBotao.setFocusPainted(false);

		cMusBotao.setFont(fonte);
		cMusBotao.setBackground(Color.decode("#A020F0"));
        cMusBotao.setForeground(Color.WHITE);
		cMusBotao.setBounds(432, 300, 187, 62);
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


		if (isArtista){
			janela.add(cAlbmBotao);
			janela.add(cMusBotao);
		}


        janela.repaint();
    }


	@Override
    public void actionPerformed(ActionEvent e){
		Object src = e.getSource();

		if (src == artBotao){

			janela.remove(musBotao);
			janela.remove(albBotao);
			janela.remove(artBotao);
			janela.remove(botaoVoltar);
			janela.remove(cAlbmBotao);
			janela.remove(cMusBotao);

			TelaArtistas telaArtistas = new TelaArtistas(controle, janela, isArtista);

			telaArtistas.show();

			telaArtistas.getBotaoVoltar().addActionListener(telaArtistas);
		}

		if (src == albBotao){
			janela.remove(musBotao);
			janela.remove(albBotao);
			janela.remove(artBotao);
			janela.remove(botaoVoltar);
			janela.remove(cAlbmBotao);
			janela.remove(cMusBotao);

			TelaAlbuns telaAlbuns = new TelaAlbuns(controle, janela, isArtista);

			telaAlbuns.show();

			telaAlbuns.getBotaoVoltar().addActionListener(telaAlbuns);
			telaAlbuns.getBotaoVisualizar().addActionListener(telaAlbuns);
		}

		if (src == musBotao){
			janela.remove(musBotao);
			janela.remove(albBotao);
			janela.remove(artBotao);
			janela.remove(botaoVoltar);
			janela.remove(cAlbmBotao);
			janela.remove(cMusBotao);

			TelaMusicas telaMusicas = new TelaMusicas(controle, janela, isArtista);

			telaMusicas.show();

			telaMusicas.getBotaoVoltar().addActionListener(telaMusicas);
			telaMusicas.getBotaoVisualizar().addActionListener(telaMusicas);
		}

		if (src == cAlbmBotao){
			janela.remove(musBotao);
			janela.remove(albBotao);
			janela.remove(artBotao);
			janela.remove(botaoVoltar);
			janela.remove(cAlbmBotao);
			janela.remove(cMusBotao);

			TelaCadastroAlbum telaCadastroAlbum = new TelaCadastroAlbum(controle, janela, isArtista);
			
			telaCadastroAlbum.show();

			telaCadastroAlbum.getBotaoCadastrar().addActionListener(telaCadastroAlbum);
			telaCadastroAlbum.getBotaoCancelar().addActionListener(telaCadastroAlbum);
			telaCadastroAlbum.getBotaoArtista().addActionListener(telaCadastroAlbum);
		}

		if (src == cMusBotao){
			janela.remove(musBotao);
			janela.remove(albBotao);
			janela.remove(artBotao);
			janela.remove(botaoVoltar);
			janela.remove(cAlbmBotao);
			janela.remove(cMusBotao);

			TelaCadastroMusica telaCadastroMusica = new TelaCadastroMusica(controle, janela, isArtista);
			
			telaCadastroMusica.show();

			telaCadastroMusica.getBotaoCadastrar().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoCancelar().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoAlbum().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoLetra().addActionListener(telaCadastroMusica);
		}

		if (src == botaoVoltar){

			janela.remove(musBotao);
			janela.remove(albBotao);
			janela.remove(artBotao);
			janela.remove(botaoVoltar);
			janela.remove(cAlbmBotao);
			janela.remove(cMusBotao);
			
			TelaCadastro telaCadastro = new TelaCadastro(controle, janela);

			telaCadastro.getCheckBox().setSelected(false);

			telaCadastro.show();
			telaCadastro.showEstilo();

			telaCadastro.getCheckBox().addActionListener(telaCadastro);
			telaCadastro.getButton().addActionListener(telaCadastro);

		}
	}	

}