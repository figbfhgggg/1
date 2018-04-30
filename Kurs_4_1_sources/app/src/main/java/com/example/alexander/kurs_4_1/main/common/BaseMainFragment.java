package com.example.alexander.kurs_4_1.main.common;

import android.os.Bundle;

import com.example.alexander.kurs_4_1.main.MainActivity;
import com.example.alexander.kurs_4_1.common.BaseFragment;
import com.example.alexander.kurs_4_1.injection.MainActivityComponent;

/**
 * Created by Alexander on 16.11.2016.
 */

public abstract class BaseMainFragment extends BaseFragment implements BaseMainView {

    public abstract String getTitle();

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainActivity mainActivity = (MainActivity) getActivity();
        getPresenter().setRouter(mainActivity);
        mainActivity.resolveToolbar(this);

    }

    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().setRouter(null);
    }

    protected MainActivityComponent getMainActivityComponent() {
        return ((MainActivity) getActivity()).getMainActivityComponent();
    }

}
