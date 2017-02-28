package com.example.searchgoogle.ui.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.searchgoogle.R;
import com.example.searchgoogle.api.model.ImageModel;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.ArrayList;
import java.util.List;


public class SearchRvAdapter extends RecyclerView.Adapter<SearchRvAdapter.ViewHolder> {
    private List<ImageModel> list;
    private SearchContract.Presenter mPresenter;
    private Context context;

    public SearchRvAdapter(Context context, SearchContract.Presenter mPresenter) {
        this.context = context;
        this.mPresenter = mPresenter;
        list = new ArrayList<>();
    }

    public void add(ImageModel imageModel) {
        list.add(imageModel);
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

        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                .cacheInMemory()
                .cacheOnDisc()
                .build();
        if (list.get(position).getPagemap().getCseImage() != null) {
            imageLoader.displayImage(list.get(position).getPagemap().getCseImage().get(0).getSrc(), holder.mImageView, options);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

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
