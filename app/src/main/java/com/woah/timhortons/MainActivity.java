package com.woah.timhortons;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.cert.CollectionCertStoreParameters;

public class MainActivity extends AppCompatActivity {
    Button button, button1,btFinal;
    TextView tvQuantity;
    TextView bill;
    EditText etName;
    int qty = 0, cost = 50, prc = 0;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.order);
        button1 = (Button) findViewById(R.id.order1);
        btFinal = (Button) findViewById(R.id.Final);
        tvQuantity = (TextView) findViewById(R.id.quantity);
        bill = (TextView) findViewById(R.id.bill);
        etName = (EditText) findViewById(R.id.name);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty += 1;
                prc = qty * cost;
                tvQuantity.setText(qty + "");



            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qty > 0) {
                    qty -= 1;
                    prc -= cost;
                    tvQuantity.setText(qty + "");
                }
            }
        });
        final Context context=this;
        btFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = etName.getText().toString();
                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                builder.setMessage(name + ", your final bill is: "+prc+" for "+qty+" drinks.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        etName.setText("");
                        bill.setText("");
                        tvQuantity.setText("0");
                        qty=0;
                    }
                });
                builder.create().show();
            }
        });
    }
}
