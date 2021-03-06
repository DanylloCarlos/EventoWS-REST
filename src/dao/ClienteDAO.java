package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Clientes;
import util.ConexaoBD;

public class ClienteDAO {
	private Connection c;
	private PreparedStatement pstm;
	private ResultSet rs = null;
	private String sql;
	ArrayList<Clientes> listaDeClientes;
	Clientes cli = new Clientes();
	
	public ClienteDAO(){
		try {
			c = ConexaoBD.novaConexao();
		
		}catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public void cadastrarCliente(String nome, BigDecimal cpf, int idEvento){
		
		String sql = "Insert into Clientes (nomeCliente, cpf, Eventos_idEvento) values (?, ?, ?)";
		
		try {
			pstm = c.prepareStatement(sql);
			
			pstm.setString(1, nome);
			pstm.setBigDecimal(2, cpf);
			pstm.setInt(3, idEvento);
			
			pstm.executeUpdate();
			
			pstm.close();
			c.close();
			
		}catch(SQLException sqe) {
			sqe.printStackTrace();
		}
			
	}
	
	public Clientes buscarCliente(String cpf){
		Clientes cli = new Clientes();
		String sql = "Select * from Clientes c where c.cpf= ?";
		
		try {
			pstm = c.prepareStatement(sql);
			pstm.setString(1, cpf);
			
			rs = pstm.executeQuery();
			
				do {
					
					if(rs.first() == false) {
						System.out.println();
						System.out.println("Cliente não cadastrado no sistema!");
					
					}else {
						
						cli.setNomeCliente(rs.getString("nomeCliente"));
						cli.setCpf(rs.getString("cpf"));
						
						System.out.println();
						System.out.println("Cliente encontrado!");
						System.out.println();
						System.out.println("Nome do cliente: "+cli.getNomeCliente());
						System.out.println("CPF do Cliente: "+cli.getCpf());
						System.out.println();
					}
						
				}while(rs.next());
				
					pstm.close();
					c.close();
				
		}catch(SQLException | NullPointerException ex) {
			System.out.println("Cliente não encontrado ou erro no sistema");
			ex.printStackTrace();
		}
		
		return cli;
		
	}
	
	public ArrayList<Clientes> listarClientes(){
		listaDeClientes = new ArrayList<Clientes>();
		sql = "Select * from Clientes";
		
		try {
			pstm = c.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				Clientes clientes = new Clientes();
				
				listaDeClientes.add(clientes);
			}
			pstm.close();
			c.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return listaDeClientes;
		
	}
}
