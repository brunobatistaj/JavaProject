package programa;
public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
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
    public static ContaPoupanca fromString(String dados) {
        String[] partes = dados.split(";");
        int numConta = Integer.parseInt(partes[0]);
        String nome = partes[1];
        String cpf = partes[2];
        String email = partes[3];
        Double saldo = Double.parseDouble(partes[4]);

        Cliente cliente = new Cliente(nome, cpf, email);
        ContaPoupanca conta = new ContaPoupanca(cliente);
        conta.numConta = numConta;
        conta.setSaldo(saldo);

        return conta;
    }
}
