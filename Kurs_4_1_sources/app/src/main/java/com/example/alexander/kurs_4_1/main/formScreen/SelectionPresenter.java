package com.example.alexander.kurs_4_1.main.formScreen;

import com.example.alexander.kurs_4_1.common.CallbackApi;
import com.example.alexander.kurs_4_1.domain.form.GetSelectionInteractor;
import com.example.alexander.kurs_4_1.domain.form.Selection;
import com.example.alexander.kurs_4_1.domain.form.SelectionBean;
import com.example.alexander.kurs_4_1.main.MainActivity;
import com.example.alexander.kurs_4_1.main.common.BaseMainPresenter;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Alexander on 17.11.2016.
 */
public class SelectionPresenter extends BaseMainPresenter {

    private final GetSelectionInteractor getSelectionInteractor;

    private ArrayList<Selection> mSelections;

    private Selection mSelected;

    private String mLevelSelected;
    private String mSpecialitySelected;
    private String mFormSelected;
    private String mTypeSelected;

    @Inject
    public SelectionPresenter(GetSelectionInteractor getSelectionInteractor) {
        this.getSelectionInteractor = getSelectionInteractor;
    }

    @Override
    public void onStart() {
        getSelectionInteractor.getSelections(new CallbackApi<SelectionBean>() {
            @Override
            public void onComplete(SelectionBean selections) {
                mSelections = selections;
            }

            @Override
            public void onError(String error) {
                ((SelectionScreenFragment)getView()).showToast(error);
            }
        });
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    public void selectLevelClick() {
        /*onStart();
        return;*/
        if (mSelections == null) {
            //вывести диалог о повторной загрузрке данных
            return;
        }

        ArrayList<String> levels = new ArrayList<>();

        for (Selection selection : mSelections) {
            boolean isNew = true;

            for (String level : levels) {
                if (selection.getLevel().equals(level)) {
                    isNew = false;
                    break;
                }
            }

            if (isNew) {
                levels.add(selection.getLevel());
            }
        }

        ((FormScreenView) getView()).showLevelEducationDialog(levels.toArray(new String[levels.size()]));
    }

    public void selectSpecialityClick(){
        if (mSelections == null) {
            //вывести диалог о повторной загрузке данных
            return;
        }

        ArrayList<String> specialities = new ArrayList<>();

        for (Selection selection : mSelections) {

            if (selection.getLevel().equals(getmLevelSelected())) {
                boolean isNew = true;

                for (String speciality : specialities) {
                    if (selection.getProgram().equals(speciality)) {
                        isNew = false;
                        break;
                    }
                }

                if (isNew) {
                    specialities.add(selection.getProgram());
                }
            }

        }

        ((FormScreenView) getView()).showSpecialitiesDialog(specialities.toArray(new String[specialities.size()]));
    }

    public void selectFormClick(){
        if (mSelections == null) {
            //вывести диалог о повторной загрузке данных
            return;
        }

        ArrayList<String> forms = new ArrayList<>();

        for (Selection selection : mSelections) {

            if (selection.getProgram().equals(getmSpecialitySelected())
                    && selection.getLevel().equals(getmLevelSelected())) {
                boolean isNew = true;

                for (String form : forms) {
                    if (selection.getForm().equals(form)) {
                        isNew = false;
                        break;
                    }
                }

                if (isNew) {
                    forms.add(selection.getForm());
                }
            }

        }

        ((FormScreenView) getView()).showFormDialog(forms.toArray(new String[forms.size()]));
    }

    public void selectTypeClick(){
        if (mSelections == null) {
            //вывести диалог о повторной загрузке данных
            return;
        }

        ArrayList<String> types = new ArrayList<>();

        for (Selection selection : mSelections) {

            if (selection.getProgram().equals(getmSpecialitySelected())
                    && selection.getLevel().equals(getmLevelSelected())
                    && selection.getForm().equals(getmFormSelected())) {
                boolean isNew = true;

                for (String type : types) {
                    if (selection.getType().equals(type)) {
                        isNew = false;
                        break;
                    }
                }

                if (isNew) {
                    types.add(selection.getType());
                }
            }

        }

        ((FormScreenView) getView()).showTypeDialog(types.toArray(new String[types.size()]));
    }

    public void OnLevelSelect(String level) {
        setmLevelSelected(level);
    }
    public void OnSpecialitySelect(String speciality) {
        setmSpecialitySelected(speciality);
    }
    public void OnFormSelect(String form) {
        setmFormSelected(form);
    }
    public void OnTypeSelect(String type) {
        setmTypeSelected(type);
        for (Selection selection : mSelections) {
            if (selection.getProgram().equals(getmSpecialitySelected())
                    && selection.getLevel().equals(getmLevelSelected())
                    && selection.getForm().equals(getmFormSelected())
                    && selection.getType().equals(getmTypeSelected())) {
                mSelected = selection;
            }
        }
    }

    public void onSearchClick() {
        ((MainActivity) getRouter()).tableScreen(getmLevelSelected(), getmSpecialitySelected(), getmFormSelected(), getmTypeSelected());
    }

    public String getmLevelSelected() {
        return mLevelSelected;
    }

    public void setmLevelSelected(String mLevelSelected) {
        this.mLevelSelected = mLevelSelected;
    }

    public String getmSpecialitySelected() {
        return mSpecialitySelected;
    }

    public void setmSpecialitySelected(String mSpecialitySelected) {
        this.mSpecialitySelected = mSpecialitySelected;
    }

    public String getmFormSelected() {
        return mFormSelected;
    }

    public void setmFormSelected(String mFormSelected) {
        this.mFormSelected = mFormSelected;
    }

    public String getmTypeSelected() {
        return mTypeSelected;
    }

    public void setmTypeSelected(String mTypeSelected) {
        this.mTypeSelected = mTypeSelected;
    }
}
