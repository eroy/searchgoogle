package com.example.searchgoogle.ui.search;


import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.searchgoogle.R;
import com.example.searchgoogle.api.model.ImageModel;
import com.example.searchgoogle.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends BaseFragment implements SearchContract.View {

    private SearchContract.Presenter presenter;
    private List<ImageModel> imageModels = new ArrayList<>();
    private RecyclerView recyclerView;

    public SearchFragment() {
    }

    public List<ImageModel> getImageModels() {
        return imageModels;
    }

    @Override
    public void setImageModels(List<ImageModel> imageModels) {
        this.imageModels = imageModels;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        presenter = new SearchPresenter(this);


        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_toolbar, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        if (null != searchManager) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        }
        searchView.setIconifiedByDefault(false);

        presenter.setOnQueryTextListener(searchView);

    }
}
