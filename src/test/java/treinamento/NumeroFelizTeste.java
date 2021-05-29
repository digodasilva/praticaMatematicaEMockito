package treinamento;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class NumeroFelizTeste {
	
	@Test
	public void verificarZerosAEsquerda() {
		Assert.assertEquals("49", new NumeroFeliz().removerZerosAEsquerda("049"));
	}
	
	@Test
	public void verificarZerosAEsquerdaSemZero() {
		Assert.assertEquals("49", new NumeroFeliz().removerZerosAEsquerda("49"));
	}
	
	@Test
	public void verificarValidacaoDosAlgarismosComLetra() {
		Assert.assertEquals(false, new NumeroFeliz().validarNumero("4a"));
	}
	
	@Test
	public void verificarValidacaoDosAlgarismosNuemroGrande() {
		Assert.assertEquals(true, new NumeroFeliz().validarNumero("4946546546465"));
	}
	
	@Test
	public void verificarValidacaoDosAlgarismosNumeroDeUmAlgarismo() {
		Assert.assertEquals(true, new NumeroFeliz().validarNumero("5"));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarNumeroFelizTrueComNumeroGrande() {
		Assert.assertEquals(true, new NumeroFeliz().eNumeroFeliz(new ArrayList<Character>(){{add('9');add('9');add('0');add('0');add('8');}}));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarNumeroFelizTrueComNumeroPequeno() {
		Assert.assertEquals(true, new NumeroFeliz().eNumeroFeliz(new ArrayList<Character>(){{add('7');}}));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarNumeroFelizFalseComNumeroGrande() {
		Assert.assertEquals(false, new NumeroFeliz().eNumeroFeliz(new ArrayList<Character>(){{add('9');add('9');add('9');add('9');add('9');}}));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarNumeroFelizFalseComNumeroPequeno() {
		Assert.assertEquals(false, new NumeroFeliz().eNumeroFeliz(new ArrayList<Character>(){{add('2');}}));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarCalculoDoProximoNumeroSucesso() {
		Assert.assertEquals(Integer.valueOf(130), new NumeroFeliz().calcularNovoNumero(new ArrayList<Character>(){{add('9');add('7');}}));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarCalculoDoProximoNumeroFalha() {
		Assert.assertNotEquals(Integer.valueOf(49), new NumeroFeliz().calcularNovoNumero(new ArrayList<Character>(){{add('9');add('7');}}));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarRecursaoTrue() {
		Assert.assertEquals(new ArrayList<Character>(){{add('4');add('9');}}, new NumeroFeliz().providenciarRecursao(Integer.valueOf(49)));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarRecursaoFalse() {
		Assert.assertNotEquals(new ArrayList<Character>(){{add('7');}}, new NumeroFeliz().providenciarRecursao(Integer.valueOf(49)));
	}
	
}
