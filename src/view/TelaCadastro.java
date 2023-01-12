package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalCheckBoxIcon;

import controller.Controle;

public class TelaCadastro implements ActionListener{

    private static JFrame janela = new JFrame("Cadastro");
    private static JLabel titulo = new JLabel("Cadastro:");
    private static JLabel nome = new JLabel("Nome:");
    private static JTextField entradaNome = new JTextField();

    private static JLabel rg = new JLabel("Rg:");
    private static JTextField entradaRg = new JTextField();

    private static JLabel estilo = new JLabel("Estilo Musical:");
    private static JTextField entradaEstilo = new JTextField();

    private static JCheckBox opcaoBox = new JCheckBox();
    private static JLabel textoBox = new JLabel("Cadastrar como Artista");

    private static JButton botao = new JButton("Cadastrar");
    
    private Font fonte = new TelaPrincipal().getFonte();

    private Controle controle = new Controle();

    public void show(){
        janela.getContentPane().setBackground(Color.darkGray);
		janela.setResizable(false);
        janela.setSize(800, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(null);

        titulo.setFont(fonte);
		titulo.setForeground(Color.white);
        titulo.setBounds(330, 121, 360, 60);

        nome.setBounds(145, 218, 100, 29);
        nome.setFont(fonte);
        nome.setForeground(Color.white);

        entradaNome.setBounds(248, 221, 350, 23);
        entradaNome.setLayout(null);
        // entradaNome.setEnabled(false);

        rg.setBounds(145, 250, 100, 29);
        rg.setFont(fonte);
        rg.setForeground(Color.white);
        
        entradaRg.setBounds(248, 253, 350, 23);
        entradaRg.setLayout(null);

        opcaoBox.setIcon(new MetalCheckBoxIcon(){
            protected int getControlSize() { return 20; }
        });
        opcaoBox.setBounds(159, 295, 18, 18);
        opcaoBox.setBorder(null);

        textoBox.setBounds(186, 295, 250, 18);
        textoBox.setForeground(Color.white);
        textoBox.setFont(new Font("Ms Gothic", Font.BOLD, 16));

        estilo.setBounds(40, 350, 200, 29);
        estilo.setFont(fonte);
        estilo.setForeground(Color.white);

        entradaEstilo.setBounds(248, 353, 350, 23);
        entradaEstilo.setLayout(null);
        
		botao.setFont(new Font("Ms Gothic", Font.BOLD, 16));
		botao.setBackground(Color.decode("#A020F0"));
        botao.setForeground(Color.WHITE);
		botao.setBounds(342, 404, 125, 35);
        botao.setBorder(null);
        botao.setFocusPainted(false);

        janela.add(titulo);
        janela.add(nome);
        janela.add(entradaNome);
        janela.add(rg);
        janela.add(entradaRg);
        janela.add(opcaoBox);
        janela.add(textoBox);
        janela.add(botao);


        janela.setVisible(true);
    }

    public JCheckBox getCheckBox(){
        return opcaoBox;
    }

    public JButton getButton(){
        return botao;
    }

    public void showEstilo(){

        if (opcaoBox.isSelected()){
            janela.add(estilo);
            janela.add(entradaEstilo);
            janela.repaint();

        }
        else{
            janela.remove(estilo);
            janela.remove(entradaEstilo);
            janela.repaint();
        }
    }


    public void actionPerformed(ActionEvent e){
		Object src = e.getSource();

		if (src == opcaoBox){
            this.showEstilo();
		}

        if (src == botao){
            janela.dispose();

            if (opcaoBox.isSelected()){
                controle.artista(entradaNome.getText(), entradaRg.getText(), entradaEstilo.getText());
                new TelaAplicativo().show(true);
                
            }
            else{
                controle.usuario(entradaNome.getText(), entradaRg.getText());
                new TelaAplicativo().show(false);
            }
            
        }
	}
}