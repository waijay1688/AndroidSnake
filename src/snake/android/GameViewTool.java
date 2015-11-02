package snake.android;

import android.graphics.Point;


import snake_class.*;
import android.content.Context;
import android.graphics.Canvas;


import android.graphics.Rect;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;




import android.graphics.Bitmap;
import android.graphics.BitmapFactory;



import android.util.Log;




public class GameViewTool extends SurfaceView implements Callback{
	//Snake_Classic classic_snake;
	
	private Bitmap snake_body[];
	
	private Bitmap fruit;
	private Bitmap background1;
	private Bitmap background2;
	private Bitmap background3;
	private Bitmap background4;
	private Bitmap background5;
	private Bitmap background;
	private Bitmap boundary_x;
	private Bitmap boundary_y;
	private Bitmap score;
	private Bitmap one;
	private Bitmap two;
	private Bitmap three;
	private Bitmap four;
	private Bitmap five;
	private Bitmap six;
	private Bitmap seven;
	private Bitmap eight;
	private Bitmap nine;
	private Bitmap zero;
	

	private Bitmap gameover;
	private Bitmap ptool1;
	private Bitmap ptool2;
	private Bitmap ptool3;
	private Bitmap ptool4;
	private Bitmap tool1;
	private Bitmap tool2;
	private Bitmap tool3;
	private Bitmap tool4;
	private Bitmap tool;
	
	
	GameThread gameThread;
	Snake snake;
	
