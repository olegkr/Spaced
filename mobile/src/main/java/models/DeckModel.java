package models;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Oleg on 03.03.2016.
 */
public class DeckModel {

    private int mDeckID;
    private int mCardID;
    private ImageView mDeckImage;
    private TextView mTvDeckName;
    private TextView mTvCardQuantity;


    public DeckModel(int deckID, int cardID, ImageView image, TextView tvDeckName, TextView tvCardQuantity) {
        this.mDeckID = deckID;
        this.mCardID = cardID;
        this.mDeckImage = image;
        this.mTvDeckName = tvDeckName;
        this.mTvCardQuantity = tvCardQuantity;
    }

    public int getIdDeck() {
        return mDeckID;
    }

    public void setIdDeck(int deckID) {
        this.mDeckID = deckID;
    }

    public int getIdCard() {
        return mCardID;
    }

    public void setIdCard(int cardID) {
        this.mCardID = cardID;
    }

    public ImageView getImage() {
        return mDeckImage;
    }

    public void setImage(ImageView image) {
        this.mDeckImage = image;
    }

    public TextView getTvDesckName() {
        return mTvDeckName;
    }

    public void setTvDesckName(TextView tvDeckName) {
        this.mTvDeckName = tvDeckName;
    }

    public TextView getTvCardQuantity() {
        return mTvCardQuantity;
    }

    public void setTvCardQuantity(TextView tvCardQuantity) {
        this.mTvCardQuantity = tvCardQuantity;
    }

}
