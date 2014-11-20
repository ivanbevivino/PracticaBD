package com.example.par2T52C2014;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Listar extends Activity {
	private TextView textoResultado;

	private SQLiteDatabase d;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar);
		BaseDeDatos db = new BaseDeDatos(this, "Tabla", null, 1);
		d= db.getReadableDatabase();
		textoResultado = (TextView) findViewById(R.id.tvResultado);
		
		verConsulta();
	}
	
	public void verConsulta() {
		
		Cursor c = d.rawQuery("SELECT dni, nombre FROM Tabla", null);
		textoResultado.setText("");
		if (c.moveToFirst()) {
		do {
			String dni = c.getString(0);
			String nom = c.getString(1);
			textoResultado.append(" " + dni + " - " + nom + "\n");
			} while (c.moveToNext());
		}
	
	}
}



