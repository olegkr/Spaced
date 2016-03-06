package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapters.MyDecksViewAdapter;
import models.CardModel;
import spaced.com.spaced.NewCardActivity;
import spaced.com.spaced.R;
import utils.LogUtil;

/**
 * Created by Oleg on 03.03.2016.
 */
public class MyDecksFragment extends Fragment {

    private static final int LAYOUT_ID = R.layout.decks_fragment;

    //private MyCardsAdapter mCardsAdapter;
    private ArrayList<CardModel> mCardList = null;
    RecyclerView itemsRecyclerView;
    MyDecksViewAdapter popularItemsViewAdapter;

    private View rootView;
    FloatingActionButton flBtn;


    public MyDecksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("");

        popularItemsViewAdapter = new MyDecksViewAdapter(getContext());
        //mCardsAdapter = new MyCardsAdapter(getActivity(), mCardList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.d("");

        View view = inflater.inflate(LAYOUT_ID, container, false);

        itemsRecyclerView = (RecyclerView) view.findViewById(R.id.itemsRecyclerView);
        itemsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        itemsRecyclerView.setAdapter(popularItemsViewAdapter);

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.d("");

        rootView = this.getView();
        flBtn = (FloatingActionButton) rootView.findViewById(R.id.fab);
        flBtn.show();

        flBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent;
                switch(view.getId()) {
                    case R.id.fab:
                        Intent intent = new Intent(getActivity().getApplicationContext(), NewCardActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

}
