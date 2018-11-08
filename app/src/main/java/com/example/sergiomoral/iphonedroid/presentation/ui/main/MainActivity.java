package com.example.sergiomoral.iphonedroid.presentation.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.sergiomoral.iphonedroid.R;
import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;
import com.example.sergiomoral.iphonedroid.presentation.base.BaseActivity;
import com.example.sergiomoral.iphonedroid.presentation.di.component.DaggerActivitycomponent;
import com.example.sergiomoral.iphonedroid.presentation.presenter.main.MainPresenter;
import com.example.sergiomoral.iphonedroid.presentation.ui.details.DetailsActivity;
import com.example.sergiomoral.iphonedroid.presentation.ui.main.adapter.PublicrepositoriesAdapter;
import com.example.sergiomoral.iphonedroid.utils.Constants;
import com.example.sergiomoral.iphonedroid.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainView, PublicrepositoriesAdapter.OnItemListener {

    private static final String TAG = "MainActivity";

    @BindView(R.id.iv_search)
    ImageView mSearch;
    @BindView(R.id.bg_empty)
    ConstraintLayout mEmptyBackGround;
    @BindView(R.id.tb_filter)
    LinearLayout mFilterToolbar;
    @BindView(R.id.iv_back)
    ImageView mButtonBack;
    @BindView(R.id.rv_repositories_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.et_filter)
    EditText mFilter;
    @BindView(R.id.pb_more)
    ProgressBar mLoading;

    @Inject
    MainPresenter mPresenter;

    private static ArrayList<PublicRepositories> publicRepositoriesArrayList;
    int layout;
    private int viewVisibility = 0;
    private PublicrepositoriesAdapter adapter;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initParams();

        if (getRepositoriesIntent() != null) {
            publicRepositoriesArrayList.addAll(getRepositoriesIntent());
            if (publicRepositoriesArrayList.size() == 0) {
                mPresenter.viewVisibility(mEmptyBackGround.getVisibility());
                mEmptyBackGround.setVisibility(viewVisibility);
            }
        }


    }

    private void initListener() {
        mPresenter.keyBoardListener(mFilter);
        mPresenter.recyclerViewListener(mRecyclerView, publicRepositoriesArrayList);
    }

    private void initFilter() {
        mPresenter.filterData(mFilter);
    }

    private void initParams() {
        publicRepositoriesArrayList = new ArrayList<>();
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mButtonBack.setVisibility(View.GONE);
    }


    @OnClick(R.id.iv_search)
    public void showSearcherToolbar() {
        mPresenter.viewVisibility(mFilterToolbar.getVisibility());
        mFilterToolbar.setVisibility(viewVisibility);
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
        initData();
        initFilter();
        initListener();
    }

    private void initData() {
        adapter = new PublicrepositoriesAdapter(publicRepositoriesArrayList, MainActivity.this, this);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    public static void open(@NonNull Activity context, ArrayList<PublicRepositories> publicRepositoriesList) {
        Intent intent = new Intent(context, MainActivity.class);
        publicRepositoriesArrayList = new ArrayList<>();
        publicRepositoriesArrayList.addAll(publicRepositoriesList);
        intent.putParcelableArrayListExtra(Constants.PUBLIC_REPOSITORIES, publicRepositoriesArrayList);
        context.startActivity(intent);
    }

    private List<PublicRepositories> getRepositoriesIntent() {
        return getIntent().getParcelableArrayListExtra(Constants.PUBLIC_REPOSITORIES);
    }


    @Override
    public void setLayout(int emptyLayout) {
        layout = emptyLayout;
    }

    @Override
    public void setVisibility(int drawerVisibility) {
        viewVisibility = drawerVisibility;
    }

    @Override
    public void filterList(String data) {
        mPresenter.filterText(publicRepositoriesArrayList, data);
    }

    @Override
    public void updataData(ArrayList<PublicRepositories> publicList) {
        if (publicList.size() == 0) {
            mEmptyBackGround.setVisibility(View.VISIBLE);
        } else {
            mEmptyBackGround.setVisibility(View.GONE);
        }
        adapter.filterList(publicList);
    }

    @Override
    public void hideKeyboard() {
        Utils.closeKeyboard(this);
    }

    @Override
    public void loadingView() {
        if (publicRepositoriesArrayList.size() > 0) {
            mPresenter.viewVisibility(mLoading.getVisibility());
            mLoading.setVisibility(viewVisibility);
        }
    }

    @Override
    public void setMoreUsers(ArrayList<PublicRepositories> publicRepositories) {
        publicRepositoriesArrayList.clear();
        publicRepositoriesArrayList.addAll(publicRepositories);
        adapter = new PublicrepositoriesAdapter(publicRepositoriesArrayList, this, this);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDetails(PublicRepositories publicRepository) {
        DetailsActivity.open(MainActivity.this, publicRepository);
    }
}
