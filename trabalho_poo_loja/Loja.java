package trabalho_poo_loja;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Loja {

    public static void main(String[] args) {
        // Criar produtos e definir estoque por tamanho
        Produto camisa1 = new Produto("Camisa Vermelha", 49.99);
        camisa1.definirEstoquePorTamanho("PP", 5);
        camisa1.definirEstoquePorTamanho("P", 10);
        camisa1.definirEstoquePorTamanho("M", 8);
        camisa1.definirEstoquePorTamanho("G", 6);

        Produto camisa2 = new Produto("Camisa Azul", 59.99);
        camisa2.definirEstoquePorTamanho("PP", 3);
        camisa2.definirEstoquePorTamanho("P", 5);
        camisa2.definirEstoquePorTamanho("M", 7);
        camisa2.definirEstoquePorTamanho("G", 4);

        Produto camisa3 = new Produto("Camisa Verde", 39.99);
        camisa3.definirEstoquePorTamanho("PP", 2);
        camisa3.definirEstoquePorTamanho("P", 4);
        camisa3.definirEstoquePorTamanho("M", 6);
        camisa3.definirEstoquePorTamanho("G", 5);

        // Criar um ArrayList de produtos
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(camisa1);
        produtos.add(camisa2);
        produtos.add(camisa3);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Novo cliente chegou à loja!");
            System.out.println("Aqui estão os produtos disponíveis:");

            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                System.out.println((i + 1) + ". " + produto.getNome() + " - Preço: R$" + produto.getPreco());
                // Exibir o estoque de cada tamanho
                System.out.println("   Estoque por tamanho:");
                for (Map.Entry<String, Integer> entry : produto.getEstoquePorTamanho().entrySet()) {
                    System.out.println("   " + entry.getKey() + ": " + entry.getValue() + " unidades");
                }
            }

            Pedido pedido = new Pedido();

            while (true) {
                System.out.println("Digite o número do produto que deseja comprar (ou 0 para finalizar): ");
                int opcao = scanner.nextInt();

                if (opcao == 0) {
                    break;
                }

                if (opcao > 0 && opcao <= produtos.size()) {
                    Produto produtoEscolhido = produtos.get(opcao - 1);

                    // Perguntar o tamanho
                    System.out.println("Escolha o tamanho (PP, P, M, G): ");
                    String tamanho = scanner.next().toUpperCase();

                    // Verificar se o tamanho existe e tem estoque
                    if (produtoEscolhido.getEstoquePorTamanho(tamanho) > 0) {
                        System.out.println("Quantas unidades de " + produtoEscolhido.getNome() + " no tamanho " + tamanho + " deseja comprar?");
                        int quantidade = scanner.nextInt();

                        pedido.adicionarProduto(produtoEscolhido, tamanho, quantidade);
                    } else {
                        System.out.println("Tamanho inválido ou sem estoque.");
                    }
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }

            pedido.mostrarPedido();

            System.out.println("Novo cliente deseja fazer compras? (S/N): ");
            String resposta = scanner.next();

            if (!resposta.equalsIgnoreCase("S")) {
                System.out.println("Obrigado por usar a loja. Até a próxima!");
                break;
            }
        }

        scanner.close();
    }
}
