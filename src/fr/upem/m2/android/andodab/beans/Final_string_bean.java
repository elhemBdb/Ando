package fr.upem.m2.android.andodab.beans;

public class Final_string_bean {

	private Integer final_string_id;
	private String final_string_val;
	
	public Final_string_bean() {
		// TODO Auto-generated constructor stub
	}

	public Final_string_bean(Integer final_string_id, String final_string_val) {
		super();
		this.final_string_id = final_string_id;
		this.final_string_val = final_string_val;
	}

	public Final_string_bean(String final_string_val) {
		super();
		this.final_string_val = final_string_val;
	}

	public Integer getFinal_string_id() {
		return final_string_id;
	}

	public void setFinal_string_id(Integer final_string_id) {
		this.final_string_id = final_string_id;
	}

	public String getFinal_string_val() {
		return final_string_val;
	}

	public void setFinal_string_val(String final_string_val) {
		this.final_string_val = final_string_val;
	}
	
	
	
}
