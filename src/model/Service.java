package model;

import java.util.Scanner;

public class Service {
	
	private String name;
	private float price;
	private String hour;
	private Clinic clinic;
	private int id;
	private int IdClinic;
	
	Scanner ler = new Scanner(System.in);
	
	public Service() {
		
	}
	
	public void registerNewService() {
		
		System.out.println("===SERVIÇOS===");
		ler.nextLine();
		
		System.out.println("Nome: ");
		String n = ler.nextLine();
		this.setName(n);
		
		System.out.println("Preço: ");
		float p = ler.nextFloat();
		this.setPrice(p);
		
		ler.nextLine();
		
		System.out.println("Hora: ");
		String h = ler.nextLine();
		this.setHour(h);
		
		System.out.println("Clinica [cnpj]: ");
		int id = ler.nextInt();
		this.setIdClinic(id);
		
		ler.reset();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public int getIdClinic() {
		return IdClinic;
	}

	public void setIdClinic(int idClinic) {
		IdClinic = idClinic;
	}

	@Override
	public String toString() {
		return "\nServiço=>\n[Nome: " + name + ", Preço: " + price + ", Inicio do atendimento: " + hour +"]";
	}
}
