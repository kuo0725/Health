package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
public class bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
    }
    public void button_Click(View view) {
        EditText name=(EditText)findViewById(R.id.txtName);//姓名
        String str = name.getText().toString();

        String gender="";//性別
        RadioButton boy = (RadioButton)findViewById(R.id.rdbBoy);
        if (boy.isChecked())
            gender += "男性";
        RadioButton girl = (RadioButton)findViewById(R.id.rdbGirl);
        if (girl.isChecked())
            gender += "女性";
        //取得門票種類
        EditText txtTemp2=(EditText)findViewById(R.id.editTextNumber4);//年齡
        int tmp2=Integer.parseInt(txtTemp2.getText().toString());

        EditText txtTemp=(EditText)findViewById(R.id.editTextNumber);//身高
        double tmp=Double.parseDouble(txtTemp.getText().toString());

        EditText txtTemp1=(EditText)findViewById(R.id.editTextNumber2);//體重
        double tmp1=Double.parseDouble(txtTemp1.getText().toString());

        double result = tmp1 / ((tmp /100 ) * ( tmp/ 100 ));//計算BMI
        String result2 = String.format("%.2f",result);

        String Bmi ="";
        if(result<18.50){
            Bmi="「體重過輕」，需要多運動，均衡飲食，以增加體能，維持健康！";}
        else if(result>=18.50 && result<24.00){
            Bmi="恭喜！「健康體重」，要繼續保持！";}
        else if(result>=24.00 && result<27){
            Bmi = "「體重過重」了，要小心囉，趕快力行「健康體重管理」！";}
        else if(result>=27.00){
            Bmi = "啊～「肥胖」，需要立刻力行「健康體重管理」囉！";
        }

        TextView output = (TextView) findViewById(R.id.IbIOutput);
        output.setText(str+"您的性別為"+gender+"，年齡為"+tmp2+
                "歲\n您的BMI結果是:" + result2+"\n"+Bmi);}
    public void button2_Click(View view) {  //清除
        TextView output = (TextView) findViewById(R.id.IbIOutput);
        output.setText("BMI結果:");
        TextView output1 = (TextView) findViewById(R.id.editTextNumber);
        output1.setText("");
        TextView output2 = (TextView) findViewById(R.id.editTextNumber2);
        output2.setText("");
        TextView output3 = (TextView) findViewById(R.id.txtName);
        output3.setText("");
        TextView output4 = (TextView) findViewById(R.id.editTextNumber4);
        output4.setText("");
    }
    public void button8_Click(View view){
        Intent intent =
                new Intent(this,MainActivity.class);
        startActivity((intent));
    }
}