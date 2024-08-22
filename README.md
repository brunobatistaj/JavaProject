## Getting Started

### Relatório: Aplicação dos Conceitos de Programação Orientada a Objetos na Aplicação Bancária

#### Introdução
Este relatório descreve a aplicação dos principais conceitos de programação orientada a objetos (POO) na implementação de um sistema bancário. O sistema é desenvolvido em Java e inclui funcionalidades como criação de contas, depósitos, saques, transferências, e persistência de dados.

#### Conceitos Aplicados

1. **Classes e Objetos**
   - **Classes**: A aplicação define várias classes para representar diferentes componentes do sistema:
     - `Banco`: Gerencia as operações bancárias e a lista de contas.
     - `Conta`: Classe abstrata que define as propriedades e comportamentos comuns a todas as contas bancárias.
     - `ContaCorrente` e `ContaPoupanca`: Subclasses de `Conta`, cada uma representando um tipo específico de conta com suas particularidades.
     - `Cliente`: Representa informações do cliente, herdando de `Pessoa`.
     - `Pessoa`: Classe base que contém informações pessoais comuns a clientes.
   - **Objetos**: Instâncias dessas classes são criadas e manipuladas. Por exemplo, um objeto de `ContaCorrente` é criado quando uma nova conta corrente é aberta, e objetos de `Cliente` são associados a essas contas.

2. **Encapsulamento**
   - **Proteção de Atributos**: Atributos como `numConta`, `saldo`, `nome`, `cpf`, e `email` são privados (`private`), garantindo que seu acesso e modificação sejam feitos somente através de métodos públicos (`getters` e `setters`). Isso protege os dados internos e promove a integridade da aplicação.
   - **Métodos Públicos**: Métodos como `deposito`, `saque`, e `transferencia` em `Conta` gerenciam o saldo da conta, garantindo que alterações sejam feitas de maneira controlada e segura.

3. **Herança**
   - **Superclasse e Subclasses**: `Conta` é uma classe abstrata que fornece a estrutura básica para todas as contas bancárias. As classes `ContaCorrente` e `ContaPoupanca` estendem `Conta` e implementam funcionalidades específicas. Esse uso de herança permite a reutilização de código e a definição de comportamentos comuns em `Conta`, enquanto as subclasses adicionam ou modificam comportamentos conforme necessário.

4. **Polimorfismo**
   - **Sobrescrita de Métodos**: O método `saque` é declarado como abstrato em `Conta` e implementado de maneira específica em `ContaCorrente` e `ContaPoupanca`. Isso permite que o método tenha comportamentos diferentes dependendo do tipo de conta, demonstrando polimorfismo.
   - **Tratamento Uniforme**: O método `transferencia` em `Conta` pode operar com qualquer tipo de conta (`ContaCorrente` ou `ContaPoupanca`), permitindo que diferentes tipos de contas sejam tratados de forma uniforme e intercambiável.

5. **Sobrecarga e Sobrescrita de Métodos**
   - **Sobrescrita**: Métodos como `toString` são sobrescritos em `Cliente` e `Conta` para fornecer representações textuais específicas das suas respectivas classes.
   - **Sobrecarregamento**: Embora não explicitamente utilizado, sobrecarga de métodos pode ser implementada caso necessário, para fornecer várias versões de um método com diferentes parâmetros.

6. **Classes Abstratas e Interfaces**
   - **Classe Abstrata**: `Conta` é uma classe abstrata que define métodos abstratos como `saque`. As subclasses fornecem implementações concretas desses métodos, estabelecendo um contrato de comportamento que as subclasses devem seguir.
   - **Interface**: No código fornecido, interfaces não são utilizadas, mas poderiam ser introduzidas para definir contratos para comportamentos específicos que várias classes devem implementar.

7. **Coleções**
   - **ArrayList**: O uso de `ArrayList<Conta>` permite o armazenamento e a manipulação dinâmica de contas bancárias. A lista é usada para adicionar, acessar, e iterar sobre as contas, demonstrando o uso de coleções para gerenciar grupos de objetos.

8. **Manipulação de Arquivos**
   - **Persistência de Dados**: `BufferedWriter` e `BufferedReader` são utilizados para salvar e carregar dados de contas bancárias a partir de um arquivo de texto. Isso permite a persistência de dados entre execuções do programa, garantindo que informações importantes não sejam perdidas.

#### Conclusão
A aplicação dos conceitos de programação orientada a objetos no sistema bancário é fundamental para a organização, manutenção e expansão do código. Através da criação de classes e objetos, encapsulamento de dados, herança, polimorfismo, e uso de coleções e manipulação de arquivos, o sistema é capaz de oferecer uma estrutura robusta e flexível para a gestão bancária. Esses conceitos não apenas promovem a reutilização e a segurança do código, mas também facilitam a adição de novas funcionalidades e a manutenção do sistema.

## Folder Structure

Duas pastas no padrão:

- `src\programa`: codigos principais.
- `src\programa\utilitarios`: codigos aux.

Saidas compiladas vão gerar arquivos na pasta `bin` por padrão.

> Para customizar, abra `.vscode/settings.json` e faça seus updates.

