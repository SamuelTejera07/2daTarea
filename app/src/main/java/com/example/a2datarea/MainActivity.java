package com.example.a2datarea;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private EditText Nombre;
    private Button Continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewTitulo = findViewById(R.id.txttitulo);
        Nombre = findViewById(R.id.edtxtnombre);
        Continuar = findViewById(R.id.btnContinuar);

        textViewTitulo.setText("Bienvenido al Taller de Aplicaciones\n\nEsta aplicación permite calcular series de Fibonacci, resolver ecuaciones cuadráticas y ordenar datos.");

        // Deshabilitar el botón inicialmente
        Continuar.setEnabled(false);


        Nombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Continuar.setEnabled(s.length() > 0);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        Continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = Nombre.getText().toString();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("NOMBRE_USUARIO", nombre);
                startActivity(intent);
            }
        });
    }
}