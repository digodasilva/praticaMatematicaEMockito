package frete;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import frete.controller.GerenciaCarrinho;
import frete.model.Carrinho;
import frete.model.Produto;
import frete.model.Usuario;

public class GerenciaCarrinhoTeste {

	private GerenciaCarrinho gerenciaCarrinho = new GerenciaCarrinho();
	@SuppressWarnings("serial")
	private ArrayList<Produto> produtos = new ArrayList<Produto>() {
		{
			add(new Produto("Produto1", 10.5, 1));
			add(new Produto("Produto2", 4.5, 1));
		}
	};
	private Carrinho carrinho = new Carrinho(new Usuario("Eu da Silva", "79070-000"), produtos);

	@Test
	public void verificarInsercaoProduto() {
		Produto produto = new Produto("Produto3", 35.99d, 1);
		int qtdeProdutosPreInsercao = carrinho.getQuantidadeDeProdutos();
		gerenciaCarrinho.adicionarItem(carrinho, produto);
		Assert.assertEquals(qtdeProdutosPreInsercao+1, carrinho.getQuantidadeDeProdutos());
	}
	
	@Test
	public void verificarInsercaoDoisProdutos() {
		Produto produto = new Produto("Produto3", 35.99d, 2);
		int qtdeProdutosPreInsercao = carrinho.getQuantidadeDeProdutos();
		Assert.assertEquals(qtdeProdutosPreInsercao, carrinho.getQuantidadeDeProdutos());
		gerenciaCarrinho.adicionarItem(carrinho, produto);
		Assert.assertEquals(qtdeProdutosPreInsercao+2, carrinho.getQuantidadeDeProdutos());
	}
	
	@Test
	public void verificarInsercaoProdutoRepetidoPorQuantidade() {
		Produto produto = new Produto("Produto2", 4.5, 1);
		int qtdeProdutosPreInsercao = carrinho.getProdutos().size();
		Assert.assertEquals(qtdeProdutosPreInsercao, carrinho.getQuantidadeDeProdutos());
		gerenciaCarrinho.incrementarItem(carrinho, produto);
		Assert.assertEquals(qtdeProdutosPreInsercao+1, carrinho.getQuantidadeDeProdutos());
	}
	
	@Test
	public void verificarInsercaoDoisProdutosRepetidosPorQuantidade() {
		Produto produto = new Produto("Produto2", 4.5, 2);
		int qtdeProdutosPreInsercao = carrinho.getProdutos().size();
		Assert.assertEquals(qtdeProdutosPreInsercao, carrinho.getQuantidadeDeProdutos());
		gerenciaCarrinho.incrementarItem(carrinho, produto);
		Assert.assertEquals(qtdeProdutosPreInsercao+2, carrinho.getQuantidadeDeProdutos());
	}
	
	@Test
	public void verificarDeteccaoDeProdutoRepetidoPorBusca() {
		Produto produto = new Produto("Produto1", 10.5, 1);
		Assert.assertTrue(gerenciaCarrinho.verificarSeExisteProdutoNoCarrinho(carrinho, produto));
	}
	
	@Test
	public void verificarDeteccaoDeProdutoRepetidoPorBuscaFalse() {
		Produto produto = new Produto("Produto5", 10.5, 1);
		Assert.assertFalse(gerenciaCarrinho.verificarSeExisteProdutoNoCarrinho(carrinho, produto));
	}

	@Test
	public void verificarValorCarrinho() {
		Assert.assertEquals(Double.valueOf(15d), gerenciaCarrinho.calcularValor(produtos));
	}

