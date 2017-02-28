package com.example.searchgoogle.ui.search;


import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
import com.example.searchgoogle.util.Network;

import java.util.List;

public class SearchFragment extends BaseFragment implements SearchContract.View {

    private SearchContract.Presenter presenter;

    private RecyclerView recyclerView;

    private SearchRvAdapter searchRvAdapter;
    private LinearLayoutManager  layoutManager;

    public SearchFragment() {
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
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_search);
        presenter = new SearchPresenter(this);
        initAdapter();

        presenter.setOnScrollListener(recyclerView,layoutManager);



        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void addModel(List<ImageModel> list) {
        for (ImageModel imageModel : list) {
            if (imageModel.getPagemap()!= null) {
                searchRvAdapter.add(imageModel);
            }
        }
        searchRvAdapter.notifyDataSetChanged();
    }

    @Override
    public void clearList() {
        searchRvAdapter.clear();
    }

    private void initAdapter() {
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        searchRvAdapter = new SearchRvAdapter(presenter);
        recyclerView.setAdapter(searchRvAdapter);
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

    @Override
    public boolean isOnline() {
        if (!Network.isOnline(getActivity())){
            Network.showErrorConnectDialog(getActivity());
            return false;
        }

        return true;
    }

    @Override
    public void gotToFullScreenImage(String url) {
       fullScreenImage(url);
    }



}
