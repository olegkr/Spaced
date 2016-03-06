package models;

import java.util.ArrayList;

/**
 * Created by Oleg on 03.03.2016.
 */
public class DeckModel {

    private int mDeckID;
    private ArrayList<CardModel> mCards;
    private String mDeckName;
    private boolean isEditable;

    public DeckModel(int deckID, String deckName, boolean isEditable) {
        mCards = new ArrayList<>();
        this.mDeckID = deckID;
        this.isEditable = isEditable;
        this.mDeckName = deckName;
    }

    public int getIdDeck() {
        return mDeckID;
    }

    public ArrayList<CardModel> getCards() {
        return mCards;
    }

    public void setCards(ArrayList<CardModel> cards) {
        this.mCards = cards;
    }

    public void addCard(CardModel card) {
        this.mCards.add(card);
    }

    public int getCardsQuantity() {
        return mCards.size();
    }

    public String getmDeckName() {
        return mDeckName;
    }

    public boolean isEditable() {
        return isEditable;
    }
}
