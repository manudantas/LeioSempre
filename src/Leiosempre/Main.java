package Leiosempre;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
        UsuarioDAO dao = new UsuarioDAO();
		String path = "C:/Users/Manu/Desktop/LeioSempre/usuarios.txt";
        dao.montarUsuarios(path);
		String login = "";
		String senha = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o login: ");
        login = in.nextLine();
        System.out.println("Digite a senha: ");
        senha = in.nextLine();
        if(dao.cadastrarUsuario(login, senha, 1, path) == false){
        	System.out.println("Esse login ja existe ! ");
        }else{
        	System.out.println("Salvo !");
        }
        dao.salvar(path);
	}
}
