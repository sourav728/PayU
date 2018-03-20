package com.example.tvd.payu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText fname, pnumber, emailAddress, rechargeAmt;
    Button Paynow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname        = (EditText)findViewById(R.id.fname);
        pnumber      = (EditText)findViewById(R.id.pnumber);
        emailAddress = (EditText)findViewById(R.id.emailAddress);
        rechargeAmt  = (EditText)findViewById(R.id.rechargeAmt);
        Paynow       = (Button)findViewById(R.id.Paynow);

        Paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getFname = fname.getText().toString().trim();
                String getPhone = pnumber.getText().toString().trim();
                String getEmail = emailAddress.getText().toString().trim();
                String getAmt   = rechargeAmt.getText().toString();//rechargeAmt.getText().toString().trim();

                Intent intent = new Intent(getApplicationContext(), PaymentGateway.class);
                intent.putExtra("FIRST_NAME",getFname);
                intent.putExtra("PHONE_NUMBER",getPhone);
                intent.putExtra("EMAIL_ADDRESS",getEmail);
                intent.putExtra("RECHARGE_AMT",getAmt);
                startActivity(intent);

            }
        });

    }
}
