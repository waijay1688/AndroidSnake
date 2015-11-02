package snake_class;
import java.util.Random;
import java.util.ArrayList;
import android.graphics.Point;
import android.util.Log;

public class Tool {
	public ArrayList<Widget> tool;
	private int tool_count;
	Random random;
	public Tool()
	{
		tool=new ArrayList<Widget>();
		tool_count=0;
		random=new Random();
	}
	public int getToolCount()
	{
		return tool_count;
	}
	public void setToolCount(int count)
	{
		tool_count=count;
	}
	// must ensure that p is not taken by others
	public void setTool(Point p, int type)
	{		
		tool.add(new Widget(p,type));		
	}
	public Widget getTool(Point p)
	{
		for(Widget t:tool)
		{	
			Log.e("Debug","int getTool: ");
			if(t.getPoint().x==p.x&&t.getPoint().y==p.y)
			{
				Log.e("Debug","getTool: ");
				return t;
			}
		}
		return null;
	}
	public int getType(Point p)
	{
		return getTool(p).getType();
	}
	public boolean remove(Point p)
	{
		if(tool_count<=0)
			return false;
		for(int i=0;i<tool_count;i++)
		{
			if(tool.get(i).getPoint().x==p.x&&tool.get(i).getPoint().y==p.y)
			{
				tool.remove(i);
				tool_count--;
				return true;
			}
		}
		return false;
	}
	public void creatTool(Snake snake)
	{
		if(tool_count>2)
			return;
		if(snake instanceof Snake_Tool)
		{
			int  temp_int;
			double temp_double;
			temp_double=random.nextDouble();
			temp_int=random.nextInt(Snake_Data.TOOL_NUM);
			if(temp_double<Snake_Data.CURRENT[temp_int])
			while(true)
			{
				int temp1=random.nextInt(Snake_Data.ROW);
				int temp2=random.nextInt(Snake_Data.COLUMN);
				Point p=new Point(temp1,temp2);
				if(snake.snake_body.contains(p)||snake.getFruit().fruit.contains(new Point(temp1,temp2))||getTool(p)!=null)							
						continue;
					else
					{
						setTool(p , temp_int+4);
						tool_count++;
						return;
					}
								
				}	
			}
	}
	
}