	@Test
	public void verificarValorCarrinhoObjetoVazio() {
		produtos = new ArrayList<Produto>();
		Assert.assertEquals(Double.valueOf(0d), gerenciaCarrinho.calcularValor(produtos));

	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarValorCarrinhoProdutoComValorNulo() {
		produtos = new ArrayList<Produto>() {
			{
				add(new Produto("Produto1", 10.5, 1));
				add(new Produto("Produto2", null, 1));
			}
		};
		Assert.assertEquals(Double.valueOf(10.5d), gerenciaCarrinho.calcularValor(produtos));		
	}
	
	@Test
	public void verificarValorCarrinhoComProdutosRepetidos() {
		produtos.get(1).setQuantidade(2);
		Assert.assertEquals(Double.valueOf(19.5d), gerenciaCarrinho.calcularValor(produtos));
	}

	@Test
	public void verificarValorCarrinhoVazio() {
		Assert.assertEquals(true, gerenciaCarrinho.carrinhoEstaVazio(produtos));

		produtos = new ArrayList<Produto>();
		Assert.assertEquals(false, gerenciaCarrinho.carrinhoEstaVazio(produtos));

	}

	@SuppressWarnings("serial")
	@Test
	public void verificarValorCarrinhoComValorNulo() {
		produtos = new ArrayList<Produto>() {
			{
				add(new Produto("Produto1", 10.5, 1));
				add(new Produto("Produto2", null, 1));
			}
		};
		ArrayList<Produto> produtosRetorno = new ArrayList<Produto>() {
			{
				add(new Produto("Produto1", 10.5, 1));
			}
		};
		produtos = gerenciaCarrinho.verificarItensInvalidos(produtos);
		Assert.assertEquals(produtosRetorno.size(), produtos.size());
		Assert.assertEquals(produtosRetorno.get(0).getNome(), produtos.get(0).getNome());
		Assert.assertEquals(produtosRetorno.get(0).getValor(), produtos.get(0).getValor());
	}

	@SuppressWarnings("serial")
	@Test
	public void verificarValorCarrinhoComValorZero() {
		produtos = new ArrayList<Produto>() {
			{
				add(new Produto("Produto1", 10.5, 1));
				add(new Produto("Produto2", 0d, 1));
			}
		};
		ArrayList<Produto> produtosRetorno = new ArrayList<Produto>() {
			{
				add(new Produto("Produto1", 10.5, 1));
			}
		};
		produtos = gerenciaCarrinho.verificarItensInvalidos(produtos);
		Assert.assertEquals(produtosRetorno.size(), produtos.size());
		Assert.assertEquals(produtosRetorno.get(0).getNome(), produtos.get(0).getNome());
		Assert.assertEquals(produtosRetorno.get(0).getValor(), produtos.get(0).getValor());
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarAdicaoNaListaDeRemocao() {
		ArrayList<Produto> listaRemocao = new ArrayList<Produto>() {
			{
				add(new Produto("Produto1", 10.5, 1));
				add(new Produto("Produto2", 4.5, 1));
			}
		};
		produtos = new ArrayList<Produto>() {
			{
				add(new Produto("Produto1", 10.5, 1));
				add(new Produto("Produto2", 0d, 1));
			}
		};
		gerenciaCarrinho.adicionarNaListaRemocao(listaRemocao, produtos);
		Assert.assertEquals(3, listaRemocao.size());
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarChamadaAoMetodoSemAdicaoNaListaDeRemocao() {
		ArrayList<Produto> listaRemocao = new ArrayList<Produto>() {
			{
				add(new Produto("Produto1", 10.5, 1));
				add(new Produto("Produto2", 4.5, 1));
			}
		};
		produtos = new ArrayList<Produto>() {
			{
				add(new Produto("Produto1", 10.5, 1));
				add(new Produto("Produto2", 10d, 1));
			}
		};
		gerenciaCarrinho.adicionarNaListaRemocao(listaRemocao, produtos);
		Assert.assertEquals(2, listaRemocao.size());
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarRemocaoDeProdutoInvalido() {
		produtos = new ArrayList<Produto>() {
			{
				add(new Produto("Produto1", 0d, 1));
				add(new Produto("Produto2", 10.5, 1));
				add(new Produto("Produto3", 0d, 1));
			}
		};
		ArrayList<Produto> listaRemocao = new ArrayList<Produto>() {
			{
				add(produtos.get(0));
				add(produtos.get(2));
			}
		};
		gerenciaCarrinho.removerProdutoInvalido(listaRemocao, produtos);
		Assert.assertEquals(1, produtos.size());
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarRemocaoDeProdutoInvalidoComListaRemocaoVazia() {
		produtos = new ArrayList<Produto>() {
			{
				add(new Produto("Produto1", 10.5, 1));
				add(new Produto("Produto2", 10d, 1));
			}
		};
		ArrayList<Produto> listaRemocao = new ArrayList<Produto>();
		gerenciaCarrinho.removerProdutoInvalido(listaRemocao, produtos);
		Assert.assertEquals(2, produtos.size());
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarRemocaoDeProdutoInvalidoComListaRemocaoNaoCompativel() {
		produtos = new ArrayList<Produto>() {
			{
				add(new Produto("Produto1", 10.5, 1));
				add(new Produto("Produto2", 10d, 1));
			}
		};
		ArrayList<Produto> listaRemocao = new ArrayList<Produto>() {
			{
				add(new Produto("Produto1", 10.5, 1));
				add(new Produto("Produto2", 10d, 1));
				add(new Produto("Produto3", 50d, 1));
				add(new Produto("Produto4", 1d, 100));
			}
		};
		gerenciaCarrinho.removerProdutoInvalido(listaRemocao, produtos);
		Assert.assertEquals(2, produtos.size());
	}
	
	@Test
	public void verificarRemocaoDeProduto() {
		Produto produto = new Produto("Produto1", 10.5);
		int qtdeProdutosPreRemocao = carrinho.getQuantidadeDeProdutos();
		Assert.assertEquals(qtdeProdutosPreRemocao, carrinho.getQuantidadeDeProdutos());
		gerenciaCarrinho.removerItem(carrinho, produto);
		Assert.assertEquals(qtdeProdutosPreRemocao-1, carrinho.getQuantidadeDeProdutos());
	}
	
	@Test
	public void verificarRemocaoDeProdutoViaAnalisarRemocao() {
		Produto produto = new Produto("Produto1", 10.5);
		int qtdeProdutosPreRemocao = carrinho.getQuantidadeDeProdutos();
		Assert.assertEquals(qtdeProdutosPreRemocao, carrinho.getQuantidadeDeProdutos());
		gerenciaCarrinho.analisarRemocao(carrinho, produto);;
		Assert.assertEquals(qtdeProdutosPreRemocao-1, carrinho.getQuantidadeDeProdutos());
	}
	
	@Test
	public void verificarReducaoDeQuantidadeDoProduto() {
		produtos.add(new Produto("Produto3", 3.00, 2));
		Produto produto = new Produto("Produto3", 3.00);
		int qtdeProdutosPreRemocao = carrinho.getQuantidadeDeProdutos();
		Assert.assertEquals(qtdeProdutosPreRemocao, carrinho.getQuantidadeDeProdutos());
		gerenciaCarrinho.removerItem(carrinho, produto);
		Assert.assertEquals(qtdeProdutosPreRemocao-1, carrinho.getQuantidadeDeProdutos());
	}
	
	@Test
	public void verificarReducaoDeQuantidadeDoProdutoViaAnalisarRemocao() {
		produtos.add(new Produto("Produto3", 3.00, 2));
		Produto produto = new Produto("Produto3", 3.00);
		int qtdeProdutosPreRemocao = carrinho.getQuantidadeDeProdutos();
		Assert.assertEquals(qtdeProdutosPreRemocao, carrinho.getQuantidadeDeProdutos());
		gerenciaCarrinho.analisarRemocao(carrinho, produto);
		Assert.assertEquals(qtdeProdutosPreRemocao-1, carrinho.getQuantidadeDeProdutos());
	}
	
	@Test
	public void verificarRemocaoDeProdutoInexistente() {
		Produto produto = new Produto("Produto5", 50.0);
		int qtdeProdutosPreRemocao = carrinho.getQuantidadeDeProdutos();
		Assert.assertEquals(qtdeProdutosPreRemocao, carrinho.getQuantidadeDeProdutos());
		gerenciaCarrinho.removerItem(carrinho, produto);
		Assert.assertEquals(qtdeProdutosPreRemocao, carrinho.getQuantidadeDeProdutos());
	}
	
	@Test
	public void verificarRemoverTodos() {
		gerenciaCarrinho.removerTodosProdutos(carrinho);
		Assert.assertEquals(0, carrinho.getQuantidadeDeProdutos());
	}
	
	@Test
	public void verificarRemocaoDeTodosOsProdutosUmPorVez() {
		Produto produto = new Produto("Produto1", 10.5, 1);
		gerenciaCarrinho.removerItem(carrinho, produto);
		Assert.assertEquals(1, carrinho.getQuantidadeDeProdutos());
		produto = new Produto("Produto2", 4.5, 1);
		gerenciaCarrinho.removerItem(carrinho, produto);
		Assert.assertEquals(0, carrinho.getQuantidadeDeProdutos());
	}

}
