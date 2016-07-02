package com.workshop.calculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by pm on 2/7/2559.
 */

public class Divide {
    public String calculate (double firstNo, double secondNo) {
        if (secondNo == 0) {
            return "Infinity";
        } else if (Math.abs(firstNo / secondNo) > 1000000) {
            return "Error";
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###,##0.00");
            return decimalFormat.format(Math.round(firstNo / secondNo * 100)/100.00);
        }
    }
}
