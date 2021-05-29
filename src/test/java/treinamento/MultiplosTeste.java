package treinamento;

import org.junit.Assert;
import org.junit.Test;

public class MultiplosTeste {
	
	Multiplos multiplos = new Multiplos();
	
	@Test
	public void verificarSomaDosMultiplosDe3() {
		Integer somaCorreta = 166833;
		Assert.assertEquals(somaCorreta, multiplos.somar(3, 999));
	}
	
	@Test
	public void verificarSomaDosMultiplosDe5() {
		Integer somaCorreta = 99500;
		Assert.assertEquals(somaCorreta, multiplos.somar(5, 999));
	}
	
	@Test
	public void verificarSomaMultiplosDe15() {
		Integer somaCorreta = 33165;
		Assert.assertEquals(somaCorreta, multiplos.somar(15, 999));
	}
	
	@Test
	public void verificarSomaMultiplosDe3OuDe5() {
		Integer somaCorreta = 233168;
		Assert.assertEquals(somaCorreta, multiplos.somaDosMultiplosDeN1OuDeN2(3, 5, 15, 999));
	}
	
	@Test
	public void verificarSomaMultiplosDe3EDe5() {
		Integer somaCorreta = 33165;
		Assert.assertEquals(somaCorreta, multiplos.somaDosMultiplosDeN1EDeN2(15, 999));
	}
	
	@Test
	public void verificarENumeroPrimoPequeno() {
		Assert.assertEquals(true, multiplos.ePrimo(Long.valueOf(7)));
	}
	
	@Test
	public void verificarENumeroPrimoGrande() {
		Assert.assertEquals(true, multiplos.ePrimo(Long.valueOf(997)));
	}
	
	@Test
	public void verificarNaoENumeroPrimoPequeno() {
		Assert.assertEquals(false, multiplos.ePrimo(Long.valueOf(4)));
	}

	@Test
	public void verificarNaoENumeroPrimoGrande() {
		Assert.assertEquals(false, multiplos.ePrimo(Long.valueOf(995)));
	}
	
	@Test
	public void verificarSomaDosMultiplosDe3Ou5MaisSomaDosMultiplosDe7() {
		Integer somaCorreta = 304239;
		Assert.assertEquals(somaCorreta, multiplos.somaDosMultiplosDeN1OuDeN2MaisSomaDosMultiplosDeN3 (233168, 7, 999));
	}
	
	@Test
	public void verificarMultiploDe3Ou5() {
		Assert.assertEquals(true, multiplos.eMultiploDe3Ou5(Long.valueOf(3)));
	}
	
	@Test
	public void verificarMultiploDe3Ou5ComMMC() {
		Assert.assertEquals(true, multiplos.eMultiploDe3Ou5(Long.valueOf(15)));
	}
	
	@Test
	public void verificarNaoEMultiploDe3Ou5() {
		Assert.assertEquals(false, multiplos.eMultiploDe3Ou5(Long.valueOf(1)));
	}

}
