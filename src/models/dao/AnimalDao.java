package models.dao;

import java.util.List;

import model.Animal;
import model.Client;

public interface AnimalDao {

	void insert(Animal obj);
	void update(Animal obj);
	void deleteById(Integer id);
	Animal findById(Integer id);
	List<Animal> findAll();
	List<Animal> findAllAnimal(Client client);
}
