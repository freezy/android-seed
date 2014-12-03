package com.kiwi.merchant.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;


import com.kiwi.merchant.app.MainActivity;
import com.kiwi.merchant.app.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	@SuppressWarnings("deprecation")
	public MainActivityTest() {
		// This constructor was deprecated - but we want to support lower API levels.
		super("com.kiwi.merchant.test", MainActivity.class);
	}
	@Override
	public void setUp() throws Exception {
		super.setUp();
		// Espresso will not launch our activity for us, we must launch it via getActivity().
		getActivity();
	}

	public void testCheckText() {
		onView(withId(R.id.text))
				.check(matches(withText("Hello World!")));
	}
}
