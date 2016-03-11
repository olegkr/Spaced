package models;

import android.content.Context;
import android.graphics.Bitmap;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import spaced.com.spaced.MyApp;

/**
 * Created by Oleg on 03.03.2016.
 */
public class DeckModel {
    Bitmap bitmap;
    private int mDeckID;
    private String mDeckName;
    private Bitmap mDeckImage;
    private ArrayList<CardModel> mCards = new ArrayList<>();

    public DeckModel(int deckID, String deckName, final Bitmap deckImage) {
        this.mDeckID = deckID;
        this.mDeckName = deckName;
//        this.mDeckImage = deckImage;
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    Context contx = MyApp.getContext().getApplicationContext();
                    bitmap = Picasso.with(contx).load("http://farm4.static.flickr.com/3114/2524849923_1c191ef42e.jpg").get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        this.mDeckImage = bitmap;
    }

    public int getDeckID() {
        return mDeckID;
    }

    public void setDeckID(int deckID) {
        this.mDeckID = deckID;
    }

    public String getDeckName() {
        return mDeckName;
    }

    public void setDeckName(String deckName) {
        this.mDeckName = deckName;
    }

    public Bitmap getDeckImage() {
        return mDeckImage;
    }

    public void setDeckImage(Bitmap deckImage) {
        this.mDeckImage = deckImage;
    }

    public int getCardsQuantity() {
        return mCards.size();
    }

    public ArrayList<CardModel> getmCards() {
        return mCards;
    }

    public void setCards(ArrayList<CardModel> mCards) {
        this.mCards = mCards;
    }
}