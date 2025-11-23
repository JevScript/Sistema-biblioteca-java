package aplicacao;

import java.util.Scanner;

import javax.swing.JOptionPane;

import Entidades.Biblioteca;
import Entidades.Livro;
import Entidades.Usuario;

public class MenuMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Biblioteca biblioteca = new Biblioteca();
		
		Scanner sc = new Scanner(System.in);
		Integer x =0;
		
		while(x != 8) {
			System.out.println("\n***** MENU *****");
			System.out.println("1. Cadastrar Livro");
			System.out.println("2. Cadastrar Usuario");
			System.out.println("3. Emprestar Livro");
			System.out.println("4. Devolver Livro");
			System.out.println("5. Listar Livros");
			System.out.println("6. Listar Usuarios");
			System.out.println("7. Listar Emprestimos");
			System.out.println("8. Sair");
			
			
			System.out.println("\nDigite a opção desejada:");
			x = sc.nextInt();
			
			switch (x) {
			
			case 1:
					String titulo = JOptionPane.showInputDialog("Qual o nome do livro?");
					String isbn = JOptionPane.showInputDialog("Qual o isbn do livro?");
					String autor = JOptionPane.showInputDialog("Qual o nome do autor?");
					String categoria = JOptionPane.showInputDialog("Qual a categoria do livro?");
					Livro livro1 = new Livro(isbn, titulo, autor, categoria);
					biblioteca.cadastrarLivro(livro1);
					break;
			case 2: 
					String cpf = JOptionPane.showInputDialog("Digite o cpf do usuário:");
					String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
					String email = JOptionPane.showInputDialog("Digite o email do usuário:");
					Usuario usuario1 = new Usuario(cpf, nome, email);
					biblioteca.cadastrarUsuario(usuario1);
					break;
					
			case 3: 
					String isbnEmprestimo = JOptionPane.showInputDialog("Digite o isbn do livro!");
					String cpfEmprestimoSolicitar = JOptionPane.showInputDialog("Digite o cpf do usuario!");
					biblioteca.emprestarLivro(isbnEmprestimo, cpfEmprestimoSolicitar);
				break;
			case 4:
				String isbnDevolucao = JOptionPane.showInputDialog("Digite o isbn do livro para localiza-lo!");
				biblioteca.devolverLivro(isbnDevolucao);
				break;
			case 5: biblioteca.listarLivrosDisponiveis();
					break;
			case 6:
				biblioteca.listarUsuarios();
				break;
			case 7: 
				String cpfEmprestimo = JOptionPane.showInputDialog("Digite o CPF do usuário que deseja consultar:");
				biblioteca.listarEmprestimos(cpfEmprestimo);
				break;
			
			}
			
		}
		sc.close();
	}

}
