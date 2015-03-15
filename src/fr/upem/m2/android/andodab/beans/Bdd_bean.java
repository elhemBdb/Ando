package fr.upem.m2.android.andodab.beans;
public class Bdd_bean {
	private Integer bdd_id;
	private String bdd_name;
	
	
	
	public Bdd_bean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bdd_bean(String bdd_name) {
		super();
		this.bdd_name = bdd_name;
	}

	public Integer getBdd_id() {
		return bdd_id;
	}
	public void setBdd_id(Integer bdd_id) {
		this.bdd_id = bdd_id;
	}
	public String getBdd_name() {
		return bdd_name;
	}
	public void setBdd_name(String bdd_name) {
		this.bdd_name = bdd_name;
	}
	
	

}
