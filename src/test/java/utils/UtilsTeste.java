package utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTeste {
	
	@SuppressWarnings("serial")
	@Test
	public void verificarSeparacaoDeCaracteresNumericos() {
		List<Character> algarismos = new ArrayList<Character>(){{add('4');add('9');}};
		Assert.assertEquals(algarismos, new Utils().separarCaracteres("49"));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarSeparacaoDeCaracteresNaoNumericos() {
		List<Character> palavra = new ArrayList<Character>(){{add('R');add('o');add('d');add('r');add('i');add('g');add('o');}};
		Assert.assertEquals(palavra, new Utils().separarCaracteres("Rodrigo"));
	}
	
	@SuppressWarnings("serial")
	@Test
	public void verificarSeparacaoDeCaracteresEspeciais() {
		List<Character> string = new ArrayList<Character>(){{add('A');add('-');add('b');add('!');add('C');add('@');add('d');add('#');}};
		Assert.assertEquals(string, new Utils().separarCaracteres("A-b!C@d#"));
	}
}
