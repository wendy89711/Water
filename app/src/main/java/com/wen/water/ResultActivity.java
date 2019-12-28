package com.wen.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private static final float DEFAULT_FEE = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        float money = getIntent().getFloatExtra("Money",DEFAULT_FEE);
        TextView moneyText = findViewById(R.id.money);
        int n = (int)(money + 0.5f) ;
        moneyText.setText(n + "");
    }
}
