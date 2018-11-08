package com.example.sergiomoral.iphonedroid.presentation.dialogs;

import android.graphics.drawable.Drawable;
import com.example.sergiomoral.iphonedroid.R;
import com.example.sergiomoral.iphonedroid.presentation.dialogs.base.BaseDialog;

import javax.inject.Inject;
import butterknife.BindDrawable;

public class LoadingDialog extends BaseDialog {

    @BindDrawable(android.R.color.transparent)
    Drawable mTransparent;

    @Inject
    public LoadingDialog() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_loading;
    }

    @Override
    public void initUI() {

    }
}

