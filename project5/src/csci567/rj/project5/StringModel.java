package csci567.rj.project5;

import java.util.ArrayList;

import csci567.rj.project5.P5DataContract.Strings;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StringModel {
	private P5DataDbHelper dbh;
	
	public StringModel(Context ctx) {
		this.dbh = new P5DataDbHelper(ctx);
	}
	
	public boolean addString(String s) {
		SQLiteDatabase db    = this.dbh.getWritableDatabase();
		ContentValues valmap = new ContentValues();
		long rowid;
		
		/* don't insert empty strings */
		if (s.length() == 0) {
			return false;
		}
		
		valmap.put(Strings.COL_DATA, s);
		
		rowid = db.insert(Strings.TABLE, null, valmap);
		
		if (rowid == -1) {
			// there was an error
			System.out.println("There was an error inserting '" + s + "'");
			return false;
		}
		
		return true;
	}
	
	public String[] getStrings() {
		ArrayList<String> strings = new ArrayList<String>();
		SQLiteDatabase db         = this.dbh.getReadableDatabase();
		Cursor c;
		int colDataIdx;
		
		/* define the columns */
		String[] columns = {
			Strings._ID,
			Strings.COL_DATA
		};
		
		c = db.query(Strings.TABLE, columns, null, null, null, null, null);
		
		colDataIdx = c.getColumnIndex(Strings.COL_DATA);
		
		/* iterate over the cursor and push into the strings array */
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			strings.add(c.getString(colDataIdx));
		}
		
		return strings.toArray(new String[strings.size()]);
	}
}
