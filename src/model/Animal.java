package model;

import java.util.Scanner;

public class Animal {
	
	private Integer id;
	private String name;
	private Integer owner;
	private String species;
	private Client client;
	
	Scanner ler = new Scanner(System.in);
	
	public Animal() {
		
	}
	
	public Animal(int id, String name, Integer owner, String species) {
		this.setId(id);
		this.setName(name);
		this.setOwner(owner);
		this.setSpecies(species);
	}



	public void registerAnimal() {
		
		System.out.println("===REGISTRAR ANIMAL===");
		ler.nextLine();
		
		System.out.println("Nome: ");
		String n = ler.nextLine();
		this.setName(n);
		
		System.out.println("Identificador: ");
		int i = ler.nextInt();
		this.setId(i);
		
		System.out.println("[CPF] Dono: ");
		int o = ler.nextInt();
		this.setOwner(o);
		
		System.out.println("Especie: ");
		String s = ler.next();
		this.setSpecies(s);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOwner() {
		return owner;
	}
	public void setOwner(Integer owner) {
		this.owner = owner;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "\nAnimal=> \n[Animal-ID: " + id + ", Nome: " + name + ", Especie: " + species +", ID dono: "+owner+"]";
	}
}
