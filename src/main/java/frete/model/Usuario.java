package frete.model;

public class Usuario {

	private String nome;
	private String CEP;
	
	
	public Usuario(String nome, String CEP) {
		this.nome = nome;
		this.CEP = CEP;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String CEP) {
		this.CEP = CEP;
	}
	
}
