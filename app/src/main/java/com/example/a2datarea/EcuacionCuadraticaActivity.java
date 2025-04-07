package com.example.a2datarea;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
public class EcuacionCuadraticaActivity extends AppCompatActivity {
    private EditText ValorA, ValorB, ValorC;
    private Button Calcular;
    private TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuacion_cuadratica);

        ValorA = findViewById(R.id.editTextA);
        ValorB = findViewById(R.id.editTextB);
        ValorC = findViewById(R.id.editTextC);
        Calcular = findViewById(R.id.btnCalcular);
        Resultado = findViewById(R.id.textViewResultado);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularEcuacion();
            }
        });
    }

    private void calcularEcuacion() {
        String strA = ValorA.getText().toString();
        String strB = ValorB.getText().toString();
        String strC = ValorC.getText().toString();

        if (strA.isEmpty() || strB.isEmpty() || strC.isEmpty()) {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double a = Double.parseDouble(strA);
            double b = Double.parseDouble(strB);
            double c = Double.parseDouble(strC);

            if (a == 0) {
                Toast.makeText(this, "El coeficiente 'a' no puede ser cero", Toast.LENGTH_SHORT).show();
                return;
            }

            DecimalFormat df = new DecimalFormat("#.###");
            double discriminante = b * b - 4 * a * c;
            StringBuilder resultado = new StringBuilder();

            if (discriminante > 0) {
                double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                resultado.append("Raíces reales:\n");
                resultado.append("x₁ = ").append(df.format(x1)).append("\n");
                resultado.append("x₂ = ").append(df.format(x2));
            } else if (discriminante == 0) {
                double x = -b / (2 * a);
                resultado.append("Raíz doble:\n");
                resultado.append("x = ").append(df.format(x));
            } else {
                double parteReal = -b / (2 * a);
                double parteImaginaria = Math.sqrt(-discriminante) / (2 * a);
                resultado.append("Raíces complejas:\n");
                resultado.append("x₁ = ").append(df.format(parteReal)).append(" + ").append(df.format(parteImaginaria)).append("i\n");
                resultado.append("x₂ = ").append(df.format(parteReal)).append(" - ").append(df.format(parteImaginaria)).append("i");
            }

            Resultado.setText(resultado.toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores numéricos válidos", Toast.LENGTH_SHORT).show();
        }
    }
}