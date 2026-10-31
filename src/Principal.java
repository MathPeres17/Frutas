import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista de bananas disponíveis
        List<Banana> estoque = new ArrayList<>();

        estoque.add(new Banana("Banana-prata", 1.50, 20));
        estoque.add(new Banana("Banana-nanica", 1.20, 15));
        estoque.add(new Banana("Banana-maçã", 2.00, 10));

        // Pré-cadastro de clientes
        Cliente[] clientes = Cliente.preCadastrarClientes();

        System.out.println("=== SISTEMA DE COMPRA DE BANANAS ===");

        System.out.println("\nClientes cadastrados:");

        for (int i = 0; i < clientes.length; i++) {
            System.out.println(
                (i + 1) + " - " + clientes[i].getNome()
            );
        }

        System.out.print("\nEscolha o cliente pelo número: ");
        int escolhaCliente = lerInteiro(scanner);

        if (escolhaCliente < 1 || escolhaCliente > clientes.length) {
            System.out.println("Cliente inválido.");
            scanner.close();
            return;
        }

        // Seleciona o cliente escolhido
        Cliente clienteSelecionado = clientes[escolhaCliente - 1];

        System.out.println(
            "\nBem-vindo(a), " + clienteSelecionado.getNome() + "!"
        );

        System.out.println("\nDados do cadastro:");
        clienteSelecionado.exibirCadastro();

        // Exibe as bananas disponíveis
        System.out.println("\nBananas disponíveis:");

        for (int i = 0; i < estoque.size(); i++) {
            System.out.print((i + 1) + " - ");
            estoque.get(i).exibirInformacoes();
        }

        System.out.print("\nEscolha a banana que deseja comprar: ");
        int escolhaBanana = lerInteiro(scanner);

        if (escolhaBanana < 1 || escolhaBanana > estoque.size()) {
            System.out.println("Opção de banana inválida.");
            scanner.close();
            return;
        }

        // Seleciona a banana escolhida
        Banana bananaSelecionada = estoque.get(escolhaBanana - 1);

        System.out.print("Quantas unidades deseja comprar? ");
        int quantidadeCompra = lerInteiro(scanner);

        // Verifica o estoque e realiza a compra
        if (bananaSelecionada.vender(quantidadeCompra)) {

            double total = bananaSelecionada.getPreco()
                    * quantidadeCompra;

            System.out.println("\n=== COMPRA REALIZADA ===");
            System.out.println(
                "Cliente: " + clienteSelecionado.getNome()
            );
            System.out.println(
                "Produto: " + bananaSelecionada.getNome()
            );
            System.out.println(
                "Quantidade: " + quantidadeCompra
            );

            System.out.printf("Total: R$ %.2f%n", total);

            System.out.println(
                "Estoque restante: "
                + bananaSelecionada.getQuantidade()
            );

        } else {
            System.out.println(
                "Compra não realizada. Verifique a quantidade "
                + "informada e o estoque."
            );
        }

        scanner.close();
    }

    // Método para ler números inteiros
    private static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print(
                "Digite um número inteiro válido: "
            );
            scanner.next();
        }

        return scanner.nextInt();
    }
}