package trabalho_poo_loja;

import java.util.Objects;

public class Produto {
	private String nome;
	private double preco;
	private int estoque;

	public Produto(String nome, double preco, int estoque) {
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	// Método para reduzir o estoque ao realizar o pedido
	public boolean reduzirEstoque(int quantidade) {
		if (estoque >= quantidade) {
			estoque -= quantidade;
			return true;
		} else {
			System.out.println("Estoque insuficiente para o produto: " + nome);
			return false;
		}
	}

	@Override
	public String toString() {
		return nome + " - Preço: " + preco + " - Em estoque: " + estoque;
	}

	// Métodos hashCode e equals para comparar produtos
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Produto produto = (Produto) o;
		return Objects.equals(nome, produto.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
}

