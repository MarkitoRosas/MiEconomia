package com.utxj.mieconomia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btncomenzar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        btncomenzar = findViewById(R.id.btncomenzar);

        btncomenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent comenzar = new Intent( getApplicationContext(), HomeActivity.class );
                startActivity(comenzar);
            }
        });
    }
}