package view.album.editar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.Controle;
import model.Album;
import model.Artista;

/**
 * Classe que represnta o album selecionado para edição, ja com seus dadods previamente inseridos
 * @author Alexandre de Santana Beck
 * @since 2023
 * @version 1.0
 */
public class TelaAlbumSelecionado implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;
    private Album album;

    private List<Artista> artistas = new ArrayList<>();
    private List<Artista> artistasRemovidos = new ArrayList<>();
    private List<Artista> artistasAdicionados = new ArrayList<>();


    private DefaultListModel<Artista> model = new DefaultListModel<>();
    private JScrollPane scrollPane = new JScrollPane();
    private JList<Artista> list = new JList<>();

    private JLabel titulo = new JLabel("Cadastro:");

    private JLabel nome = new JLabel("Nome:");
    private JTextField entradaNome = new JTextField();

    private JLabel data = new JLabel("Data de Lançamento:");
    private JFormattedTextField entradaData = new JFormattedTextField(setMascara("##/##/####"));

    private JButton botaoArtista = new JButton("Adicionar Artista");

    private JButton botaoCancelar = new JButton("Cancelar");
    private JButton botaoRemover = new JButton("Remover");
    private JButton botaoEditar = new JButton("Editar");

    private Font fonte =  new Font("Ms Gothic", Font.BOLD, 24);

    private String nomeDigitado;
    private String dataDigitado;

    /**
     * Contrutor padrao da classe
     * @param controle
     * @param janela
     * @param isArtista
     * @param album
     */
    public TelaAlbumSelecionado(Controle controle, JFrame janela, boolean isArtista, Album album){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.album = album;
    }

    /**
     * Contrutor utilizado para manter os dados contidos na tela antes de navegar
     * pela tela de adicionar adicionar artistsa
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
    public TelaAlbumSelecionado(Controle controle, JFrame janela, boolean isArtista, Album album,
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

    public JButton getBotaoEditar(){
        return botaoEditar;
    }

    public JButton getBotaoCancelar(){
        return botaoCancelar;
    }

    public JButton getBotaoRemover(){
        return botaoRemover;
    }

    public JButton getBotaoArtista(){
        return botaoArtista;
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

        model.clear();

        if (artistas.isEmpty()){
            for (Artista artista : album.getArtistas()){
                model.addElement(artista);
                artistas.add(artista);
            }
        }
        else {
            for (Artista artista : artistas){
                model.addElement(artista);
            }
        }

        list.setModel(model);
        scrollPane.setViewportView(list);
        
        list.setForeground(Color.white);
        list.setBackground(Color.gray);
        list.setBounds(250, 350, 400, 128);
        list.setFont(new Font("Ms Gothic", Font.BOLD, 16));

        
        scrollPane.setBounds(250, 350, 350, 128);

        
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

        janela.add(titulo);
        janela.add(nome);
        janela.add(entradaNome);
        janela.add(data);
        janela.add(entradaData);
        janela.add(botaoArtista);
        janela.add(botaoEditar);
        janela.add(botaoRemover);
        janela.add(botaoCancelar);
        janela.add(scrollPane);


        janela.repaint();
    }

    /**
     * meotodo executado quando há um evento
     * eventos: cancelar, adcionar artista, remover artista, editar
     * @param e
     */
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
            janela.remove(botaoRemover);
            janela.remove(botaoCancelar);
            janela.remove(scrollPane);

            TelaEditarAlbum telaEditarAlbum = new TelaEditarAlbum(controle, janela, isArtista);

            telaEditarAlbum.show();

            telaEditarAlbum.getBotaoCancelar().addActionListener(telaEditarAlbum);
            telaEditarAlbum.getBotaoRemover().addActionListener(telaEditarAlbum);
            telaEditarAlbum.getBotaoVisualizar().addActionListener(telaEditarAlbum);
    
        }

        if (src == botaoArtista){
            janela.remove(titulo);
            janela.remove(nome);
            janela.remove(entradaNome);
            janela.remove(data);
            janela.remove(entradaData);
            janela.remove(botaoArtista);
            janela.remove(botaoEditar);
            janela.remove(botaoRemover);
            janela.remove(botaoCancelar);
            janela.remove(scrollPane);

            TelaAdicionarArtistaEditar telaAdicionarArtistaEditar = new TelaAdicionarArtistaEditar(controle, janela, isArtista, album,
                                                                                                   entradaNome.getText(), entradaData.getText(),
                                                                                                   artistas, artistasRemovidos, artistasAdicionados);

            telaAdicionarArtistaEditar.show();

            telaAdicionarArtistaEditar.getBotaoAdicionar().addActionListener(telaAdicionarArtistaEditar);
            telaAdicionarArtistaEditar.getBotaoCancelar().addActionListener(telaAdicionarArtistaEditar);
        }

        if (src == botaoRemover){
            if (list.getSelectedValue() != null && list.getSelectedValue() != controle.getDados().getArtistas().get(controle.getDados().getArtistas().size() - 1)){
                artistas.remove(list.getSelectedValue());
                artistasRemovidos.add(list.getSelectedValue());
               
                nomeDigitado = entradaNome.getText();
                dataDigitado = entradaData.getText();
                show();
            }
        }

        if (src == botaoEditar){

            if (entradaNome.getText().length() < 3){
                JOptionPane.showMessageDialog(null, "Nome inválido!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            } 
            else{
                    try{
                        if (new SimpleDateFormat("dd/MM/yyyy").parse(entradaData.getText()).after(new Date(System.currentTimeMillis()))){
                            JOptionPane.showMessageDialog(null, "Data inválida!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            janela.remove(titulo);
                            janela.remove(nome);
                            janela.remove(entradaNome);
                            janela.remove(data);
                            janela.remove(entradaData);
                            janela.remove(botaoArtista);
                            janela.remove(botaoEditar);
                            janela.remove(botaoRemover);
                            janela.remove(botaoCancelar);
                            janela.remove(scrollPane);

                            album.setNome(entradaNome.getText());

                            Date dateFormat = new Date();

                            try {
                                dateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(entradaData.getText());
                                album.setDataLancamento(dateFormat);
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }
                
                            for (Artista artista : artistasRemovidos){
                                artista.removerAlbum(album);
                            }
                
                            for (Artista artista : artistasAdicionados){
                                artista.adicionarAlbum(album);
                            }
                
                            album.setArtistas(artistas);
                
                            TelaEditarAlbum telaEditarAlbum = new TelaEditarAlbum(controle, janela, isArtista);
                
                            telaEditarAlbum.show();
                
                            telaEditarAlbum.getBotaoCancelar().addActionListener(telaEditarAlbum);
                            telaEditarAlbum.getBotaoRemover().addActionListener(telaEditarAlbum);
                            telaEditarAlbum.getBotaoVisualizar().addActionListener(telaEditarAlbum);
                        }
                    } 
                    catch (ParseException e1) {
                        JOptionPane.showMessageDialog(null, "Data inválida!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
            }

        }
        
    }

    /**
     * Metodo utilizado para formatar o input da data no formato dd/MM/yyyy
     * @param mascara
     * @return
     */
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