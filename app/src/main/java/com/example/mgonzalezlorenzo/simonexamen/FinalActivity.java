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

        if(getIntent().getExtras().getString("condicion")==null){
            Toast.makeText(getApplicationContext(), "HAS GANADO", Toast.LENGTH_LONG).show();
        }

        if(getIntent().getExtras().getString("condicion")!=null){
            Toast.makeText(getApplicationContext(), "HAS PERDIDO", Toast.LENGTH_LONG).show();
        }

        
    }
}
