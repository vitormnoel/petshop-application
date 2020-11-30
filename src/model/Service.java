package model;

import java.util.Scanner;

public class Service {
	
	private String name;
	private float price;
	private String hour;
	private Clinic clinic;
	private int IdClinic;
	
	Scanner ler = new Scanner(System.in);
	
	public Service() {
		
	}
	
	public void registerNewService() {
		String n;
		float p;
		String h;
		int id;
		
		System.out.println("===SERVIÇOS===");
		
		System.out.println("Nome: ");
		n = ler.next();
		this.setName(n);
		
		System.out.println("Preço: ");
		p = ler.nextFloat();
		this.setPrice(p);
		
		System.out.println("Hora: ");
		h = ler.next();
		this.setHour(h);
		
		System.out.println("Clinica [cnpj]: ");
		id = ler.nextInt();
		this.setIdClinic(id);
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
