package fr.upem.m2.android.andodab;





import fr.upem.m2.android.andodab.R;
import fr.upem.m2.android.andodab.DAO.BddOperations;
import fr.upem.m2.android.andodab.provider.SharedInformation.Primitif;
import fr.upem.m2.android.andodab.provider.TutosAndroidProvider;
import fr.upem.m2.android.andodab.provider.SharedInformation.Bdd;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ContentProviderExempleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accueil);
		test();
		//insertRecords();
		displayContentProvider();
		
	}
	
	private void test(){
		BddOperations bdd = new BddOperations(this);
		bdd.CreateBdd("juba");
		
	}

	private void displayContentProvider() {
		
//		BddOperations bddOp= new BddOperations();
//		int i=bddOp.getListPrimitif().size();
//		Toast.makeText(ContentProviderExempleActivity.this, "taille :"+ i+ "",
//				Toast.LENGTH_LONG).show();
		
		
		String columnsTest[] = new String[] { Bdd.BDD_ID,Bdd.BDD_NAME };
		Uri mContactsTest = TutosAndroidProvider.CONTENT_URI_BDD;
		Cursor curTest = managedQuery(mContactsTest, columnsTest, null, null, null);
		Toast.makeText(ContentProviderExempleActivity.this, curTest.getCount() + "",
				Toast.LENGTH_LONG).show();

		if (curTest.moveToFirst()) {
			String name = null;
			do {
				name = curTest.getString(curTest.getColumnIndex(Bdd.BDD_ID)) + " " +
						 
						curTest.getString(curTest.getColumnIndex(Bdd.BDD_NAME));
				Toast.makeText(this, name + " ", Toast.LENGTH_LONG).show();
			} while (curTest.moveToNext());
			
			
		}
		
		
		
		
		
//		String columns[] = new String[] { Cours.COURS_ID, Cours.COURS_NAME, Cours.COURS_DESC };
//		Uri mContacts = TutosAndroidProvider.CONTENT_URI_COURS;
//		Cursor cur = managedQuery(mContacts, columns, null, null, null);
//		Toast.makeText(ContentProviderExempleActivity.this, cur.getCount() + "",
//				Toast.LENGTH_LONG).show();
//
//		if (cur.moveToFirst()) {
//			String name = null;
//			do {
//				name = cur.getString(cur.getColumnIndex(Cours.COURS_ID)) + " " +
//						cur.getString(cur.getColumnIndex(Cours.COURS_NAME)) + " " + 
//						cur.getString(cur.getColumnIndex(Cours.COURS_DESC));
//				Toast.makeText(this, name + " ", Toast.LENGTH_LONG).show();
//			} while (cur.moveToNext());
//		}
		
		
		

	}

	private void insertRecords() {
		
		ContentValues contact = new ContentValues();


		contact.clear();
		contact.put(Bdd.BDD_NAME, "TEST izan");
		getContentResolver().insert(TutosAndroidProvider.CONTENT_URI_BDD, contact);
		
		contact.clear();
		contact.put(Primitif.PRIMITIF_NAME, "Primitif test");
		getContentResolver().insert(TutosAndroidProvider.CONTENT_URI_PRIMITIF, contact);

		
		
	}
}