package com.example.alexander.kurs_4_1.main.tableScreen;

import com.example.alexander.kurs_4_1.common.CallbackApi;
import com.example.alexander.kurs_4_1.domain.table.GetTableInteractor;
import com.example.alexander.kurs_4_1.domain.table.UserBean;
import com.example.alexander.kurs_4_1.main.common.BaseMainPresenter;

import javax.inject.Inject;

/**
 * Created by Alexander on 18.01.2017.
 */
public class TablePresenter extends BaseMainPresenter {
    private final GetTableInteractor getTableInteractor;

    @Inject
    public TablePresenter(GetTableInteractor getTableInteractor) {
        this.getTableInteractor = getTableInteractor;
    }

    @Override
    public void onStart() {

    }

    public void getTable(String level, String program, String form, String type) {
        getTableInteractor.getTable(new CallbackApi<UserBean>() {
            @Override
            public void onComplete(UserBean users) {
                if(users != null) {
                    prepareUsers(users);
                    ((TableScreenView) getView()).showTable(users);
                }
            }

            @Override
            public void onError(String error) {
                ((TableScreenFragment) getView()).showToast(error);
            }
        }, level, program, form, type);
    }

    private void prepareUsers(UserBean users) {
        for (int i = 0; i < users.size(); i++) {
            users.get(i).setId(i+1l);
        }
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }
}
