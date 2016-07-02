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

    public ViewInteraction edittext_number1 ;
    public ViewInteraction edittext_number2 ;

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    @BeforeClass
    public void initialActivity() {
        edittext_number1 = onView(withId(R.id.edittext_number1));
        edittext_number2 = onView(withId(R.id.edittext_number2));
    }

    @Test
    public void showEditTextNumber1(){
        edittext_number1.check(matches(isDisplayed()));
    }

    @Test
    public void showEditTextNumber2(){
        edittext_number2.check(matches(isDisplayed()));
    }
}