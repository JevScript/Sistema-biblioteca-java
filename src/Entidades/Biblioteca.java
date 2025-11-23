package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Biblioteca {

	private List<Livro> livros = new ArrayList<>();
	private Map<String, Usuario> usuarios = new HashMap<>();
	private Set<String> categorias = new HashSet<>();
	private List<Emprestimo> emprestimos = new ArrayList<>();
	
	public void cadastrarLivro(Livro livro) {
		Livro isbn = buscarLivroPorISBN(livro.getIsbn());
		
		if(isbn != null) {
			System.out.println("Livro já se encontra na lista.");
		}else {
			
			livros.add(livro);
			categorias.add(livro.getCategoria());
			System.out.println("\nLivro adicionado com sucesso!");
		}
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		
		if(usuarios.containsKey(usuario.getCpf())) {
			System.out.println("Usuario Já cadastrado!");
		}else {
			usuarios.put(usuario.getCpf(), usuario);
			System.out.println("\nUsuario adicionado com sucesso!");
		}
		
	}
	public void emprestarLivro(String isbn, String cpf) {
		
		Livro obra = buscarLivroPorISBN(isbn);
		
		if(obra == null) {
			System.out.println("Livro não encontrado!");
		}else if(obra.isDisponivel()) {
			if(usuarios.containsKey(cpf)) {
				Emprestimo emprestimo = new Emprestimo(obra, usuarios.get(cpf));
				emprestimos.add(emprestimo);
				obra.setDisponivel(false);
				emprestimo.setDataEmprestimo(LocalDate.now());
				System.out.println("Empréstimo criado com sucesso!");
				System.out.println("Detalhes do Empréstimo: \n" + "Obra = " + emprestimo.getLivro().getTitulo() + ", Data de retirada do emprestimo = " + emprestimo.getDataEmprestimo());
			}else {
				System.out.println("Usuario não encontrado!");
			}
		}else {
			System.out.println("Livro Indisponivel!");
		}
}
	public void devolverLivro(String isbn) {
		Livro Livro = buscarLivroPorISBN(isbn);
		
		if(Livro == null) {
			System.out.println("Livro não encontrado!");
			return;
		}
		
		if(!Livro.isDisponivel()) {
			for(Emprestimo emp : emprestimos) {
				if(emp.getLivro().equals(Livro)) {
					emp.getLivro().setDisponivel(true);
					emp.setDataDevolucao(LocalDate.now());
					System.out.println("Detalhes da Devolução:\n" + "[ Usuario = " + emp.getUsuario().getNome() + ", Obra = " + emp.getLivro().getTitulo()
							+ ", data de devolução = " + emp.getDataDevolucao());				
				}
			}
		}else {
			System.out.println("Não há livros para devolução!");
		}
}
	public void listarLivrosDisponiveis() {
		
		
		if(livros.isEmpty()) {
			System.out.println("Não há Livros para exibir.");
		}
		else {
			for(Livro liv : livros) {
				if(liv.isDisponivel()) {
					System.out.println(liv.toString());
				}
		}
	}
}

	public Livro buscarLivroPorISBN(String isbn) {
		
		for(Livro l : livros) {
			
			if(l.getIsbn().equals(isbn)) {
				return l;
			}
		}
		return null;
	}
	
	public void listarUsuarios() {
		
		if(usuarios.isEmpty()) {			
			System.out.println("Não há usuarios cadastrados!");
		}else {
			System.out.println("----------Usuários Cadastrados----------");
			for(Usuario user : usuarios.values()) {
				System.out.println(user.toString());
			}
		}
	}
	
	public void listarEmprestimos(String cpf) {
		
		boolean encontrou = false;
		
		System.out.println("Listando Emprestimos do CPF: " + cpf);
		
		for(Emprestimo emp : emprestimos) {
			if(emp.getUsuario().getCpf().equals(cpf)) {
				System.out.println("O Livro foi: " + emp.getLivro().getTitulo());
				System.out.println("O Usuario foi: " + emp.getUsuario().getNome());
				encontrou =true;
			}
		}
		if(!encontrou) {
			System.out.println("Nenhum Empréstimo encontrado!");
		}

	}
}