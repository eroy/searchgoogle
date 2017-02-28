package com.example.searchgoogle.ui.favourite;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.searchgoogle.R;
import com.example.searchgoogle.model.DataModel;
import com.example.searchgoogle.util.LoadImage;

import java.util.List;


public class FavouriteRvAdapter extends RecyclerView.Adapter<FavouriteRvAdapter.ViewHolder>{

    private List<DataModel> list;
    private FavouriteContract.Presenter presenter;

    public FavouriteRvAdapter(FavouriteContract.Presenter presenter,List<DataModel> list) {
        this.presenter = presenter;
        this.list = list;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favourite, parent, false);
        return new FavouriteRvAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataModel dataModel = list.get(position);

        holder.mName.setText(dataModel.getTitle());
        LoadImage.downloadImageToView(dataModel.getUrlImage(),holder.mImageView);
        presenter.rlSetOnClick(holder.relativeLayout,dataModel.getId());
        presenter.ivSetOnClick(holder.mImageView,dataModel.getUrlImage());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mName;
        RelativeLayout relativeLayout;


        ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.fav_image);
            mName = (TextView) itemView.findViewById(R.id.fav_name);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.fav_rl);



        }


    }
}
