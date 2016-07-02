package com.workshop.calculator;

import java.text.DecimalFormat;

public class Calculate {
    private double firstNo, secondNo;
    public Calculate(double firstNo, double secondNo) {
        this.firstNo = firstNo;
        this.secondNo = secondNo;
    }


    public String plus() {
        return numberFormat(firstNo + secondNo);
    }
    public String minus() {
        return numberFormat(firstNo - secondNo);
    }
    public String multiply() {
        return numberFormat(firstNo * secondNo);
    }
    public String divide() {
        if (secondNo == 0)
            return "Infinity";
        else
            return numberFormat(firstNo / secondNo);
    }

    private String numberFormat(double result) {
        if (Math.abs(result) > 1000000) {
            return "Error";
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###,##0.00");
            return decimalFormat.format(Math.round(100.00 * result)/100.00);
        }
    }
}
