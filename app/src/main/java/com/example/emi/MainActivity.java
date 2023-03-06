package com.example.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Amount, Rate, Numberofmonths;

    Button Calculate;

    TextView txtemi, TotalAmt, txtRateAmt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Amount = findViewById(R.id.Amount);
        Rate = findViewById(R.id.Rate);
        Numberofmonths = findViewById(R.id.Numberofmonths);
        Calculate = findViewById(R.id.Calculate);
        txtemi = findViewById(R.id.txtemi);
        TotalAmt = findViewById(R.id.TotalAmt);
        txtRateAmt = findViewById(R.id.txtRateAmt);

    Calculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            int Amt = Integer.parseInt(Amount.getText().toString());
            double Inrate = Double.parseDouble(Rate.getText().toString());
            int months = Integer.parseInt(Numberofmonths.getText().toString());


            double r = Inrate/(12*100);
            double cal1 = 1;
            for (int i = 0; i<months; i++){
                cal1 *= (1+r);
            }

            double ans = Amt * r * (cal1/(cal1-1));
            txtemi.setText("EMI : "+ans);
            double Total = ans*months;
            TotalAmt.setText("Total Amount : "+Total);
            double iAmt = Total-Amt;
            txtRateAmt.setText("Interest Amount : "+iAmt);

        }
    });

    }
}