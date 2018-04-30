package com.example.alexander.kurs_4_1.main.formScreen;

import com.example.alexander.kurs_4_1.main.common.BaseMainView;

/**
 * Created by Alexander on 29.11.2016.
 */

public interface FormScreenView extends BaseMainView {
    //методы, которые будет реализовывать фрагмент
    void showToast(String username);
    void showLevelEducationDialog(String[] levels);
    void showSpecialitiesDialog(String[] specialities);
    void showFormDialog(String[] forms);
    void showTypeDialog(String[] types);
}
