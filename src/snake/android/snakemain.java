package snake.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import snake.android.Static_Date;

public class snakemain extends Activity {
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	if(Static_Date.VOICE_SWITCH == true){
    		if(Static_Date.j ==0){
    		Static_Date.MUSIC_PLAYER = new MusicPlayer(this);
    		Static_Date.MUSIC_PLAYER.music_start(R.drawable.background);
    		Static_Date.MUSIC_PLAYER.mediaPlayer.setLooping(true);
    		Static_Date.j++;
    	}
    	}
    	if(Static_Date.VOICE_SWITCH == false){
    	if(Static_Date.MUSIC_PLAYER !=null&& Static_Date.MUSIC_PLAYER.mediaPlayer !=null&&Static_Date.MUSIC_PLAYER.mediaPlayer.isPlaying()){
			Static_Date.MUSIC_PLAYER.mediaPlayer.setLooping(false);
			Static_Date.MUSIC_PLAYER.music_stop();
		}
    	    Static_Date.j--;
    	
    	}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button start_game = (Button)findViewById(R.id.start_game);
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,-3f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation.setDuration(1500);
        animationSet.addAnimation(translateAnimation);
        start_game.startAnimation(animationSet);
        start_game.setOnTouchListener(new OnTouchListener(){
        	public boolean onTouch(View v,MotionEvent event){
        		if(event.getAction()==event.ACTION_DOWN){
        			v.findViewById(R.id.start_game).setBackgroundResource(R.drawable.bstart_game);
        		}
        		else if(event.getAction()==event.ACTION_UP){
        			v.findViewById(R.id.start_game).setBackgroundResource(R.drawable.start_game);
					Intent intent1 = new Intent();
					intent1.setClass(snakemain.this , startgame.class);
					startActivity(intent1);	
					
        		}
        		return false;
        	}
        }
        );
        Button set = (Button)findViewById(R.id.set);
        AnimationSet animationSet1 = new AnimationSet(true);
        TranslateAnimation translateAnimation1 = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,10f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation1.setDuration(1500);
        animationSet1.addAnimation(translateAnimation1);
        set.startAnimation(animationSet1);
        set.setOnTouchListener(new OnTouchListener(){
        	public boolean onTouch(View v,MotionEvent event){
        		if(event.getAction()==event.ACTION_DOWN){
        			v.findViewById(R.id.set).setBackgroundResource(R.drawable.bset);
        		}
        		else if(event.getAction()==event.ACTION_UP){
        			v.findViewById(R.id.set).setBackgroundResource(R.drawable.set);
        			Intent intent2 = new Intent();
					intent2.setClass(snakemain.this , set.class);
					startActivity(intent2);	
					finish();
        		}
        		return false;
        	}
        }
        );
        Button help = (Button)findViewById(R.id.help);
        AnimationSet animationSet2 = new AnimationSet(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,-7f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation2.setDuration(1500);
        animationSet2.addAnimation(translateAnimation2);
        help.startAnimation(animationSet2);
        help.setOnTouchListener(new OnTouchListener(){
        	public boolean onTouch(View v,MotionEvent event){
        		if(event.getAction()==event.ACTION_DOWN){
        			v.findViewById(R.id.help).setBackgroundResource(R.drawable.bhelp);
        		}
        		else if(event.getAction()==event.ACTION_UP){
        			v.findViewById(R.id.help).setBackgroundResource(R.drawable.help);
        			Intent intent3 = new Intent();
					intent3.setClass(snakemain.this , help.class);
					startActivity(intent3);	
        		}
        		return false;
        	}
        }
        );
        Button finish = (Button)findViewById(R.id.finish);
        AnimationSet animationSet3 = new AnimationSet(true);
        TranslateAnimation translateAnimation3 = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,5f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation3.setDuration(1500);
        animationSet3.addAnimation(translateAnimation3);
        finish.startAnimation(animationSet3);
        finish.setOnTouchListener(new OnTouchListener(){
        	public boolean onTouch(View v,MotionEvent event){
        		if(event.getAction()==event.ACTION_DOWN){
        			v.findViewById(R.id.finish).setBackgroundResource(R.drawable.bfinish);
        		}
        		else if(event.getAction()==event.ACTION_UP){
        			v.findViewById(R.id.finish).setBackgroundResource(R.drawable.finish);
        			if(Static_Date.MUSIC_PLAYER != null && Static_Date.MUSIC_PLAYER.mediaPlayer != null&&Static_Date.MUSIC_PLAYER.mediaPlayer.isPlaying()){
        				Static_Date.MUSIC_PLAYER.mediaPlayer.setLooping(false);
        				Static_Date.MUSIC_PLAYER.music_stop();
        			}
        			android.os.Process.killProcess(android.os.Process.myPid());
        		}
        		return false;
        	}
        }
        );
        
        
    }
    
}