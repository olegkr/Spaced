package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import models.DeckModel;
import models.DecksManager;
import spaced.com.spaced.R;

/**
 * Created by Ilya on 6/3/2016.
 */
public class PopularDecksViewAdapter extends RecyclerView.Adapter<PopularDecksViewAdapter.CustomViewHolder> {
    private Context context;
    private ArrayList<DeckModel> data;

    public PopularDecksViewAdapter(Context context) {
        this.context = context;
        data = DecksManager.getInstance().getRemoteDecks();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitleLabel;
        public TextView mCountLabel;

        public CustomViewHolder(View v) {
            super(v);
            mTitleLabel = (TextView)v.findViewById(R.id.tVw_deck_name);
            mCountLabel = (TextView)v.findViewById(R.id.tVw_deck_card_quantity);
        }

        public void bindItem(DeckModel item) {
            mTitleLabel.setText(item.getDeckName());
            mCountLabel.setText(String.valueOf(item.getCardsQuantity()) + " " + context.getResources().getString(R.string.cards_num));
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_deck_item_layout, null, false);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(this, CardsListActivity.class);
////                intent.putExtra(EXTRA_MESSAGE, message);
////                startActivity(intent);
//            }
//        });
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
