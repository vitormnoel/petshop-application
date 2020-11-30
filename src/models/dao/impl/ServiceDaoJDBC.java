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
import model.Service;
import models.dao.ServiceDao;

public class ServiceDaoJDBC implements ServiceDao{
	
	Connection conn = null;

	public ServiceDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Service obj) {
PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
										"insert into service "
										+"(name, price, service_time, id_clinic) "
										+"values "
										+"(?, ?, ?, ?)"
										);
			
			st.setString(1, obj.getName());
			st.setDouble(2, obj.getPrice());
			st.setString(3, obj.getHour());
			st.setInt(4, obj.getIdClinic());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				System.out.println("Inserido!");
			}
			else {
				throw new DbException("ERRO: Nenhuma alteração.");
			}
		}
		catch (SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Service obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"update service "
					+"set name= ?, price= ?, service_time= ?  "
					+"where name = ?"
					);

			st.setString(1, obj.getName());
			st.setDouble(2, obj.getPrice());
			st.setString(3, obj.getHour());
			st.setString(4, obj.getName());
			
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
			st = conn.prepareStatement(
					"delete from service "
					+"where name = ?"
					);

			st.setString(1, name);
			
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
	public Service findByServiceName(String name) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from service "
										+"join clinic "
										+"on clinic.cnpj = service.id_clinic "
										+"where service.name = ? ");
			
			st.setString(1, name);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Clinic clinic = instanceClinic(rs);
				Service ser = instanceService(rs, clinic);
				
				return ser;
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

	private Service instanceService(ResultSet rs, Clinic clinic) throws SQLException {
		Service ser = new Service();
		ser.setName(rs.getString("service.name"));
		ser.setHour(rs.getString("service.service_time"));
		ser.setPrice(rs.getFloat("service.price"));
		ser.setClinic(clinic);
		
		return ser;
	}

	private Clinic instanceClinic(ResultSet rs) throws SQLException {
		Clinic clinic = new Clinic();
		clinic.setName(rs.getString("clinic.name"));
		clinic.setCnpj(rs.getInt("clinic.cnpj"));
		clinic.setAdress(rs.getString("clinic.adress"));
		clinic.setTel(rs.getInt("clinic.tel"));
		
		return clinic;
	}

	@Override
	public List<Service> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from service join clinic on cnpj = id_clinic");
			
			rs = st.executeQuery();
			
			List<Service> list = new ArrayList<>();
			Map<Integer, Clinic> map = new HashMap<>();
			
			while(rs.next()) {
				
				Clinic cli = map.get(rs.getInt("clinic.cnpj"));

				if(cli == null) {
					Clinic cl = instanceClinic(rs);
					map.put(rs.getInt("clinic.cnpj"), cl);
				}
				
				Service ser = instanceService(rs, cli);
				
				list.add(ser);
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
