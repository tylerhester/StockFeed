package com.morrisit.stockfeed;

import java.util.ArrayList;
import java.util.Locale;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.StrictMode;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView textView = (TextView) findViewById(R.id.stock_name);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);

        setContentView(R.layout.fragment_main);


        ImageButton imageButton = (ImageButton) findViewById(R.id.action_refresh);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {

                try {

                    String stock1 = getString(R.string.stock_name_1);
                    String stock2 = getString(R.string.stock_name_2);
                    String stock3 = getString(R.string.stock_name_3);
                    String stock4 = getString(R.string.stock_name_4);
                    String stock5 = getString(R.string.stock_name_5);
                    String stock6 = getString(R.string.stock_name_6);
                    String stock7 = getString(R.string.stock_name_7);
                    String stock8 = getString(R.string.stock_name_8);
                    String stock9 = getString(R.string.stock_name_9);

                    DataParser parser = new DataParser();

                    TextView low1 = (TextView) findViewById(R.id.stock_low_1)  ;
                    TextView high1 = (TextView) findViewById(R.id.stock_high_1);
                    TextView low2 = (TextView) findViewById(R.id.stock_low_2)  ;
                    TextView high2 = (TextView) findViewById(R.id.stock_high_2);
                    TextView low3 = (TextView) findViewById(R.id.stock_low_3)  ;
                    TextView high3 = (TextView) findViewById(R.id.stock_high_3);
                    TextView low4 = (TextView) findViewById(R.id.stock_low_4)  ;
                    TextView high4 = (TextView) findViewById(R.id.stock_high_4);
                    TextView low5 = (TextView) findViewById(R.id.stock_low_5)  ;
                    TextView high5 = (TextView) findViewById(R.id.stock_high_5);
                    TextView low6 = (TextView) findViewById(R.id.stock_low_6)  ;
                    TextView high6 = (TextView) findViewById(R.id.stock_high_6);
                    TextView low7 = (TextView) findViewById(R.id.stock_low_7)  ;
                    TextView high7 = (TextView) findViewById(R.id.stock_high_7);
                    TextView low8 = (TextView) findViewById(R.id.stock_low_8)  ;
                    TextView high8 = (TextView) findViewById(R.id.stock_high_8);
                    TextView low9 = (TextView) findViewById(R.id.stock_low_9)  ;
                    TextView high9 = (TextView) findViewById(R.id.stock_high_9);

                    String sl1 = parser.retrieveLow(stock1);
                    String sl2 = parser.retrieveLow(stock2);
                    String sl3 = parser.retrieveLow(stock3);
                    String sl4 = parser.retrieveLow(stock4);
                    String sl5 = parser.retrieveLow(stock5);
                    String sl6 = parser.retrieveLow(stock6);
                    String sl7 = parser.retrieveLow(stock7);
                    String sl8 = parser.retrieveLow(stock8);
                    String sl9 = parser.retrieveLow(stock9);

                    String sh1 = parser.retrieveHigh(stock1);
                    String sh2 = parser.retrieveHigh(stock2);
                    String sh3 = parser.retrieveHigh(stock3);
                    String sh4 = parser.retrieveHigh(stock4);
                    String sh5 = parser.retrieveHigh(stock5);
                    String sh6 = parser.retrieveHigh(stock6);
                    String sh7 = parser.retrieveHigh(stock7);
                    String sh8 = parser.retrieveHigh(stock8);
                    String sh9 = parser.retrieveHigh(stock9);

                    low1.setText("LOW: $" + sl1);
                    high1.setText("HIGH: $" + sh1);

                    low2.setText("LOW: $" + sl2);
                    high2.setText("HIGH: $" + sh2);

                    low3.setText("LOW: $" + sl3);
                    high3.setText("HIGH: $" + sh3);

                    low4.setText("LOW: $" + sl4);
                    high4.setText("HIGH: $" + sh4);

                    low5.setText("LOW: $" + sl5);
                    high5.setText("HIGH: $" + sh5);

                    low6.setText("LOW: $" + sl6);
                    high6.setText("HIGH: $" + sh6);

                    low7.setText("LOW: $" + sl7);
                    high7.setText("HIGH: $" + sh7);

                    low8.setText("LOW: $" + sl8);
                    high8.setText("HIGH: $" + sh8);

                    low9.setText("LOW: $" + sl9);
                    high9.setText("HIGH: $" + sh9);


                }

                catch (Exception e) {
                    Toast toast = Toast.makeText(MainActivity.this, "" + e.toString(), Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return OptionsFragment.newInstance(position + 1);

                case 1:
                    return FavoritesFragment.newInstance(position + 2);
            }

            return OptionsFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A fragment for the Favorites list.
     */
    public static class FavoritesFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static FavoritesFragment newInstance(int sectionNumber) {
            FavoritesFragment fragment = new FavoritesFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public FavoritesFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class OptionsFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static OptionsFragment newInstance(int sectionNumber) {
            OptionsFragment fragment = new OptionsFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public OptionsFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_options, container, false);
            return rootView;
        }
    }
}