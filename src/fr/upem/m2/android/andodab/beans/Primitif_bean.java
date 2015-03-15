package fr.upem.m2.android.andodab.beans;

public class Primitif_bean {

	private Integer primitif_id;
	private String primitif_name;
	
	public Primitif_bean() {
		// TODO Auto-generated constructor stub
	}

	public Primitif_bean(String primitif_name) {
		super();
		this.primitif_name = primitif_name;
	}
	
	

	public Primitif_bean(Integer primitif_id, String primitif_name) {
		super();
		this.primitif_id = primitif_id;
		this.primitif_name = primitif_name;
	}

	public Integer getPrimitif_id() {
		return primitif_id;
	}

	public void setPrimitif_id(Integer primitif_id) {
		this.primitif_id = primitif_id;
	}

	public String getPrimitif_name() {
		return primitif_name;
	}

	public void setPrimitif_name(String primitif_name) {
		this.primitif_name = primitif_name;
	}
	
	
}
