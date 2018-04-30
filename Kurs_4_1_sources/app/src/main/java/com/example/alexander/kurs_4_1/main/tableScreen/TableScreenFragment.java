package com.example.alexander.kurs_4_1.main.tableScreen;

import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexander.kurs_4_1.R;
import com.example.alexander.kurs_4_1.common.BasePresenter;
import com.example.alexander.kurs_4_1.common.Layout;
import com.example.alexander.kurs_4_1.domain.table.User;
import com.example.alexander.kurs_4_1.domain.table.UserBean;
import com.example.alexander.kurs_4_1.main.common.BaseMainFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Alexander on 17.11.2016.
 */

@Layout(id = R.layout.fragment_table_screen)
public class TableScreenFragment extends BaseMainFragment implements TableScreenView {

    @BindView(R.id.title_table_quota)
    TextView titleTableQuota;

    @BindView(R.id.table_quota)
    TableLayout tableLQuota;

    @BindView(R.id.title_table_no_quota)
    TextView titleTableNoQuota;


    @BindView(R.id.table_no_quota)
    TableLayout tableNoQuota;

    String program = "";
    String type = "";


    @Inject
    public TablePresenter tablePresenter;

    @Override
    public void onStart() {
        super.onStart();
        if (getArguments() != null
                && getArguments().containsKey("program")
                && getArguments().containsKey("level")
                && getArguments().containsKey("form")
                && getArguments().containsKey("type")
                ) {
            tablePresenter.getTable(
                    getArguments().getString("level"),
                    getArguments().getString("program"),
                    getArguments().getString("form"),
                    getArguments().getString("type")
                    );
        }
        if (getArguments() != null && getArguments().containsKey("program")) {
            program = getArguments().getString("program");
        }
        if (getArguments() != null && getArguments().containsKey("type")) {
            type = getArguments().getString("type");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    public String getTitle() {
        return "Рейтинг абитуриентов ВолГУ 2017";
    }

    @NonNull
    @Override
    public BasePresenter getPresenter() {
        return tablePresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void showError(String message) {
    }

    @Override
    public void showTable(UserBean users) {

        ArrayList<User> quotList = new ArrayList<>();
        ArrayList<User> noQuotList = new ArrayList<>();

        for (User user : users) {
            if (user.getIsBenefit() == 0){
                noQuotList.add(user);
            }else {
                quotList.add(user);
            }
        }

        titleTableQuota.setText(program +  " " +"(квота)");
        titleTableNoQuota.setText(program + " " + "("+ type +")");

        fillTables(quotList, tableLQuota);
        fillTables(noQuotList, tableNoQuota);
    }

    public void fillTables(ArrayList<User> users, TableLayout tableLayout) {
        if (users.size() < 1) {
            tableLayout.setVisibility(View.INVISIBLE);
        } else {
            tableLayout.removeAllViews();
            View row = getActivity().getLayoutInflater().inflate(R.layout.table_row, null);
            ((TextView) row.findViewById(R.id.id_position)).setText("#  Позиция\n в\n рейтинге\n");
            ((TextView) row.findViewById(R.id.name)).setText("ФИО\n\n\n");
            ((TextView) row.findViewById(R.id.score_1)).setText("Балл\n 1\n\n");
            ((TextView) row.findViewById(R.id.score_2)).setText("Балл\n 2\n\n");
            ((TextView) row.findViewById(R.id.score_3)).setText("Балл\n 3\n\n");
            ((TextView) row.findViewById(R.id.achievements)).setText("Индвидуальные\n достижения\n\n");
            ((TextView) row.findViewById(R.id.score_total)).setText("Общий\n балл\n\n");
            ((TextView) row.findViewById(R.id.rights)).setText("Преимущественное\n право\n\n");
            ((TextView) row.findViewById(R.id.education_doc)).setText("Документ об\n образовании\n\n");
            ((TextView) row.findViewById(R.id.agree)).setText("Наличие\n согласия\n на\n зачисление");
            ((TextView) row.findViewById(R.id.olympiad)).setText("Без\n вступительных\n испытаний (олимпиадник)\n");
            ((TextView) row.findViewById(R.id.special_rights)).setText("Особые права\n (в пределах\n особой квоты)\n");
            ((TextView) row.findViewById(R.id.order)).setText("Приказ о\n зачислении\n\n");
            tableLayout.addView(row);
            for (User user : users) {
                row = getActivity().getLayoutInflater().inflate(R.layout.table_row, null);
                ((TextView) row.findViewById(R.id.id_position)).setText(String.valueOf(user.getId()));
                ((TextView) row.findViewById(R.id.name)).setText(user.getEnrolleeName());
                ((TextView) row.findViewById(R.id.score_1)).setText(String.valueOf(user.getObject1()));
                ((TextView) row.findViewById(R.id.score_2)).setText(String.valueOf(user.getObject2()));
                ((TextView) row.findViewById(R.id.score_3)).setText(String.valueOf(user.getObject3()));
                ((TextView) row.findViewById(R.id.achievements)).setText(String.valueOf(user.getIndAchivement()));
                ((TextView) row.findViewById(R.id.score_total)).setText(String.valueOf(user.getTotalBalls()));
                ((TextView) row.findViewById(R.id.rights)).setText(user.getIsBenefit().toString());
                ((TextView) row.findViewById(R.id.education_doc)).setText(user.getTypeDocument());
                if (user.getAgreementEnroll() == 0) {
                    ((TextView) row.findViewById(R.id.agree)).setText("Нет");
                } else {
                    ((TextView) row.findViewById(R.id.agree)).setText("Да");
                }
                if (user.getIsOlymp() == 0) {
                    ((TextView) row.findViewById(R.id.olympiad)).setText("Нет");
                } else {
                    ((TextView) row.findViewById(R.id.olympiad)).setText("Да");
                }
                if (user.getIsBenefit() == 0) {
                    ((TextView) row.findViewById(R.id.special_rights)).setText("Нет");
                } else {
                    ((TextView) row.findViewById(R.id.special_rights)).setText("Да");
                }
                ((TextView) row.findViewById(R.id.order)).setText(user.getOrder());

                if(!user.getOrder().isEmpty()){
                    row.setBackgroundColor(getResources().getColor(R.color.colorTableBlue));
                    //row.setAlpha();
                } else if(user.getTypeDocument().equals("Оригинал") && user.getAgreementEnroll() == 1){
                    row.setBackgroundColor(getResources().getColor(R.color.colorTableGreen));
                    //row.setAlpha();
                }
                if(type.equals("договорная основа") && user.getAgreementEnroll() == 1  && user.getOrder().equals("")){
                    row.setBackgroundColor(getResources().getColor(R.color.colorTablePurple));
                    //row.setAlpha();
                }

                tableLayout.addView(row);
            }
        }
    }

    public void showToast(String username) {
        Toast.makeText(getActivity(), username, Toast.LENGTH_SHORT).show();
    }
}
