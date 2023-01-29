package view.musica.cadastro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.Controle;
import model.Album;
import view.main.TelaAplicativo;

/**
 * Classe que representa a tela de cadastrar musica
 * @author Alexandre de Santana Beck
 * @since 2023
 * @version 1.0
 */
public class TelaCadastroMusica implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;

    private JLabel titulo = new JLabel("Cadastro:");

    private JLabel nome = new JLabel("Nome:");
    private JTextField entradaNome = new JTextField();

    private JLabel duracao = new JLabel("Duração:");
    private JTextField entradaDuracao = new JTextField();

    private JButton botaoLetra = new JButton("Adicionar Letra");
    private JButton botaoCadastrar = new JButton("Cadastrar");
    private JButton botaoCancelar = new JButton("Cancelar");
    private JButton botaoAlbum = new JButton("Adicionar Album");

    private DefaultListModel<Album> model = new DefaultListModel<>();
    private JScrollPane scrollPane = new JScrollPane();
    private JList<Album> list = new JList<>();

    private Album album;
    private String nomeDigitado;
    private String duracaoDigitado;
    private String letraDigitado;


    /**
     * construtor padrao da classe
     * @param controle
     * @param janela
     * @param isArtista
     */
    public TelaCadastroMusica(Controle controle, JFrame janela, boolean isArtista){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
    }

    /**
     * construtor utilizado pelas classes TelaAdicionarAlbum e TelaAdicionarLetra
     * @param controle
     * @param janela
     * @param isArtista
     * @param album
     * @param nomeDigitado
     * @param duracaoDigitado
     * @param model
     * @param letraDigitado
     */
    public TelaCadastroMusica(Controle controle, JFrame janela, boolean isArtista, Album album, String nomeDigitado,
                              String duracaoDigitado, DefaultListModel<Album> model, String letraDigitado){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.album = album;
        this.nomeDigitado = nomeDigitado;
        this.duracaoDigitado = duracaoDigitado;
        this.model = model;
        this.letraDigitado = letraDigitado;
    }

    public JButton getBotaoCadastrar(){
        return botaoCadastrar;
    }

    public JButton getBotaoCancelar(){
        return botaoCancelar;
    }

    public JButton getBotaoAlbum(){
        return botaoAlbum;
    }

    public JButton getBotaoLetra(){
        return botaoLetra;
    }

    /**
     * metodo que faz a configuração da tela e faz sua atualização
     */
    public void show(){
        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 24));
		titulo.setForeground(Color.white);
        titulo.setBounds(330, 70, 360, 60);

        nome.setBounds(145, 170, 100, 29);
        nome.setFont(new Font("Ms Gothic", Font.BOLD, 24));
        nome.setForeground(Color.white);
        
        entradaNome.setText(nomeDigitado);
        entradaNome.setBounds(248, 173, 350, 23);
        entradaNome.setLayout(null);
        entradaNome.setText(nomeDigitado);

        duracao.setBounds(125, 200, 300, 29);
        duracao.setFont(new Font("Ms Gothic", Font.BOLD, 24));
        duracao.setForeground(Color.white);
        
        entradaDuracao.setText(duracaoDigitado);
        entradaDuracao.setBounds(248, 203, 350, 23);
        entradaDuracao.setLayout(null);
        entradaDuracao.setText(duracaoDigitado);

        model.removeAllElements();
        model.addElement(album);
        list.setModel(model);
        scrollPane.setViewportView(list);

        list.setForeground(Color.white);
        list.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        list.setBackground(Color.gray);

        list.setBounds(250, 350, 350, 128);
        scrollPane.setBounds(250, 350, 350, 128);

        botaoLetra.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoLetra.setBackground(Color.decode("#A020F0"));
        botaoLetra.setForeground(Color.WHITE);
		botaoLetra.setBounds(306, 260, 220, 35);
        botaoLetra.setBorder(null);
        botaoLetra.setFocusPainted(false);

        botaoAlbum.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoAlbum.setBackground(Color.decode("#A020F0"));
        botaoAlbum.setForeground(Color.WHITE);
		botaoAlbum.setBounds(306, 300, 220, 35);
        botaoAlbum.setBorder(null);
        botaoAlbum.setFocusPainted(false);

		botaoCadastrar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoCadastrar.setBackground(Color.decode("#A020F0"));
        botaoCadastrar.setForeground(Color.WHITE);
		botaoCadastrar.setBounds(416, 494, 125, 35);
        botaoCadastrar.setBorder(null);
        botaoCadastrar.setFocusPainted(false);

        botaoCancelar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoCancelar.setBackground(Color.decode("#A020F0"));
        botaoCancelar.setForeground(Color.WHITE);
		botaoCancelar.setBounds(272, 494, 125, 35);
        botaoCancelar.setBorder(null);
        botaoCancelar.setFocusPainted(false);

        janela.add(titulo);
        janela.add(nome);
        janela.add(entradaNome);
        janela.add(duracao);
        janela.add(entradaDuracao);
        janela.add(scrollPane);
        janela.add(botaoAlbum);
        janela.add(botaoLetra);
        janela.add(botaoCadastrar);
        janela.add(botaoCancelar);

        janela.repaint();
    }

    /**
     * metodo que é executado quando um evento é realizado
     * eventos: adicionar album, adicionar letra, cancelar, cadastar musica
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

        if (src == botaoCadastrar){
            if (entradaNome.getText().length() < 3){
                JOptionPane.showMessageDialog(null, "Nome inválido!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                try{
                    if (Double.parseDouble(entradaDuracao.getText()) <= 0 || (Double.parseDouble(entradaDuracao.getText()) - (int)Double.parseDouble(entradaDuracao.getText())) >= 0.6){
                        JOptionPane.showMessageDialog(null, "Duração inválida!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (letraDigitado.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Adicione uma letra!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (album == null){
                        JOptionPane.showMessageDialog(null, "Adicione um album!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }

                    else{
                        janela.remove(titulo);
                        janela.remove(nome);
                        janela.remove(entradaNome);
                        janela.remove(duracao);
                        janela.remove(entradaDuracao);
                        janela.remove(scrollPane);
                        janela.remove(botaoAlbum);
                        janela.remove(botaoLetra);
                        janela.remove(botaoCadastrar);
                        janela.remove(botaoCancelar);

                        Double dur = Double.parseDouble(entradaDuracao.getText());

                        controle.musica(entradaNome.getText(), letraDigitado, dur, album);

                        TelaAplicativo telaAplicativo = new TelaAplicativo(controle, janela, isArtista);

                        telaAplicativo.show();

                        telaAplicativo.getArtBotao().addActionListener(telaAplicativo);
                        telaAplicativo.getAlbBotao().addActionListener(telaAplicativo);
                        telaAplicativo.getMusBotao().addActionListener(telaAplicativo);
                        telaAplicativo.getCAlbmBotao().addActionListener(telaAplicativo);
                        telaAplicativo.getCMusBotao().addActionListener(telaAplicativo);
                        telaAplicativo.getBotaoVoltar().addActionListener(telaAplicativo);
                        telaAplicativo.getEditarAlbBotao().addActionListener(telaAplicativo);
                        telaAplicativo.getEditarMusBotao().addActionListener(telaAplicativo);
                    }
                }
                catch(Exception e1){
                    JOptionPane.showMessageDialog(null, "Duração inválida ou música sem letra!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        if (src == botaoAlbum){
            janela.remove(titulo);
            janela.remove(nome);
            janela.remove(entradaNome);
            janela.remove(duracao);
            janela.remove(entradaDuracao);
            janela.remove(scrollPane);
            janela.remove(botaoAlbum);
            janela.remove(botaoLetra);
            janela.remove(botaoCadastrar);
            janela.remove(botaoCancelar);

            TelaAdicionarAlbum telaAdicionarAlbum = new TelaAdicionarAlbum(controle, janela, isArtista, entradaNome.getText(), entradaDuracao.getText(), model, letraDigitado);

            telaAdicionarAlbum.show();

            telaAdicionarAlbum.getBotaoCadastrar().addActionListener(telaAdicionarAlbum);
            telaAdicionarAlbum.getBotaoCancelar().addActionListener(telaAdicionarAlbum);
        }

        if (src == botaoLetra){
            janela.remove(titulo);
            janela.remove(nome);
            janela.remove(entradaNome);
            janela.remove(duracao);
            janela.remove(entradaDuracao);
            janela.remove(scrollPane);
            janela.remove(botaoAlbum);
            janela.remove(botaoLetra);
            janela.remove(botaoCadastrar);
            janela.remove(botaoCancelar);

            TelaAdicionarLetra telaAdicionarLetra = new TelaAdicionarLetra(controle, janela, isArtista, entradaNome.getText(), entradaDuracao.getText(), model, album, letraDigitado);

            telaAdicionarLetra.show();

            telaAdicionarLetra.getBotaoCancelar().addActionListener(telaAdicionarLetra);
            telaAdicionarLetra.getButaoSalvar().addActionListener(telaAdicionarLetra);
        }

        if (src == botaoCancelar){
            janela.remove(titulo);
            janela.remove(nome);
            janela.remove(entradaNome);
            janela.remove(duracao);
            janela.remove(entradaDuracao);
            janela.remove(scrollPane);
            janela.remove(botaoAlbum);
            janela.remove(botaoLetra);
            janela.remove(botaoCadastrar);
            janela.remove(botaoCancelar);

            TelaAplicativo telaAplicativo = new TelaAplicativo(controle, janela, isArtista);

            telaAplicativo.show();

            telaAplicativo.getArtBotao().addActionListener(telaAplicativo);
            telaAplicativo.getAlbBotao().addActionListener(telaAplicativo);
            telaAplicativo.getMusBotao().addActionListener(telaAplicativo);
            telaAplicativo.getCAlbmBotao().addActionListener(telaAplicativo);
            telaAplicativo.getCMusBotao().addActionListener(telaAplicativo);
            telaAplicativo.getBotaoVoltar().addActionListener(telaAplicativo);
            telaAplicativo.getEditarAlbBotao().addActionListener(telaAplicativo);
            telaAplicativo.getEditarMusBotao().addActionListener(telaAplicativo);
        }
        
    }

}