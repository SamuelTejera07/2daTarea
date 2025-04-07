package com.example.a2datarea;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class FibonacciActivity extends AppCompatActivity {
    private EditText NumElementos;
    private Button Calcular;
    private TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        NumElementos = findViewById(R.id.editTextNumElementos);
        Calcular = findViewById(R.id.btnCalcular);
        Resultado = findViewById(R.id.textViewResultado);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularFibonacci();
            }
        });
    }

    private void calcularFibonacci() {
        String input = NumElementos.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese un número", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int n = Integer.parseInt(input);
            if (n <= 0) {
                Toast.makeText(this, "El número debe ser positivo", Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuilder resultado = new StringBuilder();
            long a = 0, b = 1;
            resultado.append(a);

            if (n > 1) {
                resultado.append(", ").append(b);
            }

            for (int i = 2; i < n; i++) {
                long c = a + b;
                resultado.append(", ").append(c);
                a = b;
                b = c;
            }

            Resultado.setText("Serie de Fibonacci (" + n + " elementos):\n" + resultado.toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese un número válido", Toast.LENGTH_SHORT).show();
        }
    }
}