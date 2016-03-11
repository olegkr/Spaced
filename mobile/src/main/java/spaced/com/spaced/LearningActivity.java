package spaced.com.spaced;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import models.CardModel;
import models.DeckModel;
import models.DecksManager;

/**
 * Created by Ilya on 10/3/2016.
 */
public class LearningActivity extends AppCompatActivity {

    TextView questionTextView;
    TextView answerTextView;
    ImageView image1;
    ImageView image2;
    TextView skipButton;
    TextView previousButton;
    TextView answerButton;
    View navigationView;
    View validationButtonsView;

    public final static String DECK_ID = "deckId";
    private DeckModel mDeck;
    private CardModel mCurrentCard;
    private int cardIndex = 0;

    private void setAppTitle(){
        this.setTitle(mDeck.getDeckName() + " ("+ (cardIndex + 1) + "/" + mDeck.getCardsQuantity() + ")");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_with_question_activity);

        Intent intent = getIntent();
        mDeck = DecksManager.getInstance().getLocalDeckById((int) intent.getExtras().get(DECK_ID));
        mCurrentCard = mDeck.getmCards().get(cardIndex);
        questionTextView = (TextView) findViewById(R.id.questionText);
        answerTextView = (TextView) findViewById(R.id.answerTextView);
        image1 = (ImageView)findViewById(R.id.cardImage);
        image2 = (ImageView)findViewById(R.id.vintik);
        navigationView = findViewById(R.id.navigationLayout);
        answerButton = (TextView) findViewById(R.id.showAnswerButton);
        validationButtonsView = findViewById(R.id.validationButtons);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/UbuntuCondensedRegular.ttf");
        skipButton = (TextView)findViewById(R.id.skipButton);
        previousButton = (TextView)findViewById(R.id.previousButton);
        questionTextView.setTypeface(font);
        answerButton.setTypeface(font);
        answerTextView.setTypeface(font);
        skipButton.setTypeface(font);
        previousButton.setTypeface(font);

        questionTextView.setText(mCurrentCard.getCardQuestion());

        ImageView shesteryonok = (ImageView) findViewById(R.id.vintik);
        Animation rotation = new RotateAnimation(0f, 359, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotation.setDuration(5000);
        rotation.setInterpolator(new LinearInterpolator());
        rotation.setRepeatCount(Animation.INFINITE);
        shesteryonok.startAnimation(rotation);

        setAppTitle();

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextCard();
            }
        });
        findViewById(R.id.buttonCorrect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextCard();
            }
        });
        findViewById(R.id.buttonWrong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextCard();
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardIndex > 0) {
                    mCurrentCard = mDeck.getmCards().get(--cardIndex);
                    questionTextView.setText(mCurrentCard.getCardQuestion());
                    navigationView.setVisibility(View.VISIBLE);
                    validationButtonsView.setVisibility(View.GONE);
                    setAppTitle();
                }
            }
        });

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View imageContainer = findViewById(R.id.imageLayoutView);
                Animation animation = new ScaleAnimation(1.0f, 0f, 1.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(500);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        navigationView.setVisibility(View.GONE);
                        validationButtonsView.setVisibility(View.VISIBLE);
                        image1.setVisibility(View.GONE);
                        image2.setVisibility(View.GONE);
                        answerTextView.setText(mCurrentCard.getCardAnswer());
                        answerTextView.setVisibility(View.VISIBLE);
                        Animation animationGrow = new ScaleAnimation(0f, 1f, 1.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                        animationGrow.setDuration(500);
                        imageContainer.startAnimation(animationGrow);
                    }
                });
                imageContainer.startAnimation(animation);
            }
        });
    }

    private void nextCard(){
        if (mDeck.getmCards().size() > cardIndex + 1) {
            mCurrentCard = mDeck.getmCards().get(++cardIndex);
            questionTextView.setText(mCurrentCard.getCardQuestion());

            setAppTitle();
            if(navigationView.getVisibility() == View.GONE) {
                showQuestion();
            }

            navigationView.setVisibility(View.VISIBLE);
            validationButtonsView.setVisibility(View.GONE);
        } else {
            Intent intent = new Intent(this, CongratsActivity.class);
            startActivity(intent);
        }
    }

    private void showQuestion(){
        questionTextView.setText(mCurrentCard.getCardQuestion());
        final View imageContainer = findViewById(R.id.imageLayoutView);
        Animation animation = new ScaleAnimation(1.0f, 0f, 1.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(500);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                image1.setVisibility(View.VISIBLE);
                image2.setVisibility(View.VISIBLE);
                answerTextView.setVisibility(View.GONE);
                Animation animationGrow = new ScaleAnimation(0f, 1f, 1.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animationGrow.setDuration(500);
                imageContainer.startAnimation(animationGrow);
            }
        });
        imageContainer.startAnimation(animation);
    }
}
