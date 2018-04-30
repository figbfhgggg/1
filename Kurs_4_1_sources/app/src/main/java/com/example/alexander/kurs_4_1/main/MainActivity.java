package com.example.alexander.kurs_4_1.main;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.alexander.kurs_4_1.R;
import com.example.alexander.kurs_4_1.common.BaseActivity;
import com.example.alexander.kurs_4_1.common.Layout;
import com.example.alexander.kurs_4_1.common.MainRouter;
import com.example.alexander.kurs_4_1.injection.DaggerMainActivityComponent;
import com.example.alexander.kurs_4_1.injection.DataModule;
import com.example.alexander.kurs_4_1.injection.MainActivityComponent;
import com.example.alexander.kurs_4_1.main.common.BaseMainFragment;
import com.example.alexander.kurs_4_1.main.formScreen.SelectionScreenFragment;
import com.example.alexander.kurs_4_1.main.mainScreen.MainScreenFragment;
import com.example.alexander.kurs_4_1.main.tableScreen.TableScreenFragment;

import butterknife.BindView;
import dagger.internal.Preconditions;

@Layout(id = R.layout.activity_main)
public class MainActivity extends BaseActivity implements MainRouter {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private MainActivityComponent mainActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        mainActivityComponent =
                DaggerMainActivityComponent
                        .builder()
                        .dataModule(new DataModule())
                        .build();
        mainScreen();
    }

    public void resolveToolbar(BaseMainFragment fragment) {
        toolbar.setTitle(fragment.getTitle());
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        } else {
            toolbar.setNavigationIcon(null);
            toolbar.setNavigationOnClickListener(null);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            mainScreen();
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void addBackStack(BaseMainFragment fragment) {
        Preconditions.checkNotNull(fragment);
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content, fragment);
        tx.addToBackStack(fragment.getFragmentName());
        tx.commit();
        resolveToolbar(fragment);
    }

    @Override
    public void selectionScreen() {
        addBackStack(new SelectionScreenFragment());
    }

    @Override
    public void tableScreen(String level, String program, String form, String type) {
        BaseMainFragment fragment = new TableScreenFragment();
        Bundle args = new Bundle();
        args.putString("level", level);
        args.putString("program", program);
        args.putString("form", form);
        args.putString("type", type);
        fragment.setArguments(args);
        addBackStack(fragment);
    }

    @Override
    public void mainScreen() {
        addBackStack(new MainScreenFragment());
    }

    public MainActivityComponent getMainActivityComponent() {
        return mainActivityComponent;
    }
}
