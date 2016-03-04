package fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import spaced.com.spaced.R;
import utils.LogUtil;

/**
 * Created by Oleg on 03.03.2016.
 */

public class PopularDecksFragment extends Fragment {

    private static final int ACTIVITY_ID = R.layout.decks_fragment;
    private View rootView;
    FloatingActionButton flBtn;


    public PopularDecksFragment() {
        LogUtil.d("");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
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
        flBtn.hide();
    }
}

