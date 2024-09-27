package trabalho_poo_loja;

import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    // Classe auxiliar para armazenar produto, tamanho e quantidade inicial
    private class ItemPedido {
        Produto produto;
        String tamanho;
        int estoqueInicial;

        ItemPedido(Produto produto, String tamanho, int estoqueInicial) {
            this.produto = produto;
            this.tamanho = tamanho;
            this.estoqueInicial = estoqueInicial;
        }
    }

    private ArrayList<ItemPedido> itens;  // Usando ArrayList para gerenciar os itens do pedido
    private double total;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.total = 0;
    }

    public void adicionarProduto(Produto produto, String tamanho, int quantidade) {
        if (produto.getEstoquePorTamanho(tamanho) >= quantidade) {
            int estoqueInicial = produto.getEstoquePorTamanho(tamanho);
            produto.reduzirEstoque(tamanho, quantidade);
            itens.add(new ItemPedido(produto, tamanho, estoqueInicial));
            total += produto.getPreco() * quantidade;
        } else {
            System.out.println("Estoque insuficiente para o tamanho " + tamanho + " do produto: " + produto.getNome());
        }
    }

    public void mostrarPedido() {
        System.out.println("Itens do Pedido:");
        for (ItemPedido item : itens) {
            String precoFormatado = String.format("R$%.2f", item.produto.getPreco());
            System.out.println(item.produto.getNome() + " - Tamanho: " + item.tamanho + " - Preço: " + precoFormatado + " - Em estoque (inicial): " + item.estoqueInicial);
        }

        String totalFormatado = String.format("R$%.2f", total);
        System.out.println("Total: " + totalFormatado);
    }
}
