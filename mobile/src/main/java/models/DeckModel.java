package models;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Oleg on 03.03.2016.
 */
public class DeckModel {

    private int mDeckID;
    private String mDeckName;
    private Bitmap mDeckImage;
    private ArrayList<CardModel> mCards = new ArrayList<>();

    public DeckModel(int deckID, String deckName, Bitmap deckImage) {
        this.mDeckID = deckID;
        this.mDeckName = deckName;
        this.mDeckImage = deckImage;
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