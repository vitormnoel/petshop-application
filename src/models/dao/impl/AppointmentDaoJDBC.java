package models.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.Animal;
import model.Appointment;
import model.Client;
import model.Vet;
import models.dao.AppointmentDao;

public class AppointmentDaoJDBC implements AppointmentDao{
	
	Connection conn = null;
	
	public AppointmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Appointment obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into appointment (date_query, hour_query, id, id_vet) "
										+"values (?, ?, ?, ?)"
										);
			st.setString(1, obj.getDate());
			st.setString(2, obj.getHour());
			st.setInt(3, obj.getAnimal());
			st.setInt(4, obj.getVet());
			
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
	public Appointment findByAnimalName(String name) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from appointment "
					+"join vet "
					+"on vet.vetId = appointment.id_vet "
					+"join animal "
					+"on animal.id = appointment.id "
					+ "join client "
					+ "on client.id = animal.owner_id "
					+ "where animal.name = ?");
			
			st.setString(1, name);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Client cli = instanceClient(rs);
				Animal an = instanceAnimal(rs);
				Vet v = instanceVet(rs);
				Appointment ap = instanceAppointment(rs, an, v, cli);

				return ap;
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		return null;
	}
	
	

	private Appointment instanceAppointment(ResultSet rs, Animal an, Vet v, Client cli) throws SQLException{
		Appointment ap = new Appointment();
		ap.setDate(rs.getString("date_query"));
		ap.setHour(rs.getString("hour_query"));
		ap.setAnimal(rs.getInt("animal.id"));
		ap.setVet(rs.getInt("vet.vetID"));
		ap.setAnimalObj(an);
		ap.setVetObj(v);
		ap.setCli(cli);
		
		return ap;
	}

	private Vet instanceVet(ResultSet rs) throws SQLException{
		Vet v = new Vet();
		v.setName(rs.getString("vet.name"));
		v.setAdress(rs.getString("adress"));
		v.setId(rs.getInt("id"));
		v.setTel(rs.getInt("vet.tel"));
		v.setVetID(rs.getInt("vet.vetID"));
		
		return v;
	}

	private Animal instanceAnimal(ResultSet rs) throws SQLException{
		Animal an = new Animal();
		an.setName(rs.getString("animal.name"));
		an.setSpecies(rs.getString("species"));
		an.setId(rs.getInt("animal.id"));
		an.setOwner(rs.getInt("animal.owner_id"));
		
		return an;
	}

	private Client instanceClient(ResultSet rs) throws SQLException{
		Client cli = new Client();
		cli.setName(rs.getString("client.name"));
		cli.setAdress(rs.getString("client.adress"));
		cli.setId(rs.getInt("client.id"));
		cli.setTel(rs.getInt("client.tel"));
		
		return cli;
	}

	@Override
	public List<Appointment> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
										"select * from appointment "
										+"join animal "
										+ "on animal.id = appointment.id "
										+"join client " 
										+"on client.id = animal.owner_id "
										+"join vet "
										+"on vet.vetID = appointment.id_vet "
										+"order by date_query "
										);
			
			rs = st.executeQuery();
			
			List<Appointment> list = new ArrayList<>();
			
			while(rs.next()) {
				Appointment ap = new Appointment();
				Client cli = instanceClient(rs);
				Animal an = instanceAnimal(rs);
				Vet vet = instanceVet(rs);
				ap.setCli(cli);
				ap.setDate(rs.getString("appointment.date_query"));
				ap.setHour(rs.getString("appointment.hour_query"));
				ap.setVetObj(vet);
				ap.setAnimalObj(an);
				
				list.add(ap);
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
