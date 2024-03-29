package view.artista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controller.Controle;
import model.Artista;
import view.main.TelaAplicativo;

/**
 * Classe que representa a tela de listagem dos artistas cadastrados
 * @author Alexandre de Santana Beck
 * @since 2023
 * @version 1.0
 */
public class TelaArtistas implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;

    private JLabel titulo = new JLabel("Artistas");

    private JTextField pesquisa = new JTextField();
    private JLabel lupa = new JLabel();
    
    private DefaultListModel<Artista> model = new DefaultListModel<>();
    private JList<Artista> list = new JList<>();
    private JScrollPane scrollPane = new JScrollPane();

    private JButton botaoVoltar = new JButton("Voltar");
    private JButton botaoVisualizar = new JButton("Visualizar");
    private JButton botaoSeguir = new JButton("Seguir");
    private JButton botaoPararDeSeguir = new JButton("Parar de Seguir");

    private KeyListener keyListener = new KeyListener() {
        /**
         * metodo de verificação ao apertar o enter, para realizar a atualização da lista por meio da pesquisa
         * @param keyEvent
         */
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER){
                showPesquisa(pesquisa.getText());
            }   
        }
        /**
         * metodo vazio, pois é obrigarótio ao instanciar um KeyListener
         * @param keyEvent
         */
        public void keyReleased(KeyEvent keyEvent) {

        }
        /**
         * metodo de verificação ao apertar o qualquer tecla, para realizar a atualização da lista por meio da pesquisa
         * @param keyEvent
         */
        public void keyTyped(KeyEvent keyEvent) {
            showPesquisa(pesquisa.getText());
        }
  
    };

    /**
     * Construtor padrao da classe
     * @param controle
     * @param janela
     * @param isArtista
     */
    public TelaArtistas(Controle controle, JFrame janela, boolean isArtista){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
    }

    public JButton getBotaoVoltar(){
        return botaoVoltar;
    }

    public JButton getBotaoVisualizar(){
        return botaoVisualizar;
    }

    public JButton getBotaoSeguir() {
        return botaoSeguir;
    }

    public JButton getBotaoPararDeSeguir(){
        return botaoPararDeSeguir;
    }

    /**
     * metodo que faz a configuração da página e faz sua atualização
     */
    public void show(){
        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 24));
		titulo.setForeground(Color.white);
		titulo.setBounds(360, 15, 200, 48);

        pesquisa.setBounds(505, 20, 185, 20);
        pesquisa.setLayout(null);
        pesquisa.setText(null);
        pesquisa.addKeyListener(keyListener);

        ImageIcon imageIcon = new ImageIcon(new ImageIcon("imgs//lupa.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        lupa.setIcon(imageIcon);
        lupa.setBounds(480, 20, 20, 20);

        model.clear();
        for (Artista artista : controle.getDados().getArtistas()){
            model.addElement(artista);
        }
        list.setModel(model);
        scrollPane.setViewportView(list);

        list.setForeground(Color.white);
        list.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        list.setBounds(110, 60, 579, 420);
        list.setBackground(Color.gray);

        DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
        renderer.setHorizontalAlignment(JLabel.CENTER);

        scrollPane.setBounds(110, 60, 579, 420);

        botaoVoltar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoVoltar.setBackground(Color.decode("#A020F0"));
        botaoVoltar.setForeground(Color.WHITE);
		botaoVoltar.setBounds(117, 494, 125, 35);
        botaoVoltar.setBorder(null);
        botaoVoltar.setFocusPainted(false);

        botaoVisualizar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoVisualizar.setBackground(Color.decode("#A020F0"));
        botaoVisualizar.setForeground(Color.WHITE);
		botaoVisualizar.setBounds(264, 494, 125, 35);
        botaoVisualizar.setBorder(null);
        botaoVisualizar.setFocusPainted(false);

        botaoSeguir.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        botaoSeguir.setBackground(Color.decode("#A020F0"));
        botaoSeguir.setForeground(Color.WHITE);
        botaoSeguir.setBounds(411, 494, 125, 35);
        botaoSeguir.setBorder(null);
        botaoSeguir.setFocusPainted(false);

        botaoPararDeSeguir.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        botaoPararDeSeguir.setBackground(Color.decode("#A020F0"));
        botaoPararDeSeguir.setForeground(Color.WHITE);
        botaoPararDeSeguir.setBounds(558, 494, 125, 35);
        botaoPararDeSeguir.setBorder(null);
        botaoPararDeSeguir.setFocusPainted(false);

        janela.add(lupa);
        janela.add(titulo);
        janela.add(botaoVoltar);
        janela.add(botaoVisualizar);
        janela.add(scrollPane);
        janela.add(pesquisa);
        janela.add(botaoSeguir);
        janela.add(botaoPararDeSeguir);

        janela.repaint();
    }

    /**
     * metodo que atualiza a lista de artistas de acordo com o que foi digitado na barra de pesquisa
     * @param digitado
     */
    public void showPesquisa(String digitado){

        model.clear();
        for (Artista artista : controle.getDados().getArtistas()){
            String temp = "";
            for (int i = 0; i < digitado.length(); i++){


                if (digitado.length() <= artista.getNome().length()){
                    try{
                        temp += artista.getNome().charAt(i);
                    }
                    catch (RuntimeException e){
                        System.out.println(e.getMessage());
                        System.out.println("Out of index");
                    }
                }

            }

            if (temp.equalsIgnoreCase(digitado)){
                model.addElement(artista);
            }

        }
    }

    /**
     * metodo que é executado ao realizar um evento
     * eventos: visualizar artista, voltar para TelaAplicativo, seguir e parar de seguir
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoVisualizar){
            if (list.getSelectedValue() != null){

                janela.remove(lupa);
                janela.remove(titulo);
                janela.remove(botaoVoltar);
                janela.remove(botaoVisualizar);
                janela.remove(scrollPane);
                janela.remove(pesquisa);
                janela.remove(botaoSeguir);
                janela.remove(botaoPararDeSeguir);

                TelaVisualizarArtista telaVisualizarArtista = new TelaVisualizarArtista(controle, janela, isArtista, list.getSelectedValue());

                telaVisualizarArtista.show();

                telaVisualizarArtista.getBotaoVoltar().addActionListener(telaVisualizarArtista);
                telaVisualizarArtista.getBotaoVisualizar().addActionListener(telaVisualizarArtista);
            }
        }

        if (src == botaoVoltar){
            janela.remove(lupa);
            janela.remove(titulo);
            janela.remove(botaoVoltar);
            janela.remove(botaoVisualizar);
            janela.remove(scrollPane);
            janela.remove(pesquisa);
            janela.remove(botaoSeguir);
            janela.remove(botaoPararDeSeguir);

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

        if (src == botaoSeguir){
            if (list.getSelectedValue() != null){
                list.getSelectedValue().seguirArtista(list.getSelectedValue());

                show();
            }
        }

        if (src == botaoPararDeSeguir){
            if (list.getSelectedValue() != null){
                list.getSelectedValue().pararDeSeguirArtista(list.getSelectedValue());
            }

            show();
        }
        
    }
}   