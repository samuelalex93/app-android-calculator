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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
        Button btnEnter = findViewById(R.id.btnEnter);
        Button btnTrip = findViewById(R.id.btnTrip);
        btnEnter.setOnClickListener(this);
        btnTrip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnEnter) {
            Intent telaHome = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(telaHome);
        }else if(view.getId() == R.id.btnTrip) {
            Intent telaViagem = new Intent(MainActivity.this, ViagemActivity.class);
            startActivity(telaViagem);
        }
    }
}