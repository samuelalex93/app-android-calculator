package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        Button btnSub = findViewById(R.id.btnSub);
        btnSub.setOnClickListener(this);

        Button btnMult = findViewById(R.id.btnMult);
        btnMult.setOnClickListener(this);

        Button btnDivid = findViewById(R.id.btnDivid);
        btnDivid.setOnClickListener(this);

        Button btnVoltarC = findViewById(R.id.btnBackC);
        btnVoltarC.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent telaCalcula = new Intent(HomeActivity.this, CalculaActivity.class);

        if(view.getId() == R.id.btnAdd) {
            telaCalcula.putExtra("operation", "Somar");
        }else if(view.getId() == R.id.btnSub) {
            telaCalcula.putExtra("operation", "Subtrair");
        } else if(view.getId() == R.id.btnMult) {
            telaCalcula.putExtra("operation", "Multiplicar");
        } else if(view.getId() == R.id.btnDivid) {
            telaCalcula.putExtra("operation", "Dividir");
        } else if(view.getId() == R.id.btnBackC) {
            finish();
            return;
        }
        startActivity(telaCalcula);
    }
}