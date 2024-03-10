package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtResult;
        EditText edtweight,edtheightft,edtheightin;
        Button btnCalculate;
        LinearLayout llmain;

        edtweight=findViewById(R.id.edtweight);
        edtheightft=findViewById(R.id.edtheightft);
        edtheightin=findViewById(R.id.edtheightin);
        btnCalculate=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);
        llmain=findViewById(R.id.llmain);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weight=Integer.parseInt(edtweight.getText().toString());
                int ft=Integer.parseInt(edtheightft.getText().toString());
                int in=Integer.parseInt(edtheightin.getText().toString());

                int totalin=ft*12+in;
                double cm=totalin*2.53;
                double metre=cm/100;

                double bmi=weight/(metre*metre);

                if (bmi>25){
                    txtResult.setText("You are overweight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.colorOw));
                }else if(bmi<18){
                    txtResult.setText("you are underweight");
                    llmain.setBackgroundColor((getResources().getColor(R.color.colorUw)));
                }else{
                    txtResult.setText("you are  healthy");
                    llmain.setBackgroundColor(getResources().getColor(R.color.colorFw));
                }
            }
        });
    }
}