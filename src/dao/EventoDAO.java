package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Clientes;
import modelo.Eventos;
import util.ConexaoBD;

public class EventoDAO {
	private Connection c;
	private PreparedStatement pstm;
	private ResultSet rs;
	private String sql;
	private ArrayList<Clientes> listaClientesPorEvento;
	
	public EventoDAO() {
		
		try {
			c = ConexaoBD.novaConexao();
		
		}catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public void cadastrarEvento(String nomeDoEvento, int qtdIngressos, int idCliente){
		
		sql = "Insert into Eventos(nomeEvento, qtdIngressos)"
				+ " values (?, ?)";
		
		try {
			
			pstm = c.prepareStatement(sql);
			pstm.setString(1, nomeDoEvento);
			pstm.setInt(2, qtdIngressos);
			
			pstm.executeUpdate();
			
			pstm.close();
			c.close();
			
		}catch(SQLException sqe) {
			sqe.printStackTrace();
		}
	}
	
	public void removerEvento(Eventos e){
		
		String sql = "Delete from Eventos e where e.IdEvento = ?";
		
		try {
			pstm = c.prepareStatement(sql);
			pstm.setInt(1, e.getIdEvento());
			
			pstm.execute();
			
			pstm.close();
			c.close();
			
		}catch(SQLException sqe) {
			sqe.printStackTrace();
		}
		
		
	}
	
	public ArrayList<Clientes> listarClientesPorEvento(int codigoDoEvento) {
		listaClientesPorEvento = new ArrayList<>();
		
		sql = "Select nomeCliente, cpf from Clientes c, Eventos e "
				+ "Where c.Eventos_idEvento = e.idEvento and e.idEvento = ?";
		
			try {
				pstm = c.prepareStatement(sql);
				pstm.setInt(1, codigoDoEvento);
				rs = pstm.executeQuery();
				
				while(rs.next()){

					Clientes cli = new Clientes();
					
					cli.setNomeCliente(rs.getString("nomeCliente"));
					cli.setCpf(rs.getInt("cpf"));
					
					listaClientesPorEvento.add(cli);
				}
				
				pstm.close();
				c.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return listaClientesPorEvento;
		}	
}