package snake.android;


import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;

public class MusicPlayer 
{
	MediaPlayer mediaPlayer;   
	Activity activity; 
	public MusicPlayer(Activity ac)
	{
		activity = ac;
	}
	
	public void music_start(int sourceID)
	{
		
		if(mediaPlayer == null)
		{
			mediaPlayer = MediaPlayer.create(activity , sourceID); 
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();   
			} catch (IOException e) {
				e.printStackTrace();   
			}
		}
		
		
		if(!mediaPlayer.isPlaying()){
			mediaPlayer.start();}
	}
	
	public void music_pause()
	{
		if(mediaPlayer != null && mediaPlayer.isPlaying())
			mediaPlayer.pause();  
	}
	public void music_stop()
	{
		if(mediaPlayer != null)
		{
			mediaPlayer.stop();
			mediaPlayer = null;
		}
	}
	
}
