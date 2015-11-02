package snake_class;
import java.util.Random;
import java.util.ArrayList;

import android.graphics.Point;
public class Fruit {
	private int height;
	private int width;
	public ArrayList<Point> fruit;
	Random random;
	Fruit()
	{
		height=Snake_Data.COLUMN;
		width=Snake_Data.ROW;
		fruit=new ArrayList<Point>();
		random=new Random();
	}
	public int getFruitCount()
	{
		return fruit.size();
	}
	public void setFruit(Point p, boolean temp)
	{
		if(temp)
		fruit.add(p);
		else
		fruit.remove(p);
	}
	public void creatFruit(Snake snake)
	{
		if(fruit.size()>2)
			return;
		while(true)
		{
			int temp1=random.nextInt(width);
			int temp2=random.nextInt(height);
			Point p=new Point(temp1,temp2);
			if(snake instanceof Snake_Classic)
			{
				if((snake.snake_body.contains(p)||fruit.contains(p)))							
					continue;
				else
				{
					setFruit(p, true);
					return;
				}
			}
			if(snake instanceof Snake_Tool)
			{
				if((snake.snake_body.contains(p)||fruit.contains(p))||snake.getTool().getTool(p)!=null)							
					continue;
				else
				{
					setFruit(p, true);
					return;
				}
			}
						
		}		
	}
}
