package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import models.DeckModel;
import remoteRepository.RemoteRepositoryMock;
import spaced.com.spaced.R;

/**
 * Created by Ilya on 6/3/2016.
 */
public class PopularDecksViewAdapter extends RecyclerView.Adapter<PopularDecksViewAdapter.CustomViewHolder> {
    private Context context;
    private ArrayList<DeckModel> data;

    public PopularDecksViewAdapter(Context context) {
        this.context = context;
        data = new RemoteRepositoryMock().GetAllDecks();
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
            mTitleLabel.setText(item.getmDeckName());
            mCountLabel.setText(String.valueOf(item.getCardsQuantity()));
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_deck_item_layout, null, false);
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
