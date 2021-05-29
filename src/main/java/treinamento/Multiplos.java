package treinamento;

public class Multiplos {
	

	public void iniciar(int n1, int n2, int n3, int mmcEntreN1EN2, int limite ) {
		Integer somaDosMultiplosDeN1OuDeN2 = somaDosMultiplosDeN1OuDeN2(n1, n2, mmcEntreN1EN2, limite);
		Integer somaDosMultiplosDeN1EDeN2 = somaDosMultiplosDeN1EDeN2(mmcEntreN1EN2, limite); 
		Integer somaDosMultiplosDeN1OuDeN2MaisSomaDosMultiplosDeN3 = somaDosMultiplosDeN1OuDeN2MaisSomaDosMultiplosDeN3(somaDosMultiplosDeN1OuDeN2, n3, limite);

		System.out.println("A soma dos múltiplos de n1 OU de n2 é: " + somaDosMultiplosDeN1OuDeN2);
		System.out.println("A soma dos múltiplos de n1 E de n2 é: " +  somaDosMultiplosDeN1EDeN2);
		System.out.println("A soma dos múltiplos de n1 OU de n2 mais a soma dos múltiplos de n3 é: " + somaDosMultiplosDeN1OuDeN2MaisSomaDosMultiplosDeN3);
	}

	public Integer somaDosMultiplosDeN1OuDeN2(int n1, int n2, int mmcEntreN1EN2, int limite) {
		return somar(n1,limite) + somar(n2,limite) - somar(mmcEntreN1EN2,limite);
	}

	public Integer somaDosMultiplosDeN1EDeN2(int mmcEntreN1EN2, int limite) {
		return somar(mmcEntreN1EN2,limite);
	}
	
	public Integer somaDosMultiplosDeN1OuDeN2MaisSomaDosMultiplosDeN3(Integer somaDosMultiplosDeN1OuDeN2, int n3, int limite) {
		return somaDosMultiplosDeN1OuDeN2 + somar(n3,limite);
	}

	public Integer somar(int multiplo, int limite) {
		int lm = limite/multiplo;
		return multiplo * (lm+1) * lm/2;
	}

	public Boolean eMultiploDe3Ou5(Long numero) {
		return numero%3 == 0 || numero%5==0 ? true : false;
	}
	
	public Boolean ePrimo(Long numero) {
		for (int i = 2; i <= numero; i++) {
			if ( ( (numero % i) == 0) && (i != numero) ) {
				return false;				
			}
		}
		return true;
	}
	
}
