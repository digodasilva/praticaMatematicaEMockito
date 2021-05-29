package frete.model;

import java.util.ArrayList;

public class Carrinho {

	private Usuario usuario;
	private ArrayList<Produto> produtos;

	
	public Carrinho(Usuario usuario, ArrayList<Produto> produtos) {
		this.usuario = usuario;
		this.produtos = produtos;
	}
	
	
	public int getQuantidadeDeProdutos() {
		int quantidade = 0;
		for (Produto produto : produtos) {
			if (produto.getQuantidade() > 1) {
				quantidade += produto.getQuantidade() - 1;
			}
		}
		return getProdutos().size() + quantidade;
	}
	
	public Double getValorTotal() {
		Double total = 0d;
		for (Produto produto : produtos) {
			total+= produto.getValor() * produto.getQuantidade();
		}
		return total;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProduto(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
