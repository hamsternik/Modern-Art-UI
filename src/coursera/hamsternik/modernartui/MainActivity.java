package coursera.hamsternik.modernartui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import coursera.hamsternik.modernartui.R;

public class MainActivity extends Activity {

	private RelativeLayout canvas;
	private SeekBar seekBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_android);

		canvas = (RelativeLayout) findViewById(R.id.canvas);
		seekBar = (SeekBar) findViewById(R.id.seekBarItem);

		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

				for (int i = 0; i < canvas.getChildCount(); ++i) {
					View child = canvas.getChildAt(i);

					long origColor = Color.parseColor((String) child.getTag());
					long invertColor = (0x00FFFFFF - (origColor | 0xFF000000))
							| (origColor & 0xFF000000);

					if (getResources().getColor(R.color.white) != origColor
							&& getResources().getColor(R.color.light_gray) != origColor) {

						long origRed = (origColor >> 16) & 0x000000FF;
						long origGreen = (origColor >> 8) & 0x000000FF;
						long origBlue = origColor & 0x000000FF;
						long invRed = (invertColor >> 16) & 0x000000FF;
						long invGreen = (invertColor >> 8) & 0x000000FF;
						long invBlue = invertColor & 0x000000FF;
						child.setBackgroundColor(Color.rgb(
								(int) (origRed + (invRed - origRed)
										* (progress / 100f)),
								(int) (origGreen + (invGreen - origGreen)
										* (progress / 100f)),
								(int) (origBlue + (invBlue - origBlue)
										* (progress / 100f))));
						child.invalidate();
					}
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void showDialog(MenuItem item) {
		//new DialogWithAdvanceInfo().show(getFragmentManager(), "MainActivity.java");
	}
}
