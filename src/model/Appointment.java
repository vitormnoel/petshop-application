package model;

import java.util.Scanner;

public class Appointment {
	
	private String date;
	private String hour;
	private Integer vet;
	private Integer animal;
	private Animal animalObj;
	private Vet vetObj;
	private Client cli;
	
	Scanner ler = new Scanner(System.in);
	
	public Appointment() {
		
	}
	
	public void newAppointment() {
		String d;
		String h;
		Integer v;
		Integer a;
		
		System.out.println("===CONSULTAS===");
		
		System.out.println("Data: ");
		d = ler.nextLine();
		this.setDate(d);
		
		System.out.println("Hora: ");
		h = ler.nextLine();
		this.setHour(h);
		
		System.out.println("Veterinario: ");
		v = ler.nextInt();
		this.setVet(v);

		System.out.println("Animal: ");
		a = ler.nextInt();
		this.setAnimal(a);
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public Integer getVet() {
		return vet;
	}
	public void setVet(Integer vet) {
		this.vet = vet;
	}
	public Integer getAnimal() {
		return animal;
	}
	public void setAnimal(Integer animal) {
		this.animal = animal;
	}

	public Animal getAnimalObj() {
		return animalObj;
	}

	public void setAnimalObj(Animal animalObj) {
		this.animalObj = animalObj;
	}

	public Vet getVetObj() {
		return vetObj;
	}

	public void setVetObj(Vet vetObj) {
		this.vetObj = vetObj;
	}

	public Client getCli() {
		return cli;
	}

	public void setCli(Client cli) {
		this.cli = cli;
	}

	@Override
	public String toString() {
		return "\nConsulta=> \nData: " + date + ", Hora: " + hour + ", \n-----\nAnimal: "
				+ animalObj.getName() + " | Especie: "+animalObj.getSpecies()+"\n-----\nVeterinario: " 
				+ vetObj.getName() + " | Vet-ID: "+vetObj.getVetID()+"\n-----\nDono: "+ cli.getName()+" | Tel: "+cli.getTel();
	}
}
