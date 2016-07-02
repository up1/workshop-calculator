package com.workshop.calculator;

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

public class ResultActivityTest {

    public ViewInteraction displayResult;

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(ResultActivity.class , true , false);

    @Before
    public void initialActivity() {
        displayResult = onView(withId(R.id.display_result));
    }

    @Test
    public void showDisplayResult() {
        displayResult.check(matches(isDisplayed()));
    }
}