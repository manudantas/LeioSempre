package Leiosempre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class LivroDAO {
	
	public ArrayList< Livro > livros = new ArrayList< Livro >();	
	
	public boolean cadastrarLivro(String titulo, String autor, boolean fisico, String path) throws IOException{
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
	
	public void montarLivros(String path) throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        int line = 0;  
        while((linha = buffRead.readLine())!= null) { 
        	String[] t = linha.split(" ");
            line++;   
            livros.add(new Livro(t[0], t[1], Boolean.getBoolean(t[2])));
        }	
	}
	
	public void salvar(String path) throws IOException{
        Writer out = new FileWriter(path);
        out.write("");
        out.flush();
		for(int i=0;i<livros.size();i++){
			Livro livro = livros.get(i);
			LerEsc.escritor(path, livro.toString());
		}
	}
	
	

}
