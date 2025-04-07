package com.example.a2datarea;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        String nombre = getIntent().getStringExtra("NOMBRE_USUARIO");
        TextView textViewBienvenida = findViewById(R.id.textViewBienvenida);
        textViewBienvenida.setText("Hola, " + nombre + "! Selecciona una opción:");

        Button Fibonacci = findViewById(R.id.btnFibonacci);
        Button Ecuacion = findViewById(R.id.btnEcuacion);
        Button Ordenar = findViewById(R.id.btnOrdenar);

        Fibonacci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, FibonacciActivity.class));
            }
        });

        Ecuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, EcuacionCuadraticaActivity.class));
            }
        });

        Ordenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, OrdenarDatosActivity.class));
            }
        });
    }
}