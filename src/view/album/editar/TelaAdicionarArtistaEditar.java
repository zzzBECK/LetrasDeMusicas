package view.album.editar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import controller.Controle;
import model.Album;
import model.Artista;

/**
 * Classe que represnta a tela de Adicionar artista, na tela de Editar artista
 * @author Alexandre de Santana Beck
 * @since 2023
 * @version 1.0
 */
public class TelaAdicionarArtistaEditar implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;
    private Album album;
    private String nomeDigitado;
    private String dataDigitado;
    private List<Artista> artistas = new ArrayList<>();
    private List<Artista> artistasRemovidos = new ArrayList<>();
    private List<Artista> artistasAdicionados = new ArrayList<>();

    private JLabel titulo = new JLabel("Adicionar Artista:");

    private DefaultListModel<Artista> model = new DefaultListModel<>();
    private JList<Artista> list = new JList<>();

    private JButton botaoAdicionar = new JButton("Adicionar");
    private JButton botaoCancelar = new JButton("Cancelar");

    private JScrollPane scrollPane = new JScrollPane();

    /**
     * Construtor padrao da classe, com parametros digitados na tela anterior
     * @param controle
     * @param janela
     * @param isArtista
     * @param album
     * @param nomeDigitado
     * @param dataDigitado
     * @param artistas
     * @param artistasRemovidos
     * @param artistasAdicionados
     */
    public TelaAdicionarArtistaEditar(Controle controle, JFrame janela, boolean isArtista, Album album,
                                      String nomeDigitado, String dataDigitado, List<Artista> artistas,
                                      List<Artista> artistasRemovidos, List<Artista> artistasAdicionados){

        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.album = album;
        this.nomeDigitado = nomeDigitado;
        this.dataDigitado = dataDigitado;
        this.artistas = artistas;
        this.artistasRemovidos = artistasRemovidos;
        this.artistasAdicionados = artistasAdicionados;
    }

    
    public JButton getBotaoAdicionar(){
        return botaoAdicionar;
    }

    public JButton getBotaoCancelar(){
        return botaoCancelar;
    }

    /**
     * Meotodo que altera a configuração da tela e faz sua atualização
     */
    public void show(){

        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 24));
		titulo.setForeground(Color.white);
		titulo.setBounds(300, 15, 300, 48);

        for (Artista artista : controle.getDados().getArtistas()){
            model.addElement(artista);
        }
        list.setModel(model);
        scrollPane.setViewportView(list);

        list.setForeground(Color.white);
        list.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        list.setBackground(Color.gray);
        list.setBounds(110, 60, 579, 400);

        DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
        renderer.setHorizontalAlignment(JLabel.CENTER);

        scrollPane.setBounds(110, 60, 579, 400);

        botaoAdicionar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoAdicionar.setBackground(Color.decode("#A020F0"));
        botaoAdicionar.setForeground(Color.WHITE);
		botaoAdicionar.setBounds(416, 494, 125, 35);
        botaoAdicionar.setBorder(null);
        botaoAdicionar.setFocusPainted(false);

        botaoCancelar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoCancelar.setBackground(Color.decode("#A020F0"));
        botaoCancelar.setForeground(Color.WHITE);
		botaoCancelar.setBounds(272, 494, 125, 35);
        botaoCancelar.setBorder(null);
        botaoCancelar.setFocusPainted(false);


        janela.add(titulo);
        janela.add(botaoAdicionar);
        janela.add(botaoCancelar);
        janela.add(scrollPane);


        janela.repaint();
    }

    /**
     * Meotodo que é executado quando realiza-se um evento
     * eventos: adicionar, cancelar
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoAdicionar){
            if (list.getSelectedValue() != null){
                if (artistas.contains(list.getSelectedValue())){
                    JOptionPane.showMessageDialog(null, "Artista já selecionado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    janela.remove(titulo);
                    janela.remove(botaoAdicionar);
                    janela.remove(botaoCancelar);
                    janela.remove(scrollPane);

                    artistas.add(list.getSelectedValue());
                    artistasAdicionados.add(list.getSelectedValue());

                    TelaAlbumSelecionado telaAlbumSelecionado = new TelaAlbumSelecionado(controle, janela, isArtista, album,
                                                                                        nomeDigitado, dataDigitado, artistas,
                                                                                        artistasRemovidos, artistasAdicionados);
                    
                    telaAlbumSelecionado.show();

                    telaAlbumSelecionado.getBotaoArtista().addActionListener(telaAlbumSelecionado);
                    telaAlbumSelecionado.getBotaoCancelar().addActionListener(telaAlbumSelecionado);
                    telaAlbumSelecionado.getBotaoEditar().addActionListener(telaAlbumSelecionado);
                    telaAlbumSelecionado.getBotaoRemover().addActionListener(telaAlbumSelecionado);
                }
            }
            
        }
        
        if (src == botaoCancelar){
            janela.remove(titulo);
            janela.remove(botaoAdicionar);
            janela.remove(botaoCancelar);
            janela.remove(scrollPane);

            TelaAlbumSelecionado telaAlbumSelecionado = new TelaAlbumSelecionado(controle, janela, isArtista, album,
                                                                                 nomeDigitado, dataDigitado, artistas,
                                                                                 artistasRemovidos, artistasAdicionados);

            telaAlbumSelecionado.show();
            
            telaAlbumSelecionado.getBotaoArtista().addActionListener(telaAlbumSelecionado);
            telaAlbumSelecionado.getBotaoCancelar().addActionListener(telaAlbumSelecionado);
            telaAlbumSelecionado.getBotaoEditar().addActionListener(telaAlbumSelecionado);
            telaAlbumSelecionado.getBotaoRemover().addActionListener(telaAlbumSelecionado);
        }
    }

}