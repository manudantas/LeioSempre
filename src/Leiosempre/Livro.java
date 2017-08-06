package Leiosempre;

public class Livro {
	private String titulo;
	private String autor;
	private boolean fisico;
	
	public Livro(String titulo, String autor, boolean fisico){
		setTitulo(titulo);
		setAutor(autor);
		setFisico(fisico);
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public boolean isFisico() {
		return fisico;
	}
	public void setFisico(boolean fisico) {
		this.fisico = fisico;
	}
	
	public String toString(){
		return getTitulo() + " " + getAutor() + " " + Boolean.toString(isFisico());
	}
	


}
