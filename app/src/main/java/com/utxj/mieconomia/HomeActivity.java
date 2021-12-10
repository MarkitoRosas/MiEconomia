package com.utxj.mieconomia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    public ArrayList<Movimiento> movimientos = new ArrayList<>();
    RecyclerView recyclerView;
    TextView total, ingresos, gastos;
    FloatingActionButton btnnuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnnuevo = findViewById(R.id.btnnuevo);
        recyclerView = findViewById(R.id.recycler);
        total = findViewById(R.id.txtotal);
        ingresos = findViewById(R.id.txingresos);
        gastos = findViewById(R.id.txgastos);

        btnnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                RegistroFragment registroFragment = new RegistroFragment();
                fragmentTransaction.add( R.id.homeactiviy, registroFragment );
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MovimientosAdapters movimientosAdapters = new MovimientosAdapters( movimientos, this );
        recyclerView.setAdapter(movimientosAdapters);
        this.calculos();
    }

    public void calculos() {
        Double ingresos = 0.0, gastos = 0.0, total = 0.0;
        for (Movimiento movimiento:
             movimientos) {
            if( movimiento.getTipo() ){
                ingresos += movimiento.getMonto();
            }else{
                gastos += movimiento.getMonto();
            }
        }
        total = ingresos - gastos;
        this.ingresos.setText( "+ $" + Double.toString( ingresos ) );
        this.ingresos.setTextColor(Color.rgb(9,175,0));
        this.gastos.setText( "- $" + Double.toString( gastos ) );
        this.gastos.setTextColor(Color.rgb(238, 96,2));
        this.total.setText( "$" + Double.toString( total ) );
        if ( total >= 0 ) {
            this.total.setTextColor(Color.rgb(9,175,0));
        }else{
            this.total.setTextColor(Color.rgb(238, 96,2));
        }
    }

    public void agregarMovimiento( Movimiento movimiento ) {
        this.movimientos.add( movimiento );
        this.calculos();
    }
}