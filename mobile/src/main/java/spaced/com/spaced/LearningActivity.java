package spaced.com.spaced;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import models.CardModel;
import models.DeckModel;
import models.DecksManager;

/**
 * Created by Ilya on 10/3/2016.
 */
public class LearningActivity extends AppCompatActivity {

    public final static String DECK_ID = "deckId";
    private DeckModel mDeck;
    private CardModel mCurrentCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_with_question_activity);

        Intent intent = getIntent();
        mDeck = DecksManager.getInstance().getLocalDeckById((int)intent.getExtras().get(DECK_ID));
        mCurrentCard = mDeck.getmCards().get(0);

        ((TextView)findViewById(R.id.questionText)).setText(mCurrentCard.getCardQuestion());

    }
}
