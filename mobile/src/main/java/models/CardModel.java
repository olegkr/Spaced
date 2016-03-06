package models;

/**
 * Created by Oleg on 03.03.2016.
 */
public class CardModel {

    private int mCardID;
    private String mCardQuestion;
    private String mCardAnswer;

    public CardModel(int cardID, String cardQuestion, String cardAnswer) {
        this.mCardID = cardID;
        this.mCardQuestion = cardQuestion;
        this.mCardAnswer = cardAnswer;
    }

    public int getCardID() {
        return mCardID;
    }

    public void setCardID(int cardID) {
        this.mCardID = cardID;
    }

    public String getCardQuestion() {
        return mCardQuestion;
    }

    public void setCardQuestion(String cardQuestion) {
        this.mCardQuestion = cardQuestion;
    }

    public String getCardAnswer() {
        return mCardAnswer;
    }

    public void setCardAnswer(String cardAnswer) {
        this.mCardAnswer = cardAnswer;
    }
}
