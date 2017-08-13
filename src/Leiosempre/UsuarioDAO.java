package Leiosempre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class UsuarioDAO {
	public String path = "C:/Users/Manu/Desktop/LeioSempre/usuarios.txt";
	
	public ArrayList< Usuario > usuarios = new ArrayList< Usuario >();
	
	public boolean cadastrarUsuario(String login, String senha, int pacote) throws IOException{
		for(int i=0;i<usuarios.size();i++){
			Usuario us = usuarios.get(i);
			if(us.getLogin().equals(login)){
				return false;
			}
		}
		Usuario usuario = new Usuario(login, senha, pacote);
		usuarios.add(usuario);
		return true;
	}
	
	public void montarUsuarios() throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        Usuario usuario = null;
        int line = 0;  
        while((linha = buffRead.readLine())!= null) { 
        	String[] t = linha.split(";");
        	usuario = new Usuario(t[0], t[1], Integer.parseInt(t[2]));
            usuarios.add(usuario);
            for(int i=3;i<t.length;i++){
            	Livro livro = pegarLivro(t[i]);
            	usuario.adicionarLivro(livro);
            }
            line++;   
        }	
	}
	
	public boolean mudarPacote(String usuario, int pacote){
		for(int i=0;i<usuarios.size();i++){
			Usuario usu = usuarios.get(i);
			if(usu.getLogin().equals(usuario)){
				usu.setPacote(pacote);
				return true;
			}
		}
		return false;
	}
	
	public boolean login(String login, String senha) throws IOException{
		//String string = login + " " + senha;
		for(int i=0;i<usuarios.size();i++){
			Usuario usuario = usuarios.get(i);
			if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
				return true;
			}
		}
		return false;
	}
	
	public void salvar() throws IOException{
        Writer out = new FileWriter(path);
        out.write("");
        out.flush();
		for(int i=0;i<usuarios.size();i++){
			Usuario usuario = usuarios.get(i);
			LerEsc.escritor(path, usuario.toString());
		}
	}
	
	public static Livro pegarLivro(String titulo){
		for(int i=0;i<LivroDAO.livros.size();i++){
			Livro liv = LivroDAO.livros.get(i);
			if(liv.getTitulo().equals(titulo)){
				return liv;
			}
		}
		return null;
	}

	public void adicionarLivroUs(String usuario,String titulo){
		for(int i=0;i<usuarios.size();i++){
			Usuario usu = usuarios.get(i);
			if(usu.getLogin().equals(usuario)){
				Livro livro = pegarLivro(titulo);
				if(LivroDAO.verificarLivro(livro.getTitulo()) == true){
					usu.adicionarLivro(livro);
				}else{
					System.out.println("O livro nao está no acervo !");
				}
				break;
			}
		}
	}
	
	public void removerLivroUs(String usuario, String titulo){
		for(int i=0;i<usuarios.size();i++){
			Usuario usu = usuarios.get(i);
			if(usu.getLogin().equals(usuario)){
				Livro livro = pegarLivro(titulo);
				usu.removerLivro(livro);
				break;
			}
		}
	}
	
	public String mostrarLivros(String login){
		String livros = "";
		for(int i=0;i<usuarios.size();i++){
			Usuario usuario = usuarios.get(i);
			if(usuario.getLogin().equals(login)){
				livros = usuario.livros() + "\n";
			}
		}
		return livros;
	}

}
