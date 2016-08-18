package com.example.uitest.testapp;

import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;
import android.widget.ProgressBar;

import org.hamcrest.Matcher;

import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;

/**
 * Created by Michel Felipe on 18/08/16.
 *
 * Class to use custom Espresso ViewAction methods
 */
public class CustomViewActions {

    private static CustomViewActions ourInstance = new CustomViewActions();

    public static CustomViewActions getInstance() {
        return ourInstance;
    }

    private CustomViewActions() {}

    /**
     * Replace the progressbar icon animation
     * with a custom red square
     *
     * @return ViewAction Returns a view action object
     */
    public ViewAction replaceProgressBarDrawable() {
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

    /**
     * Perform action of waiting for a specific time.
     *
     * @param millis Milliseconds to wait
     * @return ViewAction Returns a view action object
     */
    public ViewAction waitFor(final long millis)
    {
        return new ViewAction()
        {
            @Override
            public Matcher<View> getConstraints()
            {
                return isRoot();
            }

            @Override
            public String getDescription()
            {
                return "wait for a specific time: " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view)
            {
                uiController.loopMainThreadForAtLeast(millis);

            }
        };
    }
}