	public GameViewTool(Context context)
	{
		super(context);
		
		SurfaceHolder holder =getHolder();
		holder.addCallback(this);
		gameThread = new GameThread(holder);
		
		snake=new Snake_Tool();
		snake_body=new Bitmap[6];
		setBitmap();
	}
	public void surfaceChanged(SurfaceHolder holder, int format, int width,int height) 
	{
			// TODO Auto-generated method stub
	}
	public void surfaceCreated(SurfaceHolder holder)
	{
		// TODO Auto-generated method stub
		Log.i("Debug","Before thread start");
		gameThread.start();
	}
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		// TODO Auto-generated method stub
		gameThread.run = false;
	}
	void setBitmap()
	{
		snake_body[0]=BitmapFactory.decodeResource(getResources() , R.drawable.body);
		snake_body[1]=BitmapFactory.decodeResource(getResources() , R.drawable.body1);
		snake_body[2]=BitmapFactory.decodeResource(getResources() , R.drawable.body6);
		
		snake_body[3]=BitmapFactory.decodeResource(getResources() , R.drawable.body4);
		snake_body[4]=BitmapFactory.decodeResource(getResources() , R.drawable.body5);
		snake_body[5]=BitmapFactory.decodeResource(getResources() , R.drawable.body2);
		fruit=BitmapFactory.decodeResource(getResources() , R.drawable.food);
		background1=BitmapFactory.decodeResource(getResources() , R.drawable.back1);
		background2=BitmapFactory.decodeResource(getResources() , R.drawable.back2);
		background3=BitmapFactory.decodeResource(getResources() , R.drawable.back3);
		background4=BitmapFactory.decodeResource(getResources() , R.drawable.back4);
		background5=BitmapFactory.decodeResource(getResources() , R.drawable.back5);
		boundary_x=BitmapFactory.decodeResource(getResources() , R.drawable.cboundary);
		boundary_y=BitmapFactory.decodeResource(getResources() , R.drawable.rboundary);
		background=background1;
		score=BitmapFactory.decodeResource(getResources() , R.drawable.score);
		zero=BitmapFactory.decodeResource(getResources() , R.drawable.zero);
		one=BitmapFactory.decodeResource(getResources() , R.drawable.one);
		two=BitmapFactory.decodeResource(getResources() , R.drawable.two);
		three=BitmapFactory.decodeResource(getResources() , R.drawable.three);
		four=BitmapFactory.decodeResource(getResources() , R.drawable.four);
		five=BitmapFactory.decodeResource(getResources() , R.drawable.five);
		six=BitmapFactory.decodeResource(getResources() , R.drawable.six);
		seven=BitmapFactory.decodeResource(getResources() , R.drawable.seven);
		eight=BitmapFactory.decodeResource(getResources() , R.drawable.egiht);
		nine=BitmapFactory.decodeResource(getResources() , R.drawable.nin);
		
		
		tool1=BitmapFactory.decodeResource(getResources() , R.drawable.tool1);
		tool2=BitmapFactory.decodeResource(getResources() , R.drawable.tool2);
		tool3=BitmapFactory.decodeResource(getResources() , R.drawable.tool3);
		tool4=BitmapFactory.decodeResource(getResources() , R.drawable.tool4);
		ptool1=BitmapFactory.decodeResource(getResources() , R.drawable.ptool1);
		ptool2=BitmapFactory.decodeResource(getResources() , R.drawable.ptool2);
		ptool3=BitmapFactory.decodeResource(getResources() , R.drawable.ptool3);
		ptool4=BitmapFactory.decodeResource(getResources() , R.drawable.ptool4);
		gameover=BitmapFactory.decodeResource(getResources() , R.drawable.gameover);
		
	}
	private void setBackGround()
	{
		if(Static_Date.i==0)
			background=background1;
		if(Static_Date.i==1)
			background=background2;
		if(Static_Date.i==2)
			background=background3;
		if(Static_Date.i==3)
			background=background4;
		if(Static_Date.i==4)
			background=background5;
	}
	private void speedUp()
	{
		int score=snake.getScore();
		if(score>=0&&score<20)
		{
			Snake_Data.TEMP_FRENCUNCY=500;
			Snake_Data.ITEM=2;
		}
		if(score>=20&&score<60)
		{
			Snake_Data.TEMP_FRENCUNCY=200;
			Snake_Data.ITEM=1;
		}
		if(score>=60)
		{
			Snake_Data.TEMP_FRENCUNCY=100;
			Snake_Data.ITEM=0;
		}
	}
	private void drawBody(Canvas c)
	{
		int length=snake.getLength();
		if(length<10)
		{
			for(Point p:snake.snake_body)
			c.drawBitmap(snake_body[0], p.x*18+54,p.y*18+54 ,null);
		}
		else
		{
			int i=0;
			for(int item=length-1;item>=0;item--)
			{
				Point p=snake.snake_body.get(item);
				c.drawBitmap(snake_body[i], p.x*18+54,p.y*18+54 ,null);
				i++;
				if(i==6)
					i=0;
			}
		}
	}
	private void drawFruit(Canvas c)
	{
		for(Point p:snake.getFruit().fruit)
		{
			c.drawBitmap(fruit, p.x*18+54,p.y*18+54 ,null);
		}
	}
	private void drawTool(Canvas c)
	{
		for(Widget w:snake.getTool().tool)
		{
			Point p=w.getPoint();
			switch(w.getType())
			{
			case Snake_Data.CHANGE:
				tool=tool1;
				break;
			case Snake_Data.AUGMENT:
				tool=tool2;
				break;
			case Snake_Data.CUT:
				tool=tool3;
				break;
			case Snake_Data.ACROSS:
				tool=tool4;
				break;
			}
			c.drawBitmap(tool, p.x*18+54,p.y*18+54, null);
		}
	}
	private void drawToolBox(Canvas c)
	{
		if(snake.getChange()>0)
			c.drawBitmap(ptool1, 25*18, 4*18,null);
		if(snake.getAugment()>0)
			c.drawBitmap(ptool2, 25*18, 7*18,null);
		if(snake.getCut()>0)
			c.drawBitmap(ptool3, 25*18, 10*18,null);
		if(snake.getAcross()>0)
			c.drawBitmap(ptool4, 25*18, 13*18,null);
	}
	private void drawBoundary(Canvas c,Rect rc1,Rect rc2,Rect rr1,Rect rr2)
	{
		c.drawBitmap(boundary_x,null,rc1,null);
		c.drawBitmap(boundary_x,null,rc2,null);
		c.drawBitmap(boundary_y,null,rr1,null);
		c.drawBitmap(boundary_y,null,rr2,null);
	}
	private void drawNum(int num, int row,int column,Canvas c,Bitmap b)
	{
		if(num==0)
		{
			c.drawBitmap(b, row-38,column, null);
			c.drawBitmap(zero, row-18,column, null);
		}
		int f_score=num;
		int item=1;
		while(f_score!=0)
		{			
			switch(f_score%10)
			{
			case 0:
				c.drawBitmap(zero,row-18*item,column,null );
				break;
			case 1:
				c.drawBitmap(one,row-18*item,column,null );
				break;
			case 2:
				c.drawBitmap(two,row-18*item,column,null );
				break;
			case 3:
				c.drawBitmap(three,row-18*item,column,null );	
				break;
			case 4:
				c.drawBitmap(four,row-18*item,column,null );
				break;
			case 5:
				c.drawBitmap(five,row-18*item,column,null );
				break;
			case 6:
				c.drawBitmap(six,row-18*item,column,null );
				break;
			case 7:
				c.drawBitmap(seven,row-18*item,column,null );
				break;
			case 8:
				c.drawBitmap(eight,row-18*item,column,null );
				break;
			case 9:
				c.drawBitmap(nine,row-18*item,column,null );	
				break;
			}
			item++;
			f_score=f_score/10;
		}
		c.drawBitmap(b,row-18*item-20,column,null );
	}	

	class GameThread extends Thread
	{						
		SurfaceHolder surfaceHolder;
		public boolean run;
		public GameThread(SurfaceHolder surfaceHolder)
		{
			this.surfaceHolder = surfaceHolder;
			run=true;			
		}
		
		protected void doStop() 
		{ 
				run = false; 
		}
		
		public void run()
		{
			
			setBackGround();
			Canvas c = null;
			Snake_Data.BPAUSE=false;
			Snake_Data.BRESTART=false;
			Rect r=new Rect(0,0,Snake_Data.SCREENWIDTH,Snake_Data.SCREENHEIGHT);
			Rect cboundary1=new Rect(2*18,2*18,25*18,3*18);
			Rect rboundary1=new Rect(2*18,2*18,3*18,15*18);
			Rect cboundary2=new Rect(2*18,14*18,25*18,15*18);
			Rect rboundary2=new Rect(24*18,2*18,25*18,15*18);
			Rect rOver=new Rect(Snake_Data.SCREENWIDTH/4,Snake_Data.SCREENHEIGHT/4,Snake_Data.SCREENWIDTH*3/4,Snake_Data.SCREENHEIGHT*3/4);
			Snake_Data.DIRECTION=Snake_Data.DIRECTION_UP;
			snake.creatFruit();
			
			Point pAhead;
			int iAhead;
			int temp_score;
			
				Snake_Data.ACHANGE=false;
				Snake_Data.ACUT=false;
				Snake_Data.TACROSS=0;
				Snake_Data.TAUGMENT=0;
				Snake_Data.TEMP_FRENCUNCY=500;
				Snake_Data.ITEM=2;
				while(run)
				{						
					try
					{																		
						c = surfaceHolder.lockCanvas();
						synchronized (surfaceHolder) 
						{
							c.drawBitmap(background,null,r, null);
							
							temp_score=snake.getScore();
							drawNum(temp_score,5*18,0,c,score);
							speedUp();
							drawBoundary(c,cboundary1,cboundary2,rboundary1,rboundary2);
							snake.listenTool();
							pAhead=snake.getAhead();
							iAhead=snake.judgeAhead(pAhead);
							if(Snake_Data.TAUGMENT==0&&Snake_Data.TACROSS==0&&!Snake_Data.ACHANGE&&!Snake_Data.ACUT)
							{
								if(snake.judgeDeath(iAhead)==Snake_Data.ALIVE)	
								{															
									snake.move(pAhead,iAhead);
									if(snake.bScore())
									{
										snake.creatFruit();	
										snake.creatTool();
									}
								}
								else run=false;
							}
							if(Snake_Data.TACROSS>0)
							{
								pAhead=snake.getAcrossAhead();
								iAhead=snake.judgeAcrossAhead(pAhead);
								snake.moveAcross(pAhead,iAhead);
								if(snake.bScore())
								{
									snake.creatFruit();	
									snake.creatTool();
								}
								Snake_Data.TACROSS--;
							}
							if(Snake_Data.TAUGMENT>0)
							{
								snake.doubleScoreValue();
								snake.move(pAhead,iAhead);
								if(snake.bScore())
								{
									snake.creatFruit();	
									snake.creatTool();
								}
								Snake_Data.TAUGMENT--;
								snake.halfScoreValue();
							}
							if(Snake_Data.ACHANGE)
							{
								Snake_Data.ACHANGE=false;
								snake.changeHead();
							}
							if(Snake_Data.ACUT)
							{
								Snake_Data.ACUT=false;
								snake.cutRear();
							}
							drawToolBox(c);
							
							drawBody(c);
							drawFruit(c);
							drawTool(c);
							snake.setDirection(Snake_Data.DIRECTION);
							Thread.sleep(Snake_Data.TEMP_FRENCUNCY);							
						}						
					}
					catch (Exception e) 
					{
						Log.e("Debug","Exception caught: ",e);
					}
					finally
					{
						if(c != null)
						{
							Log.i("Debug","In final, unlocking canvas");
							surfaceHolder.unlockCanvasAndPost(c);
						}
					}
				}
				c = surfaceHolder.lockCanvas();
				c.drawBitmap(gameover,null,rOver, null);
				surfaceHolder.unlockCanvasAndPost(c);
			
		}
	}
}

