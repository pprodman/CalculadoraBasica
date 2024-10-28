package com.example.calculadora;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String currentText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calculator Calculator = new Calculator();

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
        setupButton(R.id.multiplicar, "*");

        // Botón para limpiar el texto
        findViewById(R.id.buttonC).setOnClickListener(v -> {
            currentText = "";
            textView.setText(currentText);
        });

        // Botón para calcular el resultado
        findViewById(R.id.igual).setOnClickListener(v -> {
            try {
                int result = Calculator.calculate(currentText);
                textView.setText(String.valueOf(result));
            } catch (Exception e) {
                textView.setText("-1"); // Si hay error, muestra -1
            }
        });
    }

    /**
     * Método de configuración de un botón para escribir en el textView
     * @param buttonId Id del botón
     * @param value Valor a escribir en el textView
     */
    private void setupButton(int buttonId, String value) {
        findViewById(buttonId).setOnClickListener(v -> {
            currentText += value;
            textView.setText(currentText);
        });
    }


}