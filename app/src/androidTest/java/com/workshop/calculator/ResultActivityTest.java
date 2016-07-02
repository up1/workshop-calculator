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
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class ResultActivityTest {

    public ViewInteraction displayResult = onView(withId(R.id.display_result));

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(ResultActivity.class , true , false);

    @Before
    public void initialActivity() {
        Intent intent = new Intent();
        intent.putExtra(MainActivity.DISPLAY_RESULT, "100000");
        activityTestRule.launchActivity(intent);
    }

    @Test
    public void showDisplayResult() {
        displayResult.check(matches(isDisplayed()));
    }

    public void checkDisplayResult() {
        displayResult.check(matches(withText("100000.00")));
    }
}