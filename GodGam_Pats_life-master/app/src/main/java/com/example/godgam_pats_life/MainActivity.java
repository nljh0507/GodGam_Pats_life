package com.example.godgam_pats_life;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, Intro.class));
    }

    public void OnclickButton(View view){
        Intent i = new Intent(this,animal_hospital.class);
        startActivity(i);
    }
    public void OnclickButton1(View view){
        Intent i = new Intent (this,animal_sales.class);
        startActivity(i);
    }
    public void OnclickButton2(View view){
        Intent i = new Intent (this,animal_death.class);
        startActivity(i);
    }
}
