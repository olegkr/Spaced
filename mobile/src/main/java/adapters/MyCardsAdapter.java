package adapters;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import db.DbOpenHelper;
import models.CardModel;
import utils.Globals;

/**
 * Created by Oleg on 04.03.2016.
 */
public class MyCardsAdapter extends ArrayAdapter<CardModel>{

    private static Cursor cursor = null;
    private SQLiteDatabase database = null;
    private DbOpenHelper dbOpenHelper = null;
    Activity mContext = null;
    LayoutInflater inflater = null;


    public MyCardsAdapter(Activity contxt, ArrayList<CardModel> cardList) {
        super(contxt, 0, cardList);
        this.mContext = contxt;

        init();

        inflater = LayoutInflater.from(mContext);
        //		inflater = ((Activity) context).getLayoutInflater();
    }

    private void init() {
        String query = "SELECT * FROM  cards  ORDER BY  deck_name";
        dbOpenHelper = new DbOpenHelper(mContext, Globals.DB_NAME, null, Globals.DATABASE_VERSION);
        try {
            database = dbOpenHelper.getWritableDatabase();
            cursor = database.rawQuery(query, null);
        } catch (SQLException e) {
            Log.e(this.toString(), "Error while getting database");
            throw new Error("The end");
        }
//        cursor = getAllEntries();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);

    }
}
