package com.example.godgam_pats_life;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class hospital_item_a extends AppCompatActivity {
    public String strTitle;
    public String strDate;
    public View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_item);
    }
    public void onClick(View v){
       // TextView text = (TextView)findViewById(R.id.textTitle);
       // String a = text.getText().toString();
        Intent i = new Intent(this,Detail_View.class);
        //i.putExtra("n",a);
        startActivity(i);
        //finish();
    }
}
