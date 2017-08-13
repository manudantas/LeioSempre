package Leiosempre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class AdministradorDAO extends LivroDAO{
	public String path = "C:/Users/Manu/Desktop/LeioSempre/administrador.txt";
	
	public ArrayList< Administrador > adms = new ArrayList< Administrador >();
	
	public boolean cadastrarAdm(String login, String senha, String nome){
		for(int i=0; i<adms.size();i++){
			Administrador ad = adms.get(i);
			if(ad.getLogin().equals(login)){
				return false;
			}
		}
		Administrador adm = new Administrador(login, senha, nome);
		adms.add(adm);
		return true;
	}
	
	public void montarAdmin() throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        int line = 0;  
        while((linha = buffRead.readLine())!= null) { 
        	String[] t = linha.split(";");
            adms.add(new Administrador(t[0], t[1], t[2]));
            line++;   
        }	
	}
	
	public boolean login(String login, String senha) throws IOException{
		String string = login + " " + senha;
		for(int i=0;i<adms.size();i++){
			Administrador adm = adms.get(i);
			if(adm.getLogin().equals(login) && adm.getSenha().equals(senha)){
				return true;
			}
		}
		return false;
	}
	
	public void salvar() throws IOException{
        Writer out = new FileWriter(path);
        out.write("");
        out.flush();
		for(int i=0;i<adms.size();i++){
			Administrador adm = adms.get(i);
			LerEsc.escritor(path, adm.toString());
		}
	}
	
	public boolean admCadastrarLivro(String titulo, String autor, boolean fisico) throws IOException{
		if(cadastrarLivro(titulo, autor, fisico) == true){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean admExcluirLivro(String titulo) throws IOException{
		if(excluirLivro(titulo) == true){
			return true;
		}else{
			return false;
		}
	}
	
	
	

}
