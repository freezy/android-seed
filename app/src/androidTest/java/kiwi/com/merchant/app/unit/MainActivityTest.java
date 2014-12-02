package kiwi.com.merchant.app.unit;

import android.app.Activity;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import kiwi.com.merchant.app.MainActivity;

@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

	@Test
	public void testExampleActivity() {
		final ActivityController<MainActivity> activityController = Robolectric.buildActivity(MainActivity.class);
		final Activity activity = activityController.create().visible().get();

		Assert.assertTrue(true);
	}
}
