package com.example.godgam_pats_life;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class sales_Detail_View extends AppCompatActivity {
    float x;
    float y;
    String number;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales__detail__view);
        loadDB();
    }
    protected void onResume() {
        super.onResume();

    }
    public void loadDB(){
        Intent i = getIntent();
        int id = i.getExtras().getInt("a",0);
        name = i.getExtras().getString("b");
        String address = i.getExtras().getString("c");
        number = i.getExtras().getString("d");
        TextView text_name = (TextView)findViewById(R.id.textView);
        TextView text_address = (TextView)findViewById(R.id.textView5);
        TextView text_number = (TextView)findViewById(R.id.textView2);

        text_name.setText(name);
        text_address.setText(address);
        text_number.setText(number);
    }
    public void onClickButton(View v){
        int id = v.getId();
        Intent intent;
        Intent i = getIntent();
        switch (id){
            case R.id.button4:
                intent = new Intent(sales_Detail_View.this,MapsActivity.class);
                name = i.getExtras().getString("b");
                float x = i.getExtras().getFloat("e");
                float y = i.getExtras().getFloat("f");
                intent.putExtra("e",x);
                intent.putExtra("f",y);
                intent.putExtra("b",name);
                startActivity(intent);
                break;
            case R.id.button5:
                number = i.getExtras().getString("d");
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);
                break;
        }
    }
}