package Leiosempre;

public class Usuario {
	private String login;
	private String senha;
	private int pacote;
	
	public Usuario(String login, String senha, int pacote){
		setLogin(login);
		setSenha(senha);
		setPacote(pacote);
	}
	
	public int getPacote() {
		return pacote;
	}

	public void setPacote(int pacote) {
		if(pacote != 1 && pacote != 2 && pacote != 3){
			System.out.println("Esse pacote não existe");
		}else{
			this.pacote = pacote;
		}
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
	
	public String toString(){
		return getLogin() + " " + getSenha() + Integer.toString(getPacote());
	}

}
