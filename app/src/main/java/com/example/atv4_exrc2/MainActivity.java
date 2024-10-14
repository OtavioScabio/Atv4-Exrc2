/*
 *@author: Otávio Gabriel Ribeiro Scabio - RA 1110482223043
 */

package com.example.atv4_exrc2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private Button btnCalcula;
    private TextView tvRes;

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

        etNumero = findViewById(R.id.etNumero);
        btnCalcula = findViewById(R.id.btnConcluir);
        tvRes = findViewById(R.id.tvRes);

        btnCalcula.setOnClickListener(op -> exibirNumeros());
    }


    public void exibirNumeros() {

        int numero = Integer.parseInt(etNumero.getText().toString());

        if (numero < 100 || numero > 999) {
            tvRes.setText("ERRO! Insira um numero entre 100 e 999");
        } else {
            int centena = numero / 100;
            int dezena = (numero % 100) / 10;
            int unidade = numero % 10;

            tvRes.setText("CENTENA = " + centena + " / DEZENA = " + dezena + " / UNIDADE = " + unidade);
        }

    }
}