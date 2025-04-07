package com.example.a2datarea;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class OrdenarDatosActivity extends AppCompatActivity {
    private EditText Numeros;
    private RadioGroup Orden;
    private RadioButton Ascendente, Descendente;
    private Button Ordenar;
    private TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenar_datos);

        Numeros = findViewById(R.id.editTextNumeros);
        Orden = findViewById(R.id.radioGroupOrden);
        Ascendente = findViewById(R.id.radioButtonAsc);
        Descendente = findViewById(R.id.radioButtonDesc);
        Ordenar = findViewById(R.id.btnOrdenar);
        Resultado = findViewById(R.id.textViewResultado);


        Ascendente.setChecked(true);

        Ordenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ordenarNumeros();
            }
        });
    }

    private void ordenarNumeros() {
        String input = Numeros.getText().toString().trim();
        if (input.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese números separados por comas", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            String[] numerosStr = input.split(",");
            List<Double> numeros = new ArrayList<>();

            for (String num : numerosStr) {
                numeros.add(Double.parseDouble(num.trim()));
            }

            boolean esAscendente = Ascendente.isChecked();

            if (esAscendente) {
                Collections.sort(numeros);
            } else {
                Collections.sort(numeros, new Comparator<Double>() {
                    @Override
                    public int compare(Double num1, Double num2) {
                        return num2.compareTo(num1);
                    }
                });
            }

            StringBuilder resultado = new StringBuilder();
            for (int i = 0; i < numeros.size(); i++) {
                resultado.append(numeros.get(i));
                if (i < numeros.size() - 1) {
                    resultado.append(", ");
                }
            }

            String orden = esAscendente ? "menor a mayor" : "mayor a menor";
            Resultado.setText("Números ordenados de " + orden + ":\n" + resultado.toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese solo números válidos", Toast.LENGTH_SHORT).show();
        }
    }
}
