package com.diego.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView tvnombre, tvfechanac, tvtelefono, tvemail, tvdescripcion;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_confirmar_datos );

        tvnombre = (TextView)findViewById( R.id.cnombre );
        tvfechanac = (TextView)findViewById( R.id.cfechanac );
        tvtelefono = (TextView)findViewById( R.id.ctelefono );
        tvemail = (TextView)findViewById( R.id.cemail );
        tvdescripcion = (TextView)findViewById( R.id.cdescripcion );
        btnOk = (Button)findViewById( R.id.ceditar );

        btnOk.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                startActivity( intent );
            }
        } );

        mostrarDato();
    }

    private void mostrarDato(){
        Bundle datos = this.getIntent().getExtras();
        String nombre = datos.getString( "name" );
        String fecha = datos.getString( "fecha" );
        String telefono = datos.getString( "tel" );
        String email = datos.getString( "ema" );
        String descripcion = datos.getString( "descrip" );

        tvnombre.setText( nombre );
        tvfechanac.setText( fecha );
        tvtelefono.setText( telefono );
        tvemail.setText( email );
        tvdescripcion.setText( descripcion );
    }
}