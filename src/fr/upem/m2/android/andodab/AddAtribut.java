package fr.upem.m2.android.andodab;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddAtribut extends Activity {

	private Spinner attribType,objectList,primitfList;
	private TextView valueLbl,objetLbl,primitifLbl;
	private EditText valueAttrib,nomAttrib;
	private String attribFinalValue;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_atribut);
		
		attribType = (Spinner) findViewById(R.id.attribType);
		objectList = (Spinner) findViewById(R.id.objectAttrib);
		primitfList = (Spinner) findViewById(R.id.primitifAttrib);
		
		valueLbl = (TextView) findViewById(R.id.valueTxt);
		objetLbl = (TextView) findViewById(R.id.objectTxtField);
		primitifLbl = (TextView) findViewById(R.id.primitifTxtField);
		
		valueAttrib = (EditText) findViewById(R.id.attribValueTxt);
		nomAttrib = (EditText) findViewById(R.id.nameAttributTxt);
		
		
		 
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.type_attribut, android.R.layout.simple_spinner_item);
		 
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		 
		attribType.setAdapter(adapter);
		
		attribType.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

             showAttribType(position);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		String db = getIntent().getStringExtra("db");
		//alimenter la liste des objets selon la db selectionné
		//appel fonction qui retourne les objet de la base
		ArrayList<String> listObjetDb = new ArrayList<String>();
		listObjetDb.add("objet 1");
		listObjetDb.add("objet 2");
		listObjetDb.add("objet 3");
		
		ArrayAdapter<String> objectListAdaper = new ArrayAdapter<String>(AddAtribut.this,android.R.layout.simple_spinner_item,listObjetDb);
		objectListAdaper.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		objectList.setAdapter(objectListAdaper);	
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_atribut, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
	public void showAttribType(int index){
		
		objetLbl.setVisibility(View.INVISIBLE);
		objectList.setVisibility(View.INVISIBLE);
		primitifLbl.setVisibility(View.INVISIBLE);
		primitfList.setVisibility(View.INVISIBLE);
		valueLbl.setVisibility(View.INVISIBLE);
		valueAttrib.setVisibility(View.INVISIBLE);
		
		
		switch (index) {
		case 1:		
			objetLbl.setVisibility(View.VISIBLE);
			objectList.setVisibility(View.VISIBLE);
			break;

		case 2:		
			primitifLbl.setVisibility(View.VISIBLE);
			primitfList.setVisibility(View.VISIBLE);
			break;
		case 3:			
			valueLbl.setVisibility(View.VISIBLE);
			valueAttrib.setVisibility(View.VISIBLE);
			break;
		}
		
		
	}
	
	
	public void backToCreateObject(View v){
		
		Intent intent = new Intent(getApplicationContext(),CreateObjectActivity.class);
		setResult(RESULT_CANCELED, intent);
		finish();
		 
		
	}
	
public void validerAjoutAttrib(View v){
		String value = null;
		Intent intent = new Intent(getApplicationContext(),CreateObjectActivity.class);
		intent.putExtra("Nom", nomAttrib.getText().toString());
		 
		if(valueAttrib.getVisibility() == View.VISIBLE){
			value = valueAttrib.getText().toString();
		}
		else
			if(objectList.getVisibility() == View.VISIBLE){
				value = objectList.getSelectedItem().toString();
			}
			else
				if(primitfList.getVisibility() == View.VISIBLE)
				{
					value = primitfList.getSelectedItem().toString();
				}
		intent.putExtra("Value", value);
			
		setResult(RESULT_OK,intent);
		finish();
		
	}
	
}
