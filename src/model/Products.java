package model;

import java.util.Scanner;

public class Products {
    private String name;
    private String category;
    private int amount;
    private double price;
    private Integer cnpj;
    private Clinic clinic;
    
	Scanner ler = new Scanner(System.in);
    
    public Products() {
    	
    }
    
    public void produtos(){
        String n;
        String c;
        int a;
        double p;
        
        System.out.println("----CADASTRAR PRODUTOS----");
        System.out.println("Nome: ");
        n = ler.nextLine();
        this.setName(n);
        
        System.out.println("Categoria: ");
        c = ler.nextLine();
        this.setcategory(c);
        
        System.out.println("Quantidade: ");
        a = ler.nextInt();
        this.setamount(a);
        
        System.out.println("Preço: ");
        p = ler.nextDouble();
        this.setPrice(p);
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public void setcategory(String d){
        this.category = d;
    }
    
    public void setamount(int a){
        this.amount = a;
    }
    
    public void setPrice(double p){
        this.price = p;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getcategory(){
        return this.category;
    }
    
    public int getamount(){
        return this.amount;
    }
    
    public double getPrice(){
        return this.price;
    }

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	
	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	@Override
	public String toString() {
		return "\nProdutos=> \n[Nome: " + name + ", Categoria: " + category + ", Quantidade: " + amount + ", Preço: " + price + "]\n"+clinic;
	}
}
