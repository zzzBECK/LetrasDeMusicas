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
import view.main.TelaAplicativo;

/**
 * Classe que lista os albuns a serem selecionados para edição
 * @author Alexandre de Santana Beck
 * @since 2023
 * @version 1.0
 */
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
    private JButton botaoRemover = new JButton("Remover");
    private JButton botaoEditar = new JButton("Editar");

    /**
     * Contrutor padrao da classe
     * @param controle
     * @param janela
     * @param isArtista
     */
    public TelaEditarAlbum(Controle controle, JFrame janela, boolean isArtista){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.artista = controle.getDados().getArtistas().get(controle.getDados().getArtistas().size() - 1);
    }

    public JButton getBotaoVisualizar(){
        return botaoEditar;
    }

    public JButton getBotaoRemover(){
        return botaoRemover;
    }

    public JButton getBotaoCancelar(){
        return botaoCancelar;
    }

    /**
     * Metodo que faz a configuração da tela e faz sua atualização
     */
    public void show(){
        nome.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		nome.setForeground(Color.white);
        nome.setBounds(50, 30, 400, 30);
        nome.setText("Nome: " + artista.getNome());

        model.clear();
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
		botaoCancelar.setBounds(190, 494, 125, 35);
        botaoCancelar.setBorder(null);
        botaoCancelar.setFocusPainted(false);

        botaoRemover.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoRemover.setBackground(Color.decode("#A020F0"));
        botaoRemover.setForeground(Color.WHITE);
		botaoRemover.setBounds(337, 494, 125, 35);
        botaoRemover.setBorder(null);
        botaoRemover.setFocusPainted(false);

        botaoEditar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoEditar.setBackground(Color.decode("#A020F0"));
        botaoEditar.setForeground(Color.WHITE);
		botaoEditar.setBounds(484, 494, 125, 35);
        botaoEditar.setBorder(null);
        botaoEditar.setFocusPainted(false);

        janela.add(nome);
        janela.add(scrollPane);
        janela.add(botaoCancelar);
        janela.add(botaoEditar);
        janela.add(botaoRemover);

        janela.repaint();
    }


    /**
     * metodo que é executado quando há um evento
     * eventos: cancelar, remover, editar
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoCancelar){
            janela.remove(nome);
            janela.remove(scrollPane);
            janela.remove(botaoCancelar);
            janela.remove(botaoEditar);
            janela.remove(botaoRemover);

            
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

        if (src == botaoRemover){
            if (list.getSelectedValue() != null){
                janela.remove(nome);
                janela.remove(scrollPane);
                janela.remove(botaoCancelar);
                janela.remove(botaoEditar);
                janela.remove(botaoRemover);

                controle.removerAlbum(list.getSelectedValue());

                show();
            }
        }

        if (src == botaoEditar){
            if (list.getSelectedValue() != null){
                janela.remove(nome);
                janela.remove(scrollPane);
                janela.remove(botaoCancelar);
                janela.remove(botaoEditar);
                janela.remove(botaoRemover);

                TelaAlbumSelecionado telaAlbumSelecionado = new TelaAlbumSelecionado(controle, janela, isArtista, list.getSelectedValue());

                telaAlbumSelecionado.show();

                telaAlbumSelecionado.getBotaoCancelar().addActionListener(telaAlbumSelecionado);
                telaAlbumSelecionado.getBotaoEditar().addActionListener(telaAlbumSelecionado);
                telaAlbumSelecionado.getBotaoRemover().addActionListener(telaAlbumSelecionado);
                telaAlbumSelecionado.getBotaoArtista().addActionListener(telaAlbumSelecionado);

            }

        }
        
    }

    
}