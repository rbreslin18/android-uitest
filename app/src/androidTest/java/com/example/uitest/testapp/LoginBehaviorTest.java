package com.example.uitest.testapp;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ProgressBar;

import com.metova.cappuccino.Cappuccino;
import com.metova.cappuccino.animations.SystemAnimations;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static org.hamcrest.Matchers.not;

/**
 * Created by Michel Felipe on 02/08/16.
 */

@RunWith(AndroidJUnit4.class)
public class LoginBehaviorTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class, true, false);

    @BeforeClass
    public static void disableAnimations(){
        SystemAnimations.disableAll(InstrumentationRegistry.getContext());
    }

    @AfterClass
    public static void enableAnimations(){
        SystemAnimations.enableAll(InstrumentationRegistry.getContext());
    }

    @Before
    public void setUp() throws Exception {
        mActivityRule.launchActivity(new Intent());
    }

    @After
    public void tearDown() throws Exception {
        Cappuccino.reset();
    }

    @Test
    public void performAuth_sameActivity(){

        CustomViewActions customActions = CustomViewActions.getInstance();

        onView(ViewMatchers.withId(R.id.email))
                .perform(typeText("foo@example.com"), closeSoftKeyboard());

        onView(ViewMatchers.withId(R.id.password))
                .perform(typeText("hello"), closeSoftKeyboard());

        onView(isAssignableFrom(ProgressBar.class)).perform(customActions.replaceProgressBarDrawable());

        onView(ViewMatchers.withId(R.id.email_sign_in_button))
                .perform(click());

        onView(ViewMatchers.withId(R.id.login_progress))
                .check(matches(not(ViewMatchers.isDisplayed())));
        
    }
}
