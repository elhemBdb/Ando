package fr.upem.m2.android.andodab.beans;
public class Objet_bean {
	private Integer objet_id;
	private String objet_nom;
	private Integer objet_objet_id;
	private Integer objet_sealed;
	private Integer objet_bdd_id;
	public Objet_bean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Objet_bean(String objet_nom, Integer objet_objet_id) {
		super();
		this.objet_nom = objet_nom;
		this.objet_objet_id = objet_objet_id;
	}
	public Integer getObjet_id() {
		return objet_id;
	}
	public void setObjet_id(Integer objet_id) {
		this.objet_id = objet_id;
	}
	public String getObjet_nom() {
		return objet_nom;
	}
	public void setObjet_nom(String objet_nom) {
		this.objet_nom = objet_nom;
	}
	public Integer getObjet_objet_id() {
		return objet_objet_id;
	}
	public void setObjet_objet_id(Integer objet_objet_id) {
		this.objet_objet_id = objet_objet_id;
	}
	public Integer getObjet_bdd_id() {
		return objet_bdd_id;
	}
	public void setObjet_bdd_id(Integer objet_bdd_id) {
		this.objet_bdd_id = objet_bdd_id;
	}
	public Integer getObjet_sealed() {
		return objet_sealed;
	}
	public void setObjet_sealed(Integer objet_sealed) {
		this.objet_sealed = objet_sealed;
	}
	
	

}
