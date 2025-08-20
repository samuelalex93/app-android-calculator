package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculaActivity extends AppCompatActivity implements View.OnClickListener {
    String operation = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcula);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        TextView tvTitle = findViewById(R.id.tvTitle);
        String title = getIntent().getStringExtra("operation");
        operation = title;
        tvTitle.setText(operation.concat(" números"));
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnBack) {
            finish();
        } else if (view.getId() == R.id.btnCalculate) {
            calculate();
        }
    }

    private void calculate() {
        EditText etNumber1 = findViewById(R.id.etNumber1);
        EditText etNumber2 = findViewById(R.id.etNumber2);
        int n1 = Integer.parseInt(etNumber1.getText().toString());
        int n2 = Integer.parseInt(etNumber2.getText().toString());
        int result = 0;
        switch (operation) {
            case "Somar" :
                result = n1 + n2;
                break;
            case "Subtrair" :
                result = n1 - n2;
                break;
            case "Multiplicar" :
                result = n1 * n2;
                break;
            case "Dividir" :
                result = n1 / n2;
                break;
        }

        Toast.makeText(CalculaActivity.this, "Resultado: ".concat(String.valueOf(result)),Toast.LENGTH_LONG).show();
    }
}