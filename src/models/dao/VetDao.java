package models.dao;

import java.util.List;

import model.Vet;

public interface VetDao {

	void insert(Vet obj);
	void update(Vet obj);
	void deleteById(Integer id);
	Vet findById(Integer id);
	List<Vet> findAll();
}
