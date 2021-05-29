package frete.controller;

import frete.interfaces.Correios;
import frete.model.Carrinho;

public class CalculaFrete {
	
	private Correios correios;
	
	public CalculaFrete(Correios correios) {
		this.correios = correios;
	}
	
	public CalculaFrete() {
		super();
		this.correios = new CorreiosImplementado();
	}


	public Double calcularFrete(Carrinho carrinho) {
		Double total = carrinho.getValorTotal(); 
		if (total < 100d)
			return correios.calculaFrete(carrinho.getUsuario().getCEP()) + total;
		return total;
	}
	

	public Correios getCorreios() {
		return correios;
	}

	public void setCorreios(Correios correios) {
		this.correios = correios;
	}

}
