package Leiosempre;

import java.util.ArrayList;

public class Usuario {
	private String login;
	private String senha;
	private int pacote;
	
	public ArrayList< Livro > livros = new ArrayList< Livro >();		
	
	public Usuario(String login, String senha, int pacote){
		setLogin(login);
		setSenha(senha);
		setPacote(pacote);
	}
	
	public int getPacote() {
		return pacote;
	}

	public void setPacote(int pacote) {
		if(pacote != 3 && pacote != 5 && pacote != 10){
			System.out.println("Esse pacote não existe");
		}else{
			this.pacote = pacote;
		}
	}	
	
	public void adicionarLivro(Livro livro){
		if(livros.size() == pacote){
			System.out.println("Seu pacote está cheio !");
		}else{
			String titulo = livro.getTitulo();
			if(LivroDAO.verificarLivro(titulo) == true){
				livros.add(livro);
			}
		}
	}
	
	public void removerLivro(Livro livro){
		String titulo = livro.getTitulo();
		for(int i=0;i<livros.size();i++){
			Livro liv = livros.get(i);
			if(liv.getTitulo().equals(titulo)){
				livros.remove(livro);
			}else{
				System.out.println("Esse livro não está no seu pacote !");
			}
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
	
	public String livros(){
		String result = "";
		for(int i=0;i<livros.size();i++){
			Livro livro = livros.get(i);
			result += livro.getTitulo()+ " ";
		}
		return result;
	}
	
	public String toString(){
		return getLogin() + ";" + getSenha() +";"+ Integer.toString(getPacote())+ ";" + livros();
	}

}
