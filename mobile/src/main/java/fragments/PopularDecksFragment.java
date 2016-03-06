package fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adapters.PopularDecksViewAdapter;
import spaced.com.spaced.R;
import utils.LogUtil;

/**
 * Created by Oleg on 03.03.2016.
 */

public class PopularDecksFragment extends Fragment {

    private static final int LAYOUT_ID = R.layout.popular_decks_fragment;
    private View rootView;
    FloatingActionButton flBtn;
    RecyclerView itemsRecyclerView;
    PopularDecksViewAdapter popularItemsViewAdapter;

    public PopularDecksFragment() {
        LogUtil.d("");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("");

        popularItemsViewAdapter = new PopularDecksViewAdapter(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        LogUtil.d("");

        View view = inflater.inflate(LAYOUT_ID, container, false);

        itemsRecyclerView = (RecyclerView) view.findViewById(R.id.itemsRecyclerView);
        itemsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        itemsRecyclerView.setAdapter(popularItemsViewAdapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LogUtil.d("");

        rootView = this.getView();
        flBtn = (FloatingActionButton) rootView.findViewById(R.id.fab);
        flBtn.hide();
    }
}

