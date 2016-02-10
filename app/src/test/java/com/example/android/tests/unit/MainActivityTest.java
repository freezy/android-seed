package com.example.android.tests.unit;

import android.widget.TextView;

import com.example.android.app.BuildConfig;
import com.example.android.app.MainActivity;
import com.example.android.app.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@Config(sdk=21, constants=BuildConfig.class)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {

	private MainActivity activity;

	@Before
	public void setUp() throws Exception {
		activity = Robolectric.setupActivity(MainActivity.class);
		assertThat(activity, is(notNullValue()));
	}

	@Test
	public void textShouldEqualHelloWorld() throws Exception {

		final TextView textView = (TextView) activity.findViewById(R.id.hello_world);
		assertThat(textView, is(notNullValue()));

		final CharSequence text = textView.getText();
		assertThat(text.toString(), equalTo("Hello world!"));
	}
}
