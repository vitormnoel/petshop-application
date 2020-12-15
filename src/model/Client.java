package model;

import java.util.Scanner;

/**
 *
 * @author Vitor Manoel
 */
public class Client extends User{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer id;
	private Integer tel;
	private String adress;
        private int Controler;
	
	Scanner ler = new Scanner(System.in);
	
	public Client() {
	}
	
	public Client(String n, int id, int tel, String a, String e, String p) {
		this.setName(n);
		this.setId(id);
		this.setTel(tel);
		this.setAdress(a);
		this.setEmail(e);
		this.setPass(p);
	}
	
	public void registerNewUser() {
		
		System.out.println("****************");
		System.out.println("--> CADASTRO");
		
		System.out.print("Nome: ");
		String n = ler.nextLine();
		this.setName(n);
		ler.reset();

		System.out.print("Endere�o: ");
		String a = ler.nextLine();
		this.setAdress(a);
		ler.reset();
		
		System.out.print("CPF: ");
		int id1 = ler.nextInt();
		this.setId(id1);
		ler.reset();
		
		System.out.print("Telefone: ");
		int t = ler.nextInt();
		this.setTel(t);
		ler.reset();
		
		System.out.println("");
		ler.nextLine();
		
		System.out.print("Email: ");
		String e = ler.nextLine();
		this.setEmail(e);
		ler.reset();
		
		System.out.print("Senha: ");
		String p = ler.nextLine();
		this.setPass(p);
		ler.reset();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

    public int getControler() {
        return Controler;
    }

    public void setControler(int Controler) {
        this.Controler = Controler;
    }
       
	@Override
	public String toString() {
		return "\nCliente=> \n[Nome: " + name + ", CPF: " + id + ", Tel: " + tel
				+ ", Endere�o: (" + adress + ")]";
	}

	
}
