package com.example.android.tests.instrumentation;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;


import com.example.android.app.MainActivity;
import com.example.android.app.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	@SuppressWarnings("deprecation")
	public MainActivityTest() {
		// This constructor was deprecated - but we want to support lower API levels.
		super("com.example.android.app", MainActivity.class);
	}


	@Override
	public void setUp() throws Exception {
		super.setUp();
		// Espresso will not launch our activity for us, we must launch it via getActivity().
		getActivity();
	}

	public void testCheckText() {
		onView(withId(R.id.hello_world))
				.check(matches(withText("Hello world!")));
	}

}
