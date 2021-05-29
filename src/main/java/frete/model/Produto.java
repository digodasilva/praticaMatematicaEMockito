package frete.model;

import java.util.Objects;

public class Produto {

	private String nome;
	private Double valor;
	private int quantidade = 0;
	
	
	public Produto() {
		super();
	}

	public Produto(String nome, Double valor, int quantidade) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade; 
	}
	
	public Produto(String nome, Double valor) {
		this.nome = nome;
		this.valor = valor; 
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		if (Objects.isNull(valor))
			valor = 0d;
		this.valor = valor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", quantidade=" + quantidade + ", valor=" + valor + "]";
	}

}
