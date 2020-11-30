package application;

import java.util.List;

import model.Products;
import models.dao.DaoFactory;
import models.dao.ProductsDao;

public class Product_Main {
	public static void main(String[] args) {
		
		ProductsDao products = DaoFactory.createProductDao();
		
		List<Products> list = products.findAll();
		
		for(Products obj : list) {
			System.out.println("Nome: "+obj.getName()+" | preço: "+obj.getPrice());
		}
	}
}
