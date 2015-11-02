package snake_class;

import java.util.Random;

import android.graphics.Point;

public class Snake_Classic extends Snake {
	protected Random random;
	protected int score;
	public int score_value;
	protected Fruit fruit;
	protected boolean bscore;
	public Snake_Classic()
	{
		super();
		fruit=new Fruit();
		random=new Random();
		score=0;
		score_value=Snake_Data.FRUIT_SCORE;
		bscore=false;
	}
	public boolean bScore()
	{
		return bscore;
	}
	public int getScore()

	{
		return score;
	}	
	public Fruit getFruit()
	{
		return fruit;
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
	public void creatFruit()
	{
		fruit.creatFruit(this);
	}	
	public Point getAhead()
	{
		return super.getAhead();
	}
	public int judgeAhead(Point p)
	{
		int temp_ahead=super.judgeAhead(p);
		if(temp_ahead==Snake_Data.EMPTY)
			if(fruit.fruit.contains(p))
				return Snake_Data.FRUIT;
			else return Snake_Data.EMPTY;
		return temp_ahead;
	}	
	public int judgeDeath(int ahead)
	{
		setDirection(Snake_Data.DIRECTION);
		return super.judgeDeath(ahead);
	}	
	public void move(Point p,int ahead)
	{
		setDirection(Snake_Data.DIRECTION);
		if(ahead==Snake_Data.EMPTY)
		{
			super.move(p,ahead);
			bscore=false;
			return;
		}
		if(ahead==Snake_Data.FRUIT)
		{
			bscore=true;
			length++;
			snake_body.add(p);
			fruit.fruit.remove(p);
			score+=score_value;
		}
	}
}