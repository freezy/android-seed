package com.example.android.tests.instrumentation;

import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.android.app.MainActivity;
import com.example.android.app.R;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class MainActivityTest {

	@Rule
	public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

	@Test
	public void testCheckText() {
		onView(withId(R.id.hello_world))
				.check(matches(withText("Hello world!")));
	}
}
