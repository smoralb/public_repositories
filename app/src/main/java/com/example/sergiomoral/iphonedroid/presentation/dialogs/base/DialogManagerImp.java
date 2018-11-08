package com.example.sergiomoral.iphonedroid.presentation.dialogs.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.example.sergiomoral.iphonedroid.R;
import com.example.sergiomoral.iphonedroid.presentation.dialogs.LoadingDialog;
import com.example.sergiomoral.iphonedroid.utils.Constants;

import javax.inject.Inject;

public class DialogManagerImp implements DialogManager {

    private Activity mActivity;
    private static final String TAG = "DialogManagerImp";

    @Inject
    LoadingDialog mLoadingDialog;

    @Inject
    public DialogManagerImp(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void showErrorMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(mActivity).create();
        alertDialog.setTitle(mActivity.getResources().getString(R.string.error_title));
        alertDialog.setMessage(mActivity.getResources().getString(R.string.connection_error));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, mActivity.getResources().getString(R.string.ok),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    @Override
    public void showLoading() {
        if (!mActivity.isFinishing()) {

            mLoadingDialog.show(mActivity.getFragmentManager(), Constants.TAG_LOADING_DIALOG);
        }
    }

    @Override
    public void hideLoading() {
        try {
            mLoadingDialog.dismiss();
        } catch (Exception e) {
            Log.d(TAG, "hideLoading: Cannot close loading");
        }
    }
}
