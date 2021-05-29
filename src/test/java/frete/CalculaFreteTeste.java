package frete;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import frete.controller.CalculaFrete;
import frete.model.Carrinho;
import frete.model.Produto;
import frete.model.Usuario;

public class CalculaFreteTeste {

	private CalculaFrete calculafrete= new CalculaFrete();
	@SuppressWarnings("serial")
	private ArrayList<Produto> produtos = new ArrayList<Produto>() {
		{
			add(new Produto("Produto1", 10.5, 1));
			add(new Produto("Produto2", 4.5, 1));
		}
	};
	private Carrinho carrinho = new Carrinho(new Usuario("Eu da Silva", "79070-000"), produtos);
	
	@Test
	public void verificarCalculoFreteMenorQue100() {
		Assert.assertEquals(Double.valueOf(65d), calculafrete.calcularFrete(carrinho));
	}
	
	@Test
	public void verificarCalculoFreteMaiorQue100() {
		carrinho.getProdutos().add(new Produto("Produto3", 90.0, 1));
		Assert.assertEquals(Double.valueOf(105d), calculafrete.calcularFrete(carrinho));
	}
	
//	@Test
//	public void verificarCalculoFreteMaiorQue100ComProdutoRepetido() {
//		carrinho.getProdutos().add(new Produto("Produto3", 50.0, 2));
//		Assert.assertEquals(Double.valueOf(115d), calculafrete.calcularFrete(carrinho));
//	}
	
	@Test
	public void verificarCalculoFreteIgualA100() {
		carrinho.getProdutos().add(new Produto("Produto3", 85.0, 1));
		Assert.assertEquals(Double.valueOf(100d), calculafrete.calcularFrete(carrinho));
	}
}
