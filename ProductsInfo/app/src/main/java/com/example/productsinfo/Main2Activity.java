package com.example.productsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
Button btnlogin;
EditText etusername,etpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


 etusername=findViewById(R.id.usernamr);
 etpassword=findViewById(R.id.password);
        btnlogin= findViewById(R.id.login);

        btnlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(etusername.getText().toString().equals("admin")&&etpassword.getText().toString().equals("123")) {

            Intent act = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(act);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please enter valid username and password",Toast.LENGTH_SHORT).show();
        }
    }
}
