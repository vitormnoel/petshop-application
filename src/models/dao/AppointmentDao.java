package models.dao;

import java.util.List;

import model.Appointment;

public interface AppointmentDao {
	
	void insert(Appointment obj);
	Appointment findByAnimalName(String name);
	List<Appointment> findAll();
}
