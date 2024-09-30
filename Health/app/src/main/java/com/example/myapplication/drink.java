package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;


public class drink extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener{
    private TextView output;
    private TextView output2;
    private Calendar dt = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        output = (TextView) findViewById(R.id.lblOutput);
        output2 = (TextView) findViewById(R.id.lblOutput2);
    }
    @Override
    public void onDateSet(DatePicker datePicker, int y, int m, int d){
        output.setText("今日是:" + y + "/" + (m + 1) + "/" + d);
    }
    @Override
    public void onTimeSet(TimePicker timePicker, int h, int m){
        output2.setText("現在時間:" + h + ":" + m);s
    }
    public void button3_Click(View view){
        DatePickerDialog dlg = new DatePickerDialog(this, this,
                dt.get(Calendar.YEAR),
                dt.get(Calendar.MONTH),
                dt.get(Calendar.DAY_OF_MONTH));
        dlg.show();
    }

    public void button4_Click(View view){
        TimePickerDialog dlg = new TimePickerDialog(this, this,
                dt.get(Calendar.HOUR),
                dt.get(Calendar.MINUTE), true);
        dlg.show();
    }

    public void button_Click(View view) {
        EditText name=(EditText)findViewById(R.id.txtName);//姓名
        String str = name.getText().toString();

        EditText Ml=(EditText)findViewById(R.id.MlNumber);//目標水量
        int tmp=Integer.parseInt(Ml.getText().toString());

        int water = 0; //水量選擇
        CheckBox one =(CheckBox)findViewById(R.id.check100ml);
        if(one.isChecked())
            water+=100;
        CheckBox two =(CheckBox)findViewById(R.id.check200ml);
        if (two.isChecked())
            water+=200;
        CheckBox three =(CheckBox)findViewById(R.id.check300ml);
        if(three.isChecked())
            water+=300;
        CheckBox four =(CheckBox)findViewById(R.id.check400ml);
        if(four.isChecked())
            water+=400;
        CheckBox five =(CheckBox)findViewById(R.id.check500ml);
        if(five.isChecked())
            water+=500;

        int w = tmp-water;


        if(w>0){
            TextView output = (TextView) findViewById(R.id.lblOutput3);
            output.setText(str+"，您離目標攝取水量還差"+w+"毫升(ml)，請再繼續攝取水份");
        }
        else{
            TextView output = (TextView) findViewById(R.id.lblOutput3);
            output.setText(str+"，您今日攝取水分已足夠，請繼續保持");
        }

    }
    public void button2_Click(View view) {
        TextView output = (TextView) findViewById(R.id.lblOutput);
        output.setText("今日是:");
        TextView output1 = (TextView) findViewById(R.id.txtName);
        output1.setText("");
        TextView output2 = (TextView) findViewById(R.id.MlNumber);
        output2.setText("");
        TextView output3 = (TextView) findViewById(R.id.lblOutput2);
        output3.setText("現在時間:");
        TextView output4 = (TextView) findViewById(R.id.lblOutput3);
        output4.setText("");
    }
    public void button9_Click(View view){
        Intent intent =
                new Intent(this,MainActivity.class);
        startActivity((intent));
    }
}