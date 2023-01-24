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
import view.main.TelaAplicativo;

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
    private JButton botaoTocar = new JButton("Tocar");

    private Musica musicaNoPlayer;
    private JLabel background = new JLabel();
    private JLabel musicaNoPlayerLabel = new JLabel();
    private JButton botaoPlay = new JButton("Play");
    private JButton botaoAvancar = new JButton("Avançar");
    private JButton botaoRetroceder = new JButton("Retroceder");

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

    public JButton getBotaoTocar(){
        return botaoTocar;
    }

    public JButton getBotaoPlay(){
        return botaoPlay;
    }

    public JButton getBotaoAvancar(){
        return botaoAvancar;
    }

    public JButton getBotaoRetroceder(){
        return botaoRetroceder;
    }


    public void show(){

        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 24));
		titulo.setForeground(Color.white);
		titulo.setBounds(365, 15, 200, 48);

        pesquisa.setBounds(505, 20, 185, 20);
        pesquisa.setLayout(null);
        pesquisa.setText(null);
        pesquisa.addKeyListener(keyListener);

        model.clear();
        for (Musica musica : controle.getDados().getMusicas()){
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
		botaoVoltar.setBounds(190, 494, 125, 35);
        botaoVoltar.setBorder(null);
        botaoVoltar.setFocusPainted(false);

        botaoVisualizar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoVisualizar.setBackground(Color.decode("#A020F0"));
        botaoVisualizar.setForeground(Color.WHITE);
		botaoVisualizar.setBounds(484, 494, 125, 35);
        botaoVisualizar.setBorder(null);
        botaoVisualizar.setFocusPainted(false);

        botaoTocar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoTocar.setBackground(Color.decode("#A020F0"));
        botaoTocar.setForeground(Color.WHITE);
		botaoTocar.setBounds(337, 494, 125, 35);
        botaoTocar.setBorder(null);
        botaoTocar.setFocusPainted(false);

        janela.add(titulo);
        janela.add(botaoVoltar);
        janela.add(botaoVisualizar);
        janela.add(scrollPane);
        janela.add(pesquisa);
        janela.add(botaoTocar);

        janela.repaint();
    }

    public void showPesquisa(String digitado){

        model.clear();
        for (Musica musica : controle.getDados().getMusicas()){
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
            janela.setSize(800, 600);

            janela.remove(titulo);
            janela.remove(scrollPane);
            janela.remove(botaoVoltar);
            janela.remove(botaoVisualizar);
            janela.remove(pesquisa);
            janela.remove(botaoTocar);
            janela.remove(botaoAvancar);
            janela.remove(botaoRetroceder);
            janela.remove(botaoPlay);
            janela.remove(musicaNoPlayerLabel);
            janela.remove(background);

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

        if (src == botaoVisualizar){
            
            if(list.getSelectedValue() != null){
                janela.setSize(800, 600);

                janela.remove(titulo);
                janela.remove(scrollPane);
                janela.remove(botaoVoltar);
                janela.remove(botaoVisualizar);
                janela.remove(pesquisa);
                janela.remove(botaoTocar);
                janela.remove(botaoAvancar);
                janela.remove(botaoRetroceder);
                janela.remove(botaoPlay);
                janela.remove(musicaNoPlayerLabel);
                janela.remove(background);

                TelaVisualizarMusica telaVisualizarMusica = new TelaVisualizarMusica(controle, janela, isArtista, list.getSelectedValue());

                telaVisualizarMusica.show();

                telaVisualizarMusica.getBotaoVoltar().addActionListener(telaVisualizarMusica);
                telaVisualizarMusica.getBotaoVoltarAlbum().addActionListener(telaVisualizarMusica);
            }
        }

        if (src == botaoTocar){
            if(list.getSelectedValue() != null){
                for (Musica musica : controle.getDados().getMusicas()){
                    if (!musica.equals(list.getSelectedValue())){
                        musica.setStatusTocando(false);
                    }
                    else{
                        list.getSelectedValue().setStatusTocando(true);
                        musicaNoPlayer = musica;
                        musicaNoPlayerLabel.removeAll();
                        musicaNoPlayerLabel.setFont(new Font("Ms Gothic", Font.BOLD, 18));
                        musicaNoPlayerLabel.setText(musicaNoPlayer.getNome());
                        musicaNoPlayerLabel.setForeground(Color.white);
                        musicaNoPlayerLabel.setBounds(5, 615, 400, 30);
                    }
                }

                botaoRetroceder.setFont(new Font("Ms Gothic", Font.BOLD, 16));
                botaoRetroceder.setBackground(Color.decode("#A020F0"));
                botaoRetroceder.setForeground(Color.WHITE);
                botaoRetroceder.setBounds(190, 615, 125, 35);
                botaoRetroceder.setBorder(null);
                botaoRetroceder.setFocusPainted(false);
        
                botaoAvancar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
                botaoAvancar.setBackground(Color.decode("#A020F0"));
                botaoAvancar.setForeground(Color.WHITE);
                botaoAvancar.setBounds(484, 615, 125, 35);
                botaoAvancar.setBorder(null);
                botaoAvancar.setFocusPainted(false);
        
                botaoPlay.setFont(new Font("Ms Gothic", Font.BOLD, 16));
                botaoPlay.setBackground(Color.decode("#A020F0"));
                botaoPlay.setForeground(Color.WHITE);
                botaoPlay.setBounds(337, 615, 125, 35);
                botaoPlay.setBorder(null);
                botaoPlay.setFocusPainted(false);

                background.setBackground(Color.black);
                background.setOpaque(true);
                background.setBounds(0, 600, 800, 70);

                janela.setSize(800, 700);
                janela.add(botaoAvancar);
                janela.add(botaoRetroceder);
                janela.add(botaoPlay);
                janela.add(musicaNoPlayerLabel);
                janela.add(background);

                show();
            }
        }

        if (src == botaoPlay){
            musicaNoPlayer.tocarOuPausar();

            show();
        }
        
        if (src == botaoAvancar){
            for (Musica musica : controle.getDados().getMusicas()){
                if (musica.isStatusTocando() && !musica.equals(controle.getDados().getMusicas().get(controle.getDados().getMusicas().size() - 1))){
                    musica.setStatusTocando(false);

                    musicaNoPlayer = controle.getDados().getMusicas().get(controle.getDados().getMusicas().indexOf(musica) + 1);
                    musicaNoPlayer.setStatusTocando(true);

                    musicaNoPlayerLabel.removeAll();
                    musicaNoPlayerLabel.setFont(new Font("Ms Gothic", Font.BOLD, 18));
                    musicaNoPlayerLabel.setText(musicaNoPlayer.getNome());
                    musicaNoPlayerLabel.setForeground(Color.white);
                    musicaNoPlayerLabel.setBounds(5, 615, 400, 30);

                    break;
                }
            }

            show();
        }

        if (src == botaoRetroceder){
            for (Musica musica : controle.getDados().getMusicas()){
                if (musica.isStatusTocando() && !musica.equals(controle.getDados().getMusicas().get(0))){
                    musica.setStatusTocando(false);

                    musicaNoPlayer = controle.getDados().getMusicas().get(controle.getDados().getMusicas().indexOf(musica) - 1);
                    musicaNoPlayer.setStatusTocando(true);

                    musicaNoPlayerLabel.removeAll();
                    musicaNoPlayerLabel.setFont(new Font("Ms Gothic", Font.BOLD, 18));
                    musicaNoPlayerLabel.setText(musicaNoPlayer.getNome());
                    musicaNoPlayerLabel.setForeground(Color.white);
                    musicaNoPlayerLabel.setBounds(5, 615, 400, 30);

                    break;
                }
            }

            show();
        }
    }

}