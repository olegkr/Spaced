package fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapters.MyCardsAdapter;
import models.CardModel;
import spaced.com.spaced.NewDeckActivity;
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

        mCardsAdapter = new MyCardsAdapter(getActivity(), mCardList);

        flBtn = (FloatingActionButton) rootView.findViewById(R.id.fab);
        flBtn.show();

        flBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.fab:
                        Intent intent = new Intent(getActivity().getApplicationContext(), NewDeckActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }


    public static MyDecksFragment newInstance(Bundle bundle){
        LogUtil.d("");

        MyDecksFragment fragment = new MyDecksFragment();
        if(bundle != null) {
            int id = bundle.getInt("deck_id");
            LogUtil.d("id: " + id);
            String name = bundle.getString("deck_name");
            LogUtil.d("name: " + name);
            Bitmap image = bundle.getParcelable("deck_image");
            LogUtil.d("image: " + image);
        }
        return fragment;
    }



}
