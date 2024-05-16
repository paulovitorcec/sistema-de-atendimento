public class App {
    public static void main(String[] args) throws Exception {

        FilaAtendimento filaAtendimento = new FilaAtendimento();

        filaAtendimento.adicionarCliente( new Cliente ("Cliente 1"));
        filaAtendimento.adicionarCliente( new Cliente ("Cliente 2"));
        filaAtendimento.adicionarCliente( new Cliente ("Cliente 3"));

        while (!filaAtendimento.filaVazia()) {
            filaAtendimento.atenderProximoCliente();
        }
            filaAtendimento.indicarFimDoAtendimento();
    }
}
