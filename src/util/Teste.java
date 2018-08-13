package util;

import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;

import dao.EventoDAO;
import modelo.Clientes;
import resources.ServicosClienteWebService;
import resources.ServicosEventoWebService;
	
public class Teste {
	private static EventoDAO evtDAO = new EventoDAO();
	private static int codEvento = 0;
	private static int opcao = -1;
	
	public static void main(String[] args) {
		Scanner op = new Scanner(System.in);

		do {
			
		System.out.println();
		System.out.println("Por favor, escolha 1 (um) dos serviços abaixo: ");
		System.out.println();
		System.out.println("1 - Listar todos os clientes cadastrados dado um evento.");
		System.out.println("2 - Buscar cliente por CPF.");
		System.out.println("3 - Sair do programa");
		System.out.println();
		System.out.printf("Digite aqui a opção escolhida: ");
		opcao = op.nextInt();
		
			
			switch(opcao) {
			
			case 1:
				System.out.println();
				System.out.println("Serviço escolhido: Listar todos os clientes em um evento!");
				System.out.println();
				
				servicoListarClientesPorEvento();
				
				break;
				
			case 2:
				System.out.println();
				System.out.println("Serviço escolhido: Buscar cliente por CPF!");
				System.out.println();
			
				servicoBuscarClientePorCpf();
				
				break;
				
			case 3:
				
				sairDoPrograma();
			
				System.out.println("O programa foi encerrado com sucesso.");
				
				break;
			}
			
		}while(opcao != -1);
		
	}
	
	public static void servicoListarClientesPorEvento() {
		Scanner codScan = new Scanner(System.in);
		
		System.out.printf("Por favor, digite o código do evento: ");
		codEvento = codScan.nextInt();
		
		ServicosEventoWebService servicoEvt = new ServicosEventoWebService();
		JsonArray js = new JsonArray();
		
		List<Clientes> clientesPorEvento;
		
		clientesPorEvento = servicoEvt.listarClientesPorEvento(codEvento);
		
		for(Clientes c : clientesPorEvento) {
			js.add(c.getNomeCliente());
			js.add(c.getCpf());
		}
		System.out.println();
		System.out.println(js);
	}
	

	public static void servicoBuscarClientePorCpf() {
		Scanner cpfScan = new Scanner (System.in);
		String cpf;
		
		System.out.printf("Digite o CPF do Cliente: ");
		cpf = cpfScan.nextLine();
		
		ServicosClienteWebService servicoCli = new ServicosClienteWebService();
		
		System.out.println();
		Clientes cliente = servicoCli.buscarCliente(cpf);
		
		JsonArray arrayJson = new JsonArray();
		
		arrayJson.add(cliente.getNomeCliente().toString());
		arrayJson.add(cliente.getCpf().toString());
		
		System.out.println("JSON: " + arrayJson);
		/*
		ClienteDAO cliDAO = new ClienteDAO();
		cliDAO.buscarCliente(cpf);*/
	}
	
	public static void sairDoPrograma() {
		opcao = -1;
	}
}
