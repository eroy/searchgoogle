package com.example.searchgoogle.ui.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.searchgoogle.R;
import com.example.searchgoogle.api.model.ImageModel;
import com.example.searchgoogle.model.DataModel;
import com.example.searchgoogle.util.LoadImage;

import java.util.ArrayList;
import java.util.List;


public class SearchRvAdapter extends RecyclerView.Adapter<SearchRvAdapter.ViewHolder> {
    private List<ImageModel> list;
    private SearchContract.Presenter mPresenter;

    public SearchRvAdapter(SearchContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
        list = new ArrayList<>();
    }

    public void add(ImageModel imageModel) {
        list.add(imageModel);
    }

    public void clear() {
        list.clear();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageModel imageModel = list.get(position);

        holder.mName.setText(imageModel.getTitle());

        if (list.get(position).getPagemap().getCseImage() != null) {
            DataModel dataModel = new DataModel(imageModel.getTitle(), imageModel.getPagemap().getCseImage().get(0).getSrc());
            LoadImage.downloadImageToView(list.get(position).getPagemap().getCseImage().get(0).getSrc(), holder.mImageView);
            mPresenter.setOnClickListenerImage(holder.mImageView, list.get(position).getPagemap().getCseImage().get(0).getSrc());
            mPresenter.setOnCheckedChangeListener(holder.mCheckBox, dataModel);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mName;
        CheckBox mCheckBox;


        ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.search_image);
            mName = (TextView) itemView.findViewById(R.id.search_name);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.search_checkbox);


        }


    }
}
