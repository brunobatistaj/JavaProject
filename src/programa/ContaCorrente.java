package programa;
public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void saque(Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque realizado!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    // Implementação específica do método fromString
    public static ContaCorrente fromString(String dados) {
        String[] partes = dados.split(";");
        int numConta = Integer.parseInt(partes[0]);
        String nome = partes[1];
        String cpf = partes[2];
        String email = partes[3];
        Double saldo = Double.parseDouble(partes[4]);

        Cliente cliente = new Cliente(nome, cpf, email);
        ContaCorrente conta = new ContaCorrente(cliente);
        conta.numConta = numConta;
        conta.setSaldo(saldo);

        return conta;
    }
}
