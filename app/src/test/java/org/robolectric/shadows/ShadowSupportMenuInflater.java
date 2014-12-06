package org.robolectric.shadows;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import android.support.v7.internal.view.SupportMenuInflater;
import android.view.Menu;

// https://github.com/robolectric/robolectric/issues/898#issuecomment-36306341

@Implements(SupportMenuInflater.class)
public class ShadowSupportMenuInflater extends ShadowMenuInflater {

	@Implementation
	public void inflate(int menuRes, Menu menu) {
		super.inflate(menuRes, menu);
	}
}