package model;

public class Client {
	
	private String name;
	private String email;
	private String pass;
	private int card;
	
	public Client() {
	}
	
	public Client(String n, String e, String p, int c) {
		this.setName(n);
		this.setEmail(e);
		this.setPass(p);
		this.setCard(c);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}
	

	@Override
	public String toString() {
		return "Cliente [Nome= " + name + ", email= " + email +"]";
	}
	
	
}
