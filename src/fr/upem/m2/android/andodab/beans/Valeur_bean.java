package fr.upem.m2.android.andodab.beans;

public class Valeur_bean {
	private Integer valeur_id;
	private Integer valeur_attribut_id;
	private Integer valeur_objet_fils_id;
	private Integer valeur_primitif_id;
	private Integer valeur_final_id;
	private Integer valeur_obj_type_id;
	
	
	
	
	
	public Valeur_bean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Valeur_bean(Integer valeur_id, Integer valeur_attribut_id,
			Integer valeur_objet_fils_id, Integer valeur_primitif_id,
			Integer valeur_final_id, Integer valeur_obj_type_id) {
		super();
		this.valeur_id = valeur_id;
		this.valeur_attribut_id = valeur_attribut_id;
		this.valeur_objet_fils_id = valeur_objet_fils_id;
		this.valeur_primitif_id = valeur_primitif_id;
		this.valeur_final_id = valeur_final_id;
		this.valeur_obj_type_id = valeur_obj_type_id;
	}



	public Valeur_bean(Integer valeur_attribut_id, Integer valeur_objet_fils_id,
			Integer valeur_primitif_id, Integer valeur_final_id,
			Integer valeur_obj_type_id) {
		super();
		this.valeur_attribut_id = valeur_attribut_id;
		this.valeur_objet_fils_id = valeur_objet_fils_id;
		this.valeur_primitif_id = valeur_primitif_id;
		this.valeur_final_id = valeur_final_id;
		this.valeur_obj_type_id = valeur_obj_type_id;
	}



	public Integer getValeur_id() {
		return valeur_id;
	}
	public void setValeur_id(Integer valeur_id) {
		this.valeur_id = valeur_id;
	}
	public Integer getValeur_attribut_id() {
		return valeur_attribut_id;
	}
	public void setValeur_attribut_id(Integer valeur_attribut_id) {
		this.valeur_attribut_id = valeur_attribut_id;
	}
	public Integer getValeur_objet_fils_id() {
		return valeur_objet_fils_id;
	}
	public void setValeur_objet_fils_id(Integer valeur_objet_fils_id) {
		this.valeur_objet_fils_id = valeur_objet_fils_id;
	}
	public Integer getValeur_primitif_id() {
		return valeur_primitif_id;
	}
	public void setValeur_primitif_id(Integer valeur_primitif_id) {
		this.valeur_primitif_id = valeur_primitif_id;
	}
	public Integer getValeur_final_id() {
		return valeur_final_id;
	}
	public void setValeur_final_id(Integer valeur_final_id) {
		this.valeur_final_id = valeur_final_id;
	}
	public Integer getValeur_obj_type_id() {
		return valeur_obj_type_id;
	}
	public void setValeur_obj_type_id(Integer valeur_obj_type_id) {
		this.valeur_obj_type_id = valeur_obj_type_id;
	}
	
	
	

}
