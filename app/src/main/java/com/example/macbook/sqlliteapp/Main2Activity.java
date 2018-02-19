package com.example.macbook.sqlliteapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView readText;
    private Button read;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        read = findViewById(R.id.read);
        readText = findViewById(R.id.read_text);

        final DbHelper dbHelper = new DbHelper(this);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dbHelper.getDates();

                StringBuilder stringBuilder = new StringBuilder();
                while (cursor.moveToNext()){
                    stringBuilder.append("ID " + cursor.getString(0) + "\n");
                    stringBuilder.append("Name " + cursor.getString(1) + "\n");
                    stringBuilder.append("Age " + cursor.getString(2) + "\n");
                }
                readText.setText(stringBuilder);
            }
        });
    }
}
