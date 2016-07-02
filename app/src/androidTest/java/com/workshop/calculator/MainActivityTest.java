package com.workshop.calculator;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by nextzy on 7/2/2016 AD.
 */

public class MainActivityTest {

    public ViewInteraction editTextNumber1;
    public ViewInteraction editTextNumber2;

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    @BeforeClass
    public void initialActivity() {
        editTextNumber1 = onView(withId(R.id.edittext_number1));
        editTextNumber2 = onView(withId(R.id.edittext_number2));
    }

    @Test
    public void showEditTextNumber1(){
        editTextNumber1.check(matches(isDisplayed()));
    }

    @Test
    public void showEditTextNumber2(){

        editTextNumber2.check(matches(isDisplayed()));
    }
}