package models.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.Clinic;
import model.Products;
import models.dao.ProductsDao;

public class ProductsDaoJDBC implements ProductsDao{
	
	Connection conn = null;

	public ProductsDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Products obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into product (name, category, price, amount, id_clinic) "
										+"values (?, ?, ?, ?, ?)"
										);
			
			st.setString(1, obj.getName());
			st.setString(2, obj.getcategory());
			st.setDouble(3, obj.getPrice());
			st.setInt(4, obj.getamount());
			st.setInt(5, obj.getCnpj());
			
			int row = st.executeUpdate();
			
			if(row>0) {
				System.out.println("Dado inserido!");
			}
			
		}
		catch (SQLException e) {
			throw new DbException("Erro ao inserir dado. Deve olhar: "+e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Products obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"update product "
					+"set name= ?, category= ?, price= ?, amount= ? "
					+"where id= ?"
					);

			st.setString(1, obj.getName());
			st.setString(2, obj.getcategory());
			st.setDouble(3, obj.getPrice());
			st.setInt(4, obj.getamount());
			st.setInt(5, obj.getId());
			
			st.executeUpdate();
		}
		catch (SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteByName(String name) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("delete from product where name = ?");
			
			st.setString(1, name);
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	

	@Override
	public Products findById(int id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from product join clinic on id_clinic = cnpj "
										+ "where id = ? ");
								
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Clinic cli = instanceCli(rs);
				
				Products pro = new Products();
				pro.setId(rs.getInt("product.id"));
				pro.setName(rs.getString("product.name"));
				pro.setcategory(rs.getString("product.category"));
				pro.setamount(rs.getInt("product.amount"));
				pro.setPrice(rs.getFloat("product.price"));
				pro.setCnpj(rs.getInt("product.id_clinic"));
				pro.setClinic(cli);
				
				return pro;
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return null;
	}

	@Override
	public Products findByName(String name) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from product "
                                                    + "join clinic "
                                                    + "on cnpj = id_clinic "
                                                    + "where product.name like ? ");
								
			st.setString(1, "%"+name+"%");
			rs = st.executeQuery();
			
			if(rs.next()) {
				Clinic clinic = instanceCli(rs);
				Products pro = instanceProducts(rs, clinic);
				
				return pro;
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return null;
	}

	private Products instanceProducts(ResultSet rs, Clinic clinic) throws SQLException {
		Products pro = new Products();
		pro.setId(rs.getInt("product.id"));
		pro.setName(rs.getString("product.name"));
		pro.setcategory(rs.getString("product.category"));
		pro.setamount(rs.getInt("product.amount"));
		pro.setPrice(rs.getFloat("product.price"));
		pro.setClinic(clinic);
		
		return pro;
	}

	private Clinic instanceCli(ResultSet rs) throws SQLException {
		Clinic clinic = new Clinic();
		clinic.setName(rs.getString("clinic.name"));
		clinic.setCnpj(rs.getInt("product.id_clinic"));
		clinic.setAdress(rs.getString("clinic.adress"));
		clinic.setTel(rs.getInt("clinic.tel"));
		
		return clinic;
	}

	@Override
	public List<Products> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from product join clinic on cnpj = id_clinic ");
			
			rs = st.executeQuery();
			
			List<Products> list = new ArrayList<>();
			Map<Integer, Clinic> map = new HashMap<>();
			
			while(rs.next()) {
				
				Clinic cli = map.get(rs.getInt("clinic.cnpj"));

				if(cli == null) {
					Clinic cl = instanceCli(rs);
					map.put(rs.getInt("clinic.cnpj"), cl);
				}
				
				Products product = new Products();
				product.setId(rs.getInt("product.id"));
				product.setName(rs.getString("product.name"));
				product.setPrice(rs.getDouble("product.price"));
				product.setamount(rs.getInt("product.amount"));
				product.setcategory(rs.getString("product.category"));
				product.setClinic(cli);
				
				list.add(product);
			}
			return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}


}
