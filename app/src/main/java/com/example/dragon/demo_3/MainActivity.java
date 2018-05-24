package com.example.dragon.demo_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView gridView  ;
    private ArrayList<Product> pro;
    private  CustomAdapter adapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView= findViewById(R.id.gridView);
        pro = new ArrayList<>();
            pro.add(new Product("1","san pham 1",10000,2018));
        adapters = new CustomAdapter(this,R.layout.custom_list_view,pro);
        gridView.setAdapter(adapters);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("product",adapters.getItemId(position));
                startActivity(i);
            }
        });
    }
    public void addNew(View view){
        Intent itent = new Intent(getApplicationContext(),AddNewActivity.class);
        startActivityForResult(itent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==200){
           Product product = (Product) data.getSerializableExtra("product");
            adapters.add(product);
            //Cẩn thận thì set lại
            gridView.setAdapter(adapters);
        }
    }
}
