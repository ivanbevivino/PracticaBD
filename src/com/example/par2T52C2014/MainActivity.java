package com.example.par2T52C2014;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button botonAlta;
	private TextView textoDni;
	private TextView textoNombre;
	private Button botonListar;
	private BaseDeDatos b;
	private SQLiteDatabase db;
	private Listar lista;
	//COMPLETAR !
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textoDni = (TextView) findViewById(R.id.etDni);
		textoNombre = (TextView) findViewById(R.id.etNombre);
		botonAlta = (Button) findViewById(R.id.btnAlta);
		botonListar = (Button) findViewById(R.id.btnListar);
		
		
		//COMPLETAR !
		
		b = new BaseDeDatos(this, "Tabla", null, 1);
		db = b.getWritableDatabase();
		botonAlta.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
			
			
				String sDni = textoDni.getText().toString();
				String sNombre = textoNombre.getText().toString();
				
				if (!sDni.isEmpty()) {
					ContentValues cvRegistro = new ContentValues();
					cvRegistro.put("dni", sDni);
					cvRegistro.put("nombre", sNombre);	
					db.insert("Tabla", null, cvRegistro);	
					textoDni.setText("");
					textoNombre.setText("");
					}
			}
		});
				
		botonListar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		
				Intent i =new Intent (getApplicationContext(),Listar.class);
				startActivity(i);
			}
		});
		
		
	}

	
}
