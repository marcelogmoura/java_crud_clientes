package controllers;

import java.util.List;
import java.util.Scanner;

import entitites.Cliente;
import repositories.ClienteRepository;

public class ClienteController {

	public void cadastrarCliente() {

		System.out.println("* * * Cadastro de Clientes * * * ");
		Scanner scanner = new Scanner(System.in);

		try {

			Cliente cliente = new Cliente();

			System.out.print("Nome: ");
			cliente.setNome(scanner.nextLine());

			System.out.print("E-mail: ");
			cliente.setEmail(scanner.nextLine());

			System.out.print("Telefone: ");
			cliente.setTelefone(scanner.nextLine());

			System.out.print("cpf: ");
			cliente.setCpf(scanner.nextLine());

			ClienteRepository clienteRepository = new ClienteRepository();
			clienteRepository.create(cliente);

			System.out.println("\nCliente cadastrado com sucesso.");

		} catch (Exception e) {
			System.out.println("Erro ao cadastrar cliente: " + e.getMessage());

		} finally {
			scanner.close();
		}
	}

	public void atualizarCliente() {
		
		System.out.println("* * * Atualizar cliente * * * ");
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			System.out.println("Informe o ID para editar: ");
			Integer idCliente = Integer.parseInt(scanner.nextLine());
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);
			
			if(cliente != null) {
				
				System.out.print("Altere o nome: ");
				cliente.setNome(scanner.nextLine());
				
				System.out.print("Altere o email: ");
				cliente.setEmail(scanner.nextLine());
				
				System.out.print("Altere o telefone: ");
				cliente.setTelefone(scanner.nextLine());
				
				System.out.print("Altere o cpf: ");
				cliente.setCpf(scanner.nextLine());
				
				clienteRepository.update(cliente);
				
				System.out.println("Atualizado com sucesso");
				
			}else {
				System.out.println("ID não encontrado");
			}
						
		}catch (Exception e) {
			System.out.println("Não foi possível atualizar" + e.getMessage());
			
		}finally {
			scanner.close();
		}

	}
	
	public void excluirCliente() {
		
		System.out.println("* * * Excluir cliente * * * ");
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			System.out.print("Informe o ID: ");
			Integer idCliente = Integer.parseInt(scanner.nextLine());
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);
			
			if(cliente != null) {
				clienteRepository.delete(cliente);
				
				System.out.println("ID " + idCliente + " - Excluído com sucesso");
				
			}else {
				System.out.println("ID não encontrado");
			}
			
		}catch(Exception e) {
			System.out.println("Não foi possível excluir" + e.getMessage());
			
		}finally {
			scanner.close();
		}
				
	}
	
	public void consultarClientes() {
		
		System.out.println("Consulta de Clientes");
		
		try {
			
			ClienteRepository clienteRepository = new ClienteRepository();
			List<Cliente> lista = clienteRepository.findAll();
			
			for(Cliente cliente : lista) {
				
				System.out.println("ID cliente " + cliente.getIdCliente());
				System.out.println("Nome " + cliente.getNome());
				System.out.println("Email " + cliente.getEmail());
				System.out.println("Telefone " + cliente.getTelefone());
				System.out.println("cpf" + cliente.getCpf());
				System.out.println(" * * * * * * * * ");
				
			}
			
			System.out.println("Quantidade de clientes obtidos: " + lista.size());
			
		}catch (Exception e) {
			
			System.out.println("Erro ao consultar" + e.getMessage());
			
		}finally {
			
		}
	}

}




