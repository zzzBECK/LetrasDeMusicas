package view.album;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controller.Controle;
import model.Album;
import view.main.TelaAplicativo;

/**
 * Classe que represnta a tela de listagem de todos os albuns cadastrados
 * @author Alexandre de Santana Beck
 * @since 2023
 * @version 1.0
 */
public class TelaAlbuns implements ActionListener{
    private Controle controle;
    private boolean isArtista;
    private JFrame janela;

    private JLabel titulo = new JLabel("Álbuns");
    
    private JTextField pesquisa = new JTextField();
    private JLabel lupa = new JLabel();

    private DefaultListModel<Album> model = new DefaultListModel<>();
    private JList<Album> list = new JList<>();
    private JScrollPane scrollPane = new JScrollPane();

    private JButton botaoVoltar = new JButton("Voltar");
    private JButton botaoVisualizar = new JButton("Visualizar");

    private KeyListener keyListener = new KeyListener() {
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER){
                showPesquisa(pesquisa.getText());
            }   
        }
  
        public void keyReleased(KeyEvent keyEvent) {

        }
  
        public void keyTyped(KeyEvent keyEvent) {
            showPesquisa(pesquisa.getText());
        }
  
    };

    /**
     * Contrutor padrao da classe TelaAlbuns
     * @param controle
     * @param janela
     * @param isArtista
     */
    public TelaAlbuns(Controle controle, JFrame janela, boolean isArtista){
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


    /**
     * metodo que altera a configuração da tela
     */
    public void show(){

		titulo.setFont(new Font("Ms Gothic", Font.BOLD, 24));
		titulo.setForeground(Color.white);
		titulo.setBounds(370, 15, 200, 48);

        pesquisa.setBounds(505, 20, 185, 20);
        pesquisa.setLayout(null);
        pesquisa.setText(null);
        pesquisa.addKeyListener(keyListener);

        ImageIcon imageIcon = new ImageIcon(new ImageIcon("imgs//lupa.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        lupa.setIcon(imageIcon);
        lupa.setBounds(480, 20, 20, 20);

        for (Album album : controle.getDados().getAlbuns()){
            model.addElement(album);
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
		botaoVoltar.setBounds(264, 494, 125, 35);
        botaoVoltar.setBorder(null);
        botaoVoltar.setFocusPainted(false);

        botaoVisualizar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoVisualizar.setBackground(Color.decode("#A020F0"));
        botaoVisualizar.setForeground(Color.WHITE);
		botaoVisualizar.setBounds(411, 494, 125, 35);
        botaoVisualizar.setBorder(null);
        botaoVisualizar.setFocusPainted(false);

        janela.add(lupa);
        janela.add(titulo);
        janela.add(botaoVoltar);
        janela.add(botaoVisualizar);
        janela.add(scrollPane);
        janela.add(pesquisa);

        janela.repaint();
    }

    /**
     * metodo que atualiza a lista de albuns de acordo com o que foi pesquisado
     * @param digitado
     */
    public void showPesquisa(String digitado){

        model.clear();
        for (Album album : controle.getDados().getAlbuns()){
            String temp = "";
            for (int i = 0; i < digitado.length(); i++){


                if (digitado.length() <= album.getNome().length()){
                    try{
                        temp += album.getNome().charAt(i);
                    }
                    catch (RuntimeException e){
                        System.out.println(e.getMessage());
                        System.out.println("Out of index");
                    }
                }

            }

            if (temp.toLowerCase().equals(digitado.toLowerCase())){
                model.addElement(album);
            }

        }
    }

    /**
     * Metodo que é ativado quando algum evento acontece
     * eventos: visualizar e voltar
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoVisualizar){
            if(list.getSelectedValue() != null){
                janela.remove(lupa);
                janela.remove(titulo);
                janela.remove(scrollPane);
                janela.remove(botaoVisualizar);
                janela.remove(botaoVoltar);
                janela.remove(pesquisa);

                TelaVisualizarAlbum telaVisualizarAlbum = new TelaVisualizarAlbum(controle, janela, isArtista, list.getSelectedValue());

                telaVisualizarAlbum.show();

                telaVisualizarAlbum.getBotaoVoltar().addActionListener(telaVisualizarAlbum);
                telaVisualizarAlbum.getBotaoVisualizar().addActionListener(telaVisualizarAlbum);
            } 
        }

        if (src == botaoVoltar){
            janela.remove(lupa);
            janela.remove(titulo);
            janela.remove(scrollPane);
            janela.remove(botaoVisualizar);
            janela.remove(botaoVoltar);
            janela.remove(pesquisa);

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