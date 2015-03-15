package fr.upem.m2.android.andodab.provider;

import android.provider.BaseColumns;

public class SharedInformation {

	public SharedInformation() {
	}

	
	public static final class Bdd implements BaseColumns {
		private Bdd() {
		}

		public static final String BDD_ID = "BDD_ID";
		public static final String BDD_NAME = "BDD_NAME";
	}
	
	
	public static final class Objet implements BaseColumns {
		private Objet() {
		}

		public static final String OBJET_ID = "OBJET_ID";
		public static final String OBJET_NAME = "OBJET_NAME";
		public static final String OBJET_SEALED="OBJET_SEALED";
		public static final String OBJET_ID_OBJET = "OBJET_OBJET_ID";
		public static final String OBJET_BDD_ID="OBJET_BDD_ID";
	}
	
	public static final class Attribut implements BaseColumns {
		private Attribut() {
		}

		public static final String ATTRIBUT_ID = "ATTRIBUT_ID";
		public static final String ATTRIBUT_NAME = "ATTRIBUT_NAME";
	}
	
	public static final class Valeur implements BaseColumns {
		private Valeur() {
		}

		public static final String VALEUR_ID = "VALEUR_ID";
		public static final String ATTRIBUT_ID = "VALEUR_ATTRIBUT_ID";
		public static final String OBJET_ID = "VALEUR_OBJET_ID";
		public static final String PRIMITIF_ID = "VALEUR_PRIMITIF_ID";
		public static final String FINAL_ID = "VALEUR_FINAL_ID";
		public static final String OBJET_TYPE_ID = "VALEUR_OBJET_TYPE_ID";		
	}
	
	public static final class Primitif implements BaseColumns {
		private Primitif() {
		}

		public static final String PRIMITIF_ID = "PRIMITIF_ID";
		public static final String PRIMITIF_NAME = "PRIMITIF_NAME";
	}
	
	public static final class Final implements BaseColumns {
		private Final() {
		}

		public static final String FINAL_ID = "FINAL_ID";
	}
	
	public static final class FinalInt implements BaseColumns {
		private FinalInt() {
		}

		public static final String FINAL_INT_ID = "FINAL_INT_ID";
		public static final String FINAL_INT_VALUE="FINAL_INT_VALUE";
		
	}
	
	public static final class FinalFloat implements BaseColumns {
		private FinalFloat() {
		}

		public static final String FINAL_FLOAT_ID = "FINAL_FLOAT_ID";
		public static final String FINAL_FLOAT_VALUE="FINAL_FLOAT_VALUE";
		
	}
	
	public static final class FinalString implements BaseColumns {
		private FinalString() {
		}

		public static final String FINAL_STRING_ID = "FINAL_STRING_ID";
		public static final String FINAL_STRING_VALUE="FINAL_STRING_VALUE";
		
	}
	
	public static final class Objet_Attribut implements BaseColumns {
		private Objet_Attribut(){
		}
			public static final String OBJET_ATTRIBUT_OBJET_ID="OA_OBJET_ID";
			public static final String OBJET_ATTRIBUT_ATTRIBUT_ID="OA_ATTRIBUT_ID";
		
		
	}
}
