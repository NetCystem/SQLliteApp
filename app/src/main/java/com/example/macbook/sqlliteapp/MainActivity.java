package com.example.macbook.sqlliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nametext,agetext, id;
    private Button go,save, update, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nametext = findViewById(R.id.name);
        agetext = findViewById(R.id.age);
        id = findViewById(R.id.id);
        go = findViewById(R.id.go);
        save = findViewById(R.id.save);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        final DbHelper dbHelper = new DbHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nametext.getText().toString();
                String age = agetext.getText().toString();

                if (dbHelper.myInsert(name,age)){
                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

                }
            }
        });


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nametext.getText().toString();
                String age = agetext.getText().toString();
                String iD = id.getText().toString();

                dbHelper.myUpdate(iD, name, age);
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String iD = id.getText().toString();
                dbHelper.deleByID(iD);
            }
        });
    }



}
