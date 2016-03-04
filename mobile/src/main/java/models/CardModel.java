package models;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Oleg on 03.03.2016.
 */
public class CardModel {

    private int mCardID;
    private ImageView mCardImage;
    private TextView mCardQuestion;
    private TextView mCardAnswer;

    public CardModel(int cardID, ImageView cardImage, TextView cardQuestion, TextView cardAnswer) {
        this.mCardID = cardID;
        this.mCardImage = cardImage;
        this.mCardQuestion = cardQuestion;
        this.mCardAnswer = cardAnswer;
    }

    public int getCardID() {
        return mCardID;
    }

    public void setCardID(int cardID) {
        this.mCardID = cardID;
    }

    public ImageView getCardImage() {
        return mCardImage;
    }

    public void setCardImage(ImageView cardImage) {
        this.mCardImage = cardImage;
    }

    public TextView getCardQuestion() {
        return mCardQuestion;
    }

    public void setCardQuestion(TextView cardQuestion) {
        this.mCardQuestion = cardQuestion;
    }

    public TextView getCardAnswer() {
        return mCardAnswer;
    }

    public void setCardAnswer(TextView cardAnswer) {
        this.mCardAnswer = cardAnswer;
    }
}
