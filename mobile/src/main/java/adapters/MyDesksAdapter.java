package adapters;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import db.DbOpenHelper;
import models.DeckModel;
import spaced.com.spaced.R;
import utils.Globals;

/**
 * Created by Oleg on 04.03.2016.
 */
public class MyDesksAdapter extends ArrayAdapter<DeckModel> implements View.OnClickListener{

    private static Cursor cursor = null;
    private SQLiteDatabase database = null;
    private DbOpenHelper dbOpenHelper = null;
    Activity mContext = null;
    LayoutInflater inflater = null;
    ArrayList<DeckModel> mDecksList;


    public MyDesksAdapter(Activity contxt) {
        super(contxt, 0);
    }


    public MyDesksAdapter(Activity contxt, ArrayList<DeckModel> decksList) {
        super(contxt, R.layout.popular_deck_item_layout, decksList);
        this.mContext = contxt;
        this.mDecksList = decksList;

//        init();

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
    public View getView(final int position, View convertView,  ViewGroup parent) {

        DeckModel insertDm = this.getItem(position);

        final ImageView iv_deck_image;
        final TextView tv_deck_name;
        final TextView tv_deck_card_qnt;

        final LinearLayout ll_insert;

        final Button deck_delete;
        final Button deck_edit;
        final Button deck_enter;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.my_desk_item_layout, null);

            iv_deck_image = (ImageView) convertView.findViewById(R.id.imVw_deck);
            tv_deck_name = (TextView) convertView.findViewById(R.id.tVw_deck_name);
            tv_deck_card_qnt = (TextView) convertView.findViewById(R.id.tVw_deck_card_quantity);


//            deck_delete = (Button)convertView.findViewById(R.id.btn_deck_delete);
//            deck_edit = (Button)convertView.findViewById(R.id.btn_deck_edit);
//            deck_enter = (Button)convertView.findViewById(R.id.btn_deck_enter);

            convertView.setTag(new MyDeskViewHolder(iv_deck_image, tv_deck_name, tv_deck_card_qnt));
//                    ,
//                                                              deck_delete, deck_edit, deck_enter));
            convertView.setOnClickListener(this);

//            desk_edit.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                }
//            });


        } else {
            MyDeskViewHolder viewHolder = (MyDeskViewHolder) convertView.getTag();
            iv_deck_image = viewHolder.getDeskBitmap();
            tv_deck_name = viewHolder.getDeskName();
            tv_deck_card_qnt = viewHolder.getCardsQuantity();
        }

        Bitmap bitmap = insertDm.getDeckImage();
        String deck_name = insertDm.getDeckName();
        int cards_in_deck = insertDm.getCardsQuantity();

        iv_deck_image.setTag(insertDm);
        tv_deck_name.setTag(insertDm);
        tv_deck_card_qnt.setTag(insertDm + " " + getContext().getResources().getString(R.string.cards_num));

        iv_deck_image.setImageBitmap(bitmap);
        tv_deck_name.setText(deck_name);
        String quantity = String.valueOf(cards_in_deck);
        tv_deck_card_qnt.setText(quantity);

        return convertView;
    }

    @Override
    public void onClick(View v) {

    }


    public static class MyDeskViewHolder {

        public ImageView bitmap;
        public TextView descName;
        public TextView cardsQuantity;

//        public Button desk_delete;
//        public Button desk_edit;
//        public Button desk_enter;

        public MyDeskViewHolder(ImageView _bitmap, TextView _descName, TextView _cardsQuantity){
//                                ,Button _deskDelete, Button _deskEdit, Button _deskEnter) {
            this.bitmap = _bitmap;
            this.descName = _descName;
            this.cardsQuantity = _cardsQuantity;
//            this.desk_delete = _deskDelete;
//            this.desk_edit = _deskEdit;
//            this.desk_enter = _deskEnter;
        }

        public ImageView getDeskBitmap() {
            return bitmap;
        }

        public TextView getDeskName() {
            return descName;
        }

        public TextView getCardsQuantity() {
            return cardsQuantity;
        }
    }

}
