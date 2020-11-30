package application;

import java.util.List;

import model.Appointment;
import models.dao.AppointmentDao;
import models.dao.DaoFactory;

public class Appointment_Main {

	public static void main(String[] args) {
		
		AppointmentDao appointment = DaoFactory.createAppointmentDao();
		List<Appointment> list = appointment.findAll();
		
		System.out.println("Consultas: ");
		for(Appointment obj : list) {
			System.out.println(obj);
		}

	}

}
