package com.workshop.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etText1;
    private EditText etText2;

    private Button buttonOk;
    private Button operatorPlus;
    private Button operatorMinus;
    private Button operatorMultiply;
    private Button operatorDivide;
    private String currentOperator;

    static final String DISPLAY_RESULT = "display_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstance();
    }

    private void initInstance() {
        etText1 = (EditText) findViewById(R.id.edittext_number1);
        etText2 = (EditText) findViewById(R.id.edittext_number2);
        buttonOk = (Button) findViewById(R.id.button_ok);
        operatorPlus = (Button) findViewById(R.id.operator_plus);
        operatorMinus = (Button) findViewById(R.id.operator_minus);
        operatorMultiply = (Button) findViewById(R.id.operator_multiply);
        operatorDivide = (Button) findViewById(R.id.operator_divide);

        buttonOk.setOnClickListener(this);
        operatorPlus.setOnClickListener(this);
        operatorMinus.setOnClickListener(this);
        operatorMultiply.setOnClickListener(this);
        operatorDivide.setOnClickListener(this);
    }


    private void setCurrentOperator(String operator) {
        currentOperator = operator;
    }

    private double getLeftNumber() {
        return Double.valueOf(numberize(etText1.getText().toString()));
    }

    private double getRightNumber() {
        return Double.valueOf(numberize(etText2.getText().toString()));
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
        if (v == buttonOk) {
            if (getCurrentOperator() != null) {
                operate();
            }

        } else if (v == operatorPlus) {
            setCurrentOperator("+");
        } else if (v == operatorMinus) {
            setCurrentOperator("-");
        } else if (v == operatorMultiply) {
            setCurrentOperator("*");
        } else if (v == operatorDivide) {
            setCurrentOperator("/");
        }

    }


}
