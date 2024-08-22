package programa;

public abstract class Conta {
    private static int cont_conta = 1;
    protected int numConta;
    protected Cliente cliente;
    protected Double saldo = 0.0;

    public Conta(Cliente cliente) {
        this.numConta = cont_conta++;
        this.cliente = cliente;
    }

    public int getNumConta() {
        return numConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public abstract void saque(Double valor);

    public void deposito(Double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito realizado!");
        } else {
            System.out.println("Valor inadequado. Refaça o depósito!");
        }
    }

    public void transferencia(Conta contaDestino, Double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
            System.out.println("Transferência realizada!");
        } else {
            System.out.println("Valor inadequado. Refaça a transferência!");
        }
    }

    @Override
    public String toString() {
        return numConta + "\n" + cliente.getNome() + "\n" + cliente.getCpf() + "\n" + cliente.getEmail() + "\n" + saldo + "\n" + (this instanceof ContaCorrente ? "CC" : "CP");
    }

    public static Conta fromString(String dados) {
        String[] partes = dados.split("\n");
        int numConta = Integer.parseInt(partes[0]);
        String nome = partes[1];
        String cpf = partes[2];
        String email = partes[3];
        Double saldo = Double.parseDouble(partes[4]);
        String tipoConta = partes[5]; // Adiciona a informação do tipo de conta
    
        Cliente cliente = new Cliente(nome, cpf, email);
        Conta conta;
    
        if (tipoConta.equals("CC")) {
            conta = new ContaCorrente(cliente);
        } else {
            conta = new ContaPoupanca(cliente);
        }
    
        conta.numConta = numConta;
        conta.setSaldo(saldo);
    
        return conta;
    }  
}
