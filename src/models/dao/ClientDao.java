package models.dao;

import model.Client;

import java.util.List;

public interface ClientDao {
	
	void insert(Client obj);
	void update(Client obj);
	void deleteById(Integer id);
	Client findById(Integer id);
        Client findByEmail(String email, String pass);
	List<Client> findAll();
	List<Client> findAllClients(Client client);
}
