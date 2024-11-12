package com.example.certamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText lblSexo, lblEstatura, lblPeso;
    Button btnIMC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblPeso = findViewById(R.id.lblPeso);
        lblEstatura = findViewById(R.id.lblEstatura);
        lblSexo = findViewById(R.id.lblSexo);
    }
}
