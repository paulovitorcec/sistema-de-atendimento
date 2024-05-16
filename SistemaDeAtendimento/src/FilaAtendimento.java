import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class FilaAtendimento {

    private Queue<Cliente> fila;
    private Funcionario[] funcionarios;
    private Random random;

    public FilaAtendimento() {
        fila = new LinkedList<>();
        funcionarios = new Funcionario[]{ new Funcionario("Funcionário 1"), new Funcionario("Funcionário 2")};
        random = new Random();
    }

    public void adicionarCliente(Cliente cliente) {
        fila.add(cliente);
        System.out.println(getHoraAtual() + " *" + cliente.getNome() + "* entrou na fila de espera.");
    }

    public void atenderProximoCliente() {
        if (!fila.isEmpty()) {
            Cliente cliente = fila.poll();
            Funcionario funcionario = funcionarios[random.nextInt(funcionarios.length)];
            int tempoAtendimento = random.nextInt(10) + 1;
            System.out.println("\n " + getHoraAtual() + " Atendendo *"+ cliente.getNome() + "*.");

            try{
                Thread.sleep(tempoAtendimento * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 

            System.out.println("\n " + getHoraAtual() + " *" + cliente.getNome() + "* foi atendido pelo *" +funcionario.getNome()+ "* com o tempo de " + tempoAtendimento + " segundos.");
        }
    } public boolean filaVazia() {
        return fila.isEmpty();
    } 

    public void indicarFimDoAtendimento() {
        System.out.println("\n" + getHoraAtual() + " Fim do atendimento!!!");
    }

    private String getHoraAtual() {
        LocalDateTime agora = LocalDateTime.now();
        return agora.toString();
    }
}
