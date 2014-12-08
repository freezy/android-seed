package com.example.android.tests.unit;

import android.app.Activity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.app.MainActivity;
import com.example.android.app.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.tester.android.view.TestMenuItem;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@Config(emulateSdk=18, reportSdk=18)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

	private MainActivity activity;

	@Before
	public void setUp() throws Exception {
		activity = Robolectric.buildActivity(MainActivity.class).create().start().resume().visible().get();
		assertThat(activity, is(notNullValue()));
	}

	@Test
	public void textShouldEqualHelloWorld() throws Exception {

		final TextView textView = (TextView) activity.findViewById(R.id.hello_world);
		assertThat(textView, is(notNullValue()));

		final CharSequence text = textView.getText();
		assertThat(text.toString(), equalTo("Hello world!"));
	}

	@Test
	public void settingsMenuShouldBeClickable() throws Exception {
		MenuItem item = new TestMenuItem(R.id.action_settings);
		activity.onOptionsItemSelected(item);
	}
}
