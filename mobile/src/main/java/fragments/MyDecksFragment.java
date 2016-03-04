package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapters.MyCardsAdapter;
import models.CardModel;
import spaced.com.spaced.NewCardActivity;
import spaced.com.spaced.R;
import utils.LogUtil;

/**
 * Created by Oleg on 03.03.2016.
 */
public class MyDecksFragment extends Fragment {

    private static final int ACTIVITY_ID = R.layout.decks_fragment;

    private MyCardsAdapter mCardsAdapter;
    private ArrayList<CardModel> mCardList = null;

    private View rootView;
    FloatingActionButton flBtn;


    public MyDecksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("");

        mCardsAdapter = new MyCardsAdapter(getActivity(), mCardList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.d("");

        // Inflate the layout for this fragment
        return inflater.inflate(ACTIVITY_ID, container, false);
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
