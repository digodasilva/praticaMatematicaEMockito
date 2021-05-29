package frete.controller;

import java.util.ArrayList;
import java.util.Objects;

import frete.model.Carrinho;
import frete.model.Produto;

public class GerenciaCarrinho {

	int i = 0;

	public void adicionarItem(Carrinho carrinho, Produto produto) {
		if (verificarSeExisteProdutoNoCarrinho(carrinho, produto))
			incrementarItem(carrinho, produto);
		else
			carrinho.getProdutos().add(produto);
		calcularValor(carrinho.getProdutos());
	}

	public void incrementarItem(Carrinho carrinho, Produto produto) {
		System.out.println("Um segundo item de um mesmo produto será adicionado ao seu carrinho");
		carrinho.getProdutos().get(i)
				.setQuantidade(carrinho.getProdutos().get(i).getQuantidade() + produto.getQuantidade());
		i = 0;
	}

	public Boolean verificarSeExisteProdutoNoCarrinho(Carrinho carrinho, Produto produto) {
		for (i = 0; i < carrinho.getProdutos().size(); i++) {
			if (carrinho.getProdutos().get(i).getNome().equals(produto.getNome())
					&& carrinho.getProdutos().get(i).getValor().equals(produto.getValor()))
				return true;
		}
		return false;
	}

	public final Double calcularValor(ArrayList<Produto> produtos) {
		Double soma = 0d;
		if (carrinhoEstaVazio(produtos)) {
			produtos = verificarItensInvalidos(produtos);
			for (Produto produto : produtos) {
				soma += produto.getValor() * produto.getQuantidade();
			}
		}
		return soma;
	}

	public boolean carrinhoEstaVazio(ArrayList<Produto> produtos) {
		return produtos.isEmpty() ? false : true;
	}

	public ArrayList<Produto> verificarItensInvalidos(ArrayList<Produto> produtos) {
		ArrayList<Produto> listaRemocao = new ArrayList<Produto>();
		adicionarNaListaRemocao(listaRemocao, produtos);
		removerProdutoInvalido(listaRemocao, produtos);
		return produtos;
	}

	public void adicionarNaListaRemocao(ArrayList<Produto> listaRemocao, ArrayList<Produto> produtos) {
		for (Produto produto : produtos) {
			if (Objects.isNull(produto.getValor()) || produto.getValor().equals(0d)) {
				listaRemocao.add(produto);
			}
		}
	}
	
	public void removerProdutoInvalido(ArrayList<Produto> listaRemocao, ArrayList<Produto> produtos) {
		for (Produto produtoInvalido : listaRemocao) {
			System.out.println(produtoInvalido.getValor().equals(0d) ?
				"O item " + produtoInvalido.getNome() + " tem valor inválido e será removido da lista." :
				"O item " + produtoInvalido.getNome() + " é válido e não foi removido.");
			produtos.remove(produtoInvalido);
		}
	}

	public void removerItem(Carrinho carrinho, Produto produto) {
		if (verificarSeExisteProdutoNoCarrinho(carrinho, produto))
			analisarRemocao(carrinho, produto);
		else
			System.out.println("Produto para exclusão não foi encontrado no carrinho.");
		calcularValor(carrinho.getProdutos());
	}

	public void analisarRemocao(Carrinho carrinho, Produto produto) {
		if (carrinho.getProdutos().get(i).getQuantidade() > 1)
			carrinho.getProdutos().get(i).setQuantidade(carrinho.getProdutos().get(i).getQuantidade() - 1);
		else
			carrinho.getProdutos().remove(i);
		i = 0;
	}

	public void removerTodosProdutos(Carrinho carrinho) {
		carrinho.getProdutos().clear();
	}

}
