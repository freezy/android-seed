package com.kiwi.merchant.app;

import android.app.Activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class MainActivityRobolectricTest {

	@Test
	public void testSomething() throws Exception {
		final Activity activity = Robolectric.buildActivity(MainActivity.class).create().get();
		assertTrue(activity != null);
	}
}
