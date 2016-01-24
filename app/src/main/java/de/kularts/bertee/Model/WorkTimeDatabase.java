package de.kularts.bertee.Model;

import de.kularts.bertee.Controller.MainActivity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class WorkTimeDatabase extends SQLiteOpenHelper {

    // Database constants
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "InternshipDB";
    private static final String TABLE_WORKTIME = "worktime";

    private static final String WORKTIME_ID = "ID";
    private static final String WORKTIME_TIMESTAMP = "timestamp";
    private static final String WORKTIME_TYPE = "type";

    //private static final String[] COLUMNS = {TRACK_ID, TRACK_TITLE, TRACK_ARTIST, TRACK_ALBUM, TRACK_YEAR, TRACK_BPM, TRACK_MIMETYPE, TRACK_CATEGORY, TRACK_FILEPATH, TRACK_DURATION};


    // DEBUG
    private static final String TAG = MainActivity.class.getName();
    private static final boolean D = false;

    // ------------------------------------------------------------------------

    public WorkTimeDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // CREATE TABLES
//		String CREATE_ARTIST_TABLE = "CREATE TABLE artist(artistid INTEGER PRIMARY KEY,artistname TEXT);";
//		String CREATE_CATEGORY_TABLE = "CREATE TABLE category (categoryid INTEGER PRIMARY KEY,categoryname TEXT,categorydesc TEXT);";
//		String CREATE_TRACK = 	"CREATE TABLE track(trackid INTEGER PRIMARY KEY,tracktitle TEXT,trackalbum TEXT,trackyear TEXT,trackbpm INTEGER"+
//								",trackmimetype TEXT,trackartist INTEGER,trackcategory INTEGER,"+
//								"FOREIGN KEY(trackartist) REFERENCES artist(artistid),FOREIGN KEY(trackcategory) REFERENCES category(categoryid));";
//

        String CREATE_TABLE_WORKTIME =
                "CREATE TABLE "+ TABLE_WORKTIME +"("
                        + WORKTIME_ID + " INTEGER PRIMARY KEY,"
                        + WORKTIME_TIMESTAMP + " DATE,"
                        + WORKTIME_TYPE + " TEXT"
                        + ");";

        // CREATE DATABASE
        String CREATE_DATABASE_TABLES = CREATE_TABLE_WORKTIME /* + CREATE_ARTIST_TABLE +  CREATE_CATEGORY_TABLE*/ ;
        db.execSQL(CREATE_DATABASE_TABLES);

    }

    // ------------------------------------------------------------------------

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

//		db.execSQL("DROP TABLE IF EXISTS artist");
//		db.execSQL("DROP TABLE IF EXISTS category");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKTIME);

        this.onCreate(db);

    }

    // ------------------------------------------------------------------------

    public void addWorktimeEntry(WorktimeEntry entry){

        if(D) Log.d(TAG, "addWorktimeEntry: " + entry.toString());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WORKTIME_ID, entry.getId());
        //values.put(WORKTIME_TIMESTAMP, entry.getTimestamp());
        //values.put(WORKTIME_TYPE, entry.getType());

        db.insert(TABLE_WORKTIME, null, values);

        db.close();
    }

    // ------------------------------------------------------------------------

    /*public Track getTrack(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_TRACKS,
                        COLUMNS,
                        " trackid = ?",
                        new String[] { String.valueOf(id) },
                        null, // group by
                        null, // having
                        null, // order by
                        null); // limit

        if (cursor != null)
            cursor.moveToFirst();

        Track track = new Track();
        if(cursor.getString(0) != null) track.setId(Integer.parseInt(cursor.getString(0))); else track.setId(0);

        track.setTitle(cursor.getString(1));
        track.setArtist(cursor.getString(2));
        track.setAlbum(cursor.getString(3));
        track.setYear(cursor.getString(4));

//		if(cursor.getString(5) != null) track.setBpm(Integer.parseInt(cursor.getString(5))); else track.setBpm(0);
        track.setBpm(cursor.getString(5));

        track.setMimeType(cursor.getString(6));
        track.setCategory(cursor.getString(7));
        track.setFilepath(cursor.getString(8));
        track.setDuration(cursor.getString(9));

        //log
        if(D) Log.d("getTrack("+id+")", track.toString());

        return track;
    }*/

    // ------------------------------------------------------------------------

    /*public List<Track> getAllTracks() {

        List<Track> tracks = new LinkedList<Track>();

        String query = "SELECT * FROM " + TABLE_TRACKS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // go over each row, build track and add it to list
        Track track = null;
        if (cursor.moveToFirst()) {
            do {
                track = new Track();

                if(cursor.getString(0) != null) track.setId(Integer.parseInt(cursor.getString(0))); else track.setId(0);
//	    		   track.setId(Integer.parseInt(cursor.getString(0)));
                track.setTitle(cursor.getString(1));
                track.setArtist(cursor.getString(2));
                track.setAlbum(cursor.getString(3));
                track.setYear(cursor.getString(4));
//	    		   if(cursor.getString(5) != null) track.setBpm(Integer.parseInt(cursor.getString(5))); else track.setBpm(0);
                track.setBpm(cursor.getString(5));
                track.setMimeType(cursor.getString(6));
                track.setCategory(cursor.getString(7));
                track.setFilepath(cursor.getString(8));
                track.setDuration(cursor.getString(9));

                tracks.add(track);
            } while (cursor.moveToNext());
        }

//	       Log.d("getAllTracks()", tracks.toString());

        return tracks;
    }*/

    // ------------------------------------------------------------------------

    /*public void deleteAllTracks(){

        SQLiteDatabase db = this.getWritableDatabase();

        // DELETE TABLE before adding tracks by scanning the music folder
        // Query doesn't work with *
        db.execSQL("DELETE FROM track");

    }*/
}

