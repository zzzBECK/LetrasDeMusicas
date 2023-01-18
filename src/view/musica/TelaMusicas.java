package view.musica;

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
import model.Musica;
import view.TelaAplicativo;

public class TelaMusicas implements ActionListener{
    private Controle controle;
    private boolean isArtista;
    private JFrame janela;

    private JLabel titulo = new JLabel("Músicas");

    private JTextField pesquisa = new JTextField();

    private DefaultListModel<Musica> model = new DefaultListModel<>();
    private JList<Musica> list = new JList<>();
    private JScrollPane scrollPane = new JScrollPane();

    private JButton botaoVoltar = new JButton("Voltar");
    private JButton botaoVisualizar = new JButton("Visualizar");

    private KeyListener keyListener = new KeyListener() {
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER){
                showPesquisa(pesquisa.getText());
                System.out.println("Pesquisou");
            }   
        }
  
        public void keyReleased(KeyEvent keyEvent) {

        }
  
        public void keyTyped(KeyEvent keyEvent) {
            showPesquisa(pesquisa.getText());
            System.out.println("Pesquisou");
        }
  
      };

    public TelaMusicas(Controle controle, JFrame janela, boolean isArtista){
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
		titulo.setBounds(365, 15, 200, 48);

        pesquisa.setBounds(505, 20, 185, 20);
        pesquisa.setLayout(null);
        pesquisa.setText(null);
        pesquisa.addKeyListener(keyListener);

        for (Musica musica : controle.getPesquisa().getMusicas()){
            model.addElement(musica);
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
        for (Musica musica : controle.getPesquisa().getMusicas()){
            String temp = "";
            for (int i = 0; i < digitado.length(); i++){


                if (digitado.length() <= musica.getNome().length()){
                    try{
                        temp += musica.getNome().charAt(i);
                    }
                    catch (RuntimeException e){
                        System.out.println(e.getMessage());
                        System.out.println("Out of index");
                    }
                }

            }

            if (temp.toLowerCase().equals(digitado.toLowerCase())){
                model.addElement(musica);
            }

        }

        // Jeito que achei na internet, teve a mesma funcionalidade do meu metodo
        // for (Musica musica : controle.getPesquisa().getMusicas()){
            
        //     Pattern pattern = Pattern.compile(digitado, Pattern.CASE_INSENSITIVE);
        //     Matcher matcher = pattern.matcher(musica.getNome());
        //     boolean matchFound = matcher.find();
        //     if (matchFound){
        //         System.out.println("Match found");
        //         model.addElement(musica);
        //     }
        //     else{
        //         System.out.println("Match not found");
        //     }
          
        // }


        list.setModel(model);
        scrollPane.setViewportView(list);

        list.setForeground(Color.white);
        list.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        list.setBounds(110, 60, 579, 420);
        list.setBackground(Color.gray);

        DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
        renderer.setHorizontalAlignment(JLabel.CENTER);

        scrollPane.setBounds(110, 60, 579, 420);

        janela.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoVoltar){
            janela.remove(titulo);
            janela.remove(scrollPane);
            janela.remove(botaoVoltar);
            janela.remove(botaoVisualizar);
            janela.remove(pesquisa);

            TelaAplicativo telaAplicativo = new TelaAplicativo(controle, janela, isArtista);

            telaAplicativo.show();

            telaAplicativo.getArtBotao().addActionListener(telaAplicativo);
            telaAplicativo.getAlbBotao().addActionListener(telaAplicativo);
            telaAplicativo.getMusBotao().addActionListener(telaAplicativo);
            telaAplicativo.getCAlbmBotao().addActionListener(telaAplicativo);
            telaAplicativo.getCMusBotao().addActionListener(telaAplicativo);
            telaAplicativo.getBotaoVoltar().addActionListener(telaAplicativo);

        }

        if (src == botaoVisualizar){
            
            if(list.getSelectedValue() != null){
                janela.remove(titulo);
                janela.remove(scrollPane);
                janela.remove(botaoVoltar);
                janela.remove(botaoVisualizar);
                janela.remove(pesquisa);

                TelaVisualizarMusica telaVisualizarMusica = new TelaVisualizarMusica(controle, janela, isArtista, list.getSelectedValue());

                telaVisualizarMusica.show();

                telaVisualizarMusica.getBotaoVoltar().addActionListener(telaVisualizarMusica);
                telaVisualizarMusica.getBotaoVoltarAlbum().addActionListener(telaVisualizarMusica);
            }
        }
        
    }




}