package models.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.Clinic;
import models.dao.ClinicDao;

public class ClinicDaoJDBC implements ClinicDao{
	
	Connection conn = null;

	public ClinicDaoJDBC(Connection conn) {
		this.conn = conn;
	}
		
	@Override
	public void insert(Clinic obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
										"insert into clinic "
										+"(name, tel, adress, cnpj) "
										+"values "
										+"(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
										);
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getTel());
			st.setString(3, obj.getAdress());
			st.setInt(4, obj.getCnpj());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int cnpj = rs.getInt(1);
					obj.setCnpj(cnpj);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("ERRO: Nenhuma alteracao.");
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
	public void update(Clinic obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"update clinic "
					+"set name= ?, tel= ?, adress= ? "
					+"where cnpj = ?"
					);

			st.setString(1, obj.getName());
			st.setInt(2, obj.getTel());
			st.setString(3, obj.getAdress());
			st.setInt(4, obj.getCnpj());
			
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
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
										"delete from clinic where cnpj = ?"	
											);
			
			st.setInt(1, id);
			
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
	public Clinic findByCnpj(Integer cnpj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from clinic where cnpj = ?");
			
			st.setInt(1, cnpj);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Clinic cl = instanceClin(rs);
				
				return cl;
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

	private Clinic instanceClin(ResultSet rs) throws SQLException {
		Clinic cl = new Clinic();
		cl.setName(rs.getString("name"));
		cl.setAdress(rs.getString("adress"));
		cl.setTel(rs.getInt("tel"));
		cl.setCnpj(rs.getInt("cnpj"));
		
		return cl;
	}

	@Override
	public List<Clinic> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from clinic");
			
			rs = st.executeQuery();
			
			List<Clinic> list = new ArrayList<>();
			
			while(rs.next()) {
				
				Clinic clinic = instanceClinic(rs);
				
				list.add(clinic);
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

	private Clinic instanceClinic(ResultSet rs) throws SQLException {
		Clinic clinic = new Clinic();
		clinic.setName(rs.getString("clinic.name"));
		clinic.setAdress(rs.getString("clinic.adress"));
		clinic.setTel(rs.getInt("clinic.tel"));
		clinic.setCnpj(rs.getInt("clinic.cnpj"));
		
		return clinic;
	}

}
