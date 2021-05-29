package frete;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import frete.controller.CalculaFrete;
import frete.interfaces.Correios;
import frete.model.Carrinho;
import frete.model.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class CalculaFreteTesteMock {

	private CalculaFrete calculafrete;

	@Mock
	private Carrinho carrinho;
	@Mock
	private Correios correios;
	
	@Before
	public void iniciaFrete() {
		calculafrete = new CalculaFrete(correios);
	}
	
	@Test
	public void verificarCalculoFreteMenorQue100() {
		Mockito.when(correios.calculaFrete("79070-000")).thenReturn(50d);
		Mockito.when(carrinho.getUsuario()).thenReturn(new Usuario("Eu da Silva", "79070-000"));
		Mockito.when(carrinho.getValorTotal()).thenReturn(15d);
		Assert.assertEquals(Double.valueOf(65d), calculafrete.calcularFrete(carrinho));
	}
	
	@Test
	public void verificarCalculoFreteMaiorQue100() {
		Mockito.when(carrinho.getValorTotal()).thenReturn(105d);
		Assert.assertEquals(Double.valueOf(105d), calculafrete.calcularFrete(carrinho));
	}
	
	@Test
	public void verificarCalculoFreteIgualA100() {
		Mockito.when(carrinho.getValorTotal()).thenReturn(100d);
		Assert.assertEquals(Double.valueOf(100d), calculafrete.calcularFrete(carrinho));
	}
	
}

















