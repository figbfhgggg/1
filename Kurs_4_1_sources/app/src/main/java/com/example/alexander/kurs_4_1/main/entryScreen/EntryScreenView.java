package com.example.alexander.kurs_4_1.main.entryScreen;

import com.example.alexander.kurs_4_1.domain.entry.Dates;
import com.example.alexander.kurs_4_1.domain.entry.Entry;
import com.example.alexander.kurs_4_1.main.common.BaseMainView;

/**
 * Created by Alexander on 29.11.2016.
 */

public interface EntryScreenView extends BaseMainView {

    void showDatePicker(Dates dates);
    void showTimePicker(Entry entryBean);
    void showSuccess(String message);
}
