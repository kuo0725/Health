package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button3_Click(View view){
        Intent intent = new Intent(this, bmi.class);
        startActivity(intent);
    }

    public void button4_Click(View view){
        Intent intent = new Intent(this, drink.class);
        startActivity(intent);
    }

    public void button5_Click(View view){
        Intent intent = new Intent(this, walk.class);
        startActivity(intent);
    }
    public void button7_Click(View view){
        Intent intent = new Intent(this, Compass.class);
        startActivity(intent);
    }
}
