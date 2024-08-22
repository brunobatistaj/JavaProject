package programa;

public class Cliente extends Pessoa {

    // Construtor
    public Cliente(String nome, String cpf, String email) {
        super(nome, cpf, email);
    }

    // Não há necessidade de getters e setters para nome, cpf e email, pois já são herdados de Pessoa

    // Sobrescrevendo o método toString da classe Pessoa para adicionar informações específicas do Cliente, se necessário
    @Override
    public String toString() {
        return super.toString(); // Pode adicionar mais detalhes específicos do Cliente aqui, se necessário
    }
}
