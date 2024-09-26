package trabalho_poo_loja;

import java.util.ArrayList;

public class Pedido {
    // Classe auxiliar para armazenar produto e quantidade de estoque inicial
    private class ItemPedido {
        Produto produto;
        int estoqueInicial;

        ItemPedido(Produto produto, int estoqueInicial) {
            this.produto = produto;
            this.estoqueInicial = estoqueInicial;
        }
    }

    private ArrayList<ItemPedido> itens;  // Usando ArrayList para gerenciar os itens do pedido
    private double total;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.total = 0;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (produto.getEstoque() >= quantidade) {
            // Armazenar o estoque antes de reduzir
            int estoqueInicial = produto.getEstoque();
            // Reduzir o estoque
            produto.reduzirEstoque(quantidade);
            // Adicionar ao pedido
            itens.add(new ItemPedido(produto, estoqueInicial));
            total += produto.getPreco() * quantidade;
        } else {
            System.out.println("Estoque insuficiente para o produto: " + produto.getNome());
        }
    }

    public void mostrarPedido() {
        System.out.println("Itens do Pedido:");
        for (ItemPedido item : itens) {
            // Formatar o preço com "R$" e duas casas decimais
            String precoFormatado = String.format("R$%.2f", item.produto.getPreco());
            // Mostrar o estoque original antes da redução
            System.out.println(item.produto.getNome() + " - Preço: " + precoFormatado + " - Em estoque (inicial): " + item.estoqueInicial);
        }

        // Formatar o total com "R$" e duas casas decimais
        String totalFormatado = String.format("R$%.2f", total);
        System.out.println("Total: " + totalFormatado);
    }
}
