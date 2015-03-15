package fr.upem.m2.android.andodab;

import java.util.ArrayList;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class EditValueObjectActivity extends Activity {
	private LinearLayout linearLayout ;
	private LinearLayout simplelinear;
	Button btOk;
	Button btno;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		   super.onCreate(savedInstanceState);
	        // creating LinearLayout
	        LinearLayout linLayout = new LinearLayout(this);
	        // specifying vertical orientation
	        linLayout.setOrientation(LinearLayout.VERTICAL);
	        // creating LayoutParams  
	        LayoutParams linLayoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT); 
	        // set LinearLayout as a root element of the screen 
	        setContentView(linLayout, linLayoutParam);
	        
	        //debut de la boucle pour ajouter les attributs
	        LinearLayout firstLayout = new LinearLayout(this);
	        // specifying vertical orientation
	        firstLayout.setOrientation(LinearLayout.HORIZONTAL);
	        LayoutParams firstParam = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT); 
	        firstLayout.setLayoutParams(firstParam);    
	        
	        LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);	        
	        TextView tv = new TextView(this);
	        tv.setText("nom de l'attribut");
	        tv.setLayoutParams(lpView);
	        firstLayout.addView(tv);	        
	        EditText et = new EditText(this);
	        et.setText("sf");
	        et.setLayoutParams(lpView);
	        firstLayout.addView(et, lpView);
	        
	        // second layout
	        LinearLayout secondLayout = new LinearLayout(this);
	        secondLayout.setOrientation(LinearLayout.HORIZONTAL);	       
	        secondLayout.setLayoutParams(firstParam);  
	        TextView tv1 = new TextView(this);
	        tv1.setText("nom de l'attribut");
	        tv1.setLayoutParams(lpView);
	        secondLayout.addView(tv1);	        
	        EditText et1 = new EditText(this);
	        et1.setText("te");
	        secondLayout.addView(et1, lpView);
	        EditText et2 = new EditText(this);
	        et2.setText("te2");
	        secondLayout.addView(et2, lpView);
	        
	        
	        //fin de la boucle
	        
	        //bouton ok et annuler
	        LinearLayout buttonLayout = new LinearLayout(this);
	        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);	       
	        buttonLayout.setLayoutParams(firstParam);
	        LinearLayout.LayoutParams rightGravityParams = new LinearLayout.LayoutParams(
	                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	        rightGravityParams.gravity = Gravity.END;
	        LinearLayout.LayoutParams leftGravityParams = new LinearLayout.LayoutParams(
	                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	        rightGravityParams.gravity = Gravity.START;
	        
	         btOk = new Button(this);
	        btOk.setText("Ok");
	        btOk.setLayoutParams(leftGravityParams);
	        
	        btOk.setBackgroundColor(getResources().getColor(R.color.success));
	        Drawable imgn = getBaseContext().getResources().getDrawable( R.drawable.ok );
	        imgn.setBounds( 0, 0, 60, 60 );
	        btOk.setCompoundDrawables( imgn, null, null, null );
	        btOk.setWidth(RESULT_OK);
	        btOk.setHeight(RESULT_OK);

	        
	        

	        buttonLayout.addView(btOk,leftGravityParams);	 
	        
	         btno = new Button(this);
	        btno.setText("Annuler");
	        btno.setWidth(RESULT_OK);
	        btno.setHeight(RESULT_OK);
	        btno.setBackgroundColor(getResources().getColor(R.color.no));
	        Drawable img = getBaseContext().getResources().getDrawable( R.drawable.annuler );
	        img.setBounds( 0, 0, 60, 60 );
	        btno.setCompoundDrawables( img, null, null, null );

	        buttonLayout.addView(btno,rightGravityParams);	
	       
	      
	        //ajout des layout ds le layout principal
	        linLayout.addView(firstLayout);
	        linLayout.addView(secondLayout);
	        linLayout.addView(buttonLayout);
	        
	        
	        initEventView() ;

	}
	
	
	
	public void initEventView() {
		btOk.setOnClickListener(btOk_click);
		btno.setOnClickListener(btno_click);
		
//
//		btn_exit.setOnClickListener( btn_exit_click);
//		btn_validate.setOnClickListener( btn_validate_click);
		
	}
	

	private android.view.View.OnClickListener btOk_click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getApplicationContext(),
					EditObjectActivity.class);
			startActivity(intent);
			
		}
		
	};
	
	private android.view.View.OnClickListener btno_click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getApplicationContext(),
					EditObjectActivity.class);
			startActivity(intent);
			
		}
		
	};

}
