package view.album;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

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
import view.artista.TelaVisualizarArtista;
import view.musica.TelaVisualizarMusica;

public class TelaVisualizarAlbum implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;

    private JLabel nome = new JLabel();
    private JLabel arts = new JLabel();
    private JLabel titulo = new JLabel();
    private JLabel data = new JLabel();

    private JButton botaoVoltar = new JButton("Voltar");
    private JButton botaoVoltarArtista = new JButton("Voltar");
    private JButton botaoVisualizar = new JButton("Visualizar");
    private JButton botaoVisualizarArtista = new JButton("Visualizar");

    private DefaultListModel<Musica> model = new DefaultListModel<>();
    private JList<Musica> list = new JList<>();
    private JScrollPane scrollPane = new JScrollPane();

    private Album album;
    private Artista art;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public TelaVisualizarAlbum(Controle controle, JFrame janela, boolean isArtista, Album album){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.album = album;
    }

    public JButton getBotaoVoltar(){
        return botaoVoltar;
    }

    public JButton getBotaoVoltarArtista(){
        return botaoVoltarArtista;
    }

    public JButton getBotaoVisualizar(){
        return botaoVisualizar;
    }

    public JButton getBotaoVisualizarArtista(){
        return botaoVisualizarArtista;
    }

    public void show(){
        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 20));
		titulo.setForeground(Color.decode("#A020F0"));
        titulo.setBounds(360, 118, 400, 30);
        titulo.setText("Músicas");

        nome.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		nome.setForeground(Color.white);
        nome.setBounds(50, 30, 400, 30);
        nome.setText("Album: " + album.getNome());

        data.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		data.setForeground(Color.white);
        data.setBounds(50, 70, 400, 30);
        data.setText("Data: " + sdf.format(album.getDataLancamento()));


        arts.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		arts.setForeground(Color.white);
        arts.setBounds(450, 30, 700, 30);

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
        janela.add(titulo);
        janela.add(botaoVisualizar);
        janela.add(botaoVoltar);
        janela.add(data);

        janela.repaint();
    }

    public void showToArtista(Artista art){
        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 20));
		titulo.setForeground(Color.decode("#A020F0"));
        titulo.setBounds(360, 118, 400, 30);
        titulo.setText("Músicas");

        this.art = art;
        nome.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		nome.setForeground(Color.white);
        nome.setBounds(50, 30, 400, 30);
        nome.setText("Nome: " + album.getNome());

        data.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		data.setForeground(Color.white);
        data.setBounds(50, 70, 400, 30);
        data.setText("Data: " + sdf.format(album.getDataLancamento()));

        arts.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		arts.setForeground(Color.white);
        arts.setBounds(450, 30, 700, 30);

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


        botaoVoltarArtista.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoVoltarArtista.setBackground(Color.decode("#A020F0"));
        botaoVoltarArtista.setForeground(Color.WHITE);
		botaoVoltarArtista.setBounds(264, 494, 125, 35);
        botaoVoltarArtista.setBorder(null);
        botaoVoltarArtista.setFocusPainted(false);

        botaoVisualizarArtista.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoVisualizarArtista.setBackground(Color.decode("#A020F0"));
        botaoVisualizarArtista.setForeground(Color.WHITE);
		botaoVisualizarArtista.setBounds(411, 494, 125, 35);
        botaoVisualizarArtista.setBorder(null);
        botaoVisualizarArtista.setFocusPainted(false);

        janela.add(nome);
        janela.add(arts);
        janela.add(scrollPane);
        janela.add(titulo);
        janela.add(botaoVisualizarArtista);
        janela.add(botaoVoltarArtista);
        janela.add(data);

        janela.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoVoltar){
            janela.remove(nome);
            janela.remove(arts);
            janela.remove(scrollPane);
            janela.remove(titulo);
            janela.remove(botaoVisualizar);
            janela.remove(botaoVoltar);
            janela.remove(data);

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
                janela.remove(botaoVisualizarArtista);
                janela.remove(botaoVoltar);
                janela.remove(botaoVoltarArtista);
                janela.remove(titulo);
                janela.remove(data);


                TelaVisualizarMusica telaVisualizarMusica = new TelaVisualizarMusica(controle, janela, isArtista, list.getSelectedValue());

                telaVisualizarMusica.showToAlbum();

                telaVisualizarMusica.getBotaoVoltarAlbum().addActionListener(telaVisualizarMusica);
            }
        }

        if (src == botaoVoltarArtista){
            janela.remove(nome);
            janela.remove(arts);
            janela.remove(scrollPane);
            janela.remove(botaoVisualizar);
            janela.remove(botaoVisualizarArtista);
            janela.remove(botaoVoltar);
            janela.remove(botaoVoltarArtista);
            janela.remove(titulo);
            janela.remove(data);

            TelaVisualizarArtista telaVisualizarArtista = new TelaVisualizarArtista(controle, janela, isArtista, art);

            telaVisualizarArtista.show();

            telaVisualizarArtista.getBotaoVisualizar().addActionListener(telaVisualizarArtista);
            telaVisualizarArtista.getBotaoVoltar().addActionListener(telaVisualizarArtista);
        }

        if (src == botaoVisualizarArtista){
            if (list.getSelectedValue() != null){
                janela.remove(nome);
                janela.remove(arts);
                janela.remove(scrollPane);
                janela.remove(botaoVisualizar);
                janela.remove(botaoVisualizarArtista);
                janela.remove(botaoVoltar);
                janela.remove(botaoVoltarArtista);
                janela.remove(titulo);
                janela.remove(data);

                TelaVisualizarMusica telaVisualizarMusica = new TelaVisualizarMusica(controle, janela, isArtista, list.getSelectedValue());

                telaVisualizarMusica.showToArtista(art);

                telaVisualizarMusica.getBotaoVoltarArtista().addActionListener(telaVisualizarMusica);
            }
        }
        
    }

}