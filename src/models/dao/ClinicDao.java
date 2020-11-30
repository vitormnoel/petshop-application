package models.dao;

import java.util.List;

import model.Clinic;

public interface ClinicDao {

	void insert(Clinic obj);
	void update(Clinic obj);
	void deleteById(Integer id);
	Clinic findByCnpj(Integer cnpj);
	List<Clinic> findAll();
}
