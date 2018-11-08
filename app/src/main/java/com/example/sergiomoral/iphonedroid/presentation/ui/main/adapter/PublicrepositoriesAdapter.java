package com.example.sergiomoral.iphonedroid.presentation.ui.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sergiomoral.iphonedroid.R;
import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PublicrepositoriesAdapter extends RecyclerView.Adapter<PublicrepositoriesAdapter.ViewHolder> {

    private static final String TAG = "PublicrepositoriesAdapt";
    private ArrayList<PublicRepositories> publicRepositoriesList;
    private Context mContext;
    private OnItemListener mListener;


    public PublicrepositoriesAdapter(ArrayList<PublicRepositories> publicRepositoriesList, Context mContext, OnItemListener mListener) {
        this.publicRepositoriesList = publicRepositoriesList;
        this.mContext = mContext;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_repository, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called.");
        if (publicRepositoriesList.get(i) != null) {
            viewHolder.bind(publicRepositoriesList.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return publicRepositoriesList.size();
    }

    public void filterList(ArrayList<PublicRepositories> publicList) {
        publicRepositoriesList.clear();
        publicRepositoriesList.addAll(publicList);
        notifyDataSetChanged();
    }


    public interface OnItemListener {

        void showDetails(PublicRepositories randomUser);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView avatar;
        TextView userName;
        TextView repoPath;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.avatar = itemView.findViewById(R.id.iv_item_repo_logo);
            this.userName = itemView.findViewById(R.id.tv_item_user_name);
            this.repoPath = itemView.findViewById(R.id.tv_item_path_name);
            this.parentLayout = itemView.findViewById(R.id.item_parent);
        }

        public void bind(final PublicRepositories publicRepositories) {
            Glide.with(mContext)
                    .asBitmap()
                    .load(publicRepositories.getOwner().getProfilePicture())
                    .into(avatar);

            userName.setText(publicRepositories.getOwner().getUserName());
            repoPath.setText(publicRepositories.getPath());
            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.showDetails(publicRepositoriesList.get(getAdapterPosition()));
                }
            });
        }

    }
}
