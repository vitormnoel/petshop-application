package application;

import java.util.List;

import model.Client_Animal;
import models.dao.Client_AnimalDao;
import models.dao.DaoFactory;

public class CA_Main {

	public static void main(String[] args) {

		Client_AnimalDao canimal = DaoFactory.createCADao();
		
		List<Client_Animal> list = canimal.All();
		System.out.println("Lista de clientes e seus pets:::\n"); 
		for(Client_Animal obj : list) {
			System.out.println(obj+"\n");
		}

	}

}
