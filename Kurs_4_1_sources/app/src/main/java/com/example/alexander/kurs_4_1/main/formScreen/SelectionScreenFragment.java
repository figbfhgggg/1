package com.example.alexander.kurs_4_1.main.formScreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexander.kurs_4_1.R;
import com.example.alexander.kurs_4_1.common.BasePresenter;
import com.example.alexander.kurs_4_1.common.Layout;
import com.example.alexander.kurs_4_1.main.common.BaseMainFragment;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Alexander on 17.11.2016.
 */

@Layout(id = R.layout.fragment_selection_screen)
public class SelectionScreenFragment extends BaseMainFragment implements FormScreenView {

    @BindView(R.id.text_title)
    TextView mTextTitle;
    @BindView(R.id.level_button)
    Button mLevelButton;
    @BindView(R.id.speciality_button)
    Button mSpecialityButton;
    @BindView(R.id.form_button)
    Button mFormButton;
    @BindView(R.id.type_button)
    Button mTypeButton;
    @BindView(R.id.search_button)
    Button mSearchButton;

    @Inject
    public SelectionPresenter selectionPresenter;


    @Override
    public String getTitle() {
        return "Рейтинг абитуриентов ВолГУ 2016";
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
        return selectionPresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }

    @Override
    public void onCreate() {
        mLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectionPresenter.selectLevelClick();
            }
        });

        mSpecialityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectionPresenter.selectSpecialityClick();
            }
        });

        mFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectionPresenter.selectFormClick();
            }
        });

        mTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectionPresenter.selectTypeClick();
            }
        });

        mSpecialityButton.setEnabled(false);
        mSpecialityButton.setText("Выберите тип направления подготовки");
        mFormButton.setEnabled(false);
        mFormButton.setText("Выберите форму обучения");
        mTypeButton.setEnabled(false);
        mTypeButton.setText("Выберите тип приема");

        if(getArguments() != null && getArguments().getBoolean("searchButton", false)){
            mSearchButton.setVisibility(View.GONE);
            mTextTitle.setText("Запись на подачу документов в ВолГУ 2016");

        } else {
            mSearchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectionPresenter.onSearchClick();
                }
            });

            mSearchButton.setEnabled(false);
            mSearchButton.setAlpha(0.5f);
        }
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showToast(String username) {
        Toast.makeText(getActivity(), username, Toast.LENGTH_SHORT).show();
    }

    private void showDialog(String[] items, String title, DialogInterface.OnClickListener clickListener,
                            SelectionAdapter.Listener listener){
        SelectionAdapter myAdapter = new SelectionAdapter(getActivity(), items);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title)
                .setCancelable(false)
                .setPositiveButton("ОК", clickListener)
                .setNegativeButton("ОТМЕНА", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.list_for_dialog, null);
        builder.setView(dialogView);

        RecyclerView myRecycler = (RecyclerView) dialogView.findViewById(R.id.recycler_view);
        myRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        myRecycler.setItemAnimator(new DefaultItemAnimator());
        myRecycler.setAdapter(myAdapter);
        myAdapter.setListener(listener);

        builder.create().show();
    }

    @Override
    public void showLevelEducationDialog(String[] levels) {
        showDialog(levels, "Уровень образования", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if(selectionPresenter.getmLevelSelected() != null){
                    mLevelButton.setText(selectionPresenter.getmLevelSelected());
                }

                mSpecialityButton.setEnabled(true);
                mSpecialityButton.setText("Выберите тип направления подготовки");
                mFormButton.setEnabled(false);
                mFormButton.setText("Выберите форму обучения");
                mTypeButton.setEnabled(false);
                mTypeButton.setText("Выберите тип приема");
                mSearchButton.setEnabled(false);
                mSearchButton.setAlpha(0.5f);
                dialog.cancel();
            }
        }, new SelectionAdapter.Listener() {
            @Override
            public void onClick(String level) {
                selectionPresenter.OnLevelSelect(level);
            }
        });
    }

    @Override
    public void showSpecialitiesDialog(String[] specialities) {
        showDialog(specialities, "Специальность/направление подготовки", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if(selectionPresenter.getmSpecialitySelected() != null){
                    mSpecialityButton.setText(selectionPresenter.getmSpecialitySelected());
                }
                mSpecialityButton.setEnabled(true);
                mFormButton.setEnabled(true);
                mFormButton.setText("Выберите форму обучения");
                mTypeButton.setEnabled(false);
                mTypeButton.setText("Выберите тип приема");
                mSearchButton.setEnabled(false);
                mSearchButton.setAlpha(0.5f);
                dialog.cancel();
            }
        }, new SelectionAdapter.Listener() {
            @Override
            public void onClick(String speciality) {
                selectionPresenter.OnSpecialitySelect(speciality);
            }
        });
    }

    @Override
    public void showFormDialog(String[] forms) {
        showDialog(forms, "Форма обучения", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if(selectionPresenter.getmFormSelected() != null){
                    mFormButton.setText(selectionPresenter.getmFormSelected());
                }
                mSpecialityButton.setEnabled(true);
                mFormButton.setEnabled(true);
                mTypeButton.setEnabled(true);
                mTypeButton.setText("Выберите тип приема");
                mSearchButton.setEnabled(false);
                mSearchButton.setAlpha(0.5f);
                dialog.cancel();
            }
        }, new SelectionAdapter.Listener() {
            @Override
            public void onClick(String form) {
                selectionPresenter.OnFormSelect(form);
            }
        });
    }

    @Override
    public void showTypeDialog(String[] types) {
        showDialog(types, "Тип приема", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if(selectionPresenter.getmTypeSelected() != null){
                    mTypeButton.setText(selectionPresenter.getmTypeSelected());
                }

                dialog.cancel();
            }
        }, new SelectionAdapter.Listener() {
            @Override
            public void onClick(String type) {
                selectionPresenter.OnTypeSelect(type);
                mSearchButton.setEnabled(true);
                mSearchButton.setAlpha(1.0f);
            }
        });
    }
}
