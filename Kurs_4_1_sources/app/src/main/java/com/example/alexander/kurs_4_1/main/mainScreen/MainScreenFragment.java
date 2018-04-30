package com.example.alexander.kurs_4_1.main.mainScreen;

import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.alexander.kurs_4_1.R;
import com.example.alexander.kurs_4_1.common.BasePresenter;
import com.example.alexander.kurs_4_1.common.Layout;
import com.example.alexander.kurs_4_1.main.common.BaseMainFragment;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Alexander on 17.11.2016.
 */

@Layout(id = R.layout.main_screen)
public class MainScreenFragment extends BaseMainFragment implements MainScreenView {
    @Inject
    public MainScreenPresenter mainScreenPresenter;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.pager)
    ViewPager viewPager;


    @Override
    public String getTitle() {
        return "Рейтинг абитуриентов ВолГУ 2017";
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @NonNull
    @Override
    public BasePresenter getPresenter() {
        return mainScreenPresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }

    @Override
    public void onCreate() {
        tabLayout.addTab(tabLayout.newTab().setText("Рейтинг"));
        tabLayout.addTab(tabLayout.newTab().setText("Запись"));
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void showError(String message) {

    }

}
