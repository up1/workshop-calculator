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
public class ResultActivityTest {

    public ViewInteraction displayResult;

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(ResultActivity.class);

    @BeforeClass
    public void initialActivity() {
        displayResult = onView(withId(R.id.display_result));
    }

    @Test
    public void showdisplayResult() {
        displayResult.check(matches(isDisplayed()));
    }
}