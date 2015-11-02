package snake_class;

import android.graphics.Point;

public class Widget
{
	public Point p;
	public int type;
	public Widget(int row,int column,int type)
	{
		p=new Point(row,column);
		this.type=type;
	}
	public Widget(Point p,int type)
	{
		this.p=p;
		this.type=type;
	}
	public int getType()
	{
		return type;
	}
	public Point getPoint()
	{
		return p;
	}
}

	