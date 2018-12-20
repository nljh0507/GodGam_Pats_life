package com.example.godgam_pats_life;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Detail_View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__view);
        Intent i = getIntent();
        String a = i.getStringExtra("n");
        TextView txt = (TextView)findViewById(R.id.textView);
        txt.setText(a);
    }
}
