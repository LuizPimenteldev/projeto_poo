package poo_atualizado;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

// classe
public class Produto {
    private String nome;    //atributos 
    private double preco;
    private Map<String, Integer> estoquePorTamanho; // Armazena o estoque por tamanho (PP, P, M, G)
    
    // construtor, inicializador do objeto
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        
        // Usando LinkedHashMap para manter a ordem de inserção
        this.estoquePorTamanho = new LinkedHashMap<>(); 
    }

    // Método para definir o estoque de cada tamanho
    public void definirEstoquePorTamanho(String tamanho, int estoque) {
        estoquePorTamanho.put(tamanho, estoque);
    }

    // Método para obter o estoque de um tamanho específico
    public int getEstoquePorTamanho(String tamanho) {
        return estoquePorTamanho.getOrDefault(tamanho, 0); // Retorna 0 se o tamanho não existir
    }

    // Método para reduzir o estoque de um tamanho específico
    public boolean reduzirEstoque(String tamanho, int quantidade) {
        int estoqueAtual = getEstoquePorTamanho(tamanho);
        if (estoqueAtual >= quantidade) {
            estoquePorTamanho.put(tamanho, estoqueAtual - quantidade);
            return true;
        } else {
            System.out.println("Estoque insuficiente para o tamanho " + tamanho + " do produto: " + nome);
            return false;
        }
    }
    //método get
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + " - Preço: R$" + preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    // Adicione esse método na classe Produto
    public Map<String, Integer> getEstoquePorTamanho() {
        return estoquePorTamanho;
    }
}
