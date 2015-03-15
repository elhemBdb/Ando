package fr.upem.m2.android.andodab.beans;

public class Attribut_bean {
	private Integer attribut_id;
	private String attribut_name;
	public Attribut_bean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Attribut_bean(Integer attribut_id, String attribut_name) {
		super();
		this.attribut_id = attribut_id;
		this.attribut_name = attribut_name;
	}

	public Attribut_bean(String attribut_name) {
		super();
		this.attribut_name = attribut_name;
	}
	public Integer getAttribut_id() {
		return attribut_id;
	}
	public void setAttribut_id(Integer attribut_id) {
		this.attribut_id = attribut_id;
	}
	public String getAttribut_name() {
		return attribut_name;
	}
	public void setAttribut_name(String attribut_name) {
		this.attribut_name = attribut_name;
	}
	

}
