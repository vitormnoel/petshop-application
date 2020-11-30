package application;

import java.util.List;

import model.Service;
import models.dao.DaoFactory;
import models.dao.ServiceDao;

public class Service_Main {

	public static void main(String[] args) {
		
		ServiceDao service = DaoFactory.createServiceDao();
		
		List<Service> list = service.findAll();
		
		for(Service obj : list) {
			System.out.println(obj);
		}
		
		Service ser = new Service();
		ser = service.findByServiceName("Banho");
		System.out.println(ser);
		ser.setPrice(15);
		service.update(ser);
		System.out.println("confirmed update");
		
		ser.registerNewService();
		service.insert(ser);service.findByServiceName("Consulta");
	}

}
