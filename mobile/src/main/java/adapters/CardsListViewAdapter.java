package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import models.CardModel;
import models.DeckModel;
import models.DecksManager;
import spaced.com.spaced.R;

/**
 * Created by Ilya on 6/3/2016.
 */
public class CardsListViewAdapter extends RecyclerView.Adapter<CardsListViewAdapter.CustomViewHolder> {
    private Context context;
    private ArrayList<CardModel> data;
    private DeckModel mDeck;

    public CardsListViewAdapter(Context context, int deckID) {
        this.context = context;
        ArrayList<DeckModel> decks = DecksManager.getInstance().getLocalDecks();
        for (DeckModel deck : decks) {
            if (deck.getDeckID() == deckID) {
                mDeck = deck;
                data = deck.getmCards();
                break;
            }
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView mQuestionTextView;

        public CustomViewHolder(View v) {
            super(v);
            mQuestionTextView = (TextView)v.findViewById(R.id.questionTextView);
        }

        public void bindItem(CardModel item) {
            mQuestionTextView.setText(item.getCardQuestion());
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout, null, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.bindItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
