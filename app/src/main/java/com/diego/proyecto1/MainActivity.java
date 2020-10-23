package com.diego.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    EditText nombre, fechanacimiento, telefono, email, descripcion;
    DatePickerDialog datePickerDialog;
    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        nombre = (EditText)findViewById( R.id.xnombre );
        fechanacimiento = (EditText)findViewById( R.id.xfechanac );
        fechanacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                fechanacimiento.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        telefono = (EditText)findViewById( R.id.xtelefono );
        email = (EditText)findViewById( R.id.xemail );
        descripcion = (EditText)findViewById( R.id.xdescripcion );
        enviar = (Button)findViewById( R.id.xenviar );

        enviar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = nombre.getText().toString();
                String fecha = fechanacimiento.getText().toString();
                String tel = telefono.getText().toString();
                String ema = email.getText().toString();
                String descrip = descripcion.getText().toString();

                Intent i = new Intent(MainActivity.this, ConfirmarDatos.class);

                i.putExtra( "name", name );
                i.putExtra( "fecha", fecha );
                i.putExtra( "tel", tel );
                i.putExtra( "ema", ema );
                i.putExtra( "descrip", descrip );

                startActivity( i );

            }
        } );


    }



}