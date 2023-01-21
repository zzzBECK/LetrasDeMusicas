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
import javax.swing.JTextArea;

import controller.Controle;
import model.Album;
import model.Musica;

public class TelaLetraEAlbum implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;
    private Musica musica;
    private String nomeDigitado;
    private String duracaoDigitado;

    private JLabel tituloLetra = new JLabel("Letra:");
    private JScrollPane scrollPaneLetra = new JScrollPane();
    private JTextArea entradaLetra = new JTextArea();

    private JButton botaoSalvarLetra = new JButton("Salvar");
    private JButton botaoCancelar = new JButton("Cancelar");
    private JButton botaoSalvarAlbum = new JButton("Salvar");

    private JLabel tituloAlbum = new JLabel("Editar Album:");
    private DefaultListModel<Album> modelAlbum = new DefaultListModel<>();
    private JList<Album> listAlbum = new JList<>();
    private JScrollPane scrollPaneAlbum = new JScrollPane();


    public TelaLetraEAlbum(Controle controle, JFrame janela, boolean isArtista, Musica musica, String nomeDigitado, String duracaoDigitado){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.musica = musica;
        this.nomeDigitado = nomeDigitado;
        this.duracaoDigitado = duracaoDigitado;
    }

    public JButton getBotaoSalvarLetra(){
        return botaoSalvarLetra;
    }

    public JButton getBotaoSalvarAlbum(){
        return botaoSalvarAlbum;
    }

    public JButton getBotaoCancelar(){
        return botaoCancelar;
    }

    public void showLetra(){
        tituloLetra.setFont(new Font("Ms Gothic", Font.BOLD, 24));
		tituloLetra.setForeground(Color.white);
		tituloLetra.setBounds(350, 15, 300, 48);

        entradaLetra.setToolTipText("Digite a letra");
        entradaLetra.setText(musica.getLetra());
        entradaLetra.setBounds(110, 60, 579, 400); 
        entradaLetra.setLineWrap(true);

        scrollPaneLetra.getViewport().add(entradaLetra);
        scrollPaneLetra.setBounds(110, 60, 579, 400);

        botaoSalvarLetra.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoSalvarLetra.setBackground(Color.decode("#A020F0"));
        botaoSalvarLetra.setForeground(Color.WHITE);
		botaoSalvarLetra.setBounds(416, 494, 125, 35);
        botaoSalvarLetra.setBorder(null);
        botaoSalvarLetra.setFocusPainted(false);

        botaoCancelar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoCancelar.setBackground(Color.decode("#A020F0"));
        botaoCancelar.setForeground(Color.WHITE);
		botaoCancelar.setBounds(272, 494, 125, 35);
        botaoCancelar.setBorder(null);
        botaoCancelar.setFocusPainted(false);

        janela.add(tituloLetra);
        janela.add(scrollPaneLetra);
        janela.add(botaoSalvarLetra);
        janela.add(botaoCancelar);

        janela.repaint();
    }

    public void showAlbum(){
        tituloAlbum.setFont(new Font("Ms Gothic", Font.BOLD, 24));
		tituloAlbum.setForeground(Color.white);
		tituloAlbum.setBounds(300, 15, 300, 48);

        for (Album album : controle.getDados().getArtistas().get(controle.getDados().getArtistas().size() - 1).getAlbuns()){
            modelAlbum.addElement(album);
        }
        listAlbum.setModel(modelAlbum);
        scrollPaneAlbum.setViewportView(listAlbum);

        listAlbum.setForeground(Color.white);
        listAlbum.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        listAlbum.setBackground(Color.gray);
        listAlbum.setBounds(110, 60, 579, 400);

        DefaultListCellRenderer renderer =  (DefaultListCellRenderer)listAlbum.getCellRenderer();  
        renderer.setHorizontalAlignment(JLabel.CENTER);

        scrollPaneAlbum.setBounds(110, 60, 579, 400);

        botaoSalvarAlbum.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoSalvarAlbum.setBackground(Color.decode("#A020F0"));
        botaoSalvarAlbum.setForeground(Color.WHITE);
		botaoSalvarAlbum.setBounds(416, 494, 125, 35);
        botaoSalvarAlbum.setBorder(null);
        botaoSalvarAlbum.setFocusPainted(false);

        botaoCancelar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoCancelar.setBackground(Color.decode("#A020F0"));
        botaoCancelar.setForeground(Color.WHITE);
		botaoCancelar.setBounds(272, 494, 125, 35);
        botaoCancelar.setBorder(null);
        botaoCancelar.setFocusPainted(false);


        janela.add(tituloAlbum);
        janela.add(botaoSalvarAlbum);
        janela.add(botaoCancelar);
        janela.add(scrollPaneAlbum);


        janela.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoSalvarLetra){
            janela.remove(tituloAlbum);
            janela.remove(botaoSalvarAlbum);
            janela.remove(botaoCancelar);
            janela.remove(scrollPaneAlbum);
            janela.remove(tituloLetra);
            janela.remove(scrollPaneLetra);
            janela.remove(botaoSalvarLetra);

            

            musica.setLetra(entradaLetra.getText());

            TelaMusicaSelecionada telaMusicaSelecionada = new TelaMusicaSelecionada(controle, janela, isArtista, musica, nomeDigitado, duracaoDigitado);

            telaMusicaSelecionada.showEdit();

            telaMusicaSelecionada.getBotaoAlbum().addActionListener(telaMusicaSelecionada);
            telaMusicaSelecionada.getBotaoCadastrar().addActionListener(telaMusicaSelecionada);
            telaMusicaSelecionada.getBotaoCancelar().addActionListener(telaMusicaSelecionada);
            telaMusicaSelecionada.getBotaoLetra().addActionListener(telaMusicaSelecionada);
        }

        if (src == botaoSalvarAlbum){
            janela.remove(tituloAlbum);
            janela.remove(botaoSalvarAlbum);
            janela.remove(botaoCancelar);
            janela.remove(scrollPaneAlbum);
            janela.remove(tituloLetra);
            janela.remove(scrollPaneLetra);
            janela.remove(botaoSalvarLetra);

            musica.setAlbum(listAlbum.getSelectedValue());;

            TelaMusicaSelecionada telaMusicaSelecionada = new TelaMusicaSelecionada(controle, janela, isArtista, musica, nomeDigitado, duracaoDigitado);

            telaMusicaSelecionada.showEdit();

            telaMusicaSelecionada.getBotaoAlbum().addActionListener(telaMusicaSelecionada);
            telaMusicaSelecionada.getBotaoCadastrar().addActionListener(telaMusicaSelecionada);
            telaMusicaSelecionada.getBotaoCancelar().addActionListener(telaMusicaSelecionada);
            telaMusicaSelecionada.getBotaoLetra().addActionListener(telaMusicaSelecionada);
        }

        if (src == botaoCancelar){
            janela.remove(tituloAlbum);
            janela.remove(botaoSalvarAlbum);
            janela.remove(botaoCancelar);
            janela.remove(scrollPaneAlbum);
            janela.remove(tituloLetra);
            janela.remove(scrollPaneLetra);
            janela.remove(botaoSalvarLetra);

            TelaMusicaSelecionada telaMusicaSelecionada = new TelaMusicaSelecionada(controle, janela, isArtista, musica, nomeDigitado, duracaoDigitado);

            telaMusicaSelecionada.showEdit();

            telaMusicaSelecionada.getBotaoAlbum().addActionListener(telaMusicaSelecionada);
            telaMusicaSelecionada.getBotaoCadastrar().addActionListener(telaMusicaSelecionada);
            telaMusicaSelecionada.getBotaoCancelar().addActionListener(telaMusicaSelecionada);
            telaMusicaSelecionada.getBotaoLetra().addActionListener(telaMusicaSelecionada);
        }
        
    }
}