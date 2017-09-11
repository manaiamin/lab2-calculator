package com.example.a1537066.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText amount,years, rate;
    TextView month, totalPayment, totalInterest;
    double num1, num2, num3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = (EditText) findViewById(R.id.amount);
        years = (EditText) findViewById(R.id.years);
        rate = (EditText) findViewById(R.id.rate);

        month = (TextView) findViewById(R.id.monthlypayment);
        totalPayment = (TextView) findViewById(R.id.totalpayment);
        totalInterest = (TextView) findViewById(R.id.totalinterest);

    }

    public void calculateLoan(View v) {
        num1 = Double.parseDouble(amount.getText().toString());
        num2 = Double.parseDouble(years.getText().toString());
        num3 = Double.parseDouble(rate.getText().toString());

        double monthlyPayment;
        double monthlyInterestRate;
        double numberOfPayments;

        if (num2 != 0 && num3 != 0)
        {
            //calculate the monthly payment
            monthlyInterestRate = num3 / 1200;
            numberOfPayments = num2 * 12;

            monthlyPayment =
                    (num1 * monthlyInterestRate) /
                            (1 - (1 / Math.pow ((1 + monthlyInterestRate), numberOfPayments)));

            monthlyPayment = Math.round (monthlyPayment * 100) / 100.0;
            month.setText(Double.toString(monthlyPayment));
            double total = monthlyPayment * num2 * 12;
            totalPayment.setText(Double.toString(total));
            double interest = total - num1;
            totalInterest.setText(Double.toString(interest));
        } else {
            month.setText(Double.toString(0));
            totalPayment.setText(Double.toString(0));
            totalInterest.setText(Double.toString(0));
        }


    }

    public void clear(View v) {
        amount.setText("");
        years.setText("");
        rate.setText("");
        month.setText("");
        totalPayment.setText("");
        totalInterest.setText("");
    }

}
