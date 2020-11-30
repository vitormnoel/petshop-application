package application;

import java.util.List;

import model.Animal;
import model.Appointment;
import model.Client;
import model.Clinic;
import model.Products;
import model.Service;
import model.Vet;
import models.dao.AnimalDao;
import models.dao.AppointmentDao;
import models.dao.ClientDao;
import models.dao.ClinicDao;
import models.dao.DaoFactory;
import models.dao.ProductsDao;
import models.dao.ServiceDao;
import models.dao.VetDao;

public class Animal_main {

	public static void main(String[] args) {
		AnimalDao animal = DaoFactory.createAnimalDao();
		Animal ani = animal.findById(2);
		
		System.out.println(ani);
		
		System.out.println("*******************");
		ClientDao client = DaoFactory.createClientDao();
		Client cli = client.findById(111222333);
		
		System.out.println(cli);
		
		System.out.println("*******************");
		AppointmentDao appointment = DaoFactory.createAppointmentDao();
		Appointment appo = appointment.findByAnimalName("Helena");
		
		System.out.println(appo);
		
		System.out.println("*******************");
		ClinicDao clinic = DaoFactory.createClinicDao();
		Clinic cl = clinic.findByCnpj(999888777);
		
		System.out.println(cl);
		
		System.out.println("*******************");
		ProductsDao products = DaoFactory.createProductDao();
		Products pro = products.findByName("Bola");
		
		System.out.println(pro);
		
		System.out.println("*******************");
		ServiceDao service = DaoFactory.createServiceDao();
		Service ser = service.findByServiceName("Tosa");
		
		System.out.println(ser);
		
		System.out.println("*******************");
		VetDao vet = DaoFactory.createVetDao();
		Vet v = vet.findById(1);
		
		System.out.println(v);
		System.out.println("-----------");
		List<Animal> list = animal.findAllAnimal(cli);
		
		for(Animal obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("----------- test");
		list = animal.findAll();
		
		for(Animal obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("---------- insert");
		Animal animal1 = new Animal(9, null, 111222333, "Cachorrinho");
		animal.insert(animal1);
		System.out.println("nova id: "+animal1.getId());
		
		System.out.println("---------- update");
		ani = animal.findById(9);
		ani.setName("Baleia");
		animal.update(ani);
		System.out.println("confirmed update");
		
		System.out.println("---------- delete ");
		animal.deleteById(9);
		System.out.println("confirmed delete");
		
//		ani.registerAnimal();
//		animal.insert(ani);
		
		animal.deleteById(10);
	}

}
