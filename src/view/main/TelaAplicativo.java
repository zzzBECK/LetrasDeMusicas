package view.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Controle;
import view.album.TelaAlbuns;
import view.album.cadastro.TelaCadastroAlbum;
import view.album.editar.TelaEditarAlbum;
import view.artista.TelaArtistas;
import view.musica.TelaMusicas;
import view.musica.cadastro.TelaCadastroMusica;
import view.musica.editar.TelaEditarMusica;

public class TelaAplicativo implements ActionListener{
	private Controle controle;
    private JFrame janela;
	private boolean isArtista;

	private JButton musBotao = new JButton("Músicas");
	private JButton albBotao = new JButton("Álbuns");
	private JButton artBotao = new JButton("Artistas");
	private JButton cAlbmBotao = new JButton("Cadastrar Álbum");
	private JButton cMusBotao = new JButton("Cadastrar Música");
	private JButton editarAlbBotao = new JButton("Editar Álbum");
	private JButton editarMusBotao = new JButton("Editar Música");

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

	public JButton getEditarAlbBotao(){
		return editarAlbBotao;
	}

	public JButton getEditarMusBotao(){
		return editarMusBotao;
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
		cAlbmBotao.setBounds(200, 300, 187, 62);
        cAlbmBotao.setBorder(null);
        cAlbmBotao.setFocusPainted(false);

		cMusBotao.setFont(fonte);
		cMusBotao.setBackground(Color.decode("#A020F0"));
        cMusBotao.setForeground(Color.WHITE);
		cMusBotao.setBounds(395, 300, 187, 62);
        cMusBotao.setBorder(null);
        cMusBotao.setFocusPainted(false);

		editarAlbBotao.setFont(fonte);
		editarAlbBotao.setBackground(Color.decode("#A020F0"));
        editarAlbBotao.setForeground(Color.WHITE);
		editarAlbBotao.setBounds(5, 300, 187, 62);
        editarAlbBotao.setBorder(null);
        editarAlbBotao.setFocusPainted(false);

		editarMusBotao.setFont(fonte);
		editarMusBotao.setBackground(Color.decode("#A020F0"));
        editarMusBotao.setForeground(Color.WHITE);
		editarMusBotao.setBounds(590, 300, 187, 62);
        editarMusBotao.setBorder(null);
        editarMusBotao.setFocusPainted(false);

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
			janela.add(editarAlbBotao);
			janela.add(editarMusBotao);
		}


        janela.repaint();
    }


	@Override
    public void actionPerformed(ActionEvent e){
		Object src = e.getSource();

		janela.remove(musBotao);
		janela.remove(albBotao);
		janela.remove(artBotao);
		janela.remove(botaoVoltar);
		janela.remove(cAlbmBotao);
		janela.remove(cMusBotao);
		janela.remove(editarAlbBotao);
		janela.remove(editarMusBotao);

		if (src == artBotao){

			TelaArtistas telaArtistas = new TelaArtistas(controle, janela, isArtista);

			telaArtistas.show();

			telaArtistas.getBotaoVoltar().addActionListener(telaArtistas);
			telaArtistas.getBotaoVisualizar().addActionListener(telaArtistas);
		}

		if (src == albBotao){

			TelaAlbuns telaAlbuns = new TelaAlbuns(controle, janela, isArtista);

			telaAlbuns.show();

			telaAlbuns.getBotaoVoltar().addActionListener(telaAlbuns);
			telaAlbuns.getBotaoVisualizar().addActionListener(telaAlbuns);
		}

		if (src == musBotao){

			TelaMusicas telaMusicas = new TelaMusicas(controle, janela, isArtista);

			telaMusicas.show();

			telaMusicas.getBotaoVoltar().addActionListener(telaMusicas);
			telaMusicas.getBotaoVisualizar().addActionListener(telaMusicas);
		}

		if (src == cAlbmBotao){

			TelaCadastroAlbum telaCadastroAlbum = new TelaCadastroAlbum(controle, janela, isArtista);
			
			telaCadastroAlbum.show();

			telaCadastroAlbum.getBotaoCadastrar().addActionListener(telaCadastroAlbum);
			telaCadastroAlbum.getBotaoCancelar().addActionListener(telaCadastroAlbum);
			telaCadastroAlbum.getBotaoArtista().addActionListener(telaCadastroAlbum);
		}

		if (src == cMusBotao){

			TelaCadastroMusica telaCadastroMusica = new TelaCadastroMusica(controle, janela, isArtista);
			
			telaCadastroMusica.show();

			telaCadastroMusica.getBotaoCadastrar().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoCancelar().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoAlbum().addActionListener(telaCadastroMusica);
			telaCadastroMusica.getBotaoLetra().addActionListener(telaCadastroMusica);
		}

		if (src == editarAlbBotao){

			TelaEditarAlbum telaEditarAlbum = new TelaEditarAlbum(controle, janela, isArtista);

			telaEditarAlbum.show();

			telaEditarAlbum.getBotaoCancelar().addActionListener(telaEditarAlbum);
			telaEditarAlbum.getBotaoVisualizar().addActionListener(telaEditarAlbum);

		}

		if (src ==  editarMusBotao){

			TelaEditarMusica telaEditarMusica = new TelaEditarMusica(controle, janela, isArtista);

			telaEditarMusica.show();

			telaEditarMusica.getBotaoCancelar().addActionListener(telaEditarMusica);
			telaEditarMusica.getBotaoVisualizar().addActionListener(telaEditarMusica);
		}

		if (src == botaoVoltar){
		
			TelaCadastro telaCadastro = new TelaCadastro(controle, janela);

			telaCadastro.getCheckBox().setSelected(false);

			telaCadastro.show();
			telaCadastro.showEstilo();

			telaCadastro.getCheckBox().addActionListener(telaCadastro);
			telaCadastro.getButton().addActionListener(telaCadastro);

		}
	}	

}