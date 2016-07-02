package com.workshop.calculator;

import android.content.Intent;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by pm on 2/7/2559.
 */

public class ResultActivityWithOperationTest {
    public ViewInteraction displayResult = onView(withId(R.id.display_result));

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(ResultActivity.class , true , false);

    @Test
    public void showDisplayResultWithDivide() {
        Intent intent = new Intent();
        intent.putExtra("display_result" , new Divide().calculate(789,0.123));
        activityTestRule.launchActivity(intent);
        displayResult.check(matches(withText("6,414.63")));
    }
    @Test
    public void showDisplayResultWithDivideByZero() {
        Intent intent = new Intent();
        intent.putExtra("display_result" , new Divide().calculate(789,0));
        activityTestRule.launchActivity(intent);
        displayResult.check(matches(withText("Infinity")));
    }
    @Test
    public void showDisplayResultWithDivideBoundary() {
        Intent intent = new Intent();
        intent.putExtra("display_result" , new Divide().calculate(10000000000.00,1000));
        activityTestRule.launchActivity(intent);
        displayResult.check(matches(withText("Error")));
    }
}
