package snake.android;
import snake_class.*;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.view.GestureDetector.OnGestureListener; 
import android.view.GestureDetector; 
import android.util.Log; 

public class Prop extends Activity implements OnGestureListener{
	
	private GestureDetector detector; 
	private GameViewTool myView;
	private SensorManager mManager = null;
	private Sensor mSensor = null;   
	private SensorEventListener mListener = null; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		 
		mSensor = mManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		mListener = new SensorEventListener() {
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}
		
		public void onSensorChanged(SensorEvent event) {
		float x = event.values[SensorManager.DATA_X];
		float y = event.values[SensorManager.DATA_Y];
		float z = event.values[SensorManager.DATA_Z];
		judgeDirection(x, y, z);
		}
		};
		myView=new GameViewTool(this);
		myView.setFocusable(true);

		DisplayMetrics dm = new DisplayMetrics();  
		dm = this.getApplicationContext().getResources().getDisplayMetrics();  
		Snake_Data.SCREENWIDTH = dm.widthPixels;  
		Snake_Data.SCREENHEIGHT = dm.heightPixels;  
		detector = new GestureDetector(this); 
		
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,   
		WindowManager.LayoutParams.FLAG_FULLSCREEN);  
		
		
		Snake_Data.BCHANGE=false;
		Snake_Data.BAUGMENT=false;
		Snake_Data.BCUT=false;
		Snake_Data.BACROSS=false;
		
		Snake_Data.BCLASSIC=false;
		Snake_Data.BTIME=false;
		Snake_Data.BPROP=true;

		this.setContentView(myView);  
	}
	private void judgeDirection(float x,float y,float z)
	{
		if(!Static_Date.GRAVITY_SWITCH)
			return;
		if((y<10||y>-10)&&z<-15)
			Snake_Data.DIRECTION=Snake_Data.SNAKE_UP;
		if((y<10||y>-10)&&z>15)
			Snake_Data.DIRECTION=Snake_Data.SNAKE_DOWN;
		if((z<10||z>-10)&&y>15)
			Snake_Data.DIRECTION=Snake_Data.SNAKE_LEFT;
		if((z<10||z>-10)&&y<-15)
			Snake_Data.DIRECTION=Snake_Data.SNAKE_RIGHT;
	}
	public boolean onTouchEvent(MotionEvent event) { 
        Log.i("Fling", "Activity onTouchEvent!"); 
        if(event.getX()>25*18&&event.getX()<27*18&&
        	event.getY()>4*18&&event.getY()<7*18)
        	Snake_Data.BCHANGE=true;
        if(event.getX()>25*18&&event.getX()<27*18&&
            	event.getY()>7*18&&event.getY()<10*18)
            	Snake_Data.BAUGMENT=true;
        if(event.getX()>25*18&&event.getX()<27*18&&
            	event.getY()>10*18&&event.getY()<13*18)
            	Snake_Data.BCUT=true;
        if(event.getX()>25*18&&event.getX()<27*18&&
            	event.getY()>13*18&&event.getY()<716*18)
            	Snake_Data.BACROSS=true;
        return this.detector.onTouchEvent(event); 
    } 
    @Override 
    public boolean onDown(MotionEvent e) { 
        // TODO Auto-generated method stub 
        return false; 
    } 
     
     
    @Override 
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, 
            float velocityY) { 
        // TODO Auto-generated method stub 
        Log.i("Fling", "Fling Happened!"); 
        if (e1.getX() - e2.getX() > Snake_Data.SCREENHEIGHT*1/5) { 
            Snake_Data.DIRECTION=Snake_Data.DIRECTION_LEFT;
            return true; 
        } else if (e1.getX() - e2.getX() < -Snake_Data.SCREENHEIGHT*1/5) { 
        	Snake_Data.DIRECTION=Snake_Data.DIRECTION_RIGHT;
            return true; 
        } 
        else if(e1.getY() - e2.getY() > Snake_Data.SCREENWIDTH*1/5)
        {
        	Snake_Data.DIRECTION=Snake_Data.DIRECTION_UP;
        	return true;
        }
        else if(e1.getY() - e2.getY() < -Snake_Data.SCREENWIDTH*1/5)
        {
        	Snake_Data.DIRECTION=Snake_Data.DIRECTION_DOWN;
        	return true; 
        }
        return true; 
        
    } 
    @Override 
    public void onLongPress(MotionEvent e) { 
        // TODO Auto-generated method stub 
         
    } 
    @Override 
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, 
            float distanceY) { 
        // TODO Auto-generated method stub 
        return false; 
    } 
    @Override 
    public void onShowPress(MotionEvent e) { 
        // TODO Auto-generated method stub 
         
    } 
    @Override 
    public boolean onSingleTapUp(MotionEvent e) { 
        // TODO Auto-generated method stub 
        return false; 
    } 
   
    public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
    	if(keyCode == KeyEvent.KEYCODE_BACK&&event.getRepeatCount()== 0){
    		finish();
    	}
		
		switch(keyCode)
		{
		//ÉÏ½¨
		case KeyEvent.KEYCODE_DPAD_UP:
		{
			Snake_Data.DIRECTION=Snake_Data.DIRECTION_UP;
		}	break;
			
		//ÏÂ¼ü
		case KeyEvent.KEYCODE_DPAD_DOWN:
		{
			Snake_Data.DIRECTION=Snake_Data.DIRECTION_DOWN;
			break;
		}
		//×ó¼ü
		case KeyEvent.KEYCODE_DPAD_LEFT:
		{
			Snake_Data.DIRECTION=Snake_Data.DIRECTION_LEFT;
			break;
		}
		//ÓÒ¼ü
		case KeyEvent.KEYCODE_DPAD_RIGHT:
		{
			Snake_Data.DIRECTION=Snake_Data.DIRECTION_RIGHT;
			break;
		}
		}
		return super.onKeyDown(keyCode, event);		
	}
}



