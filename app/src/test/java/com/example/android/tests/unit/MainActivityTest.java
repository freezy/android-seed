package com.example.android.tests.unit;

import android.app.Activity;

import com.example.android.app.MainActivity;

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
