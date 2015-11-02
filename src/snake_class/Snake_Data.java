package snake_class;
import java.util.ArrayList;


public class Snake_Data {
	//the size of the fragment
	public static final int COLUMN=11;
	public static final int ROW=21;
	//the size of the screen
	public static int SCREENHEIGHT;
	public static int SCREENWIDTH;
	//the step number
	public static int STEP=100;
	//the number of tool type
	public static int TOOL_NUM=4;
	
	
	//the head and rear record of the snake
	public static ArrayList<Integer> head_Column=new ArrayList<Integer>();;
	public static ArrayList<Integer> head_Row=new ArrayList<Integer>();;
	//the direction of the snake in moving
	public static final int SNAKE_LEFT=0;
	public static final int SNAKE_RIGHT=3;
	public static final int SNAKE_UP=1;
	public static final int SNAKE_DOWN=2;
	
	//the direction that the player set in their playing
	public static final int DIRECTION_LEFT=0;
	public static final int DIRECTION_RIGHT=3;
	public static final int DIRECTION_UP=1;
	public static final int DIRECTION_DOWN=2;
	//the direction of the snake
	public static int DIRECTION=DIRECTION_UP;
	//the things the head will meet
	public static final int EMPTY=0;
	public static final int SNAKE_BODY=1;
	public static final int BOUNDARY=2;
	public static final int FRUIT=3;
	public static final int CHANGE=4;
	public static final int AUGMENT=5;
	public static final int CUT=6;
	public static final int ACROSS=7;
	//the status of the game
	public static final int DEATH=0;
	public static final int ALIVE=1;
	public static final int ERROR=2;
	//the score that will get after being eaten
	public static  int FRUIT_SCORE=3;
	public static  int TOOL_SCORE=1;
	//the current of the tool
	public static final double CURRENT[]={0.9,0.9,0.9,0.9};
	public static boolean BCHANGE;
	public static boolean BAUGMENT;
	public static boolean BCUT;
	public static boolean BACROSS;
	
	
	public static final int FRENCUNCY[]={100,200,500,1000};
	public static  int ITEM;
	public static  int TEMP_FRENCUNCY;
	
	public static boolean ACHANGE;
	public static boolean ACUT;
	public static int TAUGMENT;
	public static int TACROSS;
	
	public static boolean BCLASSIC;
	public static boolean BTIME;
	public static boolean BPROP;
	
	public static boolean BPAUSE;
	public static boolean BRESTART;
}
