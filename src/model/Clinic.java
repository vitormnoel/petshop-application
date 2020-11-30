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
	
	public void newClinic() {
		String n;
		Integer t;
		String a;
		Integer c;
		
		System.out.println("===CLINICA===");
		
		System.out.println("Nome: ");
		n = ler.next();
		this.setName(n);
		
		System.out.println("Telefone: ");
		t = ler.nextInt();
		this.setTel(t);
		
		System.out.println("Endereço: ");
		a = ler.next();
		this.setAdress(a);
		
		System.out.println("CNPJ: ");
		c = ler.nextInt();
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
