package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Controle;

public class TelaCadastroAlbum implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;

    private JLabel titulo = new JLabel("Cadastro:");
    private JLabel nome = new JLabel("Nome:");
    private JTextField entradaNome = new JTextField();

    private JLabel data = new JLabel("Data de Lançamento:");
    private JTextField entradaData = new JTextField();

    private JButton botaoCadastrar = new JButton("Cadastrar");
    private JButton botaoCancelar = new JButton("Cancelar");

    private Font fonte =  new Font("Ms Gothic", Font.BOLD, 24);

    public TelaCadastroAlbum(Controle controle, JFrame janela, boolean isArtista){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
    }

    public JButton getBotaoCadastrar(){
        return botaoCadastrar;
    }

    public JButton getBotaoCancelar(){
        return botaoCancelar;
    }

    public void show(){

        titulo.setFont(fonte);
		titulo.setForeground(Color.white);
        titulo.setBounds(330, 121, 360, 60);

        nome.setBounds(145, 218, 100, 29);
        nome.setFont(fonte);
        nome.setForeground(Color.white);

        entradaNome.setBounds(248, 221, 350, 23);
        entradaNome.setLayout(null);
        entradaNome.setText(null);

        data.setBounds(5, 250, 300, 29);
        data.setFont(fonte);
        data.setForeground(Color.white);
        
        entradaData.setBounds(248, 253, 350, 23);
        entradaData.setLayout(null);
        entradaData.setText(null);

        
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
        janela.add(botaoCadastrar);
        janela.add(botaoCancelar);


        janela.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e){
		Object src = e.getSource();

        if (src == botaoCancelar){
            janela.remove(titulo);
            janela.remove(nome);
            janela.remove(entradaNome);
            janela.remove(data);
            janela.remove(entradaData);
            janela.remove(botaoCadastrar);
            janela.remove(botaoCancelar);

            TelaAplicativo telaAplicativo = new TelaAplicativo(controle, janela, isArtista);

            telaAplicativo.show();

            telaAplicativo.getArtBotao().addActionListener(telaAplicativo);
            telaAplicativo.getAlbBotao().addActionListener(telaAplicativo);
            telaAplicativo.getMusBotao().addActionListener(telaAplicativo);
            telaAplicativo.getCAlbmBotao().addActionListener(telaAplicativo);
            telaAplicativo.getCMusBotao().addActionListener(telaAplicativo);
            telaAplicativo.getBotaoVoltar().addActionListener(telaAplicativo);
        }
            
	}
}