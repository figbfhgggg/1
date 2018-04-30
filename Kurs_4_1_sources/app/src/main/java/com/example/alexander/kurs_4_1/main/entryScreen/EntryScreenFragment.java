package com.example.alexander.kurs_4_1.main.entryScreen;

import android.app.AlertDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alexander.kurs_4_1.R;
import com.example.alexander.kurs_4_1.common.BasePresenter;
import com.example.alexander.kurs_4_1.common.Layout;
import com.example.alexander.kurs_4_1.domain.entry.Dates;
import com.example.alexander.kurs_4_1.domain.entry.Entry;
import com.example.alexander.kurs_4_1.main.common.BaseMainFragment;
import com.example.alexander.kurs_4_1.main.formScreen.SelectionPresenter;
import com.example.alexander.kurs_4_1.main.formScreen.SelectionScreenFragment;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import com.wdullaer.materialdatetimepicker.time.Timepoint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;

import static android.content.ContentValues.TAG;

/**
 * Created by Alexander on 17.11.2016.
 */

@Layout(id = R.layout.fragment_entry_screen)
public class EntryScreenFragment extends BaseMainFragment implements EntryScreenView {

    @BindView(R.id.btn_date)
    Button mDateButton;
    @BindView(R.id.input_date)
    EditText mDateInput;

    @BindView(R.id.btn_time)
    Button mTimeButton;
    @BindView(R.id.input_time)
    EditText mTimeInput;

    @BindView(R.id.input_fullName)
    EditText mFullNameInput;

    @BindView(R.id.entry_button)
    Button mEntryButton;

    @Inject
    public EntryPresenter entryPresenter;

    SelectionScreenFragment selectionScreenFragment;

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
        return entryPresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }

    @Override
    public void onCreate() {

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        selectionScreenFragment = new SelectionScreenFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("searchButton", true);
        selectionScreenFragment.setArguments(bundle);
        transaction.replace(R.id.selection_screen_container, selectionScreenFragment);
        transaction.commit();
        mEntryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, ((SelectionPresenter) selectionScreenFragment.getPresenter()).getmSpecialitySelected());
                String level = ((SelectionPresenter) selectionScreenFragment.getPresenter()).getmLevelSelected();
                String spec = ((SelectionPresenter) selectionScreenFragment.getPresenter()).getmSpecialitySelected();
                String form = ((SelectionPresenter) selectionScreenFragment.getPresenter()).getmFormSelected();
                String type = ((SelectionPresenter) selectionScreenFragment.getPresenter()).getmTypeSelected();
                String date = mDateInput.getText().toString();
                String time = mTimeInput.getText().toString();
                String fullName = mFullNameInput.getText().toString();

                mFullNameInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean hasFocus) {
                        if (!hasFocus){
                            mFullNameInput.setFocusable(false);
                            mFullNameInput.requestFocus();
                        }
                    }
                });
/*                AlertDialog.Builder builder =
                        new AlertDialog.Builder(getActivity())
                                .setMessage(level + " - " + spec + " - " + form + " - " + type + " - " + date + " - " + time + " - " + fullName);
                builder.create().show();*/
                ((EntryPresenter) getPresenter()).sendEntryClick(fullName, level, spec, form, type, date, time);
            }
        });
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((EntryPresenter)getPresenter()).onDateClick();
                mTimeInput.setText("");
            }
        });
        mTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((EntryPresenter) getPresenter()).onTimeButtonClick();
            }
        });
    }

    public void showSuccess(String message){
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity())
                        .setMessage(message);
        builder.create().show();
    }

    public void showDatePicker(Dates dates) {
        final Calendar calendar = Calendar.getInstance();
        Locale locale = new Locale("ru", "RU");
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);

        Calendar[] calendars = new Calendar[dates.getResult().size()];

        for (int i = 0; i < calendars.length; i++) {
            calendars[i] = Calendar.getInstance();

            try {
                calendars[i].setTime(dateFormat.parse(dates.getResult().get(i)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (calendar.get(Calendar.DAY_OF_MONTH) == Calendar.SUNDAY) {
            calendar.set(Calendar.DAY_OF_WEEK, calendar.MONDAY);
        } else {
            calendar.set(Calendar.DAY_OF_WEEK, calendar.get(Calendar.DAY_OF_WEEK) + 1);
        }
        DatePickerDialog datePicker = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, monthOfYear);
                calendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                mDateInput.setText(dateFormat.format(calendar1.getTime()));
                ((EntryPresenter)getPresenter()).setDayAt(calendar1.get(Calendar.DAY_OF_MONTH));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePicker.setSelectableDays(calendars);
        datePicker.show(getActivity().getFragmentManager(), TAG);

    }

    @Override
    public void showTimePicker(Entry entry) {
        Calendar calendar = Calendar.getInstance();
        ArrayList<Timepoint> timepoints = new ArrayList<>();
        Locale locale = new Locale("ru", "RU");
        final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", locale);

        for (int i = 0; i < entry.getResult().size(); i++) {
            if (entry.getResult().get(i).getIsFree()) {
                try {
                    calendar.setTime(dateFormat.parse(entry.getResult().get(i).getTime()));
                    Timepoint timepoint = new Timepoint(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
                    timepoints.add(timepoint);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        Timepoint[] points = new Timepoint[timepoints.size()];
        timepoints.toArray(points);

        TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar1.set(Calendar.MINUTE, minute);
                mTimeInput.setText(dateFormat.format(calendar1.getTime()));
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.setTimeInterval(1, 15, 60);
        timePickerDialog.setSelectableTimes(points);
        timePickerDialog.show(getActivity().getFragmentManager(), TAG);
    }


    @Override
    public void showError(String message) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity())
                        .setMessage(message);
        builder.create().show();
    }
}
