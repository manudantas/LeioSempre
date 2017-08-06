package Leiosempre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class UsuarioDAO {
	public ArrayList< Usuario > usuarios = new ArrayList< Usuario >();
	
	public boolean cadastrarUsuario(String login, String senha, int pacote, String path) throws IOException{
		Usuario usuario = new Usuario(login, senha, pacote);
		for(int i=0;i<usuarios.size();i++){
			Usuario us = usuarios.get(i);
			if(us.getLogin().equals(login)){
				return false;
			}
		}
		usuarios.add(usuario);
		return true;
	}
	
	public void montarUsuarios(String path) throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        int line = 0;  
        while((linha = buffRead.readLine())!= null) { 
        	String[] t = linha.split(" ");
            usuarios.add(new Usuario(t[0], t[1], Integer.parseInt(t[2])));
            line++;   
        }	
	}
	
	public boolean login(String login, String senha, String path) throws IOException{
		String string = login + " " + senha;
		for(int i=0;i<usuarios.size();i++){
			Usuario usuario = usuarios.get(i);
			if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
				return true;
			}
		}
		return false;
	}
	
	public void salvar(String path) throws IOException{
        Writer out = new FileWriter(path);
        out.write("");
        out.flush();
		for(int i=0;i<usuarios.size();i++){
			Usuario usuario = usuarios.get(i);
			LerEsc.escritor(path, usuario.toString());
		}
	}
}
