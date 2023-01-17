package view.album;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import controller.Controle;
import model.Album;
import model.Artista;
import model.Musica;
import view.musica.TelaVisualizarMusica;

public class TelaVisualizarAlbum implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;

    private JLabel nome = new JLabel();
    private JLabel arts = new JLabel();

    private JButton botaoVoltar = new JButton("Voltar");
    private JButton botaoVisualizar = new JButton("Visualizar");

    private DefaultListModel<Musica> model = new DefaultListModel<>();
    private JList<Musica> list = new JList<>();
    private JScrollPane scrollPane = new JScrollPane();

    private Album album;

    public TelaVisualizarAlbum(Controle controle, JFrame janela, boolean isArtista, Album album){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.album = album;
    }

    public JButton getBotaoVoltar(){
        return botaoVoltar;
    }

    public JButton getBotaoVisualizar(){
        return botaoVisualizar;
    }

    public void show(){
        nome.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		nome.setForeground(Color.white);
        nome.setBounds(50, 30, 400, 30);
        nome.setText("Nome: " + album.getNome());

        arts.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		arts.setForeground(Color.white);
        arts.setBounds(50, 70, 700, 30);

        String nomeArtistas = new String();
        for (Artista artista : album.getArtistas()){
            nomeArtistas += artista.getNome();
            nomeArtistas += " ";
        }
        arts.setText("Artistas: " + nomeArtistas);


        for (Musica musica : album.getMusicas()){
            model.addElement(musica);
        }
        list.setModel(model);
        scrollPane.setViewportView(list);

        list.setForeground(Color.white);
        list.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        list.setBounds(110, 150, 579, 300);
        list.setBackground(Color.gray);

        DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
        renderer.setHorizontalAlignment(JLabel.CENTER);

        scrollPane.setBounds(110, 150, 579, 300);


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

        janela.add(nome);
        janela.add(arts);
        janela.add(scrollPane);
        janela.add(botaoVisualizar);
        janela.add(botaoVoltar);

        janela.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoVoltar){
            janela.remove(nome);
            janela.remove(arts);
            janela.remove(scrollPane);
            janela.remove(botaoVisualizar);
            janela.remove(botaoVoltar);

            TelaAlbuns telaAlbuns = new TelaAlbuns(controle, janela, isArtista);

			telaAlbuns.show();

			telaAlbuns.getBotaoVoltar().addActionListener(telaAlbuns);
			telaAlbuns.getBotaoVisualizar().addActionListener(telaAlbuns);
        }

        if (src == botaoVisualizar){

            if (list.getSelectedValue() != null){
                janela.remove(nome);
                janela.remove(arts);
                janela.remove(scrollPane);
                janela.remove(botaoVisualizar);
                janela.remove(botaoVoltar);

                TelaVisualizarMusica telaVisualizarMusica = new TelaVisualizarMusica(controle, janela, isArtista, list.getSelectedValue());

                telaVisualizarMusica.showToAlbum();

                telaVisualizarMusica.getBotaoVoltar().addActionListener(telaVisualizarMusica);
            }
        }
        
    }

}