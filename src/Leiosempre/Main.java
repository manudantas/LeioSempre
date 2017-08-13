package Leiosempre;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	
	public static UsuarioDAO daousuarios = new UsuarioDAO();
	public static LivroDAO daolivros = new LivroDAO();
	public static AdministradorDAO daoadmin = new AdministradorDAO();
	
	public static void main(String args[]) throws IOException{		
		daolivros.montarLivros();
		daousuarios.montarUsuarios();
		daoadmin.montarAdmin();
		opcoes();
	
	
	}
		static Scanner input = new Scanner(System.in);
		
		
		public static  void opcoes() throws IOException {
			
			
		System.out.println("Escolha a opção que lhe corresponde:");
		System.out.println("\n1-Leitor");
		System.out.println("\n2-Administrador");
		System.out.println("\n3-Cadastre-se");
		System.out.println("\n4-Sair");
		int tipoDeUsuario = input.nextInt();
		switch (tipoDeUsuario){
		
		case 1:
			System.out.println("Digite seu Login:");
			Scanner sc1 = new Scanner( System.in );
			String login = sc1.nextLine();
			
			System.out.println("Digite sua senha:");
			Scanner sc2 = new Scanner( System.in );
			String senha = sc2.nextLine();
			
			if(daousuarios.login(login, senha) == true){
				menuLeitor();
			}else{
				System.out.println("Login ou senha incorretos! ");
				opcoes();
			}
			
			break;
		case 2:
			System.out.println("Digite seu Login:");
			sc1 = new Scanner( System.in );
			login = sc1.nextLine();
			
			System.out.println("Digite sua senha:");
			sc2 = new Scanner( System.in );
			senha = sc2.nextLine();
			
			if(daoadmin.login(login, senha)){
				menuADM();
			}else{
				System.out.println("Login ou senha incorretos! ");
				opcoes();
			}	
			break;
		case 3:
			System.out.println("Digite um Login: ");
			Scanner sc3 = new Scanner( System.in );
			login = sc3.nextLine();
			System.out.println("Digite a senha: ");
			Scanner sc4 = new Scanner( System.in );
			senha = sc4.nextLine();
			System.out.println("Digite o pacote que deseja(3, 5 ou 10 livros): ");
			Scanner sc5 = new Scanner( System.in );
			int pacote = sc5.nextInt();
			if(daousuarios.cadastrarUsuario(login, senha, pacote) == true){
				System.out.println("Cadastrado com sucesso !");
			}else{
				System.out.println("O login ja Existe !");
			}
			opcoes();
			break;
		case 4:
			daousuarios.salvar();
			daolivros.salvar();
			daoadmin.salvar();
			System.exit(0);
		default:
			System.out.println("Opção inválida");
			opcoes();
			break;
		
		}
		
	}


		private static void menuADM() throws IOException {
			
			
			System.out.println("Escolha o que deseja fazer:");
			System.out.println("\n1-Adicionar um livro ao acervo");
			System.out.println("\n2-Excluir um Livro do Acervo");
			System.out.println("\n3-Mostrar Acervo");
			System.out.println("\n4-Cadastrar um administrador");
			System.out.println("\n5-Voltar ao Menu");
			int administrador = input.nextInt();
			switch (administrador){
			case 1:
				adicionarAoAcervo();
				break;
			case 2:
				excluirDoAcervo();
				break;
			case 3:
				System.out.println("Livros no acervo: ");
				System.out.println(daolivros.mostrarLivros());
				menuADM();
				break;
			case 4:
				System.out.println("Digite um Login: ");
				Scanner sc3 = new Scanner( System.in );
				String login = sc3.nextLine();
				System.out.println("Digite a senha: ");
				Scanner sc4 = new Scanner( System.in );
				String senha = sc4.nextLine();
				System.out.println("Digite seu nome: ");
				Scanner sc5 = new Scanner( System.in );
				String nome = sc5.nextLine();
				
				if(daoadmin.cadastrarAdm(login, senha, nome) == true){
					System.out.println("Cadastrado !");
				}else{
					System.out.println("O login ja existe !");
				}
				menuADM();
			case 5:
				opcoes();
				break;
			default:
				System.out.println("Opção Inválida");	
			}
		}

		
		public static  void menuLeitor() throws IOException{
			

			System.out.println("Escolha o que deseja fazer:");
			System.out.println("\n1-Pedir um Livro");
			System.out.println("\n2-Excluir um livro");
			System.out.println("\n3-Mudar Pacote");
			System.out.println("\n4-Voltar ao menu");
			int leitor = input.nextInt();
			switch (leitor){
			case 1:
				pedirLivro();
				break;
			case 2:
				excluirLivro();
				break;
			case 3:
				mudarPacote();
				break;
			case 4:
				opcoes();
				break;
			default:
				System.out.println("Opção inválida");
			}

		}	
		
		
		
	private static void excluirDoAcervo() throws IOException {
		System.out.println("Digite o nome do livro: ");
		Scanner sc1 = new Scanner( System.in );
		String titulo = sc1.nextLine();
		if(daoadmin.admExcluirLivro(titulo) == true){
			System.out.println("\nexcluido\n");
			menuADM();
		}else{
			System.out.println("\nErro!\n");
			menuADM();
		}
			
	}
	
	private static void adicionarAoAcervo() throws IOException {
		System.out.println("Digite o nome do livro: ");
		Scanner sc1 = new Scanner( System.in );
		String titulo = sc1.nextLine();
		System.out.println("Digite o autor do livro: ");
		Scanner sc2 = new Scanner( System.in );
		String autor = sc2.nextLine(); 	
		System.out.println("Digite se é fisico ou nao (true ou false)");
		Scanner sc3 = new Scanner( System.in );
		Boolean estado = sc3.nextBoolean();
		if(daoadmin.admCadastrarLivro(titulo, autor, estado) == true){
			System.out.println("\nadicionado\n");
			menuADM();
		}else{
			System.out.println("\nErro!\n");
			menuADM();
		}

			
	}

	private static void mudarPacote() throws IOException {
		System.out.println("Digite seu login: ");
		Scanner sc1 = new Scanner( System.in );
		String login = sc1.nextLine();
		System.out.println("Digite o novo pacote");
		System.out.println("\nmudado\n");
		Scanner sc2 = new Scanner( System.in );
		int pacote = sc2.nextInt(); 
		if(daousuarios.mudarPacote(login, pacote)){
			System.out.println("Pacote Alterado !");
		}else{
			System.out.println("Erro !");
		}
		menuLeitor();
	}

	private static void excluirLivro() throws IOException {
		System.out.println("Digite seu login: ");
		Scanner sc1 = new Scanner( System.in );
		String login = sc1.nextLine(); 
		System.out.println("Livros disponiveis no seu pacote: ");
		System.out.println(daousuarios.mostrarLivros(login));
		System.out.println("Digite o livro que deseja excluir: ");
		Scanner sc2 = new Scanner( System.in );
		String livro = sc2.nextLine(); 
		daousuarios.removerLivroUs(login, livro);
		System.out.println("\nexcluido\n");
		menuLeitor();

	}
	
	private static void mostrarLivrosDisponiveis() throws IOException{
		System.out.println(daolivros.mostrarLivros());
	}

	private static void pedirLivro() throws IOException {
		System.out.println("Livros disponiveis: ");
		mostrarLivrosDisponiveis();
		System.out.println("Digite seu login: ");
		Scanner sc1 = new Scanner( System.in );
		String login = sc1.nextLine(); 
		System.out.println("Digite o livro que deseja: ");
		Scanner sc2 = new Scanner( System.in );
		String livro = sc2.nextLine(); 
		daousuarios.adicionarLivroUs(login, livro);
		System.out.println("\nsolicitado\n");
		menuLeitor();
	}
}
