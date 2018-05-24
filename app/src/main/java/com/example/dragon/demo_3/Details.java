package com.example.dragon.demo_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    private TextView tvCode;
    private  TextView tvName;
    private TextView tvPrice;
    private TextView tvYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Product product = (Product) getIntent().getSerializableExtra("product");
        tvCode= findViewById(R.id.tvCode);
        tvName=findViewById(R.id.tvName);
        tvPrice =findViewById(R.id.tvPrice);
        tvYear=findViewById(R.id.tvYear);
        tvCode.setText(product.getCode());
        tvName.setText(product.getName());
        tvPrice.setText(String.valueOf(product.getPrice()));
        tvYear.setText(String.valueOf(product.getYear()));

    }
}
