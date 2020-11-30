package model;

public class Client extends User{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer id;
	private Integer tel;
	private String adress;
	
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

	@Override
	public String toString() {
		return "\nCliente=> \n[Nome: " + name + ", CPF: " + id + ", Tel: " + tel
				+ ", Endereço: (" + adress + ")]";
	}

	
}
