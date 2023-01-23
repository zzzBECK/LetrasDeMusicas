package view.album.editar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.Controle;
import model.Album;
import model.Artista;

public class TelaAlbumSelecionado implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;
    private Album album;


    private DefaultListModel<Artista> model = new DefaultListModel<>();
    private JScrollPane scrollPane = new JScrollPane();
    private JList<Artista> list = new JList<>();

    private JLabel titulo = new JLabel("Cadastro:");

    private JLabel nome = new JLabel("Nome:");
    private JTextField entradaNome = new JTextField();

    private JLabel data = new JLabel("Data de Lançamento:");
    private JFormattedTextField entradaData = new JFormattedTextField(setMascara("##/##/####"));

    private JButton botaoArtista = new JButton("Adicionar Artista");

    private JButton botaoEditar = new JButton("Editar");
    private JButton botaoCancelar = new JButton("Cancelar");

    private Font fonte =  new Font("Ms Gothic", Font.BOLD, 24);

    private String nomeDigitado;
    private String dataDigitado;



    public TelaAlbumSelecionado(Controle controle, JFrame janela, boolean isArtista, Album album){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.album = album;
    }

    public JButton getBotaoEditar(){
        return botaoEditar;
    }

    public JButton getBotaoCancelar(){
        return botaoCancelar;
    }

    public void show(){
        if (nomeDigitado == null && dataDigitado == null){
            nomeDigitado = album.getNome();

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataDigitado = dateFormat.format(album.getDataLancamento());
        }

        titulo.setFont(fonte);
		titulo.setForeground(Color.white);
        titulo.setBounds(330, 121, 360, 60);

        nome.setBounds(145, 218, 100, 29);
        nome.setFont(fonte);
        nome.setForeground(Color.white);

        entradaNome.setBounds(248, 221, 350, 23);
        entradaNome.setLayout(null);
        entradaNome.setText(nomeDigitado);

        data.setBounds(5, 250, 300, 29);
        data.setFont(fonte);
        data.setForeground(Color.white);
       
        entradaData.setBounds(248, 253, 350, 23);
        entradaData.setLayout(null);
        entradaData.setText(dataDigitado);

        botaoArtista.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoArtista.setBackground(Color.decode("#A020F0"));
        botaoArtista.setForeground(Color.WHITE);
		botaoArtista.setBounds(306, 300, 220, 35);
        botaoArtista.setBorder(null);
        botaoArtista.setFocusPainted(false);


        for (Artista artista : album.getArtistas()){
            model.addElement(artista);
        }

        list.setModel(model);
        scrollPane.setViewportView(list);

        list.setForeground(Color.white);
        list.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        list.setBackground(Color.gray);

        list.setBounds(250, 350, 350, 128);
        scrollPane.setBounds(250, 350, 350, 128);
        
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

        janela.add(titulo);
        janela.add(nome);
        janela.add(entradaNome);
        janela.add(data);
        janela.add(entradaData);
        janela.add(botaoArtista);
        janela.add(botaoEditar);
        janela.add(botaoCancelar);
        janela.add(scrollPane);


        janela.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoCancelar){
            janela.remove(titulo);
            janela.remove(nome);
            janela.remove(entradaNome);
            janela.remove(data);
            janela.remove(entradaData);
            janela.remove(botaoArtista);
            janela.remove(botaoEditar);
            janela.remove(botaoCancelar);
            janela.remove(scrollPane);

            TelaEditarAlbum telaEditarAlbum = new TelaEditarAlbum(controle, janela, isArtista);

            telaEditarAlbum.show();

            telaEditarAlbum.getBotaoCancelar().addActionListener(telaEditarAlbum);
            telaEditarAlbum.getBotaoRemover().addActionListener(telaEditarAlbum);
            telaEditarAlbum.getBotaoVisualizar().addActionListener(telaEditarAlbum);
    
        }
        
    }

    private MaskFormatter setMascara(String mascara){
	    MaskFormatter mask = null;
	    try{
	        mask = new MaskFormatter(mascara);                      
	    }catch(ParseException ex){
	    	ex.printStackTrace();
	    }
	    return mask;
	}
}