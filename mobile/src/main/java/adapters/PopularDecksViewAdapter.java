package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import models.DeckModel;
import models.DecksManager;
import spaced.com.spaced.R;

/**
 * Created by Ilya on 6/3/2016.
 */
public class PopularDecksViewAdapter extends RecyclerView.Adapter<PopularDecksViewAdapter.CustomViewHolder> {
    private static final int LAYOUT = R.layout.popular_deck_item_layout;

    private Context context;
    private ArrayList<DeckModel> data;

    public PopularDecksViewAdapter(Context context) {
        this.context = context;
        data = DecksManager.getInstance().getRemoteDecks();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitleLabel;
        public TextView mCountLabel;

        public ImageView mImVvAdd;

        public CustomViewHolder(final View v) {
            super(v);

            mTitleLabel = (TextView)v.findViewById(R.id.tVw_deck_name);
            mCountLabel = (TextView)v.findViewById(R.id.tVw_deck_card_quantity);
            mImVvAdd = (ImageView)v.findViewById(R.id.imVw_add);
        }

        public void bindItem(DeckModel item) {
            mTitleLabel.setText(item.getDeckName());
            mCountLabel.setText(String.valueOf(item.getCardsQuantity()) + " " + context.getResources().getString(R.string.cards_num));
            mImVvAdd.setImageBitmap(item.getDeckImage());
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(LAYOUT, null, false);

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
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.bindItem(data.get(position));
        holder.mImVvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<DeckModel> remoteDecks = DecksManager.getInstance().getRemoteDecks();
                DeckModel myDeck = data.get(position);
                for (DeckModel remoteDeck :
                        remoteDecks) {
                    if (remoteDeck.getDeckID() == myDeck.getDeckID())
                    {
                        remoteDecks.remove(remoteDeck);
                        data.remove(remoteDeck);
                        DecksManager.getInstance().getLocalDecks().add(remoteDeck);
                        DecksManager.getInstance().notifyListener();
                        notifyDataSetChanged();
                        break;
                    }
                }

//                Bundle bundle = new Bundle();
//                bundle.putInt("deck_id", data.get(position).getCardsQuantity());  LogUtil.d("deck_id: " + 0);
//                bundle.putString("deck_name", data.get(position).getDeckName());  LogUtil.d("mDeckName: ");
//                bundle.putParcelable("deck_image", data.get(position).getDeckImage());  LogUtil.d("deck_image: ");
//                myDeck.newInstance(bundle);

//                Intent intent = new Intent(context, NewDeckActivity.class);
//                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
