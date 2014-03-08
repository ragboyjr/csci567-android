package csci567.rj.project5;

import csci567.rj.project5.P5DataContract.Strings;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class P5DataDbHelper extends SQLiteOpenHelper {

	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "p5data.db";
	
	public P5DataDbHelper(Context ctx) {
		super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(Strings.CREATE_TABLE_SQL);
		db.execSQL(Strings.CREATE_INDEX_SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// do nothing
	}

	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // do nothing
    }
}
