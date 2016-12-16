package com.example.mgonzalezlorenzo.simonexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


        //En este if, si la variable recibida por el intent tiene el valor nulo, se crea la toast de victoria
        if(getIntent().getExtras().getString("condicion")==null){
            Toast.makeText(getApplicationContext(), "HAS GANADO", Toast.LENGTH_LONG).show();
        }


        //En este if, si la variable recibida por el intent tiene un valor distinto de null, se crea la toa de derrota
        if(getIntent().getExtras().getString("condicion")!=null){
            Toast.makeText(getApplicationContext(), "HAS PERDIDO", Toast.LENGTH_LONG).show();
        }


    }
}
