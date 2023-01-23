package view.artista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.Controle;
import model.Artista;
import view.main.TelaAplicativo;

public class TelaArtistas implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;

    private JLabel titulo = new JLabel("Artistas");

    private JTextField pesquisa = new JTextField();
    
    private DefaultListModel<Artista> model = new DefaultListModel<>();
    private JList<Artista> list = new JList<>();
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

    public void show(){
        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 24));
		titulo.setForeground(Color.white);
		titulo.setBounds(360, 15, 200, 48);

        pesquisa.setBounds(505, 20, 185, 20);
        pesquisa.setLayout(null);
        pesquisa.setText(null);
        pesquisa.addKeyListener(keyListener);

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
		botaoVoltar.setBounds(264, 494, 125, 35);
        botaoVoltar.setBorder(null);
        botaoVoltar.setFocusPainted(false);

        botaoVisualizar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoVisualizar.setBackground(Color.decode("#A020F0"));
        botaoVisualizar.setForeground(Color.WHITE);
		botaoVisualizar.setBounds(411, 494, 125, 35);
        botaoVisualizar.setBorder(null);
        botaoVisualizar.setFocusPainted(false);

        janela.add(titulo);
        janela.add(botaoVoltar);
        janela.add(botaoVisualizar);
        janela.add(scrollPane);
        janela.add(pesquisa);

        janela.repaint();
    }

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

            if (temp.toLowerCase().equals(digitado.toLowerCase())){
                model.addElement(artista);
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoVisualizar){
            if (list.getSelectedValue() != null){

                janela.remove(titulo);
                janela.remove(botaoVoltar);
                janela.remove(botaoVisualizar);
                janela.remove(scrollPane);
                janela.remove(pesquisa);

                TelaVisualizarArtista telaVisualizarArtista = new TelaVisualizarArtista(controle, janela, isArtista, list.getSelectedValue());

                telaVisualizarArtista.show();

                telaVisualizarArtista.getBotaoVoltar().addActionListener(telaVisualizarArtista);
                telaVisualizarArtista.getBotaoVisualizar().addActionListener(telaVisualizarArtista);
            }
        }

        if (src == botaoVoltar){
            janela.remove(titulo);
            janela.remove(botaoVoltar);
            janela.remove(botaoVisualizar);
            janela.remove(scrollPane);
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