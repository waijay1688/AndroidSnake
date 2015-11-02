package snake_class;
import java.util.ArrayList;
import android.graphics.Point;


public class Snake {
	
	protected final static int height=Snake_Data.COLUMN;
	protected final static int width=Snake_Data.ROW;
	//the direction of the snake in moving
	protected int direction;
	//the coordination of the head
	public ArrayList<Point> snake_body;
	public int length;
	public Snake()
	{
		direction=Snake_Data.SNAKE_UP;		
		snake_body=new ArrayList<Point>();
		snake_body.add(new Point(width/2,height/2+1));
		snake_body.add(new Point(width/2,height/2));
		snake_body.add(new Point(width/2,height/2-1));		
		length=3;
	}
	public int getLength()
	{
		return length;
	}
	public void setLength(int length)
	{
		this.length=length;
	}
	public Point getHead()
	{
		return snake_body.get(length-1);
	}
	public Point getRear()
	{
		return snake_body.get(0);
	}
	public void setDirection(int direction)
	{
		if(this.direction+direction==3)
			return;
		else
			this.direction=direction;
	}
	public int getDirection()
	{
		return direction;
	}
	public Tool getTool()
	{
		return null;
	}
	public Fruit getFruit()
	{
		return null;
	}
	public void creatFruit()
	{

	}
	public void creatTool()
	{
		
	}
	public int getScore()
	{
		return 0;
	}
	public boolean bScore()
	{
		return false;
	}
	public Point getAhead()
	{
		int temp_row=getHead().x;
		int temp_column=getHead().y;
		setDirection(Snake_Data.DIRECTION);
		switch (getDirection())
		{
		case Snake_Data.SNAKE_UP:
		{
			temp_column--;			
			break;
		}
		case Snake_Data.SNAKE_DOWN:
		{
			temp_column++;
			break;
		}
		case Snake_Data.SNAKE_LEFT:
		{
			temp_row--;
			break;
		}
		case Snake_Data.SNAKE_RIGHT:
		{
			temp_row++;
			break;
		}
		}
		return new Point(temp_row,temp_column);
		
	}
	public  int judgeAhead(Point p)
	{
		int temp_row=p.x;
		int temp_column=p.y;
		switch(direction)
		{
			case Snake_Data.SNAKE_UP:
			{
				if(temp_column==-1)
					return Snake_Data.BOUNDARY;
			}
			case Snake_Data.SNAKE_DOWN:
			{
				if(temp_column==height)
					return Snake_Data.BOUNDARY;
			}
			case Snake_Data.SNAKE_LEFT:
			{
				if(temp_row==-1)
					return Snake_Data.BOUNDARY;
			}
			case Snake_Data.SNAKE_RIGHT:
			{
				if(temp_row==width)
					return Snake_Data.BOUNDARY;
			}
		}
		if(snake_body.contains(p))
				return Snake_Data.SNAKE_BODY;
		return Snake_Data.EMPTY;
	}	
	public int judgeDeath(int ahead)
	{
		setDirection(Snake_Data.DIRECTION);
		if ((ahead==Snake_Data.BOUNDARY)||
			(ahead==Snake_Data.SNAKE_BODY))
			return Snake_Data.DEATH;
		else
			return Snake_Data.ALIVE;
	}
	
	public void move(Point p,int ahead)
	{
		snake_body.remove(0);
		snake_body.add(p);
	}	
	public void listenTool()
	{
		
	}
	public void moveAcross(Point p,int ahead)
	{
		
	}
	public void changeHead()
	{
		
	}
	public void cutRear()
	{
		
	}
	public int getChange()
	{
		return 0;
	}
	public int getAugment()
	{
		return 0;
	}
	public int getCut()
	{
		return 0;
	}
	public int getAcross()
	{
		return 0;
	}
	public void doubleScoreValue()
	{
		return;
	}
	public void halfScoreValue()
	{
		return;
	}
	public Point getAcrossAhead()
	{
		return null;
	}
	public int judgeAcrossAhead(Point p)
	{
		return 0;
	}
}

