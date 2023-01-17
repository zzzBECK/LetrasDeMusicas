package view.artista;

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
import view.album.TelaVisualizarAlbum;

public class TelaVisualizarArtista implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;

    private JLabel nome = new JLabel();
    private JLabel cpf = new JLabel();
    private JLabel qtdSeguidores = new JLabel();

    private JButton botaoVoltar = new JButton("Voltar");
    private JButton botaoVisualizar = new JButton("Visualizar");

    private DefaultListModel<Album> model = new DefaultListModel<>();
    private JList<Album> list = new JList<>();
    private JScrollPane scrollPane = new JScrollPane();

    private Artista artista;

    public TelaVisualizarArtista(Controle controle, JFrame janela, boolean isArtista, Artista artista){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.artista = artista;
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
        nome.setText("Nome: " + artista.getNome());

        cpf.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		cpf.setForeground(Color.white);
        cpf.setBounds(50, 70, 700, 30);
        cpf.setText("CPF: " + artista.getCpf());

        qtdSeguidores.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		qtdSeguidores.setForeground(Color.white);
        qtdSeguidores.setBounds(50, 110, 700, 30);
        qtdSeguidores.setText("Qtd Seguidores: " + artista.getQtdSeguidores());


        for (Album album : artista.getAlbuns()){
            model.addElement(album);
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
        janela.add(cpf);
        janela.add(qtdSeguidores);
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
            janela.remove(cpf);
            janela.remove(qtdSeguidores);
            janela.remove(scrollPane);
            janela.remove(botaoVisualizar);
            janela.remove(botaoVoltar);

            TelaArtistas telaArtistas = new TelaArtistas(controle, janela, isArtista);

			telaArtistas.show();

			telaArtistas.getBotaoVoltar().addActionListener(telaArtistas);
            telaArtistas.getBotaoVisualizar().addActionListener(telaArtistas);
        }

        if (src == botaoVisualizar){
            if(list.getSelectedValue() != null){
                janela.remove(nome);
                janela.remove(cpf);
                janela.remove(qtdSeguidores);
                janela.remove(scrollPane);
                janela.remove(botaoVisualizar);
                janela.remove(botaoVoltar);

                TelaVisualizarAlbum telaVisualizarAlbum = new TelaVisualizarAlbum(controle, janela, isArtista, list.getSelectedValue());

                telaVisualizarAlbum.showToArtista(artista);

                telaVisualizarAlbum.getBotaoVisualizarArtista().addActionListener(telaVisualizarAlbum);
                telaVisualizarAlbum.getBotaoVoltarArtista().addActionListener(telaVisualizarAlbum);
            }
        }
    }
}