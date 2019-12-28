package com.wen.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView edMonth;
    private Button button;
    public float money = 0;
    boolean isNext = false;
    private Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edMonth = findViewById(R.id.monthly);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button();
            }
        });
        sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.sw);
                text.setText(isNext ? "Every other month" : "Monthly");
                TextView text1 = findViewById(R.id.monthQ);
                text1.setText(isNext ? "Every other month" : "Monthly");
            }
        });
    }

    private void button() {
        if (!TextUtils.isEmpty(edMonth.getText().toString())) {
            float m = Float.parseFloat(edMonth.getText().toString());
            if (m >= 1 && 10 >= m) {
                money = (float) ((m*7.35));
            } else if (m >= 11 && 30 >= m) {
                money = (float)((m*9.45)-21);
            } else if (m >= 31 && 50 >= m) {
                money = (float)((m*11.55)-84);
            } else if (m >= 51) {
                money = (float)((m*12.075)-110.25);
            }
        }
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("Money",money);
        startActivity(intent);
    }
}
