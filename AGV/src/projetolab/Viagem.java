package projetolab;

import agencia.model.Pessoas;

public class Viagem {
	private String nome;
	private String local;
	private String duracao;
	private String preco;
	private String capacidadePessoas;
	Pessoas[] pessoas = new Pessoas[100];
    

	//Getters and setters
	public String getCapacidadePessoas() {
		return capacidadePessoas;
	}

	public void setCapacidadePessoas(String capacidadePessoas) {
		this.capacidadePessoas = capacidadePessoas;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
	
}
