package view.musica.editar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.Controle;
import model.Album;
import model.Musica;

public class TelaMusicaSelecionada implements ActionListener{
    private Controle controle;
    private JFrame janela;
    private boolean isArtista;
    private Musica musica;

    private JLabel titulo = new JLabel("Editar Música:");
    private JLabel nome = new JLabel("Nome:");
    private JTextField entradaNome = new JTextField();

    private JLabel duracao = new JLabel("Duração:");
    private JTextField entradaDuracao = new JTextField();

    private DefaultListModel<Album> model = new DefaultListModel<>();
    private JScrollPane scrollPane = new JScrollPane();
    private JList<Album> list = new JList<>();

    private JButton botaoLetra = new JButton("Editar Letra");
    private JButton botaoEditar = new JButton("Editar");
    private JButton botaoCancelar = new JButton("Cancelar");
    private JButton botaoAlbum = new JButton("Editar Album");


    private String nomeDigitado;
    private String duracaoDigitado;

    public TelaMusicaSelecionada(Controle controle, JFrame janela, boolean isArtista, Musica musica){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.musica = musica;
    }

    public TelaMusicaSelecionada(Controle controle, JFrame janela, boolean isArtista, Musica musica, String nomeDigitado, String duracaoDigitado){
        this.controle = controle;
        this.janela = janela;
        this.isArtista = isArtista;
        this.musica = musica;
        this.nomeDigitado = nomeDigitado;
        this.duracaoDigitado = duracaoDigitado;
    }


    public JButton getBotaoCadastrar(){
        return botaoEditar;
    }

    public JButton getBotaoCancelar(){
        return botaoCancelar;
    }

    public JButton getBotaoAlbum(){
        return botaoAlbum;
    }

    public JButton getBotaoLetra(){
        return botaoLetra;
    }


    public void showEdit(){
        if (nomeDigitado == null && duracaoDigitado == null){
            nomeDigitado = musica.getNome();
            duracaoDigitado = musica.getDuracao().toString();
        }

        titulo.setFont(new Font("Ms Gothic", Font.BOLD, 24));
		titulo.setForeground(Color.white);
        titulo.setBounds(330, 70, 360, 60);

        nome.setBounds(145, 170, 100, 29);
        nome.setFont(new Font("Ms Gothic", Font.BOLD, 24));
        nome.setForeground(Color.white);
        
        entradaNome.setBounds(248, 173, 350, 23);
        entradaNome.setLayout(null);
        entradaNome.setText(nomeDigitado);

        duracao.setBounds(125, 200, 300, 29);
        duracao.setFont(new Font("Ms Gothic", Font.BOLD, 24));
        duracao.setForeground(Color.white);
        
        entradaDuracao.setText(duracaoDigitado);
        entradaDuracao.setBounds(248, 203, 350, 23);
        entradaDuracao.setLayout(null);
        entradaDuracao.setText(duracaoDigitado);

        model.removeAllElements();
        model.addElement(musica.getAlbum());
        list.setModel(model);
        scrollPane.setViewportView(list);

        list.setForeground(Color.white);
        list.setFont(new Font("Ms Gothic", Font.BOLD, 16));
        list.setBackground(Color.gray);

        list.setBounds(250, 350, 350, 128);
        scrollPane.setBounds(250, 350, 350, 128);

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

        janela.add(titulo);
        janela.add(nome);
        janela.add(entradaNome);
        janela.add(duracao);
        janela.add(entradaDuracao);
        janela.add(scrollPane);
        janela.add(botaoAlbum);
        janela.add(botaoLetra);
        janela.add(botaoEditar);
        janela.add(botaoCancelar);

        janela.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == botaoLetra){
            janela.remove(titulo);
            janela.remove(nome);
            janela.remove(entradaNome);
            janela.remove(duracao);
            janela.remove(entradaDuracao);
            janela.remove(scrollPane);
            janela.remove(botaoAlbum);
            janela.remove(botaoLetra);
            janela.remove(botaoEditar);
            janela.remove(botaoCancelar);

            TelaLetraEAlbum telaLetraEAlbum = new TelaLetraEAlbum(controle, janela, isArtista, musica, entradaNome.getText(), entradaDuracao.getText());

            telaLetraEAlbum.showLetra();

            telaLetraEAlbum.getBotaoCancelar().addActionListener(telaLetraEAlbum);
            telaLetraEAlbum.getBotaoSalvarLetra().addActionListener(telaLetraEAlbum);
        }

        if (src == botaoAlbum){
            janela.remove(titulo);
            janela.remove(nome);
            janela.remove(entradaNome);
            janela.remove(duracao);
            janela.remove(entradaDuracao);
            janela.remove(scrollPane);
            janela.remove(botaoAlbum);
            janela.remove(botaoLetra);
            janela.remove(botaoEditar);
            janela.remove(botaoCancelar);

            TelaLetraEAlbum telaLetraEAlbum = new TelaLetraEAlbum(controle, janela, isArtista, musica, entradaNome.getText(), entradaDuracao.getText());

            telaLetraEAlbum.showAlbum();

            telaLetraEAlbum.getBotaoCancelar().addActionListener(telaLetraEAlbum);
            telaLetraEAlbum.getBotaoSalvarAlbum().addActionListener(telaLetraEAlbum);
        }

        if (src == botaoEditar){

            if (entradaNome.getText().length() < 3){
                JOptionPane.showMessageDialog(null, "Nome inválido!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                try{
                    if (Double.parseDouble(entradaDuracao.getText()) <= 0 || (Double.parseDouble(entradaDuracao.getText()) - (int)Double.parseDouble(entradaDuracao.getText())) >= 0.6){
                        JOptionPane.showMessageDialog(null, "Duração inválida!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        janela.remove(titulo);
                        janela.remove(nome);
                        janela.remove(entradaNome);
                        janela.remove(duracao);
                        janela.remove(entradaDuracao);
                        janela.remove(scrollPane);
                        janela.remove(botaoAlbum);
                        janela.remove(botaoLetra);
                        janela.remove(botaoEditar);
                        janela.remove(botaoCancelar);

                        musica.setNome(entradaNome.getText());

                        Double dur = Double.parseDouble(entradaDuracao.getText());
                        musica.setDuracao(dur);
            
                        TelaEditarMusica telaEditarMusica = new TelaEditarMusica(controle, janela, isArtista);
            
                        telaEditarMusica.show();
            
                        telaEditarMusica.getBotaoCancelar().addActionListener(telaEditarMusica);
                        telaEditarMusica.getBotaoVisualizar().addActionListener(telaEditarMusica);
                        telaEditarMusica.getBotaoRemover().addActionListener(telaEditarMusica);
                    }
                }
                catch(Exception e1){
                    JOptionPane.showMessageDialog(null, "Duração inválida ou música sem letra!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }
            }



        }

        if (src == botaoCancelar){
            janela.remove(titulo);
            janela.remove(nome);
            janela.remove(entradaNome);
            janela.remove(duracao);
            janela.remove(entradaDuracao);
            janela.remove(scrollPane);
            janela.remove(botaoAlbum);
            janela.remove(botaoLetra);
            janela.remove(botaoEditar);
            janela.remove(botaoCancelar);

            TelaEditarMusica telaEditarMusica = new TelaEditarMusica(controle, janela, isArtista);

			telaEditarMusica.show();

			telaEditarMusica.getBotaoCancelar().addActionListener(telaEditarMusica);
			telaEditarMusica.getBotaoVisualizar().addActionListener(telaEditarMusica);
            telaEditarMusica.getBotaoRemover().addActionListener(telaEditarMusica);
        }
        
    }
}