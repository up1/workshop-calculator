package com.workshop.calculator;

/**
 * Created by Fixer on 7/5/2016.
 */

class CalculatorValue {
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    String result;

    public CalculatorValue(String result) {
        this.result = result;
    }
}
