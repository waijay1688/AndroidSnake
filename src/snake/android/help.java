package snake.android;


import android.app.Activity;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;


public class help extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		HorizontalScrollView scoll = (HorizontalScrollView)findViewById(R.id.scroll);
		ImageView help1 = (ImageView)findViewById(R.id.help1);
		ImageView help2 = (ImageView)findViewById(R.id.help2);
		scoll.setHorizontalScrollBarEnabled(false);
	}

}
