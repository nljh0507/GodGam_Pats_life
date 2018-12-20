package com.example.godgam_pats_life;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class animal_sales extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_sales);
        loadDB();
    }
    protected void onResume() {
        super.onResume();
        loadDB();
    }
    public void onClickButton(View v){
        EditText editText = (EditText)findViewById(R.id.list_editText);
        String a = editText.getText().toString();
        @SuppressLint("WrongConstant") SQLiteDatabase db = openOrCreateDatabase(
                "godgam_sales.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null );

        Cursor c = db.rawQuery("SELECT * FROM godgam_sales Where new_address LIKE '"+a+"%';", null);
        ListAdapter adapt = new SimpleCursorAdapter(
                this,
                R.layout.hospital_item,
                c,
                new String[]{"name","new_address"},
                new int[]{R.id.textTitle ,R.id.textDate});

        setListAdapter(adapt);

        if(db != null){
            db.close();
        }
    }
    public void loadDB(){
        @SuppressLint("WrongConstant") SQLiteDatabase db = openOrCreateDatabase(
                "godgam_sales.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null );

        db.execSQL("CREATE TABLE IF NOT EXISTS godgam_sales "
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,cname INTEGER not null unique, name TEXT, age INTEGER);");

        final Cursor c = db.rawQuery("SELECT * FROM godgam_sales;", null);
        startManagingCursor(c);

        SimpleCursorAdapter adapt = new SimpleCursorAdapter(
                this,
                R.layout.hospital_item,
                c,
                new String[]{"name","new_address"},
                new int[]{R.id.textTitle ,R.id.textDate});
        ListView Iv = (ListView) findViewById(android.R.id.list);
        Iv.setAdapter(adapt);
        Iv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // TODO Auto-generated method stub


                Intent intent = new Intent(animal_sales.this, sales_Detail_View.class);
                intent.putExtra("a", c.getString(c.getColumnIndex("_id")));
                intent.putExtra("b", c.getString(c.getColumnIndex("name")));
                intent.putExtra("c", c.getString(c.getColumnIndex("new_address")));
                intent.putExtra("d", c.getString(c.getColumnIndex("call")));
                intent.putExtra("e", c.getString(c.getColumnIndex("(X)")));
                intent.putExtra("f", c.getString(c.getColumnIndex("(Y)")));

                startActivity(intent);
            }
        });
    }
}
