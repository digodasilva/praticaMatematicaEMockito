package treinamento;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

public class NumeroFeliz {

	public String numero = "";
	public List<String> numerosPassados = new ArrayList<String>();
	public Utils utils = new Utils();
	
	public void iniciar(String numero) {
		this.numero = numero;
		numero = removerZerosAEsquerda(numero);
		if (validarNumero(numero)) { } else
			System.out.println("Digite apenas números.");
	}
	
	public String removerZerosAEsquerda(String numero) {
		return numero.replaceAll("^0*", "");
	}

	public boolean validarNumero(String numero) {
		return numero.matches("^\\d+$");
	}

	public Boolean eNumeroFeliz(ArrayList<Character> lista) {
		Integer novoNumero = 0;
		novoNumero = calcularNovoNumero(lista);
		if (Integer.valueOf(1).equals(novoNumero))
			return true;
		if (numerosPassados.contains(novoNumero.toString()))
			return false;
		return eNumeroFeliz(providenciarRecursao(novoNumero));
	}

	public Integer calcularNovoNumero(ArrayList<Character> lista) {
		int resultado = 0;
		for (Character c : lista) {
			int digito = Integer.parseInt(c.toString());
			resultado  += (int) Math.pow(digito,2);
		}
		return resultado;
	}
	
	public ArrayList<Character> providenciarRecursao(Integer novoNumero) {
		numerosPassados.add(novoNumero.toString());
		return utils.separarCaracteres(novoNumero.toString());
	}

}
