package com.bragin.AnalogClock;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class MyActivity extends Activity {

	private Handler handler;
	private Runnable runnable;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN
		);
//		setContentView(R.layout.main);
		final AnalogClockView view = new AnalogClockView(getApplicationContext());
		setContentView(view);

		runnable = new Runnable() {
			@Override
			public void run() {
				view.invalidate();
				handler.postDelayed(this, 1000);
			}
		};
		handler = new Handler();
		handler.post(runnable);
	}
}
