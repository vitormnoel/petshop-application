package model;

public class Vet extends Client{

	private static final long serialVersionUID = 1L;
	
	private Integer vetID;
	
	public Vet() {
		
	}

	public Vet(String n, int id, int tel, String a, String e, String p, int v) {
		super(n, id, tel, a, e, p);
		this.setVetID(v);
	}

	public Integer getVetID() {
		return vetID;
	}

	public void setVetID(Integer vetID) {
		this.vetID = vetID;
	}
	
	@Override
	public String toString() {
		return "===>Veterinario \n[Nome: " + this.getName() + ", CPF: " + this.getId() + ", Tel: " + this.getTel()
				+ ", Veterinario-ID: "+ this.getVetID() +"]";
	}
}
