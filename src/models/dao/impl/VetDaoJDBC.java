package models.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.Vet;
import models.dao.VetDao;

public class VetDaoJDBC implements VetDao{
	
	Connection conn = null;

	public VetDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Vet obj) {
PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
										"insert into vet "
												+"(name, id, tel, adress, email, pass, vetID) "
												+"values (?, ?, ?, ?, ?, ?, ?)");
					
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			st.setInt(3, obj.getTel());
			st.setString(4, obj.getAdress());
			st.setString(5, obj.getEmail());
			st.setString(6, obj.getPass());
			st.setInt(7, obj.getVetID());
			
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
	public void update(Vet obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"update clinic "
							+"set name= ?, id= ?, tel= ?, adress= ?, email= ?, pass= ?, vetID= ? "
							+"where vetID= ?"
							);

			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			st.setInt(3, obj.getTel());
			st.setString(4, obj.getAdress());
			st.setString(5, obj.getEmail());
			st.setString(6, obj.getPass());
			st.setInt(7, obj.getVetID());
			st.setInt(8, obj.getVetID());
			
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
			st = conn.prepareStatement("delete from vet where vetID = ?");
			
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
	public Vet findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from vet "
										+"where vetID = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Vet vet = instanceVet(rs);

				return vet;
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

	private Vet instanceVet(ResultSet rs) throws SQLException {
		Vet vet = new Vet();
		vet.setName(rs.getString("name"));
		vet.setEmail(rs.getString("email"));
		vet.setId(rs.getInt("id"));
		vet.setAdress(rs.getString("adress"));
		vet.setTel(rs.getInt("tel"));
		vet.setVetID(rs.getInt("vetID"));

		return vet;
	}

	@Override
	public List<Vet> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from vet");
			
			rs = st.executeQuery();
			
			List<Vet> list = new ArrayList<>();
			
			while(rs.next()) {
				
				Vet vet = instanceVet(rs);
				
				list.add(vet);
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
