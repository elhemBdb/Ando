package fr.upem.m2.android.andodab.beans;

public class Objet_attribut_bean {

	private Integer oa_objet_id;
	private Integer oa_attribut_id;
	
	
	public Objet_attribut_bean() {
		// TODO Auto-generated constructor stub
	}


	public Objet_attribut_bean(Integer oa_objet_id, Integer oa_attribut_id) {
		super();
		this.oa_objet_id = oa_objet_id;
		this.oa_attribut_id = oa_attribut_id;
	}


	public Integer getOa_objet_id() {
		return oa_objet_id;
	}


	public void setOa_objet_id(Integer oa_objet_id) {
		this.oa_objet_id = oa_objet_id;
	}


	public Integer getOa_attribut_id() {
		return oa_attribut_id;
	}


	public void setOa_attribut_id(Integer oa_attribut_id) {
		this.oa_attribut_id = oa_attribut_id;
	}
	
	
}
