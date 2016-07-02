package com.workshop.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pm on 2/7/2559.
 */
public class DivideTest {
    @Test
    public void testDivide() {
        assertEquals(new Divide().calculate(100,10),"10.00");
        assertEquals(new Divide().calculate(123,10),"12.30");
        assertEquals(new Divide().calculate(-123,10),"-12.30");
        assertEquals(new Divide().calculate(1000,3),"333.33");
        assertEquals(new Divide().calculate(1000,7),"142.86");
        assertEquals(new Divide().calculate(1000,6),"166.67");
        assertEquals(new Divide().calculate(789,0.123),"6,414.63");
        assertEquals(new Divide().calculate(1000000000,1000),"1,000,000.00");
        assertEquals(new Divide().calculate(10000000000.00,1000),"Error");
        assertEquals(new Divide().calculate(-10000000000.00,1000),"Error");
    }
    @Test
    public void testDivideByZero() {
        assertEquals(new Divide().calculate(100,0),"Infinity");
    }
    @Test
    public void testZeroDivide() {
        assertEquals(new Divide().calculate(0,100),"0.00");
    }
}
