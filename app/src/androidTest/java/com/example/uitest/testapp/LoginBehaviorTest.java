package com.example.uitest.testapp;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;

/**
 * Created by Michel Felipe on 02/08/16.
 */

@RunWith(AndroidJUnit4.class)
public class LoginBehaviorTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void performAuth_sameActivity(){

        onView(ViewMatchers.withId(R.id.email))
                .perform(typeText("foo@example.com"), closeSoftKeyboard());

        onView(ViewMatchers.withId(R.id.password))
                .perform(typeText("hello"), closeSoftKeyboard());


        onView(ViewMatchers.withId(R.id.email_sign_in_button))
                .perform(click());

    }
}
