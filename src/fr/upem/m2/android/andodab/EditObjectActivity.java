package fr.upem.m2.android.andodab;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
//import android.view.View.OnClickListener;

@SuppressLint("NewApi") public class EditObjectActivity extends Activity {
	private ArrayList<String> list_BD;
	private ArrayList<String> list_object;
	private Spinner sp_db;
	private Spinner sp_object;
	private String selected_bd;
	private Button btn_delete;
	private Button btn_modif;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_attribute);		
		initView();
	
		initEventView();
	}
	
	public void initView() {
		sp_db = (Spinner) findViewById(R.id.id_spinner_base);
		btn_delete = (Button) findViewById(R.id.id_btn_delete_ob);
		btn_modif = (Button) findViewById(R.id.id_btn_modif_ob);
		sp_object = (Spinner) findViewById(R.id.id_spinner_object);
		list_BD = new ArrayList<String>();
		list_BD.add("DB1");
		list_BD.add("DB2");
		list_BD.add(0,"");
		ArrayAdapter<String> dbNameAdapter = new ArrayAdapter<String>(EditObjectActivity.this,android.R.layout.simple_spinner_item,list_BD);
		dbNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_db.setAdapter(dbNameAdapter);		    
		sp_db.setSelection(sp_db.getSelectedItemPosition(), false);
	}
	
	public void initEventView() {
		sp_db.setOnItemSelectedListener(bd_selected);
		btn_delete.setOnClickListener( btn_delete_click);
		btn_modif.setOnClickListener( btn_modif_click);
	}
	
	private android.view.View.OnClickListener btn_delete_click = new View.OnClickListener() {

		
		@Override
		public void onClick(View v) {
			int id=0;
		showDialog(id);

		}

		
	};
private android.view.View.OnClickListener btn_modif_click = new View.OnClickListener() {

		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getApplicationContext(),	EditValueObjectActivity.class);
			startActivity(intent);

		}

		
	};

	
	
	
	private OnItemSelectedListener bd_selected = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			selected_bd = list_BD.get(position);
			list_object = new ArrayList<String>();
			list_object.add("Aucun");
			list_object.add("objet 1");
			list_object.add("objet 2");
			list_object.add("objet 3");
			
			//parentList.removeAllViews();
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,list_object);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp_object.setAdapter(adapter);	
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
	};
	

	
	  @Override
	  public Dialog onCreateDialog (int id) {
		  Dialog dialog;
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			 
				builder.setMessage("Voulez-vous supprimer le sms ?");
				builder.setCancelable(false);
				builder.setTitle("Confirmation");
				builder.setPositiveButton("oui", new DialogInterface.OnClickListener() {					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});
				
			 
				builder.setNegativeButton("NON",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
			 
				dialog = builder.create();
				return dialog;
				
	  }
	  
	  @Override
	  public void onPrepareDialog (int id, Dialog box) {
	  
	      box.setTitle("suppression de !"+id);
	     //On ne s'intéresse pas au cas où l'identifiant vaut 1, puisque cette boîte affiche le même texte à chaque lancement
	  }
		
	
						
		
	
		


		

}
