package treinamento;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import utils.Utils;

public class PalavrasEmNumeros {

	public void iniciar(String palavra) {
		Utils utils = new Utils();
		palavra = removerCaracteres(palavra);
		ArrayList<Character> lista = utils.separarCaracteres(palavra);
		Long valorPalavra = converterPalavraEmNumero(lista);
		System.out.println("O valor da palavra " + palavra + " é " + valorPalavra + ".");
		lista = utils.separarCaracteres(valorPalavra.toString());
		Multiplos multiplos = new Multiplos();
		String mensagem = multiplos.ePrimo(valorPalavra) ? "É número primo." : "Não é número primo.";
		System.out.println("\t" + mensagem);
		mensagem = new NumeroFeliz().eNumeroFeliz(lista) ? "É número feliz." : "Não é número feliz.";
		System.out.println("\t" + mensagem);
		mensagem = multiplos.eMultiploDe3Ou5(valorPalavra) ? "É número múltiplo de 3 e/ou 5."
				: "Não é número múltiplo de 3 ou 5.";
		System.out.println("\t" + mensagem);
	}

	public String removerCaracteres(String palavra) {
		palavra = palavra.replaceAll("[^a-zA-Z]", "");
		return palavra;
	}

	public Long converterPalavraEmNumero(List<Character> lista) {
		Long soma = 0L;
		for (Character character : lista) {
			BigInteger bigInt = new BigInteger(1, character.toString().getBytes());
			bigInt = bigInt.compareTo(new BigInteger("90")) > 0 ? bigInt.subtract(new BigInteger("96"))
					: bigInt.subtract(new BigInteger("38"));
			soma += Long.parseLong(bigInt.toString());
		}
		return soma;
	}

}
