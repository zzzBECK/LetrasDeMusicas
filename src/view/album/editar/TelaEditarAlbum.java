package view.album.editar;

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
import view.TelaAplicativo;

public class TelaEditarAlbum implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;
    private Artista artista;

    private JLabel nome = new JLabel();
    
    private DefaultListModel<Album> model = new DefaultListModel<>();
    private JList<Album> list = new JList<>();
    private JScrollPane scrollPane = new JScrollPane();

    private JButton botaoCancelar = new JButton("Cancelar");
    private JButton botaoEditar = new JButton("Editar");

    public TelaEditarAlbum(Controle controle, JFrame janela, boolean isArtista){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.artista = controle.getDados().getArtistas().get(controle.getDados().getArtistas().size() - 1);
    }

    public JButton getBotaoVisualizar(){
        return botaoEditar;
    }

    public JButton getBotaoCancelar(){
        return botaoCancelar;
    }

    public void show(){
        nome.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		nome.setForeground(Color.white);
        nome.setBounds(50, 30, 400, 30);
        nome.setText("Nome: " + artista.getNome());

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

        botaoCancelar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoCancelar.setBackground(Color.decode("#A020F0"));
        botaoCancelar.setForeground(Color.WHITE);
		botaoCancelar.setBounds(264, 494, 125, 35);
        botaoCancelar.setBorder(null);
        botaoCancelar.setFocusPainted(false);

        botaoEditar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoEditar.setBackground(Color.decode("#A020F0"));
        botaoEditar.setForeground(Color.WHITE);
		botaoEditar.setBounds(411, 494, 125, 35);
        botaoEditar.setBorder(null);
        botaoEditar.setFocusPainted(false);

        janela.add(nome);
        janela.add(scrollPane);
        janela.add(botaoCancelar);
        janela.add(botaoEditar);

        janela.repaint();
    }

    public void showEdit(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        janela.remove(nome);
        janela.remove(scrollPane);
        janela.remove(botaoCancelar);
        janela.remove(botaoEditar);

        if (src == botaoCancelar){
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

        if (src == botaoEditar){

        }
        
    }

    
}