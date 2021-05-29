package frete.controller;

import frete.interfaces.Correios;

public class CorreiosImplementado implements Correios {

	public Double calculaFrete(String CEP) {
		if (CEP.equals("79070-000"))
			return 50d;
		return 0d;
	}

}
