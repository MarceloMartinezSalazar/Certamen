package com.example.certamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText lblEstatura, lblPeso;
    Button btnIMC;
    TextView txtRecomendacion;
    Spinner lblSexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblPeso = findViewById(R.id.lblPeso);
        lblEstatura = findViewById(R.id.lblEstatura);
        lblSexo = findViewById(R.id.lblSexo);
        btnIMC = findViewById(R.id.btnIMC);
        txtRecomendacion = findViewById(R.id.txtRecomendacion);

        btnIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pesoStr = lblPeso.getText().toString();
                String estaturaStr = lblEstatura.getText().toString();
                if (pesoStr.isEmpty() || estaturaStr.isEmpty()){
                    Toast.makeText(MainActivity.this, "Porfavor ingrese ambos valores", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    double peso = Double.parseDouble(pesoStr);
                    double estatura = Double.parseDouble(estaturaStr);
                if (estatura == 0){
                    Toast.makeText(MainActivity.this, "La estatura no puede ser igual a cero", Toast.LENGTH_SHORT).show();
                    return;
                }
                double imc = peso / (estatura * estatura);
                        String mensaje = "Tu IMC es: " + String.format("%.2", imc);
                        if (imc < 18.5) {
                            mensaje += "\nbajo peso";
                            txtRecomendacion.setVisibility(View.VISIBLE);
                            txtRecomendacion.setText(
                                    "1) Come con mas frecuencia. Empieza poco a poco a hacer 5 a 6 comidas mas pequeñas durante el día.\n" +
                                            "2)Elige alimentos con muchos nutrientes. \n" +
                                            "3)agrega aderezos. \n" +
                                            "4)Prueba licuados y batidos de frutas. \n" +
                                            "5)Controla que bebes y cuando. \n" +
                                            "6)Haz ejercicio. \n"
                            );
                        } else if (imc >= 18.5 && imc < 24.9) {
                            mensaje += "\nAdecuado";
                            txtRecomendacion.setVisibility(View.GONE);
                        } else if (imc >= 25.0 && imc < 29.9) {
                            mensaje += "\nSobrePeso";
                            txtRecomendacion.setVisibility(View.GONE);
                        } else if (imc >= 30.0 && imc < 34.9) {
                            mensaje += "\nObesidad grado 1";
                            txtRecomendacion.setVisibility(View.GONE);
                        }
                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                }catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Porfavor ingresa valores validos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


