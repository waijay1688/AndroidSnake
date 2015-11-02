package snake_class;

import java.util.ArrayList;

import android.graphics.Point;
import android.util.Log;

public class Snake_Tool extends Snake_Classic {
	protected Tool tool;
	protected int change;
	protected int augment;
	protected int cut;
	protected int across;
	
	public Snake_Tool()
	{
		super();
		tool=new Tool();
		change=0;
		augment=0;
		cut=0;
		across=0;
	}
	public int getChange()
	{
		return change;
	}
	public int getAugment()
	{
		return augment;
	}
	public int getCut()
	{
		return cut;
	}
	public int getAcross()
	{
		return across;
	}
	public boolean bScore()
	{
		return super.bScore();
	}
	public int getScore()
	{
		return super.getScore();
	}
	
	public Fruit getFruit()
	{
		return super.getFruit();
	}
	public Tool getTool()
	{
		return tool;
	}
	public int getLength()
	{
		return super.getLength();
	}
	public void setLength(int length)
	{
		super.setLength(length);
	}
	public Point getHead()
	{
		return super.getHead();
	}
	public Point getRear()
	{
		return super.getRear();
	}
	public void setDirection(int direction)
	{
		super.setDirection(direction);
	}
	
	public int getDirection()
	{
		return super.getDirection();
	}
	public void doubleScoreValue()
	{
		score_value*=2;
	}
	public void halfScoreValue()
	{
		score_value/=2;
	}
	public void changeHead()
	{
		ArrayList<Point> temp_array=new ArrayList<Point>();		
		Point p1,p2;
		p1=snake_body.get(0);  //rear
		p2=snake_body.get(1);  
		int temp_row1=p1.x,temp_column1=p1.y;
		int temp_row2=p2.x,temp_column2=p2.y;
		if(temp_row1-temp_row2==1)
			Snake_Data.DIRECTION=Snake_Data.DIRECTION_RIGHT;
		if(temp_row1-temp_row2==-1)
			Snake_Data.DIRECTION=Snake_Data.DIRECTION_LEFT;
		if(temp_column1-temp_column2==1)
			Snake_Data.DIRECTION=Snake_Data.DIRECTION_DOWN;
		if(temp_column1-temp_column2==-1)
			Snake_Data.DIRECTION=Snake_Data.DIRECTION_UP;
		for(Point p:snake_body)
		{
			temp_array.add(0, p);
		}
		snake_body.clear();
		snake_body=temp_array;
		direction=Snake_Data.DIRECTION;
	}
	public void cutRear()
	{
		if(this.length>1)
		{
		snake_body.remove(0);
		this.length--;
		}
		Log.i("Debug","Not cut"+" "+snake_body.size());
	}
	public void creatFruit()
	{
		fruit.creatFruit(this);
	}
	public void creatTool()
	{
		tool.creatTool(this);
	}
	
	public Point getAhead()
	{
		return super.getAhead();
	}
	public int judgeAhead(Point p)
	{
		int temp_ahead=super.judgeAhead(p);
		Log.e("Debug","before tool judgeAhead tool: "+""+temp_ahead);
		if(temp_ahead==Snake_Data.EMPTY)
		{
			Log.e("Debug","after tool judgeAhead tool: ");
			if(tool.getTool(p)!=null)
			{
				Log.e("Debug","get tool: "+""+temp_ahead);
				return tool.getType(p);
			}
			return Snake_Data.EMPTY;
		}
		return temp_ahead;
	}
	
	public Point getAcrossAhead()
	{
		Point p=this.getAhead();
		int temp_row=p.x;
		int temp_column=p.y;
		setDirection(Snake_Data.DIRECTION);
		if(temp_column==-1)
			temp_column=height-1;
		if(temp_column==height)
			temp_column=0;
		if(temp_row==-1)
			temp_row=width-1;
		if(temp_row==width)
			temp_row=0;
		return new Point(temp_row,temp_column);
	}
	public int judgeAcrossAhead(Point p)
	{
		return this.judgeAhead(p);
	}
	public int judgeDeath(int ahead)
	{
		setDirection(Snake_Data.DIRECTION);
		return super.judgeDeath(ahead);
	}
	private void getType(int ahead)
	{
		switch(ahead)
		{
		case Snake_Data.CHANGE:
		{
			change++;
			break;
		}
		case Snake_Data.AUGMENT:
		{
			augment++;
			break;
		}
		case Snake_Data.CUT:
		{
			cut++;
			break;
		}
		case Snake_Data.ACROSS:
		{
			across++;
			break;
		}
		}
	}
	public void moveAcross(Point p,int ahead)
	{
		this.move(p, ahead);
		
	}
	public void move(Point p,int ahead)
	{		
		if(ahead<=Snake_Data.ACROSS&&ahead>=Snake_Data.CHANGE)
		{
			this.getType(ahead);
			snake_body.add(p);
			snake_body.remove(0);
			tool.remove(p);
			score+=Snake_Data.TOOL_SCORE;
			return;
		}
		super.move(p, ahead);		
	}
	public void listenTool()
	{
		if(Snake_Data.BCHANGE)
		{
			Snake_Data.BCHANGE=false;
			if(change>0)
			{
				Snake_Data.ACHANGE=true;
				change--;
			}
		}
	else
		if(Snake_Data.BAUGMENT)
		{
			Snake_Data.BAUGMENT=false;
			if(augment>0)
			{
				Snake_Data.TAUGMENT=10;
				augment--;
			}			
		}
	else
		if(Snake_Data.BCUT)
		{
			Snake_Data.BCUT=false;
			if(cut>0)
			{
				Snake_Data.ACUT=true;
				cut--;
			}
		}
	else
		if(Snake_Data.BACROSS)
		{
			Snake_Data.BACROSS=false;
			if(across>0)
			{
				Snake_Data.TACROSS=10;
				across--;
			}
		}
		
	}
}
