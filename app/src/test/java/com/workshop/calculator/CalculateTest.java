package com.workshop.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateTest {

    @Test
    public void testAdd() {
        assertEquals(new Calculate(100,10).plus(),"110.00");
        assertEquals(new Calculate(123,10).plus(),"133.00");
        assertEquals(new Calculate(-123,10).plus(),"-113.00");
        assertEquals(new Calculate(1000,3).plus(),"1,003.00");
        assertEquals(new Calculate(1000,7).plus(),"1,007.00");
        assertEquals(new Calculate(1000,6).plus(),"1,006.00");
        assertEquals(new Calculate(789,0.123).plus(),"789.12");
        assertEquals(new Calculate(1000000000,1000).plus(),"Error");
        assertEquals(new Calculate(10000000000.00,1000).plus(),"Error");
        assertEquals(new Calculate(-10000000000.00,1000).plus(),"Error");
    }
    @Test
    public void testSubtract() {
        assertEquals(new Calculate(100,10).minus(),"90.00");
        assertEquals(new Calculate(123,10).minus(),"113.00");
        assertEquals(new Calculate(-123,10).minus(),"-133.00");
        assertEquals(new Calculate(1000,3).minus(),"997.00");
        assertEquals(new Calculate(1000,7).minus(),"993.00");
        assertEquals(new Calculate(1000,6).minus(),"994.00");
        assertEquals(new Calculate(789,0.123).minus(),"788.88");
        assertEquals(new Calculate(1000000000,1000).minus(),"Error");
        assertEquals(new Calculate(10000000000.00,1000).minus(),"Error");
        assertEquals(new Calculate(-10000000000.00,1000).minus(),"Error");
    }
    @Test
    public void testMultiply() {
        assertEquals(new Calculate(100,10).multiply(),"1,000.00");
        assertEquals(new Calculate(123,10).multiply(),"1,230.00");
        assertEquals(new Calculate(-123,10).multiply(),"-1,230.00");
        assertEquals(new Calculate(1000,3).multiply(),"3,000.00");
        assertEquals(new Calculate(1000,7).multiply(),"7,000.00");
        assertEquals(new Calculate(1000,6).multiply(),"6,000.00");
        assertEquals(new Calculate(789,0.123).multiply(),"97.05");
        assertEquals(new Calculate(1000000000,1000).multiply(),"Error");
        assertEquals(new Calculate(10000000000.00,1000).multiply(),"Error");
        assertEquals(new Calculate(-10000000000.00,1000).multiply(),"Error");
    }
    @Test
    public void testDivide() {
        assertEquals(new Calculate(100,10).divide(),"10.00");
        assertEquals(new Calculate(123,10).divide(),"12.30");
        assertEquals(new Calculate(-123,10).divide(),"-12.30");
        assertEquals(new Calculate(1000,3).divide(),"333.33");
        assertEquals(new Calculate(1000,7).divide(),"142.86");
        assertEquals(new Calculate(1000,6).divide(),"166.67");
        assertEquals(new Calculate(789,0.123).divide(),"6,414.63");
        assertEquals(new Calculate(1000000000,1000).divide(),"1,000,000.00");
        assertEquals(new Calculate(10000000000.00,1000).divide(),"Error");
        assertEquals(new Calculate(-10000000000.00,1000).divide(),"Error");
    }
    @Test
    public void testDivideByZero() {
        assertEquals(new Calculate(100,0).divide(),"Infinity");
    }
    @Test
    public void testZeroDivide() {
        assertEquals(new Calculate(0,100).divide(),"0.00");
    }
}
