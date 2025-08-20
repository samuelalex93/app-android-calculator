package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ViagemActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_viagem);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnCalcularV = findViewById(R.id.btnCalculateV);
        btnCalcularV.setOnClickListener(this);

        Button btnVoltarV = findViewById(R.id.btnBackV);
        btnVoltarV.setOnClickListener(this);
    }

    public void onClick(View view) {
        if(view.getId() == R.id.btnBackV) {
            finish();
        } else if (view.getId() == R.id.btnCalculateV) {
            calcular();
        }
    }

    private void calcular() {
        EditText etDistance = findViewById(R.id.etDistance);
        EditText etFuelValue = findViewById(R.id.etFuelValue);
        EditText etAverageKm = findViewById(R.id.etAverageKm);

        float vDistance = Float.parseFloat(etDistance.getText().toString());
        float vFuelValue = Float.parseFloat(etFuelValue.getText().toString());
        float vAverageKm = Float.parseFloat(etAverageKm.getText().toString());

        float result = (vDistance/vAverageKm) * vFuelValue;

        Toast.makeText(
                ViagemActivity.this,
                "Gasto total combustive na viagem é R$" + String.format("%.2f", result),
                Toast.LENGTH_LONG
        ).show();
    }
}