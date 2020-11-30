package models.dao;

import java.util.List;

import model.Service;

public interface ServiceDao {

	void insert(Service obj);
	void update(Service obj);
	void deleteByName(String name);
	Service findByServiceName(String name);
	Service findById(int id);
	List<Service> findAll();
}
