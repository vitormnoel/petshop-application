package model;

public class Client_Animal {
	
	private int id;
	private Client id_client;
	private Animal id_animal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client getId_client() {
		return id_client;
	}
	public void setId_client(Client id_client) {
		this.id_client = id_client;
	}
	public Animal getId_animal() {
		return id_animal;
	}
	public void setId_animal(Animal id_animal) {
		this.id_animal = id_animal;
	}
	
	@Override
	public String toString() {
		return "[identificador: " + id + " | Cliente:" + id_client.getName() + ", Pet: " + id_animal.getName() + "]";
	}
}
