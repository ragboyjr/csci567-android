package csci567.rj.project5;

import android.provider.BaseColumns;

/*
 * References
 * http://developer.android.com/training/basics/data-storage/databases.html
 */
public final class P5DataContract {
	
	/* define empty constructor to ensure no one instantiates? */
	public P5DataContract() {}
	
	/* Inner classes for table definitions */
	
	/* Definition for the arbitrary strings table */
	public static abstract class Strings implements BaseColumns {
		public static final String TABLE		    = "strings";
		public static final String COL_DATA 	    = "data";
		public static final String CREATE_TABLE_SQL	= 
			"CREATE TABLE " + Strings.TABLE + " ( " +
			    Strings._ID + " INTEGER PRIMARY KEY, "+
				Strings.COL_DATA + " VARCHAR(255) " +
			")";
		public static final String CREATE_INDEX_SQL =
			"CREATE UNIQUE INDEX strings_data_idx ON " +
			Strings.TABLE + " (" + Strings.COL_DATA + ")";
	}
}
