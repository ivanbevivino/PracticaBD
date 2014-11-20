package com.example.par2T52C2014;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class BaseDeDatos extends SQLiteOpenHelper {
	
	String sqlCreate ="CREATE TABLE Tabla(dni INTEGER , nombre TEXT)";
	public BaseDeDatos(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(sqlCreate);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		
		 db.execSQL("DROP TABLE Tabla");
	     db.execSQL(sqlCreate);
	}
}	
	

