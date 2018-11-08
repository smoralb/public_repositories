package com.example.sergiomoral.iphonedroid.presentation.ui.details.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sergiomoral.iphonedroid.R;
import com.example.sergiomoral.iphonedroid.domain.entities.Contributor;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContributorsAdapter extends RecyclerView.Adapter<ContributorsAdapter.ViewHolder> {

    private static final String TAG = "ContributorsAdapter";
    private ArrayList<Contributor> mContributorsArrayList;
    private Context mContext;

    public ContributorsAdapter(ArrayList<Contributor> contributors, Context mContext) {
        this.mContributorsArrayList = contributors;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contributor, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called.");
        if (mContributorsArrayList.get(i) != null) {
            viewHolder.bind(mContributorsArrayList.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return mContributorsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        CircleImageView mUserAvatar;
        TextView mUserName;
        TextView mUserContributions;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mUserAvatar = itemView.findViewById(R.id.iv_item_repo_logo);
            this.mUserName = itemView.findViewById(R.id.tv_item_user_name);
            this.mUserContributions = itemView.findViewById(R.id.tv_contributions);
        }

        public void bind(Contributor contributor) {

            Glide.with(mContext)
                    .asBitmap()
                    .load(contributor.getProfilePicture())
                    .into(mUserAvatar);

            mUserName.setText(contributor.getUserName());
            mUserContributions.setText(String.valueOf(contributor.getContributions()));
        }
    }
}
