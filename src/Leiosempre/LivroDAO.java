package Leiosempre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class LivroDAO {
	public String path = "C:/Users/Manu/Desktop/LeioSempre/livros.txt";
	
	public static ArrayList< Livro > livros = new ArrayList< Livro >();	
	
	public boolean cadastrarLivro(String titulo, String autor, boolean fisico) throws IOException{
		Livro livro = new Livro(titulo,autor,fisico);
		for(int i=0;i<livros.size();i++){
			Livro liv = livros.get(i);
			if(livro == liv){
				return false;
			}
		}
		livros.add(livro);
		return true;
	}
	
	public boolean excluirLivro(String titulo) throws IOException{
		Livro liv = UsuarioDAO.pegarLivro(titulo);
		for(int i=0;i<livros.size();i++){
			Livro livro = livros.get(i);
			if(livro == liv){
				livros.remove(livro);
				return true;
			}
		}
		return false;
	}
	
	public void montarLivros() throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        int line = 0;  
        while((linha = buffRead.readLine())!= null) { 
        	String[] t = linha.split(";");
            line++;   
            livros.add(new Livro(t[0], t[1], Boolean.getBoolean(t[2])));
        }	
	}
	
	public void salvar() throws IOException{
        Writer out = new FileWriter(path);
        out.write("");
        out.flush();
		for(int i=0;i<livros.size();i++){
			Livro livro = livros.get(i);
			LerEsc.escritor(path, livro.toString());
		}
	}
	
	public static boolean verificarLivro(String titulo){
		for(int i=0;i<livros.size();i++){
			Livro liv = livros.get(i);
			if(liv.getTitulo().equals(titulo)){
				return true;
			}
		}
		return false;
	}	
	
	public String mostrarLivros(){
		String string = "";
		for(int i=0;i<livros.size();i++){
			Livro liv = livros.get(i);
			string += liv.getTitulo() + "\n";
		}
		return string;
	}

}
