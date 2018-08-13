package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ClienteDAO;
import modelo.Clientes;

@Path("clientservices")
public class ServicosClienteWebService {
	
	private Clientes cli;
	
	@GET
	@Path("buscaPorCpf/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	public Clientes buscarCliente(@PathParam("cpf") String cpf) {
		
		ClienteDAO cliDAO = new ClienteDAO();
		
		cli = cliDAO.buscarCliente(cpf);
		
		System.out.println(cli.getNomeCliente());
		System.out.println(cli.getCpf());
		
		return cli;

	}	
}
