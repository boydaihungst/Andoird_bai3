package com.example.dragon.demo_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewActivity extends AppCompatActivity {
    private EditText txtCode;
    private EditText txtName;
    private EditText txtPrice;
    private EditText txtYear;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        txtCode = findViewById(R.id.txtCode);
        txtName = findViewById(R.id.tvName);
        txtPrice = findViewById(R.id.txtPrice);
        txtYear = findViewById(R.id.txtYear);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product pro = new Product(txtCode.getText().toString(), txtName.getText().toString(), Double.parseDouble(txtPrice.getText().toString()), Integer.parseInt(txtYear.getText().toString()));
                Intent intent = new Intent();
                intent.putExtra("product", pro);
                setResult(200, intent);
                finish();
            }
        });
    }


}

