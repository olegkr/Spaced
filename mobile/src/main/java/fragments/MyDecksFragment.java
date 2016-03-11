package fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.MyDesksAdapter;
import models.DeckModel;
import models.DecksManager;
import spaced.com.spaced.NewDeckActivity;
import spaced.com.spaced.R;
import utils.LogUtil;

/**
 * Created by Oleg on 03.03.2016.
 */
public class MyDecksFragment extends Fragment implements AbsListView.OnScrollListener{

    private static final int ACTIVITY_ID = R.layout.decks_fragment;

    Context contxt;
    static Activity activity;
    MyDesksAdapter mDecksAdapter;
    static ArrayList<DeckModel> mDeckList;

    private View rootView;
    FloatingActionButton flBtn;

    DeckModel mDeckModel;
    static ListView mListView;

    public MyDecksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("");

//        rootView = this.getView();
//        contxt = rootView.getContext();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.d("");
        rootView = inflater.inflate(ACTIVITY_ID, container, false);
        contxt = rootView.getContext();
        activity = getActivity();
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.d("");

        rootView = this.getView();

        mListView = (ListView) rootView.findViewById(R.id.lstVw_my_desk);
        mListView.setFocusableInTouchMode(true);
        mListView.setOnScrollListener(this);

        mDeckList = DecksManager.getInstance().getLocalDecks();
//        addDeck(mDeckModel);
        LogUtil.d("mDeckList: " + mDeckList);

        mDecksAdapter = new MyDesksAdapter(getActivity(), mDeckList);
        mListView.setAdapter(mDecksAdapter);


        flBtn = (FloatingActionButton) rootView.findViewById(R.id.fab);
        flBtn.show();

        flBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {

                    case R.id.fab:
                        Intent intent = new Intent(getActivity().getApplicationContext(), NewDeckActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    public ArrayList<DeckModel> addDeck(DeckModel dm) {
        ArrayList<DeckModel> localDecks = DecksManager.getInstance().getLocalDecks();
        localDecks.add(dm);
        LogUtil.d("dm: " + dm);

        return localDecks;
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    public MyDecksFragment newInstance(Bundle bundle){
        LogUtil.d("");

        MyDecksFragment fragment = new MyDecksFragment();
        if(bundle != null) {
            int id = bundle.getInt("deck_id");
            LogUtil.d("id: " + id);


            String name = bundle.getString("deck_name");
            LogUtil.d("name: " + name);

            Bitmap image = bundle.getParcelable("deck_image");
            LogUtil.d("image: " + image);

            mDeckModel = new DeckModel(id, name, image, null);

            ArrayList<DeckModel> list = addDeck(mDeckModel);

            if (list != null) {
                mDecksAdapter = new MyDesksAdapter(activity, list);
                mListView.setAdapter(mDecksAdapter);
            } else {
                mDecksAdapter = new MyDesksAdapter(activity, null);
                mListView.setAdapter(mDecksAdapter);
            }

            mListView.setAdapter(mDecksAdapter);
        }
        return fragment;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

}
