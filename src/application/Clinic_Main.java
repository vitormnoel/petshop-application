package application;

import java.util.List;

import model.Clinic;
import models.dao.ClinicDao;
import models.dao.DaoFactory;

public class Clinic_Main {

	public static void main(String[] args) {
		
		ClinicDao clinic = DaoFactory.createClinicDao();
		
		Clinic cli = new Clinic();
		cli.newClinic();
		clinic.insert(cli);
		
		//clinic.deleteById(222);
		
		List<Clinic> list = clinic.findAll();
		
		for(Clinic obj : list) {
			System.out.println(obj);
		}

	}

}
