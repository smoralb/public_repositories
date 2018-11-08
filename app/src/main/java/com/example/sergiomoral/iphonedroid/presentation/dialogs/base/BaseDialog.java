package com.example.sergiomoral.iphonedroid.presentation.dialogs.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergiomoral.iphonedroid.iphoneDroidApp;
import com.example.sergiomoral.iphonedroid.presentation.di.component.AppComponent;
import com.example.sergiomoral.iphonedroid.presentation.di.modules.ActivityModule;

import butterknife.ButterKnife;
import fr.tvbarthel.lib.blurdialogfragment.BlurDialogFragment;

public abstract class BaseDialog extends BlurDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        if (getLayoutId() != 0) {
            view = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, view);
        }

        initUI();
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initUI();

    protected AppComponent getAppComponent() {
        return ((iphoneDroidApp) getActivity().getApplication()).getAppComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(getActivity());
    }
}
