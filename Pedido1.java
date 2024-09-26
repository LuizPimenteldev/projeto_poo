package trabalho_poo_loja;

import java.util.ArrayList;

public class Pedido1 {
    private ArrayList<Produto> itens;  // Usando ArrayList para gerenciar os itens do pedido
    private double total;

    public Pedido1() {
        this.itens = new ArrayList<>();
        this.total = 0;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (produto.reduzirEstoque(quantidade)) {
            itens.add(produto);
            total += produto.getPreco() * quantidade;
        }
    }

    public void mostrarPedido() {
        System.out.println("Itens do Pedido:");
        for (Produto p : itens) {
            System.out.println(p);
        }
        System.out.println("Total: " + total);
    }
}
