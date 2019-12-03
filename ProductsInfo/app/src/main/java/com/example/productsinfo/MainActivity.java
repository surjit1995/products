package com.example.productsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    ImageView prodImg;
    Spinner spproducts;
    EditText etprice,etquantity,ettotalresult;
    Button btnplaceorder,btnlogout;
double[] price = {1450,3450,456,6789,7890};
 int [] imageList = {R.drawable.mouse,R.drawable.keyboard,R.drawable.laptop,R.drawable.printer,R.drawable.scanner};

static int i;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prodImg = findViewById(R.id.img);
        prodImg.setBackgroundResource(R.drawable.laptop);
        etprice=findViewById(R.id.showprice);
        etquantity=findViewById(R.id.quantity);
        ettotalresult=findViewById(R.id.totalresult);
        btnplaceorder=findViewById(R.id.placeorder);
        btnlogout=findViewById(R.id.logout);

        spproducts=findViewById(R.id.productspinner);



        List<String> products = new  ArrayList<String>();


        products.add("Mouse");
        products.add("Keyboard");
        products.add("Laptop");
        products.add("Printer");
        products.add("Scanner");

        ArrayAdapter<String> proAdapter = new ArrayAdapter<String>( this,R.layout.support_simple_spinner_dropdown_item,products);


        proAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);


        spproducts.setAdapter(proAdapter);

spproducts.setOnItemSelectedListener(this);
btnplaceorder.setOnClickListener(this);
btnlogout.setOnClickListener(this);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

i=position;
Double p = new Double(price[i]);
etprice.setText(p.toString());
        int img=imageList[i];
        prodImg.setBackgroundResource(img);



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.logout :
                Intent act = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(act);
                break;

            case R.id.placeorder:
                double p=Double.parseDouble(etprice.getText().toString());
                double t=p*Double.parseDouble(etquantity.getText().toString());

                Double result = new Double(t);
                ettotalresult.setText(result.toString());

                break;
        }

    }
}
