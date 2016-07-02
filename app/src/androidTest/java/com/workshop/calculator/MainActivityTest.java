package com.workshop.calculator;

import android.content.Intent;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;


public class MainActivityTest {

    private ViewInteraction editTextNumber1 = onView(withId(R.id.edittext_number1));
    private ViewInteraction editTextNumber2 = onView(withId(R.id.edittext_number2));
    private ViewInteraction operatorPlus = onView(withId(R.id.operator_plus));
    private ViewInteraction operatorMultiply = onView(withId(R.id.operator_multiply));
    private ViewInteraction operatorMinus = onView(withId(R.id.operator_minus));
    private ViewInteraction operatorDivide = onView(withId(R.id.operator_divide));
    private ViewInteraction buttonOk = onView(withId(R.id.button_ok));

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

    @Test
    public void testAdd() {
        inputNumber();
        operatorPlus.perform(click());
        buttonOk.perform(click());
        onView(withId(R.id.display_result)).check(matches(withText("78,900.12")));
    }

    @Test
    public void testSubtract() {
        inputNumber();
        operatorMinus.perform(click());
        buttonOk.perform(click());
        onView(withId(R.id.display_result)).check(matches(withText("78,899.88")));
    }

    @Test
    public void testMultiply() {
        inputNumber();
        operatorMultiply.perform(click());
        buttonOk.perform(click());
        onView(withId(R.id.display_result)).check(matches(withText("9,704.70")));
    }

    @Test
    public void testDivide() {
        inputNumber();
        operatorDivide.perform(click());
        buttonOk.perform(click());
        onView(withId(R.id.display_result)).check(matches(withText("641,463.41")));
    }

    private void inputNumber() {
        editTextNumber1.perform(typeText("78900"));
        editTextNumber2.perform(typeText("0.123"));
        editTextNumber2.perform(closeSoftKeyboard());
    }

    @Test
    public void testPressOkWithoutOperand() {
        editTextNumber1.perform(typeText("789"));
        editTextNumber2.perform(typeText("0.123"));
        editTextNumber2.perform(closeSoftKeyboard());
        buttonOk.perform(click());
        onView(withId(R.id.display_result)).check(doesNotExist());
        onView(withId(R.id.button_ok)).check(matches(isDisplayed()));
    }
}