package com.example.searchgoogle.ui.favourite;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.searchgoogle.R;
import com.example.searchgoogle.ui.BaseFragment;

public class FavouriteFragment extends BaseFragment implements FavouriteContract.View {
    private FavouriteContract.Presenter presenter;
    private RecyclerView recyclerView;
    private FavouriteRvAdapter favouriteRvAdapter;
    private LinearLayoutManager layoutManager;

    public FavouriteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_fav);

        presenter = new FavouritePresenter(this);

        initAdapter();


        return view;
    }



    private void initAdapter() {
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        favouriteRvAdapter = new FavouriteRvAdapter(presenter,presenter.getAllData());
        recyclerView.setAdapter(favouriteRvAdapter);
        favouriteRvAdapter.notifyDataSetChanged();
    }

    @Override
    public void gotToFullScreenImage(String url) {
        fullScreenImage(url);
    }

    @Override
    public void notifyData() {
        favouriteRvAdapter.notifyDataSetChanged();
    }
}
