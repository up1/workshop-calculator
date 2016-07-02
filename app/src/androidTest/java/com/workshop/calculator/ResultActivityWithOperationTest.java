package com.workshop.calculator;

import android.content.Intent;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class ResultActivityWithOperationTest {
    private ViewInteraction displayResult = onView(withId(R.id.display_result));

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(ResultActivity.class , true , false);

    @Test
    public void showDisplayResultWithAdd() {
        Intent intent = new Intent();
        intent.putExtra("display_result" , new Calculate(789,0.123).plus());
        activityTestRule.launchActivity(intent);
        displayResult.check(matches(withText("789.12")));
    }

    @Test
    public void showDisplayResultWithSubtract() {
        Intent intent = new Intent();
        intent.putExtra("display_result" , new Calculate(789,0.123).minus());
        activityTestRule.launchActivity(intent);
        displayResult.check(matches(withText("788.88")));
    }

    @Test
    public void showDisplayResultWithMultiply() {
        Intent intent = new Intent();
        intent.putExtra("display_result" , new Calculate(789,0.123).multiply());
        activityTestRule.launchActivity(intent);
        displayResult.check(matches(withText("97.05")));
    }

    @Test
    public void showDisplayResultWithDivide() {
        Intent intent = new Intent();
        intent.putExtra("display_result" , new Calculate(789,0.123).divide());
        activityTestRule.launchActivity(intent);
        displayResult.check(matches(withText("6,414.63")));
    }
    @Test
    public void showDisplayResultWithDivideByZero() {
        Intent intent = new Intent();
        intent.putExtra("display_result" , new Calculate(789,0).divide());
        activityTestRule.launchActivity(intent);
        displayResult.check(matches(withText("Infinity")));
    }
    @Test
    public void showDisplayResultWithDivideBoundary() {
        Intent intent = new Intent();
        intent.putExtra("display_result" , new Calculate(10000000000.00,1000).divide());
        activityTestRule.launchActivity(intent);
        displayResult.check(matches(withText("Error")));
    }
}
