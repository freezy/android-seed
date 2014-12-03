package com.kiwi.merchant.robolectric;

import android.app.Activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import com.kiwi.merchant.app.MainActivity;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class MainActivityRobolectricTest {

	@Test
	public void testSomething() throws Exception {
		final Activity activity = Robolectric.buildActivity(MainActivity.class).create().get();
		assertTrue(activity != null);
	}
}
