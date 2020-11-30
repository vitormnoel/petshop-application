package application;

import java.util.List;

import model.Client;
import models.dao.ClientDao;
import models.dao.DaoFactory;

public class Client_Main {

	public static void main(String[] args) {
		
		ClientDao client = DaoFactory.createClientDao();
//		Client cli = client.findById(333444555);
//		System.out.println(cli);
		
		List<Client> list = client.findAll();
		
		for(Client obj : list) {
			System.out.println(obj);
		}
		
//		Client cli = new Client("ADMIN", 123, 9182732, "rua 0", "admin@admin", "abc");
//		client.insert(cli);
//		System.out.println("nova id inserida: "+cli.getId());
		
//		Client cli = client.findById(123);
//		System.out.println("dados do cliente: "+cli);
//		cli.setName("Vitor [new admin]");
//		client.update(cli);
//		System.out.println("dados alterados: "+cli);
		
		//List<Client> list = client.findAll();
//		
//		System.out.println("Clientes: ");
//		for(Client obj : list) {
//			System.out.println(obj);
//		}
//		
//		client.deleteById(123);
//		System.out.println("\n\nCliente apagado!\n\n");
//		
		//List<Client> list1 = client.findAll();
//		
//		System.out.println("Nova lista de clientes: ");
//		for(Client obj : list1) {
//			System.out.println(obj);
//		}
//		
//		Client cli = client.findById(666777888);
//		list = client.findAllClients(cli);
//		
//		for(Client obj : list) {
//			System.out.println(obj);
//		}
	}

}
