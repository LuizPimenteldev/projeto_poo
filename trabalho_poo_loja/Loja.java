package trabalho_poo_loja;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja {

    public static void main(String[] args) {
        // Criar produtos
        Produto camisa1 = new Produto("Camisa Vermelha", 49.99, 10);
        Produto camisa2 = new Produto("Camisa Azul", 59.99, 5);
        Produto camisa3 = new Produto("Camisa Verde", 39.99, 8);

        // Criar um ArrayList de produtos
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(camisa1);
        produtos.add(camisa2);
        produtos.add(camisa3);

        Scanner scanner = new Scanner(System.in);

        // Loop para permitir que novos clientes façam pedidos
        while (true) {
            System.out.println("Novo otário chegou à Golpe Store!");
            // Exibir produtos disponíveis na loja com o estoque atualizado
            System.out.println("Aqui estão os produtos disponíveis:");
            for (int i = 0; i < produtos.size(); i++) {
                String precoFormatado = String.format("R$%.2f", produtos.get(i).getPreco());
                System.out.println((i + 1) + ". " + produtos.get(i).getNome() + " - Preço: " + precoFormatado + " - Em estoque: " + produtos.get(i).getEstoque());
            }

            // Criar um novo pedido para o cliente
            Pedido pedido = new Pedido();

            // Laço para permitir múltiplas adições ao pedido
            while (true) {
                System.out.println("Digite o número do produto que deseja comprar (ou 0 para finalizar): ");
                int opcao = scanner.nextInt();

                // Finalizar o pedido
                if (opcao == 0) {
                    break;
                }

                // Verificar se a opção é válida
                if (opcao > 0 && opcao <= produtos.size()) {
                    Produto produtoEscolhido = produtos.get(opcao - 1);
                    System.out.println("Quantas unidades de " + produtoEscolhido.getNome() + " deseja comprar?");
                    int quantidade = scanner.nextInt();

                    // Adicionar produto ao pedido
                    pedido.adicionarProduto(produtoEscolhido, quantidade);
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }

            // Exibir o resumo do pedido
            pedido.mostrarPedido();

            // Perguntar se um novo cliente vai realizar compras
            System.out.println("Novo otário deseja fazer compras? (S/N): ");
            String resposta = scanner.next();

            if (!resposta.equalsIgnoreCase("S")) {
                System.out.println("Obrigado por usar a Golpe Store. Até a próxima!");
                break;
            }
        }

        scanner.close();
    }
}


