import view.TelaPrincipal;

public class App {
    public static void main(String[] args) throws Exception {

        TelaPrincipal tela = new TelaPrincipal();

        tela.show();
        tela.getBotao().addActionListener(tela);

    }
}