package com.app.hsalbsig.martin.app.databse;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;



// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseHandler.
 * 
 * @author Martin Meﬂner, Ramona Wicker
 */
public class DatabaseHandler {

	// Database fields
	/** The database. */
	private static SQLiteDatabase database;

	/** The db helper. */
	private static MySQLiteHelper dbHelper;

	/** The all event columns. */
	private static String[] allEventColumns = { MySQLiteHelper.COLUMN_EVENT_ID,
			MySQLiteHelper.COLUMN_EVENT_ITEMNUMBER,
			MySQLiteHelper.COLUMN_EVENT_NAME,
			MySQLiteHelper.COLUMN_EVENT_DATE1,
			MySQLiteHelper.COLUMN_EVENT_DATE2,
			MySQLiteHelper.COLUMN_EVENT_TIME1,
			MySQLiteHelper.COLUMN_EVENT_TIME2 };

	/** The all room columns. */
	private static String[] allRoomColumns = { MySQLiteHelper.COLUMN_ROOM_ID,
			MySQLiteHelper.COLUMN_ROOM_ITEMNUMBER,
			MySQLiteHelper.COLUMN_ROOM_NAME,
			MySQLiteHelper.COLUMN_ROOM_LOCATION,
			MySQLiteHelper.COLUMN_ROOM_BUILDING };

	/** The all person columns. */
	private static String[] allPersonColumns = {
			MySQLiteHelper.COLUMN_PERSON_ID,
			MySQLiteHelper.COLUMN_PERSON_ITEMNUMBER,
			MySQLiteHelper.COLUMN_PERSON_NAME };

