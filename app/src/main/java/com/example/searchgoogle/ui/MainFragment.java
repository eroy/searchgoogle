package com.example.searchgoogle.ui;


import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.searchgoogle.R;
import com.example.searchgoogle.adapter.ViewPagerAdapter;

import static com.example.searchgoogle.R.id.pager;


public class MainFragment extends BaseFragment {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private Toolbar toolbar;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);


        return view;
    }



    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(pager);
        viewPager.setOffscreenPageLimit(0);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar_actionbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        pagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);



    }


}
