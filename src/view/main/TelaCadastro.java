package view.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalCheckBoxIcon;

import controller.Controle;

/**
 * Classe que representa a tela de cadastro inicial
 * @author Alexandre de Santana Beck
 * @since 2023
 * @version 1.0
 */
public class TelaCadastro implements ActionListener{
    private Controle controle;
    private JFrame janela;

    private JLabel titulo = new JLabel("Cadastro:");
    private JLabel nome = new JLabel("Nome:");
    private JTextField entradaNome = new JTextField();

    private JLabel rg = new JLabel("CPF:");
    private JTextField entradaCpf = new JTextField();

    private JLabel estilo = new JLabel("Estilo Musical:");
    private JTextField entradaEstilo = new JTextField();

    private JCheckBox opcaoBox = new JCheckBox();
    private JLabel textoBox = new JLabel("Cadastrar como Artista");

    private JButton botao = new JButton("Cadastrar");
    
    private Font fonte =  new Font("Ms Gothic", Font.BOLD, 24);

    /**
     * Contrutor padrao da classe
     * @param controle
     * @param janela
     */
    public TelaCadastro(Controle controle, JFrame janela){
        this.controle = controle;
        this.janela = janela;
    }


    public JCheckBox getCheckBox(){
        return opcaoBox;
    }

    public JButton getButton(){
        return botao;
    }


    /**
     * metodo que faz a configuração da tela e faz sua atualização
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
        entradaNome.setText(null);

        rg.setBounds(145, 250, 100, 29);
        rg.setFont(fonte);
        rg.setForeground(Color.white);
        
        entradaCpf.setBounds(248, 253, 350, 23);
        entradaCpf.setLayout(null);
        entradaCpf.setText(null);

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
        entradaEstilo.setText(null);
        
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
        janela.add(entradaCpf);
        janela.add(opcaoBox);
        janela.add(textoBox);
        janela.add(botao);


        janela.repaint();
    }

    /**
     * metodo que adiciona o input de estilo musical, caso o checkbox esteja selecionado
     */
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


    /**
     * metodo que é executado quando um evento é realizado
     * eventos: opcao de entrar com artista (checkBox), e cadastar (Usuario ou Artista)
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e){
		Object src = e.getSource();

		if (src == opcaoBox){
            this.showEstilo();
		}

        if (src == botao){
            if (entradaNome.getText().length() < 3){
                JOptionPane.showMessageDialog(null, "Nome inválido!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (!controle.checkCpf(entradaCpf.getText())){
                JOptionPane.showMessageDialog(null, "CPF inválido!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (controle.cpfIsCadastrado(entradaCpf.getText())){
                JOptionPane.showMessageDialog(null, "CPF já cadastrado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (opcaoBox.isSelected() && entradaEstilo.getText().length() < 3){
                JOptionPane.showMessageDialog(null, "Estilo musical inválido!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                janela.remove(titulo);
                janela.remove(nome);
                janela.remove(entradaNome);
                janela.remove(rg);
                janela.remove(entradaCpf);
                janela.remove(opcaoBox);
                janela.remove(textoBox);
                janela.remove(botao);
                janela.remove(estilo);
                janela.remove(entradaEstilo);
    
    
                if (opcaoBox.isSelected()){
                    TelaAplicativo telaAplicativo = new TelaAplicativo(controle, janela, true);
    
                    controle.artista(entradaNome.getText(), entradaCpf.getText(), entradaEstilo.getText());
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
                else{
                    TelaAplicativo telaAplicativo = new TelaAplicativo(controle, janela, false);
    
                    controle.usuario(entradaNome.getText(), entradaCpf.getText());
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
        }
	}
}