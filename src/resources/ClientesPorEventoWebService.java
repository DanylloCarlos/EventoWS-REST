package resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.EventoDAO;
import modelo.Clientes;


@Path("listarclientes")
public class ClientesPorEventoWebService {
	
	private ArrayList<Clientes> listaClientesDAO;
	private Clientes cliente;

	@GET
	@Path("codEvento/{idEvento}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Clientes listarClientesPorEvento(@PathParam("codEvento") int codEvento){
		
		EventoDAO eventoDAO = new EventoDAO();
	
		listaClientesDAO = eventoDAO.listarClientesPorEvento(codEvento);
	
		for(Clientes c : listaClientesDAO) {
			cliente.setNomeCliente(c.getNomeCliente());
			cliente.setCpf(c.getCpf());	
		}	
		
		return cliente;
		
		}
	}