package models.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.Animal;
import model.Client;
import models.dao.AnimalDao;

public class AnimalDaoJDBC implements AnimalDao {

	Connection conn = null;
	
	public AnimalDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Animal obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
										"insert into animal "
										+"(id, name, species, owner_id) "
										+"values "
										+"(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
										);
			
			st.setInt(1, obj.getId());
			st.setString(2, obj.getName());
			st.setString(3, obj.getSpecies());
			st.setInt(4, obj.getOwner());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
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
	public void update(Animal obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"update animal "
					+"set name= ?, species= ?, owner_id= ? "
					+"where id = ?"
					);

			st.setString(1, obj.getName());
			st.setString(2, obj.getSpecies());
			st.setInt(3, obj.getOwner());
			st.setInt(4, obj.getId());
			
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
			st = conn.prepareStatement("delete from animal where id = ?");
			
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
	public Animal findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from animal where id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Animal an = instanceAnimal(rs);

				return an;
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

	private Animal instanceAnimal(ResultSet rs) throws SQLException {
		Animal an = new Animal();
		an.setName(rs.getString("animal.name"));
		an.setSpecies(rs.getString("species"));
		an.setId(rs.getInt("animal.id"));
		an.setOwner(rs.getInt("animal.owner_id"));
		
		return an;
	}

	@Override
	public List<Animal> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
										"select * from animal "
										+"join client " 
										+"on client.id = animal.owner_id "
										);
			
			rs = st.executeQuery();
			
			List<Animal> list = new ArrayList<>();
			Map<Integer, Client> map = new HashMap<>();
			
			while(rs.next()) {
				
				Client cli = map.get(rs.getInt("client.id"));
				
				if(cli == null) {
					Client cl = instanceClient(rs);
					map.put(rs.getInt("client.id"), cl);
				}
				
				Animal an = new Animal();
				an.setName(rs.getString("animal.name"));
				an.setSpecies(rs.getString("species"));
				an.setId(rs.getInt("animal.id"));
				an.setOwner(rs.getInt("animal.owner_id"));
				an.setClient(cli);
				list.add(an);
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

	@Override
	public List<Animal> findAllAnimal(Client client) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
										"select * from animal "
										+"join client " 
										+"on client.id = animal.owner_id "
										+"where owner_id = ?"
										);
			
			st.setInt(1, client.getId());
			rs = st.executeQuery();
			
			List<Animal> list = new ArrayList<>();
			Map<Integer, Client> map = new HashMap<>();
			
			while(rs.next()) {
				
				Client cli = map.get(rs.getInt("client.id"));
				
				if(cli == null) {
					Client cl = instanceClient(rs);
					map.put(rs.getInt("client.id"), cl);
				}
				
				Animal an = new Animal();
				an.setName(rs.getString("animal.name"));
				an.setSpecies(rs.getString("species"));
				an.setId(rs.getInt("animal.id"));
				an.setOwner(rs.getInt("animal.owner_id"));
				an.setClient(cli);
				list.add(an);
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
	
	private Client instanceClient(ResultSet rs) throws SQLException {
		Client cl = new Client();
		cl.setName(rs.getString("name"));
		cl.setEmail(rs.getString("email"));
		cl.setId(rs.getInt("id"));
		cl.setAdress(rs.getString("adress"));
		cl.setTel(rs.getInt("tel"));
		
		return cl;
	}

}
