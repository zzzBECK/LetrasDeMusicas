package view.musica.editar;

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
import javax.swing.JTextField;

import controller.Controle;
import model.Album;
import model.Artista;
import model.Musica;
import view.TelaAplicativo;

public class TelaEditarMusica implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;
    private Artista artista;

    private JLabel nome = new JLabel();
    
    private DefaultListModel<Musica> model = new DefaultListModel<>();
    private JList<Musica> list = new JList<>();
    private JScrollPane scrollPane = new JScrollPane();

    private JButton botaoCancelar = new JButton("Cancelar");
    private JButton botaoEditar = new JButton("Editar");

    private JFrame janelaEditar = new JFrame("Editar Música");
    private JLabel tituloEditar = new JLabel("Editar:");
    private JLabel nomeEditar = new JLabel("Nome:");
    private JTextField entradaNomeEditar = new JTextField();

    private JLabel duracaoEditar = new JLabel("Duração:");
    private JTextField entradaDuracaoEditar = new JTextField();

    private JButton botaoLetra = new JButton("Adicionar Letra");

    private DefaultListModel<Album> modelEditar = new DefaultListModel<>();
    private JScrollPane scrollPaneEditar = new JScrollPane();
    private JList<Album> listEditar = new JList<>();

    private Album album;
    private String nomeDigitado;
    private String duracaoDigitado;
    private String letraDigitado;

    private JButton botaoAlbum = new JButton("Adicionar Album");

    public TelaEditarMusica(Controle controle, JFrame janela, boolean isArtista){
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
            for (Musica musica : album.getMusicas()){
                model.addElement(musica);
            }
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

    public void showEdit(Musica musica){
        if (nomeDigitado == null && duracaoDigitado == null && letraDigitado == null){
            nomeDigitado = musica.getNome();
            duracaoDigitado = musica.getDuracao().toString();
            letraDigitado = musica.getLetra();
            album = musica.getAlbum();
        }

        tituloEditar.setFont(new Font("Ms Gothic", Font.BOLD, 24));
		tituloEditar.setForeground(Color.white);
        tituloEditar.setBounds(330, 70, 360, 60);

        nomeEditar.setBounds(145, 170, 100, 29);
        nomeEditar.setFont(new Font("Ms Gothic", Font.BOLD, 24));
        nomeEditar.setForeground(Color.white);
        
        entradaNomeEditar.setBounds(248, 173, 350, 23);
        entradaNomeEditar.setLayout(null);
        entradaNomeEditar.setText(nomeDigitado);

        duracaoEditar.setBounds(125, 200, 300, 29);
        duracaoEditar.setFont(new Font("Ms Gothic", Font.BOLD, 24));
        duracaoEditar.setForeground(Color.white);
        
        entradaDuracaoEditar.setText(duracaoDigitado);
        entradaDuracaoEditar.setBounds(248, 203, 350, 23);
        entradaDuracaoEditar.setLayout(null);
        entradaDuracaoEditar.setText(duracaoDigitado);

        modelEditar.removeAllElements();
        modelEditar.addElement(album);
        listEditar.setModel(modelEditar);
        scrollPaneEditar.setViewportView(list);

        listEditar.setForeground(Color.white);
        listEditar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        listEditar.setBackground(Color.gray);

        listEditar.setBounds(250, 350, 350, 128);
        scrollPaneEditar.setBounds(250, 350, 350, 128);

        botaoLetra.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoLetra.setBackground(Color.decode("#A020F0"));
        botaoLetra.setForeground(Color.WHITE);
		botaoLetra.setBounds(306, 260, 220, 35);
        botaoLetra.setBorder(null);
        botaoLetra.setFocusPainted(false);

        botaoAlbum.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoAlbum.setBackground(Color.decode("#A020F0"));
        botaoAlbum.setForeground(Color.WHITE);
		botaoAlbum.setBounds(306, 300, 220, 35);
        botaoAlbum.setBorder(null);
        botaoAlbum.setFocusPainted(false);


		botaoEditar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoEditar.setBackground(Color.decode("#A020F0"));
        botaoEditar.setForeground(Color.WHITE);
		botaoEditar.setBounds(416, 494, 125, 35);
        botaoEditar.setBorder(null);
        botaoEditar.setFocusPainted(false);

        botaoCancelar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoCancelar.setBackground(Color.decode("#A020F0"));
        botaoCancelar.setForeground(Color.WHITE);
		botaoCancelar.setBounds(272, 494, 125, 35);
        botaoCancelar.setBorder(null);
        botaoCancelar.setFocusPainted(false);

        janelaEditar.add(tituloEditar);
        janelaEditar.add(nomeEditar);
        janelaEditar.add(entradaNomeEditar);
        janelaEditar.add(duracaoEditar);
        janelaEditar.add(entradaDuracaoEditar);
        janelaEditar.add(scrollPaneEditar);
        janelaEditar.add(botaoAlbum);
        janelaEditar.add(botaoLetra);
        janelaEditar.add(botaoEditar);
        janelaEditar.add(botaoCancelar);

        janelaEditar.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        janela.remove(nome);
        janela.remove(scrollPane);
        janela.remove(botaoCancelar);
        janela.remove(botaoEditar);

        janelaEditar.remove(tituloEditar);
        janelaEditar.remove(nomeEditar);
        janelaEditar.remove(entradaNomeEditar);
        janelaEditar.remove(duracaoEditar);
        janelaEditar.remove(entradaDuracaoEditar);
        janelaEditar.remove(scrollPaneEditar);
        janelaEditar.remove(botaoAlbum);
        janelaEditar.remove(botaoLetra);
        janelaEditar.remove(botaoEditar);
        janelaEditar.remove(botaoCancelar);

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

            showEdit(list.getSelectedValue());
        }
    }
}