package com.example.calculadora;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String currentText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Configurar botones para escribir números y + en el textView
        setupButton(R.id.button1, "1");
        setupButton(R.id.button2, "2");
        setupButton(R.id.button3, "3");
        setupButton(R.id.button4, "4");
        setupButton(R.id.button5, "5");
        setupButton(R.id.button6, "6");
        setupButton(R.id.button7, "7");
        setupButton(R.id.button8, "8");
        setupButton(R.id.button9, "9");
        setupButton(R.id.button0, "0");
        setupButton(R.id.sumar, "+");

        // Botón para limpiar el texto
        findViewById(R.id.buttonC).setOnClickListener(v -> {
            currentText = "";
            textView.setText(currentText);
        });

        // Botón para calcular el resultado
        findViewById(R.id.igual).setOnClickListener(v -> {
            try {
                int result = calculate(currentText);
                textView.setText(String.valueOf(result));
            } catch (Exception e) {
                textView.setText("-1"); // Si hay error, muestra -1
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Método para configurar los botones
    private void setupButton(int buttonId, String value) {
        findViewById(buttonId).setOnClickListener(v -> {
            currentText += value;
            textView.setText(currentText);
        });
    }

    // Función recursiva para realizar sumas
    private int calculate(String input) throws Exception {
        // Si no hay un símbolo '+' en la cadena, conviértelo en número
        if (!input.contains("+")) {
            return Integer.parseInt(input.trim());
        } else {
            // Dividimos la cadena en dos partes
            int plusIndex = input.indexOf('+'); // Encuentra el primer '+'
            String left = input.substring(0, plusIndex); // Parte izquierda
            String right = input.substring(plusIndex + 1); // Parte derecha

            // Llamadas recursivas
            return calculate(left) + calculate(right);
        }
    }
}