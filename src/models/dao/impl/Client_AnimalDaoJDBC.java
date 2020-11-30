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
import model.Client_Animal;
import models.dao.Client_AnimalDao;

public class Client_AnimalDaoJDBC implements Client_AnimalDao{
	
	Connection conn = null;
	
	public Client_AnimalDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Client_Animal> All() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
										"select * from animal "
										+"join client "
										+"on client.id = owner_id "
										+"order by client.id "
										);
			
			rs = st.executeQuery();
			
			List<Client_Animal> list = new ArrayList<>();
			Map<Integer, Animal> map = new HashMap<>();
			
			while(rs.next()) {
				
				Client cli = instanceClient(rs);
				
				Animal an = map.get(rs.getInt("animal.id"));
				
				if(an == null) {
					an = new Animal();
					an.setName(rs.getString("animal.name"));
					an.setSpecies(rs.getString("species"));
					an.setId(rs.getInt("animal.id"));
					an.setOwner(rs.getInt("animal.owner_id"));
					an.setClient(cli);
					
					map.put(rs.getInt("animal.id"), an);
				}
				
				Client_Animal ca = new Client_Animal();
				ca.setId(rs.getInt("animal.id"));
				ca.setId_animal(an);
				ca.setId_client(cli);
				
				list.add(ca);
				
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
		cl.setName(rs.getString("client.name"));
		cl.setEmail(rs.getString("client.email"));
		cl.setId(rs.getInt("client.id"));
		cl.setAdress(rs.getString("client.adress"));
		cl.setTel(rs.getInt("client.tel"));
		
		return cl;
	}
}
