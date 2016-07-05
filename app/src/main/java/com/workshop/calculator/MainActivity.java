package com.workshop.calculator;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.workshop.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String currentOperator;

    static final String DISPLAY_RESULT = "display_result";

    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initInstance();
    }

    private void initInstance() {
        activityMainBinding.buttonOk.setOnClickListener(this);
        activityMainBinding.operatorPlus.setOnClickListener(this);
        activityMainBinding.operatorMinus.setOnClickListener(this);
        activityMainBinding.operatorDivide.setOnClickListener(this);
        activityMainBinding.operatorMultiply.setOnClickListener(this);
    }


    private void setCurrentOperator(String operator) {
        currentOperator = operator;
    }

    private double getLeftNumber() {
        return Double.valueOf(numberize(activityMainBinding.edittextNumber1.getText().toString()));
    }

    private double getRightNumber() {
        return Double.valueOf(numberize(activityMainBinding.edittextNumber2.getText().toString()));
    }

    private String numberize(String string) {
        return string.replaceAll(",", "");

    }

    private String getCurrentOperator() {
        if (currentOperator == null) {
            Toast.makeText(this, "Select an operator first.", Toast.LENGTH_SHORT).show();
        }
        return currentOperator;
    }

    private void operate() {

        double leftNumber = getLeftNumber();
        double rightNumber = getRightNumber();
        String operator = getCurrentOperator();
        Calculate calculate = new Calculate(leftNumber, rightNumber);
        String result;
        switch (operator) {
            case "+" :
                result = calculate.plus();
                break;
            case "-" :
                result = calculate.minus();
                break;
            case  "*" :
                result = calculate.multiply();
                break;
            case "/" :
                result = calculate.divide();
                break;
            default:
                result = "N/A";
        }
        if (!result.equals("N/A")) {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(DISPLAY_RESULT, result);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == activityMainBinding.buttonOk) {
            if (getCurrentOperator() != null) {
                operate();
            }

        } else if (v == activityMainBinding.operatorPlus) {
            setCurrentOperator("+");
        } else if (v == activityMainBinding.operatorMinus) {
            setCurrentOperator("-");
        } else if (v == activityMainBinding.operatorMultiply) {
            setCurrentOperator("*");
        } else if (v == activityMainBinding.operatorDivide) {
            setCurrentOperator("/");
        }

    }


}
