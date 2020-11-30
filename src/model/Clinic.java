package model;

import java.util.Scanner;

public class Clinic {
	
	private String name;
	private Integer tel;
	private String adress;
	private Integer cnpj;
	
	Scanner ler = new Scanner(System.in);
	
	public Clinic() {
		
	}
	
	public void registerNewClinic() {
		
		System.out.println("===CLINICA===");
		ler.nextLine();
		
		System.out.println("Nome: ");
		String n = ler.nextLine();
		this.setName(n);
		
		System.out.println("Telefone: ");
		int t = ler.nextInt();
		this.setTel(t);
		
		ler.nextLine();
		
		System.out.println("Endereço: ");
		String a = ler.nextLine();
		this.setAdress(a);
		
		System.out.println("CNPJ: ");
		int c = ler.nextInt();
		this.setCnpj(c);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTel() {
		return tel;
	}
	public void setTel(Integer tel) {
		this.tel = tel;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Integer getCnpj() {
		return cnpj;
	}
	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "\nClinica=> [Nome da filial: " + name + ", Tel: " + tel + ", Endereço: " + adress + ", CNPJ: " + cnpj + "]";
	}
}
