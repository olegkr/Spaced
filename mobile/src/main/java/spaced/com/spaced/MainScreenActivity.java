package spaced.com.spaced;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fragments.MyDecksFragment;
import fragments.PopularDecksFragment;
import utils.Globals;
import utils.LogUtil;


@SuppressWarnings("ALL")
public class MainScreenActivity extends AppCompatActivity {

    private static final int ACTIVITY_ID = R.layout.activity_main_screen;

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private View view;
//    FloatingActionButton mFlBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        LogUtil.d("");

        view = this.findViewById(android.R.id.content);

//        mFlBtn = (FloatingActionButton) view.findViewById(R.id.fab);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        LogUtil.d("");

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

//        mFlBtn.hide();
        adapter.addFragment(new PopularDecksFragment(), Globals.POPULAR_DECKS);
//        mFlBtn.show();
        adapter.addFragment(new MyDecksFragment(), Globals.MY_DECKS);

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

