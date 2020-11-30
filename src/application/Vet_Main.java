package application;

import java.util.List;

import model.Vet;
import models.dao.DaoFactory;
import models.dao.VetDao;

public class Vet_Main {

	public static void main(String[] args) {
		
		VetDao vet = DaoFactory.createVetDao();
		
		List<Vet> list = vet.findAll();
		for(Vet obj : list) {
			System.out.println(obj);
		}
		
		System.out.println(vet.findById(10));
		
//		Vet veterinario = new Vet("Paulo", 122211000, 443331, "Rua 12", "paulin@gmail.com", "123.", 10);
//		
//		vet.insert(veterinario);
		
		//vet.deleteById(10);
	}

}
