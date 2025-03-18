package com.example.calculadoramultiple;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText valor1, valor2;
    private CheckBox suma, resta, multiplicacion, division;
    private TextView resultado;
    private Button operar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        valor1 = findViewById(R.id.edtNumero1);
        valor2 = findViewById(R.id.edtNumero2);

        suma = findViewById(R.id.cbSuma);
        resta = findViewById(R.id.cbResta);
        multiplicacion = findViewById(R.id.cbMultiplicacion);
        division = findViewById(R.id.cbDivision);

        operar = findViewById(R.id.btnOperar);

        resultado = findViewById(R.id.txtResultado);

        operar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String num1 = valor1.getText().toString();
                String num2 = valor2.getText().toString();

                if (num1.isEmpty() || num2.isEmpty()) {
                    resultado.setText("Ingrese ambos valores");
                    return;
                }

                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);

                String texto = "";

                if (suma.isChecked()) {
                    texto += "Suma: " + (n1 + n2) + "\n";
                }

                if (resta.isChecked()) {
                    texto += "Resta: " + (n1 - n2) + "\n";
                }

                if (multiplicacion.isChecked()) {
                    texto += "Multiplicación: " + (n1 * n2) + "\n";
                }

                if (division.isChecked()) {
                    if (n2 == 0) {
                        texto += "Error: División por 0";
                    } else {
                        texto += "División: " + (n1 / n2) + "\n";
                    }
                }

                resultado.setText(texto);
            }
        });
    }
}