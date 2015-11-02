package snake.android;



import snake.android.MusicPlayer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.widget.LinearLayout;



public class Static_Date
{
	public static boolean VOICE_SWITCH = true;
	public static boolean GRAVITY_SWITCH = false;
	public static MusicPlayer MUSIC_PLAYER;
	public static String BACKGROUND = "地图一";
	public static int i = 0;
	public static int j = 0;
	public static int score = 0;
	public static String TABLE_SCORE = "SnakeScore";
	public static SQLiteDatabase sdb;
	public static AndroidSQLite database;
	public static String DATABASE_NAME = "SnakeGame";
	public static String sqlScore="create table"+TABLE_SCORE+"id int privary key not null ,playerScore int ";
	public static void Set_Background(LinearLayout background, String str){
		
		if(str.equals("地图一"))
			background.setBackgroundResource(R.drawable.back1);
		if(str.equals("地图二"))
			background.setBackgroundResource(R.drawable.back2);
		if(str.equals("地图三"))
			background.setBackgroundResource(R.drawable.back3);
		if(str.equals("地图四"))
			background.setBackgroundResource(R.drawable.back4);
		if(str.equals("地图五"))
			background.setBackgroundResource(R.drawable.back5);
	}
	public static boolean savePlayerInformation(int score){
		Cursor cursor = searchSQLite(TABLE_SCORE, true);
		cursor.moveToLast();
		int oldScore = cursor.getInt(0);
		if(oldScore >= score){
			return false;
		}
		else{
			int id = cursor.getInt(0);
			String sql = "delete from "+TABLE_SCORE+" where id = "+id;
			deleteData(sql);
			sql = "insert into "+TABLE_SCORE+" values("+id+","+score+")";
			addDate(sql);
			return true;
		}
	}
	private static void addDate(String sql) {
		sdb = database.getWritableDatabase();
		sdb.execSQL(sql);
		
	}
	private static void deleteData(String sql) {
		sdb = database.getWritableDatabase();
		sdb.execSQL(sql);
		
	}
	public static Cursor searchSQLite(String tableName , boolean flag){
		Cursor c;
		sdb = database.getReadableDatabase();
		if(flag)
			c = sdb.query(tableName, null, null, null, null, null, "playerScore DESC");
		else
			c = sdb.query(tableName, null, null, null, null, null, null);
		return c;
	}

}
class AndroidSQLite extends SQLiteOpenHelper{

	public AndroidSQLite(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	public void onCreate(SQLiteDatabase db){
		createTable(db,Static_Date.sqlScore);
	}
	public void createTable(SQLiteDatabase db , String sql){
		try{
			db.execSQL(sql);
		}catch (Exception e){
			Log.i("execSQL error  :" , e.getMessage());
		}
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
