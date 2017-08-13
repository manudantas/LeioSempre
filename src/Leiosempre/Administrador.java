package Leiosempre;

public class Administrador {
	private String login;
	private String senha;
	private String nome;
	
	public Administrador(String login, String senha, String nome){
		setLogin(login);
		setSenha(senha);
		setNome(nome);
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString(){
		return getLogin() +";"+ getSenha()+";" + getNome();
	}

}
