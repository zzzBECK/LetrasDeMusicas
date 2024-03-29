package view.album.cadastro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import model.Artista;
import view.main.TelaAplicativo;

/**
 * Classe que representa a tela para realizar o cadastro de um album
 * @author Alexandre de Santana Beck
 * @since 2023
 * @version 1.0
 */
public class TelaCadastroAlbum implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;
    private Artista artista;
    private List<Artista> artistas = new ArrayList<>();

    private DefaultListModel<Artista> model = new DefaultListModel<>();
    private JScrollPane scrollPane = new JScrollPane();
    private JList<Artista> list = new JList<>();

    private JLabel titulo = new JLabel("Cadastro:");

    private JLabel nome = new JLabel("Nome:");
    private JTextField entradaNome = new JTextField();

    private JLabel data = new JLabel("Data de Lançamento:");
    private JFormattedTextField entradaData = new JFormattedTextField(setMascara("##/##/####"));

    private JButton botaoArtista = new JButton("Adicionar Artista");

    private JButton botaoCadastrar = new JButton("Cadastrar");
    private JButton botaoCancelar = new JButton("Cancelar");

    private Font fonte =  new Font("Ms Gothic", Font.BOLD, 18);

    private String nomeDigitado;
    private String dataDigitado;

    /**
     * Contrutor padrao da classe, utilizado pela TelaAplicativo
     * @param controle
     * @param janela
     * @param isArtista
     */
    public TelaCadastroAlbum(Controle controle, JFrame janela, boolean isArtista){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
    }

    /**
     * construtor adicional, utilizado pela tela de AdicionarArtista, com o intuito de manter os dados
     * @param controle
     * @param janela
     * @param isArtista
     * @param artista
     * @param nomeDigitado
     * @param dataDigitado
     * @param model
     * @param artistas
     */
    public TelaCadastroAlbum(Controle controle, JFrame janela, boolean isArtista, Artista artista, String nomeDigitado,
                             String dataDigitado, DefaultListModel<Artista> model, List<Artista> artistas){                            
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.artista = artista;
        this.nomeDigitado = nomeDigitado;
        this.dataDigitado = dataDigitado;
        this.model = model;
        this.artistas = artistas;
    }

    public JButton getBotaoCadastrar(){
        return botaoCadastrar;
    }

    public JButton getBotaoCancelar(){
        return botaoCancelar;
    }

    public JButton getBotaoArtista(){
        return botaoArtista;
    }

    /**
     * Metodo que configura a tela e faz sua atualização
     */
    public void show(){

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

        if(artistas.isEmpty()){
            artistas.add(controle.getDados().getArtistas().get(controle.getDados().getArtistas().size() - 1));
            model.addElement(controle.getDados().getArtistas().get(controle.getDados().getArtistas().size() - 1));
        }

        if (artista != null && !artistas.contains(artista))
            artistas.add(artista);

        model.addElement(artista);
        list.setModel(model);
        scrollPane.setViewportView(list);

        list.setForeground(Color.white);
        list.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        list.setBackground(Color.gray);

        list.setBounds(250, 350, 350, 128);
        scrollPane.setBounds(250, 350, 350, 128);
        
		botaoCadastrar.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botaoCadastrar.setBackground(Color.decode("#A020F0"));
        botaoCadastrar.setForeground(Color.WHITE);
		botaoCadastrar.setBounds(416, 494, 125, 35);
        botaoCadastrar.setBorder(null);
        botaoCadastrar.setFocusPainted(false);

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
        janela.add(botaoCadastrar);
        janela.add(botaoCancelar);
        janela.add(scrollPane);


        janela.repaint();
    }

    /**
     * Meotodo que é executado quando um evento é realizado
     * eventos: cancelar, adicionar artista, cadastrar album
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e){
		Object src = e.getSource();

        if (src == botaoCancelar){
            janela.remove(titulo);
            janela.remove(nome);
            janela.remove(entradaNome);
            janela.remove(data);
            janela.remove(entradaData);
            janela.remove(botaoArtista);
            janela.remove(botaoCadastrar);
            janela.remove(botaoCancelar);
            janela.remove(scrollPane);

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

        if (src == botaoArtista){
            janela.remove(titulo);
            janela.remove(nome);
            janela.remove(entradaNome);
            janela.remove(data);
            janela.remove(entradaData);
            janela.remove(botaoArtista);
            janela.remove(botaoCadastrar);
            janela.remove(botaoCancelar);
            janela.remove(scrollPane);

            TelaAdicionarArtista telaAdicionarArtista = new TelaAdicionarArtista(controle, janela, isArtista,
                                                            entradaNome.getText(), entradaData.getText(), model, artistas);

            telaAdicionarArtista.show();

            telaAdicionarArtista.getBotaoCadastrar().addActionListener(telaAdicionarArtista);
            telaAdicionarArtista.getBotaoCancelar().addActionListener(telaAdicionarArtista);

        }

        if (src == botaoCadastrar){
            if (entradaNome.getText().length() < 3){
                JOptionPane.showMessageDialog(null, "Nome inválido!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (controle.albumIsCadastrado(entradaNome.getText())){
                JOptionPane.showMessageDialog(null, "Álbum já cadastrado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
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
                            janela.remove(botaoCadastrar);
                            janela.remove(botaoCancelar);
                            janela.remove(scrollPane);

                            Date dateFormat = new Date();

                            try {
                                dateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(entradaData.getText());
                                controle.album(entradaNome.getText(), dateFormat, artistas);
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }
                            

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
                    } 
                    catch (ParseException e1) {
                        JOptionPane.showMessageDialog(null, "Data inválida!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
            }


        }
            
	}

    /**
     * Metodo que estabelece o padrao de data no input
     * @param mascara
     * @return mask
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