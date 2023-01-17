import view.TelaInicial;

public class App {
    public static void main(String[] args) throws Exception {

        TelaInicial tela = new TelaInicial();

        tela.show();
        tela.getBotao().addActionListener(tela);

    }
}