package spaced.com.spaced;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ilya on 10/3/2016.
 */
public class LearningActivity extends AppCompatActivity {

    public final static String DECK_ID = "deckId";
    private int mDeckId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_with_question_activity);

        Intent intent = getIntent();
        mDeckId = intent.getIntExtra(DECK_ID, 0);

    }
}
