package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class Compass extends AppCompatActivity
        implements SensorEventListener {
    private TextView output;
    private ImageView compass;
    private float currentDegree = 0f;
    private SensorManager sm;
    private Sensor ms, as;
    float[] gravity, geomagnetic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        // 取得ImageView和TextView元件
        compass = (ImageView) findViewById(R.id.imageView);
        output = (TextView) findViewById(R.id.lblOutput);
        // 取得感測器系統服務
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        // 取得磁場感測器
        ms = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        // 取得加速感測器
        as = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
    @Override
    protected void onResume() {
        super.onResume();
        // 註冊SensorEventListener傾聽者物件
        sm.registerListener(this, ms, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, as, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        // 取消註冊SensorEventListener傾聽者物件
        sm.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor mySensor = sensorEvent.sensor;
        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER)
            gravity = sensorEvent.values;
        if (mySensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
            geomagnetic = sensorEvent.values;
        //  加速和磁場感測器都有改變
        if (gravity != null && geomagnetic != null) {
            float r[] = new float[9];
            // 使用感測器值計算出旋轉矩陣
            boolean success = SensorManager.getRotationMatrix(r, null, gravity, geomagnetic);
            if (success) {  // 有取得
                float values[] = new float[3];
                SensorManager.getOrientation(r, values); // 取得方位
                // 轉換成角度
                float degree = Math.round(Math.toDegrees(values[0]) + 360 ) % 360;
                output.setText("目前的方位: " + Float.toString(degree) + " 度");
                // 旋轉ImageView元件從目前角度至新角度
                RotateAnimation ra = new RotateAnimation(currentDegree, -degree,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                ra.setDuration(120);
                ra.setFillAfter(true);
                compass.startAnimation(ra);
                currentDegree = -degree;     // 更新目前的角度
            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {   }
    public void button10_Click(View view){
        Intent intent =
                new Intent(this,MainActivity.class);
        startActivity((intent));
    }
}