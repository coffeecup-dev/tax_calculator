package com.example.taxcalculator;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomAdapter customAdapter;
    ImageView shareBtn;
    CardView detailedTaxCard;
    Spinner detailedSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        listView = findViewById(R.id.list_view);
        shareBtn = findViewById(R.id.share);
        detailedTaxCard = findViewById(R.id.detailedtax);



        TaxModel taxModel1 =
                new TaxModel(R.drawable.scale,
                        "Compare Old vs New Rates");
        TaxModel taxModel2 =
                new TaxModel(R.drawable.mortgage, "HRA " +
                        "Exemption Calculator");
        TaxModel taxModel3 =
                new TaxModel(R.drawable.computer,
                        "Compare CTC");
        TaxModel taxModel4 =
                new TaxModel(R.drawable.money_bag,
                        "Capital Gains Tax Calculator");
        TaxModel taxModel5 =
                new TaxModel(R.drawable.tax, "Check " +
                        "Tax Rates");
        TaxModel taxModel6 =
                new TaxModel(R.drawable.survey,
                        "Advance Tax Calculator");

        ArrayList<TaxModel> arrayList = new ArrayList<>();
        arrayList.add(taxModel1);
        arrayList.add(taxModel2);
        arrayList.add(taxModel3);
        arrayList.add(taxModel4);
        arrayList.add(taxModel5);
        arrayList.add(taxModel6);

        customAdapter = new CustomAdapter(MainActivity.this, arrayList);
        listView.setAdapter(customAdapter);

        // adding share btn
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShare =
                        new Intent(Intent.ACTION_SEND);
                intentShare.setType("Text/Plain");
                intentShare.putExtra(Intent.EXTRA_EMAIL,
                        "rakibhasancse1999@gmail.com");
                intentShare.putExtra(Intent.EXTRA_SUBJECT
                        , "");
                startActivity(intentShare);
            }
        });

        //adding detailed tax card
        detailedTaxCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailedSpinner = findViewById(R.id.spiner_detailed);
                Intent detailedIntent =
                        new Intent(MainActivity.this,
                                DetailedTaxActivity.class);
                startActivity(detailedIntent);
                String detailedYear[]= getResources().getStringArray(R.array.spinner_year);
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.spiner_txt_lay, R.id.detailedyeartxt, detailedYear);
                detailedSpinner.setAdapter(adapter);
            }
        });

    }
}