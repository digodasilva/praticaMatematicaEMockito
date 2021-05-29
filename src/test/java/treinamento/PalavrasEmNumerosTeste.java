package treinamento;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class PalavrasEmNumerosTeste {

	@Test
	public void verificarRemocaoDeCaracteresEmStringInvalida() {
		Assert.assertEquals("abcde", new PalavrasEmNumeros().removerCaracteres("a-b.c_d@e"));
	}
	
	@Test
	public void verificarRemocaoDeCaracteresEmStringValida() {
		Assert.assertEquals("AbCdE", new PalavrasEmNumeros().removerCaracteres("AbCdE"));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarConversaoDeUmaLetraMinuscula() {
		Assert.assertEquals(Long.valueOf(1), new PalavrasEmNumeros().converterPalavraEmNumero(new ArrayList<Character>(){{add('a');}}));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarConversaoDeUmaLetraMaiuscula() {
		Assert.assertEquals(Long.valueOf(27), new PalavrasEmNumeros().converterPalavraEmNumero(new ArrayList<Character>(){{add('A');}}));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarConversaoDeLetrasMinusculas() {
		Assert.assertEquals(Long.valueOf(15), new PalavrasEmNumeros().converterPalavraEmNumero(new ArrayList<Character>(){{add('a');add('b');add('c');add('d');add('e');}}));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarConversaoDeLetrasMaiusculas() {
		Assert.assertEquals(Long.valueOf(103), new PalavrasEmNumeros().converterPalavraEmNumero(new ArrayList<Character>(){{add('C');add('P');add('F');}}));
	}
	
	
	@SuppressWarnings("serial")
	@Test
	public void verificarConversaoDeLetrasEmPalavraComLetrasMaiusculasEMinusculasTeste1de3() {
		Assert.assertEquals(Long.valueOf(28), new PalavrasEmNumeros().converterPalavraEmNumero(new ArrayList<Character>(){{add('a');add('A');}}));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarConversaoDeLetrasEmPalavraComLetrasMaiusculasEMinusculasTeste2de3() {
		Assert.assertEquals(Long.valueOf(53), new PalavrasEmNumeros().converterPalavraEmNumero(new ArrayList<Character>(){{add('V');add('a');add('c');add('a');}}));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarConversaoDeLetrasEmPalavraComLetrasMaiusculasEMinusculasTeste3de3() {
		Assert.assertEquals(Long.valueOf(112), new PalavrasEmNumeros().converterPalavraEmNumero(new ArrayList<Character>(){{add('R');add('o');add('d');add('r');add('i');add('g');add('o');}}));
	}
	
	
	
}
