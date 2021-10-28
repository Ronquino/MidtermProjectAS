package com.quino.midtermproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView from = (TextView) findViewById(R.id.from);
        TextView to = (TextView) findViewById(R.id.to);

        MaterialButton selectroute = (MaterialButton) findViewById(R.id.selectroute);

        //admin and admin

        selectroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(from.getText().toString().equals("Bohol") && to.getText().toString().equals("Cebu")){
                    //correct
                    Toast.makeText(MainActivity.this, "Trip Scheduled Succesfully", Toast.LENGTH_SHORT).show();
                }else
                    //incorrect
                Toast.makeText(MainActivity.this, "Schedule not found !", Toast.LENGTH_SHORT).show();

            }
        });

    }
}