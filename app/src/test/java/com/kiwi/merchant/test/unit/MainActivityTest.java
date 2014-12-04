package com.kiwi.merchant.test.unit;

import android.app.Activity;

import com.kiwi.merchant.app.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@Config(emulateSdk=18, reportSdk=18)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

	@Test
	public void testSomething() throws Exception {
		final Activity activity = Robolectric.buildActivity(MainActivity.class).create().get();
		assertTrue(activity != null);
	}
}
