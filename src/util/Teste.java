package util;

import java.math.BigDecimal;

import resources.ClientesPorEventoWebService;

public class Teste {
	static ClientesPorEventoWebService cpeWS;
	
	public static void main(String args[]) {
		cpeWS = new ClientesPorEventoWebService();
		BigDecimal bd = new BigDecimal(1201212321);
		System.out.println(cpeWS.buscarCliente(bd));
	}
}
