package resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ClienteDAO;
import dao.EventoDAO;
import modelo.Clientes;


@Path("eventservices")
public class ServicosEventoWebService {
	
	private ArrayList<Clientes> listaClientesDAO;
	private Clientes cliente = new Clientes();

	@GET
	@Path("listarEvento/{codEvento}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public ArrayList<Clientes> listarClientesPorEvento(@PathParam("codEvento") int codEvento){
		
		EventoDAO eventoDAO = new EventoDAO();
		
		listaClientesDAO = eventoDAO.listarClientesPorEvento(codEvento);
		
		return listaClientesDAO;
		
		}
}