package snake.android;

import android.content.Intent;
import snake.android.Static_Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class set extends Activity{
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set);
		
		Button set1 = (Button)findViewById(R.id.set1);
		AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,-2f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation.setDuration(1500);
        animationSet.addAnimation(translateAnimation);
        set1.startAnimation(animationSet);
		Button set2 = (Button)findViewById(R.id.set2);
		AnimationSet animationSet1 = new AnimationSet(true);
        TranslateAnimation translateAnimation1 = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,-2f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation1.setDuration(1500);
        animationSet1.addAnimation(translateAnimation1);
        set2.startAnimation(animationSet1);
		Button set3 = (Button)findViewById(R.id.set3);
		AnimationSet animationSet2 = new AnimationSet(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,-2f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation2.setDuration(1500);
        animationSet2.addAnimation(translateAnimation2);
        set3.startAnimation(animationSet2);
		final Button yes = (Button)findViewById(R.id.yes);
		AnimationSet animationSet3 = new AnimationSet(true);
        TranslateAnimation translateAnimation3 = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,-3f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation3.setDuration(1500);
        animationSet3.addAnimation(translateAnimation3);
        yes.startAnimation(animationSet3);
		final Button no = (Button)findViewById(R.id.no);
		AnimationSet animationSet4 = new AnimationSet(true);
        TranslateAnimation translateAnimation4 = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,4f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation4.setDuration(1500);
        animationSet4.addAnimation(translateAnimation4);
        no.startAnimation(animationSet4);
		final Spinner setmap = (Spinner)findViewById(R.id.setmap);
		AnimationSet animationSet5 = new AnimationSet(true);
        TranslateAnimation translateAnimation5 = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,5f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation5.setDuration(1500);
        animationSet5.addAnimation(translateAnimation5);
        setmap.startAnimation(animationSet5);
		AbsoluteLayout setbackground = (AbsoluteLayout)findViewById(R.id.setbackground);
		final ImageView image = (ImageView)findViewById(R.id.image) ;
		ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(
				this,R.array.setmap,android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		setmap.setAdapter(adapter);
		setmap.setPrompt("地图选择");
		final Spinner setmusic = (Spinner)findViewById(R.id.setmusic);
		AnimationSet animationSet6 = new AnimationSet(true);
        TranslateAnimation translateAnimation6 = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,5f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation6.setDuration(1500);
        animationSet6.addAnimation(translateAnimation6);
        setmusic.startAnimation(animationSet6);
		ArrayAdapter<CharSequence>adapter1 = ArrayAdapter.createFromResource(
				this,R.array.setmusic,android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		setmusic.setAdapter(adapter1);
		setmusic.setPrompt("音乐开关");
		final Spinner setgravity = (Spinner)findViewById(R.id.setgravity);
		AnimationSet animationSet7 = new AnimationSet(true);
        TranslateAnimation translateAnimation7 = new TranslateAnimation(
        		Animation.RELATIVE_TO_SELF,3f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f,
        		Animation.RELATIVE_TO_SELF,0f);
        translateAnimation7.setDuration(1500);
        animationSet7.addAnimation(translateAnimation7);
        setgravity.startAnimation(animationSet7);
		ArrayAdapter<CharSequence>adapter2 = ArrayAdapter.createFromResource(
				this,R.array.setgravity,android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		setgravity.setAdapter(adapter2);
		setgravity.setPrompt("重力感应开关");
		if (Static_Date.i == 0){
			setmap.setSelection(0);
		}
		if (Static_Date.i == 1){
			setmap.setSelection(1);
		}
		if (Static_Date.i == 2){
			setmap.setSelection(2);
		}
		if (Static_Date.i == 3){
			setmap.setSelection(3);
		}
		if (Static_Date.i == 4){
			setmap.setSelection(4);	
		}
		if (Static_Date.VOICE_SWITCH == false){
			setmusic.setSelection(1);
		}
		if (Static_Date.GRAVITY_SWITCH == false){
			setgravity.setSelection(1);
		}
		setmap.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				String map_state = setmap.getSelectedItem().toString();
				if(map_state.equals("地图一")){
					image.setBackgroundResource(R.drawable.back1);
					
				}
				if(map_state.equals("地图二")){
					Static_Date.i =1;
					image.setBackgroundResource(R.drawable.back2);
				}
				if(map_state.equals("地图三")){
					Static_Date.i =2;
					image.setBackgroundResource(R.drawable.back3);
				}
				if(map_state.equals("地图四")){
					Static_Date.i =3;
					image.setBackgroundResource(R.drawable.back4);
				}
				if(map_state.equals("地图五")){
					Static_Date.i =4;
					image.setBackgroundResource(R.drawable.back5);
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}});
		
		yes.setOnTouchListener(new OnTouchListener(){
			public boolean onTouch(View v, MotionEvent event){
				if(event.getAction() ==0){
					yes.setBackgroundResource(R.drawable.byes);
				}
				if(event.getAction() ==1){
					yes.setBackgroundResource(R.drawable.yes);
					String map_state = setmap.getSelectedItem().toString();
					if(map_state.equals("地图一")){
						Static_Date.i =0;
					}
					if(map_state.equals("地图二")){
						Static_Date.i =1;
					}
					if(map_state.equals("地图三")){
						Static_Date.i =2;
					}
					if(map_state.equals("地图四")){
						Static_Date.i =3;
					}
					if(map_state.equals("地图五")){
						Static_Date.i =4;
					}
					Static_Date.BACKGROUND = setmap.getSelectedItem().toString();
//				  
					        String music_state = setmusic.getSelectedItem().toString();
							if(music_state.equals("音乐开")){
								if(Static_Date.VOICE_SWITCH == false){
									Static_Date.VOICE_SWITCH = true;
									setmusic.setSelection(0);
								}
								else {
									setmusic.setSelection(0);
								}
							}
							if(music_state.equals("音乐关")){
								Static_Date.VOICE_SWITCH = false;
								
							}
							String gravity_state = setgravity.getSelectedItem().toString();
							if(gravity_state.equals("重力感应开")){
								if(Static_Date.GRAVITY_SWITCH == false){
									Static_Date.GRAVITY_SWITCH = true;
									setgravity.setSelection(0);
								}
								else{
									setgravity.setSelection(0);
								}
							if(gravity_state.equals("重力感应关")){
								Static_Date.GRAVITY_SWITCH = false;
							}
							}
					Intent intent = new Intent();
					intent.setClass(set.this, snakemain.class);
					startActivity(intent);
					finish();
				}
				return false;
			}
			}
		);
		no.setOnTouchListener(new OnTouchListener(){
			public boolean onTouch(View v, MotionEvent event){
				if(event.getAction()== 0){
					no.setBackgroundResource(R.drawable.bno);
				}
				if(event.getAction() == 1){
					no.setBackgroundResource(R.drawable.no);
					Intent intent1 = new Intent();
					intent1.setClass(set.this , snakemain.class);
					startActivity(intent1);
					finish();
				}
				return false;
			}
		});
		
		
		
	}
	

}
