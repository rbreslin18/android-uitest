package com.example.uitest.testapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.ProgressBar;

import com.metova.cappuccino.Cappuccino;
import com.metova.cappuccino.CappuccinoIdlingResource;
import com.metova.cappuccino.animations.SystemAnimations;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.registerIdlingResources;
import static android.support.test.espresso.Espresso.unregisterIdlingResources;
import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;

/**
 * Created by Michel Felipe on 02/08/16.
 */

//@TargetApi(21)
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
        CappuccinoIdlingResource idlingResource = new CappuccinoIdlingResource(mActivityRule.getActivity());
        registerIdlingResources(idlingResource);


        onView(ViewMatchers.withId(R.id.email))
                .perform(typeText("foo@example.com"), closeSoftKeyboard());

        onView(ViewMatchers.withId(R.id.password))
                .perform(typeText("hello"), closeSoftKeyboard());

//        ProgressBar progressBar = (ProgressBar) mActivityRule.getActivity().findViewById(R.id.login_progress);
//        progressBar.setIndeterminateDrawable(mActivityRule.getActivity().getDrawable(android.R.drawable.ic_lock_lock));

        onView(isAssignableFrom(ProgressBar.class)).perform(replaceProgressBarDrawable());

//        SystemClock.sleep(2000);
        onView(ViewMatchers.withId(R.id.email_sign_in_button))
                .perform(click());


        onView(ViewMatchers.withId(R.id.login_progress))
                .check(matches(ViewMatchers.isDisplayed()));

        unregisterIdlingResources(idlingResource);

    }

    public static ViewAction replaceProgressBarDrawable() {
        return actionWithAssertions(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(ProgressBar.class);
            }

            @Override
            public String getDescription() {
                return "replace the ProgressBar drawable";
            }

            @Override
            public void perform(final UiController uiController, final android.view.View view) {
                // Replace the indeterminate drawable with a static red ColorDrawable
                ProgressBar progressBar = (ProgressBar) view;
                progressBar.setIndeterminateDrawable(new ColorDrawable(0xffff0000));
                uiController.loopMainThreadUntilIdle();
            }
        });
    }
}
