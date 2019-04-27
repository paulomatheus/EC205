package agencia.model;

public class Funcionario extends Pessoas{
	private String cargo;
	private String setor;
	private String senha;
	private String login;
	
	//Getters and setters	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {	
		this.login = login;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
