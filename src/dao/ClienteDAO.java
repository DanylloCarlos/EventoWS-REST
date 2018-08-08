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
	private ResultSet rs;
	private String sql;
	ArrayList<Clientes> listaDeClientes;
	
	public ClienteDAO(){
		try {
			c = ConexaoBD.novaConexao();
		
		}catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public void cadastrarCliente(String nome, int cpf, int idEvento){
		
		String sql = "Insert into Clientes (nomeCliente, cpf, Eventos_idEvento) values (?, ?, ?)";
		
		try {
			pstm = c.prepareStatement(sql);
			
			pstm.setString(1, nome);
			pstm.setInt(2, cpf);
			pstm.setInt(3, idEvento);
			
			pstm.executeUpdate();
			
			pstm.close();
			c.close();
			
		}catch(SQLException sqe) {
			sqe.printStackTrace();
		}
			
	}
	
	public Clientes buscarCliente(BigDecimal cpf){
		Clientes cli = new Clientes();
		
		String sql = "Select * from Clientes c where c.cpf= ?";
		
		try {
			pstm = c.prepareStatement(sql);
			pstm.setBigDecimal(1, cpf);
			rs = pstm.getResultSet();
			
			pstm.close();
			c.close();
			
			while(rs.next()) {
				cli.setNomeCliente(rs.getString("nomeCliente"));
				cli.setCpf(rs.getBigDecimal("cpf"));
				
			}
			
		}catch(SQLException sqe) {
			sqe.printStackTrace();
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
				clientes.setNomeCliente(rs.getString("nomeCliente"));
				clientes.setCpf(rs.getBigDecimal("cpf"));
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
