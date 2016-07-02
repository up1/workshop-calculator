package com.workshop.calculator;

import android.content.Intent;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;


public class MainActivityTest {

    public ViewInteraction editTextNumber1 = onView(withId(R.id.edittext_number1));
    public ViewInteraction editTextNumber2 = onView(withId(R.id.edittext_number2));
    public ViewInteraction operatorPlus = onView(withId(R.id.operator_plus));
    public ViewInteraction operatorMultiply = onView(withId(R.id.operator_multiply));
    public ViewInteraction operatorMinus = onView(withId(R.id.operator_minus));
    public ViewInteraction operatorDivide = onView(withId(R.id.operator_divide));
    public ViewInteraction buttonOk = onView(withId(R.id.button_ok));

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class, true, false);

    @Before
    public void setUp(){
        Intent intent = new Intent();
        activityTestRule.launchActivity(intent);
    }

    @Test
    public void showEditTextNumber1() {
        editTextNumber1.check(matches(isDisplayed()));
    }

    @Test
    public void showEditTextNumber2() {
        editTextNumber2.check(matches(isDisplayed()));
    }

    @Test
    public void operatorPlusShowOnDisPlay() {
        operatorPlus.check(matches(isDisplayed()));
    }

    @Test
    public void operatorMinusShowOnDisPlay() {
        operatorMinus.check(matches(isDisplayed()));
    }

    @Test
    public void operatorMultiplyShowOnDisPlay() {
        operatorMultiply.check(matches(isDisplayed()));
    }

    @Test
    public void operatorDivideShowOnDisPlay() {
        operatorDivide.check(matches(isDisplayed()));
    }

    @Test
    public void buttonOkShowOnDisPlay() {
        buttonOk.check(matches(isDisplayed()));
    }
}