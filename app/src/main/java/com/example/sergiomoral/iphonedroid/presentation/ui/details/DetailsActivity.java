package com.example.sergiomoral.iphonedroid.presentation.ui.details;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.sergiomoral.iphonedroid.R;
import com.example.sergiomoral.iphonedroid.domain.entities.Contributor;
import com.example.sergiomoral.iphonedroid.domain.entities.Fork;
import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;
import com.example.sergiomoral.iphonedroid.presentation.base.BaseActivity;
import com.example.sergiomoral.iphonedroid.presentation.di.component.DaggerActivitycomponent;
import com.example.sergiomoral.iphonedroid.presentation.dialogs.base.DialogManager;
import com.example.sergiomoral.iphonedroid.presentation.presenter.details.DetailsPresenter;
import com.example.sergiomoral.iphonedroid.presentation.ui.details.adapter.ContributorsAdapter;
import com.example.sergiomoral.iphonedroid.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends BaseActivity implements DetailsView {

    private static final String TAG = "DetailsActivity";

    @BindView(R.id.iv_avatar)
    CircleImageView mProfilePicture;
    @BindView(R.id.tv_owner_name)
    TextView mUserName;
    @BindView(R.id.tv_project_name)
    TextView mProjectName;
    @BindView(R.id.tv_contributors)
    TextView mContributors;
    @BindView(R.id.tv_forks)
    TextView mForks;
    @BindView(R.id.tv_project_description)
    TextView mProjectDescription;
    @BindView(R.id.rv_contributors)
    RecyclerView mRecyclerView;
    @BindView(R.id.iv_back)
    ImageView mButtonBack;
    @BindView(R.id.iv_search)
    ImageView mButtonSearch;
    @BindView(R.id.tv_issues)
    TextView mIssues;


    @Inject
    DetailsPresenter mPresenter;

    @Inject
    DialogManager mDialogManager;

    private PublicRepositories publicRepository;
    private ArrayList<Contributor> contributorsArrayList;
    private ArrayList<Fork> forksArrayList;
    LinearLayoutManager mLayoutManager;
    private ContributorsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initParams();

        if (getRepositoriesIntent() != null) {
            publicRepository = getRepositoriesIntent();
            showLoading();
            mPresenter.getContributors(publicRepository.getOwner().getUserName(), publicRepository.getProjectName());
            mPresenter.getForks(publicRepository.getOwner().getUserName(), publicRepository.getProjectName());
            mPresenter.getIssues(publicRepository.getOwner().getUserName(), publicRepository.getProjectName());
        }

        initLabels();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void attachViewToPresenter() {
        mPresenter.attachView(this);
    }

    @Override
    protected void initInjector() {
        DaggerActivitycomponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build().inject(this);
    }

    @Override
    protected void initUI() {
    }

    @OnClick(R.id.iv_back)
    public void goBack() {
        finish();
    }

    @OnClick(R.id.external_link)
    public void seePublicRepository() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(publicRepository.getProjectUrl())));
    }

    private void initLabels() {

        Glide.with(this)
                .asBitmap()
                .load(publicRepository.getOwner().getProfilePicture())
                .into(mProfilePicture);
        mUserName.setText(publicRepository.getOwner().getUserName());
        mProjectName.setText(publicRepository.getPath());
        mProjectDescription.setText(publicRepository.getDescription());

    }

    private void initParams() {
        forksArrayList = new ArrayList<>();
        contributorsArrayList = new ArrayList<>();
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mButtonSearch.setVisibility(View.GONE);
    }

    @Override
    public void setContributors(List<Contributor> response) {
        contributorsArrayList.clear();
        contributorsArrayList.addAll(response);
        adapter = new ContributorsAdapter(contributorsArrayList, DetailsActivity.this);
        mRecyclerView.setAdapter(adapter);
        mContributors.setText(String.valueOf(contributorsArrayList.size()));
    }

    @Override
    public void setForks(List<Fork> response) {
        forksArrayList.clear();
        forksArrayList.addAll(response);
        mForks.setText(String.valueOf(forksArrayList.size()));
        hideLoading();
    }

    public static void open(Context context, PublicRepositories publicRepository) {
        Log.d(TAG, "open: DetailsActivity");
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(Constants.SELECTED_REPOSITORY, publicRepository);
        context.startActivity(intent);
    }

    private PublicRepositories getRepositoriesIntent() {
        return getIntent().getParcelableExtra(Constants.SELECTED_REPOSITORY);
    }

    @Override
    public void showLoading() {
        mDialogManager.showLoading();
    }

    @Override
    public void hideLoading() {
        mDialogManager.hideLoading();
    }

    @Override
    public void close() {
        finish();
    }

    @Override
    public void setIssues(String issues) {
        mIssues.setText(issues);
        hideLoading();
    }

}