	/**
	 * Instantiates a new database handler.
	 * 
	 * @param context
	 *            the context
	 */
	public DatabaseHandler(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	/**
	 * Open.
	 * 
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static void open() throws SQLException {
		if (database == null) {
			database = dbHelper.getWritableDatabase();
		}
	}

	/**
	 * Close DB.
	 */
	public static void close() {
		dbHelper.close();
	}

	/**
	 * Initialize.
	 * 
	 * @param context
	 *            the context
	 */
	public static void initialize(Context context) {
		dbHelper = new MySQLiteHelper(context);
		database = dbHelper.getWritableDatabase();
	}

	/**
	 * Creates the event.
	 * 
	 * @param eventList
	 *            the event list
	 */
	/*public static void createEvent(ArrayList<Event> eventList) {
		open();
		database.beginTransaction();
		for (Event event : eventList) {
			ContentValues values = new ContentValues();
			values.put(MySQLiteHelper.COLUMN_EVENT_ITEMNUMBER,
					event.getItemnumber());
			values.put(MySQLiteHelper.COLUMN_EVENT_NAME, event.getName());
			values.put(MySQLiteHelper.COLUMN_EVENT_DATE1, event.getDate1());
			values.put(MySQLiteHelper.COLUMN_EVENT_DATE2, event.getDate2());
			values.put(MySQLiteHelper.COLUMN_EVENT_TIME1, event.getTime1());
			values.put(MySQLiteHelper.COLUMN_EVENT_TIME2, event.getTime2());
			values.put(MySQLiteHelper.COLUMN_EVENT_MODULNUMBER,
					event.getModulnumber());
			values.put(MySQLiteHelper.COLUMN_EVENT_SEMESTER,
					event.getSemester());

			database.insert(MySQLiteHelper.TABLE_EVENT, null, values);

		}
		database.setTransactionSuccessful();
		database.endTransaction();

		Cursor cursor = database.rawQuery("Select * from event", null);
		Log.d("DatabaseHandler", "events count: " + cursor.getCount());
		cursor.close();
	}

	*//**
	 * Creates the room.
	 * 
	 * @param roomList
	 *            the room list
	 *//*
	public static void createRoom(ArrayList<Room> roomList) {
		open();
		database.beginTransaction();
		for (Room room : roomList) {
			ContentValues values = new ContentValues();
			values.put(MySQLiteHelper.COLUMN_ROOM_ITEMNUMBER,
					room.getItemnumber());
			values.put(MySQLiteHelper.COLUMN_ROOM_NAME, room.getName());
			values.put(MySQLiteHelper.COLUMN_ROOM_LOCATION, room.getLocation());
			values.put(MySQLiteHelper.COLUMN_ROOM_BUILDING, room.getBuilding());
			database.insert(MySQLiteHelper.TABLE_ROOM, null, values);
		}
		database.setTransactionSuccessful();
		database.endTransaction();

		Cursor cursor = database.rawQuery("Select * from room", null);
		Log.d("DatabaseHandler", "room count: " + cursor.getCount());
		cursor.close();
	}

	*//**
	 * Creates the person.
	 * 
	 * @param personList
	 *            the person list
	 *//*
	public static void createPerson(ArrayList<Person> personList) {
		open();
		database.beginTransaction();
		for (Person person : personList) {
			ContentValues values = new ContentValues();
			values.put(MySQLiteHelper.COLUMN_PERSON_ITEMNUMBER,
					person.getItemnumber());
			values.put(MySQLiteHelper.COLUMN_PERSON_NAME, person.getName());
			database.insert(MySQLiteHelper.TABLE_PERSON, null, values);
		}
		database.setTransactionSuccessful();
		database.endTransaction();

		Cursor cursor = database.rawQuery("Select * from person", null);
		Log.d("DatabaseHandler", "person count: " + cursor.getCount());
		cursor.close();
	}

	*//*
	 * Returns a List containing all Persons, uses the cursorToPerson Method to
	 * get the values of each Column, setting up a new Object of Person
	 *//*
	*//**
	 * Gets all persons by creating cursor which moves through the personlist.
	 * 
	 * @return all persons
	 *//*
	public static List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<Person>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_PERSON,
				allPersonColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Person person = cursorToPerson(cursor);
			persons.add(person);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return persons;
	}

	*//**
	 * Cursor to person returns the person of the position of the cursor.
	 * 
	 * @param cursor
	 *            the cursor
	 * @return the person
	 *//*
	private static Person cursorToPerson(Cursor cursor) {
		Person person = new Person();
		person.set_pid(cursor.getLong(0));
		person.setItemnumber(cursor.getLong(1));
		person.setName(cursor.getString(2));
		return person;
	}

	*//*
	 * Returns a List containing all Events, uses the cursorToEvent Method to
	 * get the values of each Column, setting up a new Object of Event
	 *//*
	*//**
	 * Gets the all events.
	 * 
	 * @param context
	 *            the context
	 * @return the all events
	 *//*
	public static List<Event> getAllEvents(Context context) {
		initialize(context);
		List<Event> events = new ArrayList<Event>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_EVENT,
				allEventColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Event event = cursorToEvent(cursor);
			events.add(event);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return events;
	}

	*//**
	 * Cursor to event.
	 * 
	 * @param cursor
	 *            the cursor
	 * @return the event
	 *//*
	private static Event cursorToEvent(Cursor cursor) {
		Event event = new Event("", "");
		event.set_eid(cursor.getLong(0));
		event.setItemnumber(cursor.getLong(1));
		event.setName(cursor.getString(2));
		event.setDate1(cursor.getString(3));
		event.setDate2(cursor.getString(4));
		event.setTime1(cursor.getString(5));
		event.setTime2(cursor.getString(6));
		return event;
	}

	*//*
	 * Returns a List containing all Rooms, uses the cursorToRoom Method to get
	 * the values of each Column, setting up a new Object of Room
	 *//*
	*//**
	 * Gets the all rooms.
	 * 
	 * @return the all rooms
	 *//*
	public static List<Room> getAllRooms() {
		List<Room> rooms = new ArrayList<Room>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_ROOM,
				allRoomColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Room room = cursorToRoom(cursor);
			rooms.add(room);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return rooms;
	}

	*//**
	 * Cursor to room.
	 * 
	 * @param cursor
	 *            the cursor
	 * @return the room
	 *//*
	private static Room cursorToRoom(Cursor cursor) {
		Room room = new Room();
		room.set_rid(cursor.getLong(0));
		room.setItemnumber(cursor.getLong(1));
		room.setName(cursor.getString(2));
		room.setLocation(cursor.getString(3));
		room.setBuilding(cursor.getString(4));
		return room;
	}

	*//**
	 * Fill db calls methods createPerson, createRoom, createEvent to fill the
	 * DB with the elements of the arraylists .
	 * 
	 * @param events
	 *            the events
	 * @param rooms
	 *            the rooms
	 * @param persons
	 *            the persons
	 * @throws EmptyArrayException
	 *             the empty array exception
	 *//*
	public static void fillDB(ArrayList<Event> events, ArrayList<Room> rooms,
			ArrayList<Person> persons) throws EmptyArrayException {
		Long start = System.currentTimeMillis();
		Log.d("Filling", "started");
		if (persons.isEmpty() || rooms.isEmpty() || events.isEmpty()) {
			throw new EmptyArrayException();

		} else {
			createPerson(persons);
			createRoom(rooms);
			createEvent(events);

		}
		Long end = System.currentTimeMillis();
		Long time = (end - start) / 1000;
		Log.d("Database Filling", "Filling time: " + time + " seconds");
		Log.d("XMLParser", "Event count: " + events.size() + ", Rooms count: "
				+ rooms.size() + ", Persons count: " + persons.size());
	}*/

	/**
	 * Checks if is table exists method for the first time checks if a table is
	 * existing if not catches NullPointerException returns false.
	 * 
	 * @param tableName
	 *            the table name
	 * @return true, if is table exists
	 */
	public static boolean isTableExists(String tableName) {

		try {
			database.rawQuery("Select * from " + tableName + ";", null);
			return true;
		} catch (SQLiteException e) {
			return false;
		} catch (NullPointerException npe) {
			return false;
		}
	}

	/**
	 * Clean db method calls by download function to erase all datas from the
	 * database and recreate the tables to prevent double entries.
	 */
	public static void cleanDB() {
		open();
		Log.w(MySQLiteHelper.class.getName(), "Cleaning Database");
		database.execSQL("DROP TABLE IF EXISTS " + MySQLiteHelper.TABLE_EVENT);
		database.execSQL("DROP TABLE IF EXISTS " + MySQLiteHelper.TABLE_ROOM);
		database.execSQL("DROP TABLE IF EXISTS " + MySQLiteHelper.TABLE_PERSON);
		database.execSQL(MySQLiteHelper.EVENT_CREATE);
		database.execSQL(MySQLiteHelper.ROOM_CREATE);
		database.execSQL(MySQLiteHelper.PERSON_CREATE);
	}

}
