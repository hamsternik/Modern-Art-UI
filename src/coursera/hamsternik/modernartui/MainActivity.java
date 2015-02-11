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
	
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_android);
	}
}
