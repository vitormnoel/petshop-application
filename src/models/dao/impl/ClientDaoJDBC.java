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
import model.Animal;
import model.Client;
import models.dao.ClientDao;

public class ClientDaoJDBC implements ClientDao{
	
	private Connection conn;
	
	public ClientDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Client obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into client "
										+"(name, id, tel, adress, email, pass) "
										+"values (?, ?, ?, ?, ?, ?)");
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			st.setInt(3, obj.getTel());
			st.setString(4, obj.getAdress());
			st.setString(5, obj.getEmail());
			st.setString(6, obj.getPass());
			
			int row = st.executeUpdate();
			
			if(row!=0) {
				System.out.println("Dados inseridos!");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Client obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("update client "
										+"set name= ?, tel= ?, adress= ?, email= ?, pass= ? "
										+"where id = ?");
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getTel());
			st.setString(3, obj.getAdress());
			st.setString(4, obj.getEmail());
			st.setString(5, obj.getPass());
			st.setInt(6, obj.getId());
			
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
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("delete from client where id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException("Cliente possui animais cadastrados. SQL Erro: "+e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Client findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from client where id = ? ");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) { //se tiver resultado ele mostra na posição 1
				Client cl = instanceCLient(rs);
						
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

	private Client instanceCLient(ResultSet rs) throws SQLException {
		Client cl = new Client();
		cl.setName(rs.getString("name"));
		cl.setEmail(rs.getString("email"));
		cl.setId(rs.getInt("id"));
		cl.setAdress(rs.getString("adress"));
		cl.setTel(rs.getInt("tel"));
		
		return cl;
	}

	@Override
	public List<Client> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from client ");
			
			rs = st.executeQuery();
			
			List<Client> list = new ArrayList<>();
			Map<Integer, Client> map = new HashMap<>();
			
			while(rs.next()) {
				Client cli = map.get(rs.getInt("client.id"));
				
				if(cli == null) {
					Client cl = instanceCLient(rs);
					map.put(rs.getInt("client.id"), cl);
					list.add(cl);
				}
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
	public List<Client> findAllClients(Client client) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
										"select * from client "
										+"join animal " 
										+"on client.id = animal.owner_id "
										+"where owner_id = ?"
										);
			
			st.setInt(1, client.getId());
			rs = st.executeQuery();
			
			List<Client> list = new ArrayList<>();
			Map<Integer, Animal> map = new HashMap<>();
			
			while(rs.next()) {
				
				Animal ani = map.get(rs.getInt("animal.id"));
				
				Client cli = new Client();
				cli.setName(rs.getString("client.name"));
				cli.setId(rs.getInt("client.id"));
				cli.setAdress(rs.getString("client.adress"));
				cli.setTel(rs.getInt("client.tel"));
				
				if(ani == null) {
					Animal an = new Animal();
					an.setName(rs.getString("animal.name"));
					an.setSpecies(rs.getString("species"));
					an.setId(rs.getInt("animal.id"));
					an.setOwner(rs.getInt("animal.owner_id"));
					an.setClient(cli);
					map.put(rs.getInt("animal.id"), an);
					System.out.println(an);
					System.out.println("[Nome: "+cli.getName()+" | Tel: "+cli.getTel()+"]");
				}
				
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
