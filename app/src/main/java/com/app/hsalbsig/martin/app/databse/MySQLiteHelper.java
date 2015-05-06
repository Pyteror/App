package com.app.hsalbsig.martin.app.databse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class MySQLiteHelper.
 * 
 * @author Martin Meﬂner, Ramona Wicker
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

	public static final String TABLE_EVENT = "event";

	public static final String TABLE_ROOM = "room";

	public static final String TABLE_PERSON = "person";

	public static final String TABLE_SETTINGS = "settings";

	public static final String COLUMN_EVENT_ID = "_eid";

	public static final String COLUMN_EVENT_ITEMNUMBER = "itemnumber";

	public static final String COLUMN_EVENT_NAME = "name";

	public static final String COLUMN_EVENT_DATE1 = "date1";

	public static final String COLUMN_EVENT_DATE2 = "date2";

	public static final String COLUMN_EVENT_TIME1 = "time1";

	public static final String COLUMN_EVENT_TIME2 = "time2";

	public static final String COLUMN_EVENT_MODULNUMBER = "modulnumber";

	public static final String COLUMN_EVENT_SEMESTER = "semester";

	public static final String COLUMN_ROOM_ID = "_rid";

	public static final String COLUMN_ROOM_ITEMNUMBER = "itemnumber";

	public static final String COLUMN_ROOM_NAME = "name";

	public static final String COLUMN_ROOM_LOCATION = "location";

	public static final String COLUMN_ROOM_BUILDING = "building";

	public static final String COLUMN_PERSON_ID = "_pid";

	public static final String COLUMN_PERSON_ITEMNUMBER = "itemnumber";

	public static final String COLUMN_PERSON_NAME = "name";

	public static final String COLUMN_SETTINGS_ID = "_sid";

	public static final String COLUMN_SETTINGS_SEMESTER = "semester";

	public static final String COLUMN_SETTINGS_FAV1 = "fav1";

	public static final String COLUMN_SETTINGS_FAV2 = "fav2";

	public static final String COLUMN_SETTINGS_FAV3 = "fav3";

	public static final String COLUMN_SETTINGS_FAV4 = "fav4";

	public static final String COLUMN_SETTINGS_FAV5 = "fav5";

	public static final String COLUMN_SETTINGS_FAV6 = "fav6";

	public static final String COLUMN_SETTINGS_FAV7 = "fav7";

	private static final String DATABASE_NAME = "stundenplan.db3";

	private static final int DATABASE_VERSION = 16;

	// Database creation sql statement

	public static final String EVENT_CREATE = "create table " + TABLE_EVENT
			+ "(" + COLUMN_EVENT_ID + " integer primary key autoincrement, "
			+ COLUMN_EVENT_ITEMNUMBER + " text not null, " + COLUMN_EVENT_NAME
			+ " text not null, " + COLUMN_EVENT_DATE1 + " text not null, "
			+ COLUMN_EVENT_DATE2 + " text not null, " + COLUMN_EVENT_TIME1
			+ " text not null, " + COLUMN_EVENT_TIME2 + " text not null, "
			+ COLUMN_EVENT_MODULNUMBER + " text, " + COLUMN_EVENT_SEMESTER
			+ " text not null);";

	public static final String ROOM_CREATE = "create table " + TABLE_ROOM + "("
			+ COLUMN_ROOM_ID + " integer primary key autoincrement, "
			+ COLUMN_ROOM_ITEMNUMBER + " text not null, " + COLUMN_ROOM_NAME
			+ " text not null, " + COLUMN_ROOM_LOCATION + " text not null, "
			+ COLUMN_ROOM_BUILDING + " text not null) ";

	public static final String PERSON_CREATE = "create table " + TABLE_PERSON
			+ "(" + COLUMN_PERSON_ID + " integer primary key autoincrement, "
			+ COLUMN_PERSON_ITEMNUMBER + " text not null, "
			+ COLUMN_PERSON_NAME + " text not null) ";

	public static final String SETTINGS_CREATE = "create table "
			+ TABLE_SETTINGS + "(" + COLUMN_SETTINGS_ID
			+ " integer primary key autoincrement, " + COLUMN_SETTINGS_SEMESTER
			+ " text not null, " + COLUMN_SETTINGS_FAV1 + " text, "
			+ COLUMN_SETTINGS_FAV2 + " text, " + COLUMN_SETTINGS_FAV3
			+ " text, " + COLUMN_SETTINGS_FAV4 + " text, "
			+ COLUMN_SETTINGS_FAV5 + " text, " + COLUMN_SETTINGS_FAV6
			+ " text, " + COLUMN_SETTINGS_FAV7 + " text);";

	/**
	 * Instantiates a new my sq lite helper.
	 * 
	 * @param context
	 *            the context
	 */
	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite
	 * .SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase database) {
		Log.d("DB", "OnCreate");
		database.execSQL(EVENT_CREATE);
		database.execSQL(ROOM_CREATE);
		database.execSQL(PERSON_CREATE);
		database.execSQL(SETTINGS_CREATE);
		Log.d("DB", "Created");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite
	 * .SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(MySQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROOM);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SETTINGS);
		onCreate(db);
	}

}