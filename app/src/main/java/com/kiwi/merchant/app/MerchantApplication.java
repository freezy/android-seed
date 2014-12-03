package com.kiwi.merchant.app;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

public class MerchantApplication extends MultiDexApplication {

	@Override
	public void onCreate() {
		super.onCreate();
		attachBaseContext(this);
	}

	@Override
	protected void attachBaseContext(Context base) {
		try {
			super.attachBaseContext(base);
		} catch (RuntimeException ignored) {
			// Multidex support doesn't play well with Robolectric yet
		}
	}
}
