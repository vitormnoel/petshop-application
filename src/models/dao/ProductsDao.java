package models.dao;

import java.util.List;

import model.Products;

public interface ProductsDao {

	void insert(Products obj);
	void update(Products obj);
	void deleteByName(String name);
	Products findByName(String name);
	List<Products> findAll();
}
