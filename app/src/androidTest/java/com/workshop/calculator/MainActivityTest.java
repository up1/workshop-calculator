package com.workshop.calculator;

import org.junit.BeforeClass;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.junit.Assert.*;

/**
 * Created by nextzy on 7/2/2016 AD.
 */

public class MainActivityTest {

    @BeforeClass
    public void initialActivity() {

    }

    @Test
    public void showEditTextNumber1(){
        onView(R.id.edittext_number1).check(matches(isDisplayed()));
    }

    @Test
    public void showEditTextNumber2(){
        onView(R.id.edittext_number2).check(matches(isDisplayed()));
    }
}