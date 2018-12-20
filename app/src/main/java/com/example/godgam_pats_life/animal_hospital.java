package com.example.godgam_pats_life;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class animal_hospital extends ListActivity {
    //animal_hospital ListActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_hospital_list);

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
                "leejunghee.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null );

        Cursor c = db.rawQuery("SELECT * FROM hospital Where new_address LIKE '"+a+"%';", null);
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
                "leejunghee.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null );

        db.execSQL("CREATE TABLE IF NOT EXISTS hospital "
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,cname INTEGER not null unique, name TEXT, age INTEGER);");

        Cursor c = db.rawQuery("SELECT * FROM hospital;", null);
        startManagingCursor(c);

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
}

