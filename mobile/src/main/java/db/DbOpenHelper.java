package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import utils.Globals;

/**
 * Created by Oleg on 03.03.2016.
 */
public class DbOpenHelper extends SQLiteOpenHelper {


    public DbOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Globals.DB_NAME, factory, Globals.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_DB_CARD = "CREATE TABLE " + Globals.TABLE_CARDS + " ("
                + Globals.KEY_CARD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Globals.KEY_DECK_ID + " INTEGER, "
                + Globals.KEY_DECK_NAME + " TEXT, "
                + Globals.KEY_CARD_NAME + " TEXT,"
                + Globals.KEY_CARD_IMAGE + " TEXT,"
                + Globals.KEY_CARD_QUESTION + " TEXT, "
                + Globals.KEY_CARD_ANSWER + " TEXT);";

        db.execSQL(CREATE_DB_CARD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Globals.TABLE_CARDS);

        onCreate(db);
    }



}
