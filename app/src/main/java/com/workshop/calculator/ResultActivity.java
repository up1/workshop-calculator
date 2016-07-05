package com.workshop.calculator;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.workshop.calculator.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    private TextView textView;
ActivityResultBinding activityResultBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        activityResultBinding= DataBindingUtil.setContentView(this,R.layout.activity_result);

        Intent intent = getIntent();
        String result = intent.getStringExtra("display_result");
        activityResultBinding.displayResult.setText(result);
    }
}
