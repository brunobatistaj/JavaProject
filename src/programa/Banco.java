package programa;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Banco {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contas_bancarias;

    public static void main(String[] args) {
        contas_bancarias = new ArrayList<>();
        op_menu();
    }
    

    public static void op_menu() {
        System.out.println("Banco IF - Agência 051");
        System.out.println("----------------------");
        System.out.println("#Selecione a operação#");
        System.out.println("1 - Criar conta  ");
        System.out.println("2 - Depositar    ");
        System.out.println("3 - Saque        ");
        System.out.println("4 - Transferir   ");
        System.out.println("5 - Listar Contas");
        System.out.println("6 - Salvar Dados ");
        System.out.println("7 - Carregar Dados");
        System.out.println("8 - Sair         ");
    
        int escolha = input.nextInt();
        input.nextLine(); // Limpar o buffer de entrada
    
        switch (escolha) {
            case 1:
                criar_conta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                op_listar();
                break;
            case 6:
                salvarDados();
                break;
            case 7:
                carregarDados();
                break;
            case 8:
                System.out.println("Obrigado!");
                System.exit(0);
                break;
            default:
                System.out.println("Operação inválida!");
                op_menu();
                break;
        }
    }
    

    public static void criar_conta() {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Cliente cliente = new Cliente(nome, cpf, email);

        System.out.println("\nTipo de Conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");

        int tipoConta = input.nextInt();
        Conta conta;

        if (tipoConta == 1) {
            conta = new ContaCorrente(cliente);
        } else if (tipoConta == 2) {
            conta = new ContaPoupanca(cliente);
        } else {
            System.out.println("Tipo de conta inválido!");
            return;
        }

        contas_bancarias.add(conta);
        System.out.println("\nConta criada!");
        op_menu();
    }

    public static Conta encontra_conta(int numConta) {
        for (Conta conta : contas_bancarias) {
            if (conta.getNumConta() == numConta) {
                return conta;
            }
        }
        return null; // Retorna null se a conta não for encontrada
    }

    public static void depositar() {
        System.out.println("Número da conta: ");
        int numConta = input.nextInt();

        Conta conta = encontra_conta(numConta);

        if (conta != null) {
            System.out.println("Qual valor de depósito? ");
            Double valor_deposito = input.nextDouble();
            conta.deposito(valor_deposito);
            System.out.println("VALOR DEPOSITADO!");
        } else {
            System.out.println("Conta não encontrada!");
        }

        op_menu();
    }

    public static void sacar() {
        System.out.println("Número da conta: ");
        int numConta = input.nextInt();

        Conta conta = encontra_conta(numConta);

        if (conta != null) {
            System.out.println("Qual valor de saque? ");
            Double valor_saque = input.nextDouble();
            conta.saque(valor_saque);
        } else {
            System.out.println("Conta não encontrada!");
        }

        op_menu();
    }

    public static void transferir() {
        System.out.println("Número de sua conta: ");
        int num_remetente = input.nextInt();
        Conta contaRemetente = encontra_conta(num_remetente);

        if (contaRemetente != null) {
            System.out.println("Número de conta destinatário: ");
            int num_destino = input.nextInt();
            Conta contaDestino = encontra_conta(num_destino);

            if (contaDestino != null) {
                System.out.println("Qual valor de transferência? ");
                Double valor = input.nextDouble();

                contaRemetente.transferencia(contaDestino, valor);
            } else {
                System.out.println("Conta de destino não encontrada!");
            }
        } else {
            System.out.println("Conta não encontrada!");
        }
        op_menu();
    }

    public static void op_listar() {
        if (contas_bancarias.size() > 0) {
            for (Conta conta : contas_bancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não temos contas bancárias cadastradas!");
        }
        op_menu();
    }

    public static void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contas_bancarias.txt"))) {
            for (Conta conta : contas_bancarias) {
                writer.write(conta.toString());
                writer.newLine(); // Adiciona uma nova linha para cada conta
            }
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
        op_menu();
    }
    

    public static void carregarDados() {
        try (BufferedReader reader = new BufferedReader(new FileReader("contas_bancarias.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Conta conta = Conta.fromString(linha);
                if (conta != null) {
                    contas_bancarias.add(conta);
                }
            }
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
        op_menu();
    }

}
