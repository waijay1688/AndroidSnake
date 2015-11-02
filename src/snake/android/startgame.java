package snake.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;


public class startgame extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_game);
		Button game1 = (Button)findViewById(R.id.game1);
		AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,-1f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation.setDuration(1500);
        animationSet.addAnimation(translateAnimation);
        game1.startAnimation(animationSet);
		game1.setOnTouchListener(new OnTouchListener(){
        	public boolean onTouch(View v,MotionEvent event){
        		if(event.getAction()==event.ACTION_DOWN){
        			v.findViewById(R.id.game1).setBackgroundResource(R.drawable.bgame1);
        		}
        		else if(event.getAction()==event.ACTION_UP){
        			v.findViewById(R.id.game1).setBackgroundResource(R.drawable.game1);
        			Intent intent1 = new Intent();
					intent1.setClass(startgame.this , Classical.class);
					startActivity(intent1);	
        		}
        		return false;
        	}
        }
        );
		Button game2 = (Button)findViewById(R.id.game2);
		AnimationSet animationSet1 = new AnimationSet(true);
        TranslateAnimation translateAnimation1 = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,-2f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation1.setDuration(1500);
        animationSet1.addAnimation(translateAnimation1);
        game2.startAnimation(animationSet1);
		game2.setOnTouchListener(new OnTouchListener(){
        	public boolean onTouch(View v,MotionEvent event){
        		if(event.getAction()==event.ACTION_DOWN){
        			v.findViewById(R.id.game2).setBackgroundResource(R.drawable.bgame2);
        		}
        		else if(event.getAction()==event.ACTION_UP){
        			v.findViewById(R.id.game2).setBackgroundResource(R.drawable.game2);
        			Intent intent2 = new Intent();
					intent2.setClass(startgame.this , Time.class);
					startActivity(intent2);	
        		}
        		return false;
        	}
        }
        );
		
		Button game4 = (Button)findViewById(R.id.game4);
		AnimationSet animationSet2 = new AnimationSet(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,-3f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation2.setDuration(1500);
        animationSet.addAnimation(translateAnimation2);
        game4.startAnimation(animationSet);
		game4.setOnTouchListener(new OnTouchListener(){
        	public boolean onTouch(View v,MotionEvent event){
        		if(event.getAction()==event.ACTION_DOWN){
        			v.findViewById(R.id.game4).setBackgroundResource(R.drawable.bgame4);
        		}
        		else if(event.getAction()==event.ACTION_UP){
        			v.findViewById(R.id.game4).setBackgroundResource(R.drawable.game4);
        			Intent intent4 = new Intent();
					intent4.setClass(startgame.this , Prop.class);
					startActivity(intent4);	
        		}
        		return false;
        	}
        }
        );
		
	}

}
