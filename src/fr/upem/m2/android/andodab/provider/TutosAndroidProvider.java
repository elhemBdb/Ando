package fr.upem.m2.android.andodab.provider;

import fr.upem.m2.android.andodab.provider.SharedInformation.*;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class TutosAndroidProvider extends ContentProvider {
	public static final String PROVIDER_NAME = "fr.upem.m2.android.andodab.provider";

	public static final Uri CONTENT_URI_BDD = Uri.parse("content://"
			+ PROVIDER_NAME + "/bdd");
	public static final Uri CONTENT_URI_OBJET = Uri.parse("content://"
			+ PROVIDER_NAME + "/objet");

	public static final Uri CONTENT_URI_ATTRIBUT = Uri.parse("content://"
			+ PROVIDER_NAME + "/attribut");
	public static final Uri CONTENT_URI_VALEUR = Uri.parse("content://"
			+ PROVIDER_NAME + "/valeur");

	public static final Uri CONTENT_URI_PRIMITIF = Uri.parse("content://"
			+ PROVIDER_NAME + "/primitif");
	public static final Uri CONTENT_URI_FINAL = Uri.parse("content://"
			+ PROVIDER_NAME + "/final");

	public static final Uri CONTENT_URI_FINAL_INT = Uri.parse("content://"
			+ PROVIDER_NAME + "/finalInt");
	public static final Uri CONTENT_URI_FINAL_FLOAT = Uri.parse("content://"
			+ PROVIDER_NAME + "/finalFloat");

	public static final Uri CONTENT_URI_FINAL_STRING = Uri.parse("content://"
			+ PROVIDER_NAME + "/finalString");

	public static final Uri CONTENT_URI_OBJET_ATTRIBUT = Uri.parse("content://"
			+ PROVIDER_NAME + "/ObjetAttribut");

	public static final String CONTENT_PROVIDER_DB_NAME = "andodab.db";
	public static final int CONTENT_PROVIDER_DB_VERSION = 1;

	public static final String CONTENT_PROVIDER_TABLE_NAME_BDD = "bdd";
	public static final String CONTENT_PROVIDER_TABLE_NAME_OBJET = "objet";
	public static final String CONTENT_PROVIDER_TABLE_NAME_ATTRIBUT = "attribut";
	public static final String CONTENT_PROVIDER_TABLE_NAME_VALEUR = "valeur";
	public static final String CONTENT_PROVIDER_TABLE_NAME_PRIMITIF = "primitif";
	public static final String CONTENT_PROVIDER_TABLE_NAME_FINAL = "final";
	public static final String CONTENT_PROVIDER_TABLE_NAME_FINAL_INT = "finalInt";
	public static final String CONTENT_PROVIDER_TABLE_NAME_FINAL_FLOAT = "finalFloat";
	public static final String CONTENT_PROVIDER_TABLE_NAME_FINAL_STRING = "finalString";
	public static final String CONTENT_PROVIDER_TABLE_NAME_OBJET_ATTRIBUT = "objet_attribut";

	public static final String CONTENT_PROVIDER_MIME_BDD = "vnd.android.cursor.item/vnd.android.content.provider.bdd";
	public static final String CONTENT_PROVIDER_MIME_OBJET = "vnd.android.cursor.item/vnd.android.content.provider.objet";
	public static final String CONTENT_PROVIDER_MIME_ATTRIBUT = "vnd.android.cursor.item/vnd.android.content.provider.attribut";
	public static final String CONTENT_PROVIDER_MIME_VALEUR = "vnd.android.cursor.item/vnd.android.content.provider.valeur";
	public static final String CONTENT_PROVIDER_MIME_PRIMITIF = "vnd.android.cursor.item/vnd.android.content.provider.primitif";
	public static final String CONTENT_PROVIDER_MIME_FINAL = "vnd.android.cursor.item/vnd.android.content.provider.final";
	public static final String CONTENT_PROVIDER_MIME_FINAL_INT = "vnd.android.cursor.item/vnd.android.content.provider.finalInt";
	public static final String CONTENT_PROVIDER_MIME_FINAL_FLOAT = "vnd.android.cursor.item/vnd.android.content.provider.finalFloat";
	public static final String CONTENT_PROVIDER_MIME_FINAL_STRING = "vnd.android.cursor.item/vnd.android.content.provider.finalString";
	public static final String CONTENT_PROVIDER_MIME_OBJET_ATTRIBUT = "vnd.android.cursor.item/vnd.android.content.provider.ObjetAttribut";

	private static final int BDD = 100;
	private static final int OBJET = 200;
	private static final int ATTRIBUT = 300;
	private static final int VALEUR = 400;
	private static final int PRIMITIF = 500;
	private static final int FINAL = 600;
	private static final int FINAL_INT = 700;
	private static final int FINAL_FLOAT = 800;
	private static final int FINAL_STRING = 900;
	private static final int OBJET_ATTRIBUT = 1000;

	private static final int BDD_ID = 101;
	private static final int OBJET_ID = 201;
	private static final int ATTRIBUT_ID = 301;
	private static final int VALEUR_ID = 401;
	private static final int PRIMITIF_ID = 501;
	private static final int FINAL_ID = 601;
	private static final int FINAL_INT_ID = 701;
	private static final int FINAL_FLOAT_ID = 801;
	private static final int FINAL_STRING_ID = 901;
	private static final int OBJET_ATTRIBUT_ID = 1001;

	private static final UriMatcher uriMatcher;
	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(PROVIDER_NAME, "bdd", BDD);
		uriMatcher.addURI(PROVIDER_NAME, "bdd/#", BDD_ID);
		uriMatcher.addURI(PROVIDER_NAME, "objet", OBJET);
		uriMatcher.addURI(PROVIDER_NAME, "objet/#", OBJET_ID);
		uriMatcher.addURI(PROVIDER_NAME, "attribut", ATTRIBUT);
		uriMatcher.addURI(PROVIDER_NAME, "attribut/#", ATTRIBUT_ID);
		uriMatcher.addURI(PROVIDER_NAME, "valeur", VALEUR);
		uriMatcher.addURI(PROVIDER_NAME, "valeur/#", VALEUR_ID);
		uriMatcher.addURI(PROVIDER_NAME, "primitif", PRIMITIF);
		uriMatcher.addURI(PROVIDER_NAME, "primitif/#", PRIMITIF_ID);
		uriMatcher.addURI(PROVIDER_NAME, "final", FINAL);
		uriMatcher.addURI(PROVIDER_NAME, "final/#", FINAL_ID);
		uriMatcher.addURI(PROVIDER_NAME, "finalInt", FINAL_INT);
		uriMatcher.addURI(PROVIDER_NAME, "finalInt/#", FINAL_INT_ID);
		uriMatcher.addURI(PROVIDER_NAME, "finalFloat", FINAL_FLOAT);
		uriMatcher.addURI(PROVIDER_NAME, "finalFloat/#", FINAL_FLOAT_ID);
		uriMatcher.addURI(PROVIDER_NAME, "finalString", FINAL_STRING);
		uriMatcher.addURI(PROVIDER_NAME, "finalString/#", FINAL_STRING_ID);
		uriMatcher.addURI(PROVIDER_NAME, "objet_attribut", OBJET_ATTRIBUT);
		uriMatcher.addURI(PROVIDER_NAME, "objet_attribut/#", OBJET_ATTRIBUT_ID);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {

		DatabaseHelper(Context context) {
			super(context, TutosAndroidProvider.CONTENT_PROVIDER_DB_NAME, null,
					TutosAndroidProvider.CONTENT_PROVIDER_DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			// création de la tables des BDDs
			db.execSQL("CREATE TABLE "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_BDD
					+ " (" + Bdd.BDD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ Bdd.BDD_NAME + " VARCHAR(255)" + ");");
			//
			//
			// création de la table des objets
			db.execSQL("CREATE TABLE "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_OBJET
					+ " (" + Objet.OBJET_ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT," + Objet.OBJET_NAME
					+ " VARCHAR(255)," + Objet.OBJET_ID_OBJET + " INTEGER,"
					+ Objet.OBJET_BDD_ID + " INTEGER," + "FOREIGN KEY("
					+ Objet.OBJET_ID_OBJET + ") REFERENCES "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_OBJET
					+ "(" + Objet.OBJET_ID_OBJET + ")," + "FOREIGN KEY("
					+ Objet.OBJET_BDD_ID + ") REFERENCES "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_BDD
					+ "(" + Bdd.BDD_ID + "));");
			//
			// création de la tables des attributs
			db.execSQL("CREATE TABLE "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_ATTRIBUT
					+ " (" + Attribut.ATTRIBUT_ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ Attribut.ATTRIBUT_NAME + " VARCHAR(255)" + ");");
			//
			//
			// //création de la tables des valeurs
			db.execSQL("CREATE TABLE "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_VALEUR
					+ " (" + Valeur.VALEUR_ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT," + Valeur.OBJET_ID
					+ " INTEGER," + Valeur.ATTRIBUT_ID + " INTEGER,"
					+ Valeur.PRIMITIF_ID + " INTEGER," + Valeur.FINAL_ID
					+ " INTEGER," + Valeur.OBJET_TYPE_ID + " INTEGER,"
					+ "FOREIGN KEY(" + Valeur.OBJET_ID + ") REFERENCES "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_OBJET
					+ "(" + Objet.OBJET_ID + ")," + "FOREIGN KEY("
					+ Valeur.ATTRIBUT_ID + ") REFERENCES "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_ATTRIBUT
					+ "(" + Attribut.ATTRIBUT_ID + ")," + "FOREIGN KEY("
					+ Valeur.FINAL_ID + ") REFERENCES "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL
					+ "(" + Final.FINAL_ID + ")," + "FOREIGN KEY("
					+ Valeur.PRIMITIF_ID + ") REFERENCES "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_PRIMITIF
					+ "(" + Primitif.PRIMITIF_ID + ")," + "FOREIGN KEY("
					+ Valeur.OBJET_TYPE_ID + ") REFERENCES "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_BDD
					+ "(" + Objet.OBJET_ID + "));");

			// //******************************************************************
			//
			// création de la tables des primitifs
			db.execSQL("CREATE TABLE "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_PRIMITIF
					+ " (" + Primitif.PRIMITIF_ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ Primitif.PRIMITIF_NAME + " VARCHAR(255)" + ");");
			//
			//
			// //création de la tables des finaux
			db.execSQL("CREATE TABLE "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL
					+ " (" + Final.FINAL_ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT" + ");");
			//
			//
			// //création de la tables des finaux_int
			db.execSQL("CREATE TABLE "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_INT
					+ " (" + FinalInt.FINAL_INT_ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ FinalInt.FINAL_INT_VALUE + " INTEGER," + "FOREIGN KEY("
					+ FinalInt.FINAL_INT_ID + ") REFERENCES "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL
					+ "(" + Final.FINAL_ID + "));");
			//
			//
			// création de la tables des finaux_float
			db.execSQL("CREATE TABLE "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_FLOAT
					+ " (" + FinalFloat.FINAL_FLOAT_ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ FinalInt.FINAL_INT_VALUE + " FLOAT," + "FOREIGN KEY("
					+ FinalFloat.FINAL_FLOAT_ID + ") REFERENCES "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL
					+ "(" + Final.FINAL_ID + "));");
			//
			//
			//
			// création de la tables des finaux_string
			db.execSQL("CREATE TABLE "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_STRING
					+ " (" + FinalString.FINAL_STRING_ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ FinalString.FINAL_STRING_VALUE + " VARCHAR(255),"
					+ "FOREIGN KEY(" + FinalString.FINAL_STRING_ID
					+ ") REFERENCES "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL
					+ "(" + Final.FINAL_ID + "));");

			// db.execSQL("CREATE TABLE "
			// + TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_TORERO + " ("
			// + Torero.TORERO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			// + Torero.TORERO_NAME + " VARCHAR(255)" + ");");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_BDD);
			db.execSQL("DROP TABLE IF EXISTS "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_OBJET);
			db.execSQL("DROP TABLE IF EXISTS "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_ATTRIBUT);
			db.execSQL("DROP TABLE IF EXISTS "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_VALEUR);
			db.execSQL("DROP TABLE IF EXISTS "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_PRIMITIF);
			db.execSQL("DROP TABLE IF EXISTS "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL);
			db.execSQL("DROP TABLE IF EXISTS "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_INT);
			db.execSQL("DROP TABLE IF EXISTS "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_FLOAT);
			db.execSQL("DROP TABLE IF EXISTS "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_STRING);
			db.execSQL("DROP TABLE IF EXISTS "
					+ TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_OBJET_ATTRIBUT);
			onCreate(db);
		}
	}

	private DatabaseHelper dbHelper;

	@Override
	public boolean onCreate() {
		dbHelper = new DatabaseHelper(getContext());
		return true;
	}

	@Override
	public String getType(Uri uri) {
		final int i = uriMatcher.match(uri);
		switch (i) {

		case BDD:
			return CONTENT_PROVIDER_MIME_BDD;
		case OBJET:
			return CONTENT_PROVIDER_MIME_OBJET;
		case ATTRIBUT:
			return CONTENT_PROVIDER_MIME_ATTRIBUT;
		case VALEUR:
			return CONTENT_PROVIDER_MIME_VALEUR;
		case PRIMITIF:
			return CONTENT_PROVIDER_MIME_PRIMITIF;
		case FINAL:
			return CONTENT_PROVIDER_MIME_FINAL;
		case FINAL_INT:
			return CONTENT_PROVIDER_MIME_FINAL_INT;
		case FINAL_FLOAT:
			return CONTENT_PROVIDER_MIME_FINAL_FLOAT;
		case FINAL_STRING:
			return CONTENT_PROVIDER_MIME_FINAL_STRING;
		case OBJET_ATTRIBUT:
			return CONTENT_PROVIDER_MIME_OBJET_ATTRIBUT;

		default:
			return TutosAndroidProvider.CONTENT_PROVIDER_MIME_OBJET;
		}

	}

	private long getId(Uri uri) {
		String lastPathSegment = uri.getLastPathSegment();
		if (lastPathSegment != null) {
			try {
				return Long.parseLong(lastPathSegment);
			} catch (NumberFormatException e) {
				Log.e("TutosAndroidProvider", "Number Format Exception : " + e);
			}
		}
		return -1;
	}

	/**
	 * Insert a value
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {

		SQLiteDatabase db;
		int _uri = uriMatcher.match(uri);
		long id;
		switch (_uri) {
		case BDD: {
			db = dbHelper.getWritableDatabase();

			id = db.insertOrThrow(CONTENT_PROVIDER_TABLE_NAME_BDD, null, values);

			if (id > 0) {
				getContext().getContentResolver().notifyChange(uri, null);
				ContentUris.withAppendedId(CONTENT_URI_BDD, id);
			}

			if (id == -1) {
				throw new RuntimeException(String.format(
						"%s : Failed to insert [%s] for unknown reasons.",
						"TutosAndroidProvider", values, uri));
			} else {
				return ContentUris.withAppendedId(uri, id);
			}

		}
		case OBJET: {
			db = dbHelper.getWritableDatabase();

			id = db.insertOrThrow(CONTENT_PROVIDER_TABLE_NAME_OBJET, null,
					values);
			if (id > 0) {
				getContext().getContentResolver().notifyChange(uri, null);
				getContext().getContentResolver().notifyChange(uri, null);
				ContentUris.withAppendedId(CONTENT_URI_OBJET, id);
			}
			if (id == -1) {
				throw new RuntimeException(String.format(
						"%s : Failed to insert [%s] for unknown reasons.",
						"TutosAndroidProvider", values, uri));
			} else {
				return ContentUris.withAppendedId(uri, id);
			}
		}

		case ATTRIBUT: {
			db = dbHelper.getWritableDatabase();

			id = db.insertOrThrow(CONTENT_PROVIDER_TABLE_NAME_ATTRIBUT, null,
					values);
			if (id > 0) {
				getContext().getContentResolver().notifyChange(uri, null);
				getContext().getContentResolver().notifyChange(uri, null);
				ContentUris.withAppendedId(CONTENT_URI_ATTRIBUT, id);
			}
			if (id == -1) {
				throw new RuntimeException(String.format(
						"%s : Failed to insert [%s] for unknown reasons.",
						"TutosAndroidProvider", values, uri));
			} else {
				return ContentUris.withAppendedId(uri, id);
			}
		}

		case VALEUR: {
			db = dbHelper.getWritableDatabase();

			id = db.insertOrThrow(CONTENT_PROVIDER_TABLE_NAME_VALEUR, null,
					values);
			if (id > 0) {
				getContext().getContentResolver().notifyChange(uri, null);
				getContext().getContentResolver().notifyChange(uri, null);
				ContentUris.withAppendedId(CONTENT_URI_VALEUR, id);
			}
			if (id == -1) {
				throw new RuntimeException(String.format(
						"%s : Failed to insert [%s] for unknown reasons.",
						"TutosAndroidProvider", values, uri));
			} else {
				return ContentUris.withAppendedId(uri, id);
			}
		}

		case PRIMITIF: {
			db = dbHelper.getWritableDatabase();

			id = db.insertOrThrow(CONTENT_PROVIDER_TABLE_NAME_PRIMITIF, null,
					values);
			if (id > 0) {
				getContext().getContentResolver().notifyChange(uri, null);
				getContext().getContentResolver().notifyChange(uri, null);
				ContentUris.withAppendedId(CONTENT_URI_PRIMITIF, id);
			}
			if (id == -1) {
				throw new RuntimeException(String.format(
						"%s : Failed to insert [%s] for unknown reasons.",
						"TutosAndroidProvider", values, uri));
			} else {
				return ContentUris.withAppendedId(uri, id);
			}
		}

		case FINAL: {
			db = dbHelper.getWritableDatabase();

			id = db.insertOrThrow(CONTENT_PROVIDER_TABLE_NAME_FINAL, null,
					values);
			if (id > 0) {
				getContext().getContentResolver().notifyChange(uri, null);
				getContext().getContentResolver().notifyChange(uri, null);
				ContentUris.withAppendedId(CONTENT_URI_FINAL, id);
			}
			if (id == -1) {
				throw new RuntimeException(String.format(
						"%s : Failed to insert [%s] for unknown reasons.",
						"TutosAndroidProvider", values, uri));
			} else {
				return ContentUris.withAppendedId(uri, id);
			}
		}

		case FINAL_INT: {
			db = dbHelper.getWritableDatabase();

			id = db.insertOrThrow(CONTENT_PROVIDER_TABLE_NAME_FINAL_INT, null,
					values);
			if (id > 0) {
				getContext().getContentResolver().notifyChange(uri, null);
				getContext().getContentResolver().notifyChange(uri, null);
				ContentUris.withAppendedId(CONTENT_URI_FINAL_INT, id);
			}
			if (id == -1) {
				throw new RuntimeException(String.format(
						"%s : Failed to insert [%s] for unknown reasons.",
						"TutosAndroidProvider", values, uri));
			} else {
				return ContentUris.withAppendedId(uri, id);
			}
		}

		case FINAL_FLOAT: {
			db = dbHelper.getWritableDatabase();

			id = db.insertOrThrow(CONTENT_PROVIDER_TABLE_NAME_FINAL_FLOAT,
					null, values);
			if (id > 0) {
				getContext().getContentResolver().notifyChange(uri, null);
				getContext().getContentResolver().notifyChange(uri, null);
				ContentUris.withAppendedId(CONTENT_URI_FINAL_FLOAT, id);
			}
			if (id == -1) {
				throw new RuntimeException(String.format(
						"%s : Failed to insert [%s] for unknown reasons.",
						"TutosAndroidProvider", values, uri));
			} else {
				return ContentUris.withAppendedId(uri, id);
			}
		}

		case FINAL_STRING: {
			db = dbHelper.getWritableDatabase();

			id = db.insertOrThrow(CONTENT_PROVIDER_TABLE_NAME_FINAL_STRING,
					null, values);
			if (id > 0) {
				getContext().getContentResolver().notifyChange(uri, null);
				getContext().getContentResolver().notifyChange(uri, null);
				ContentUris.withAppendedId(CONTENT_URI_FINAL_STRING, id);
			}
			if (id == -1) {
				throw new RuntimeException(String.format(
						"%s : Failed to insert [%s] for unknown reasons.",
						"TutosAndroidProvider", values, uri));
			} else {
				return ContentUris.withAppendedId(uri, id);
			}
		}

		default:
			throw new SQLException("Failed to insert row into " + uri);
		}

	}

	/**
	 * update a value
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		long id;
		SQLiteDatabase db = dbHelper.getWritableDatabase();

		int _uri = uriMatcher.match(uri);

		switch (_uri) {
		case BDD: {
			id = getId(uri);

			if (id < 0)
				return db.update(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_BDD,
						values, selection, selectionArgs);
			else
				return db.update(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_BDD,
						values, Bdd.BDD_ID + "=" + id, null);

		}
		case OBJET: {
			id = getId(uri);

			if (id < 0)
				return db.update(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_OBJET,
						values, selection, selectionArgs);
			else
				return db.update(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_OBJET,
						values, Objet.OBJET_ID + "=" + id, null);

		}
		case ATTRIBUT: {
			id = getId(uri);

			if (id < 0)
				return db
						.update(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_ATTRIBUT,
								values, selection, selectionArgs);
			else
				return db
						.update(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_ATTRIBUT,
								values, Attribut.ATTRIBUT_ID + "=" + id, null);

		}
		case VALEUR: {
			id = getId(uri);

			if (id < 0)
				return db
						.update(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_VALEUR,
								values, selection, selectionArgs);
			else
				return db
						.update(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_VALEUR,
								values, Valeur.VALEUR_ID + "=" + id, null);

		}
		case PRIMITIF: {
			id = getId(uri);

			if (id < 0)
				return db
						.update(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_PRIMITIF,
								values, selection, selectionArgs);
			else
				return db
						.update(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_PRIMITIF,
								values, Primitif.PRIMITIF_ID + "=" + id, null);

		}
		case FINAL: {
			id = getId(uri);

			if (id < 0)
				return db.update(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL,
						values, selection, selectionArgs);
			else
				return db.update(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL,
						values, Final.FINAL_ID + "=" + id, null);

		}
		case FINAL_INT: {
			id = getId(uri);

			if (id < 0)
				return db
						.update(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_INT,
								values, selection, selectionArgs);
			else
				return db
						.update(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_INT,
								values, Final.FINAL_ID + "=" + id, null);

		}
		case FINAL_FLOAT: {
			id = getId(uri);

			if (id < 0)
				return db
						.update(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_FLOAT,
								values, selection, selectionArgs);
			else
				return db
						.update(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_FLOAT,
								values, FinalFloat.FINAL_FLOAT_ID + "=" + id,
								null);

		}
		case FINAL_STRING: {
			id = getId(uri);

			if (id < 0)
				return db
						.update(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_STRING,
								values, selection, selectionArgs);
			else
				return db
						.update(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_STRING,
								values, FinalString.FINAL_STRING_ID + "=" + id,
								null);

		}

		default:
			throw new SQLException("Failed to insert row into " + uri);
		}

	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		long id;
		SQLiteDatabase db = dbHelper.getWritableDatabase();

		int _uri = uriMatcher.match(uri);

		switch (_uri) {
		case BDD: {
			id = getId(uri);
			if (id < 0)
				return db.delete(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_BDD,
						selection, selectionArgs);
			else
				return db.delete(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_BDD,
						Bdd.BDD_ID + "=" + id, selectionArgs);
		}
		case OBJET: {
			id = getId(uri);
			if (id < 0)
				return db.delete(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_OBJET,
						selection, selectionArgs);
			else
				return db.delete(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_OBJET,
						Objet.OBJET_ID + "=" + id, selectionArgs);
		}
		case ATTRIBUT: {
			id = getId(uri);
			if (id < 0)
				return db
						.delete(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_ATTRIBUT,
								selection, selectionArgs);
			else
				return db
						.delete(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_ATTRIBUT,
								Attribut.ATTRIBUT_ID + "=" + id, selectionArgs);
		}
		case VALEUR: {
			id = getId(uri);
			if (id < 0)
				return db
						.delete(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_VALEUR,
								selection, selectionArgs);
			else
				return db
						.delete(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_VALEUR,
								Valeur.VALEUR_ID + "=" + id, selectionArgs);
		}
		case PRIMITIF: {
			id = getId(uri);
			if (id < 0)
				return db
						.delete(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_PRIMITIF,
								selection, selectionArgs);
			else
				return db
						.delete(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_PRIMITIF,
								Primitif.PRIMITIF_ID + "=" + id, selectionArgs);
		}
		case FINAL: {
			id = getId(uri);
			if (id < 0)
				return db.delete(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL,
						selection, selectionArgs);
			else
				return db.delete(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL,
						Final.FINAL_ID + "=" + id, selectionArgs);
		}
		case FINAL_INT: {
			id = getId(uri);
			if (id < 0)
				return db
						.delete(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_INT,
								selection, selectionArgs);
			else
				return db
						.delete(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_INT,
								FinalInt.FINAL_INT_ID + "=" + id, selectionArgs);
		}
		case FINAL_FLOAT: {
			id = getId(uri);
			if (id < 0)
				return db
						.delete(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_FLOAT,
								selection, selectionArgs);
			else
				return db
						.delete(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_FLOAT,
								FinalFloat.FINAL_FLOAT_ID + "=" + id,
								selectionArgs);
		}
		case FINAL_STRING: {
			id = getId(uri);
			if (id < 0)
				return db
						.delete(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_STRING,
								selection, selectionArgs);
			else
				return db
						.delete(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_STRING,
								FinalString.FINAL_STRING_ID + "=" + id,
								selectionArgs);
		}
		default:
			return 0;
		}

	}

	/**
	 * 
	 */

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		long id;
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		int _uri = uriMatcher.match(uri);

		switch (_uri) {
		case BDD: {
			id = getId(uri);
			if (id < 0) {
				return db.query(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_BDD,
						projection, selection, selectionArgs, null, null,
						sortOrder);
			} else {
				return db.query(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_BDD,
						projection, Bdd.BDD_ID + "=" + id, null, null, null,
						null);
			}

		}
		case OBJET: {
			id = getId(uri);
			if (id < 0) {
				return db.query(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_OBJET,
						projection, selection, selectionArgs, null, null,
						sortOrder);
			} else {
				return db.query(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_OBJET,
						projection, Objet.OBJET_ID + "=" + id, null, null,
						null, null);
			}
		}
		case ATTRIBUT: {
			id = getId(uri);
			if (id < 0) {
				return db
						.query(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_ATTRIBUT,
								projection, selection, selectionArgs, null,
								null, sortOrder);
			} else {
				return db
						.query(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_ATTRIBUT,
								projection, Attribut.ATTRIBUT_ID + "=" + id,
								null, null, null, null);
			}
		}
		case VALEUR: {
			id = getId(uri);
			if (id < 0) {
				return db
						.query(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_VALEUR,
								projection, selection, selectionArgs, null,
								null, sortOrder);
			} else {
				return db
						.query(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_VALEUR,
								projection, Valeur.VALEUR_ID + "=" + id, null,
								null, null, null);
			}
		}
		case PRIMITIF: {
			id = getId(uri);
			if (id < 0) {
				return db
						.query(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_PRIMITIF,
								projection, selection, selectionArgs, null,
								null, sortOrder);
			} else {
				return db
						.query(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_PRIMITIF,
								projection, Primitif.PRIMITIF_ID + "=" + id,
								null, null, null, null);
			}
		}
		case FINAL: {
			id = getId(uri);
			if (id < 0) {
				return db.query(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL,
						projection, selection, selectionArgs, null, null,
						sortOrder);
			} else {
				return db.query(
						TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL,
						projection, Final.FINAL_ID + "=" + id, null, null,
						null, null);
			}
		}
		case FINAL_INT: {
			id = getId(uri);
			if (id < 0) {
				return db
						.query(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_INT,
								projection, selection, selectionArgs, null,
								null, sortOrder);
			} else {
				return db
						.query(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_INT,
								projection, FinalInt.FINAL_INT_ID + "=" + id,
								null, null, null, null);
			}
		}
		case FINAL_FLOAT: {
			id = getId(uri);
			if (id < 0) {
				return db
						.query(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_FLOAT,
								projection, selection, selectionArgs, null,
								null, sortOrder);
			} else {
				return db
						.query(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_FLOAT,
								projection, FinalFloat.FINAL_FLOAT_ID + "="
										+ id, null, null, null, null);
			}
		}
		case FINAL_STRING: {
			id = getId(uri);
			if (id < 0) {
				return db
						.query(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_STRING,
								projection, selection, selectionArgs, null,
								null, sortOrder);
			} else {
				return db
						.query(TutosAndroidProvider.CONTENT_PROVIDER_TABLE_NAME_FINAL_STRING,
								projection, FinalString.FINAL_STRING_ID + "="
										+ id, null, null, null, null);
			}
		}
		default:
			return null;
		}

	}

}
