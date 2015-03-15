package fr.upem.m2.android.andodab.beans;

public class Final_Float_bean {

	
	private Integer final_int_id;
	private Float final_int_val;
	
	public Final_Float_bean() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public Final_Float_bean(Float final_int_val) {
		super();
		this.final_int_val = final_int_val;
	}




	public Final_Float_bean(Integer final_int_id, Float final_int_val) {
		super();
		this.final_int_id = final_int_id;
		this.final_int_val = final_int_val;
	}




	public Integer getFinal_int_id() {
		return final_int_id;
	}

	public void setFinal_int_id(Integer final_int_id) {
		this.final_int_id = final_int_id;
	}

	public Float getFinal_int_val() {
		return final_int_val;
	}

	public void setFinal_int_val(Float final_int_val) {
		this.final_int_val = final_int_val;
	}
	
	
}
