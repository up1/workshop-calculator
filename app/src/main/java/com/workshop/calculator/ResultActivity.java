package com.workshop.calculator;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.workshop.calculator.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {
    public static final String DISPLAY_RESULT = "display_result";
    public ActivityResultBinding binder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        binder = DataBindingUtil.setContentView(this,R.layout.activity_result);
        Intent intent = getIntent();
        CalculatorValue result=new CalculatorValue(intent.getStringExtra(DISPLAY_RESULT));
        binder.setCalculatorValue(result);
    }
}
