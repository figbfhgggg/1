package com.example.alexander.kurs_4_1.main.tableScreen;

import com.example.alexander.kurs_4_1.domain.table.UserBean;
import com.example.alexander.kurs_4_1.main.common.BaseMainView;

/**
 * Created by Alexander on 18.01.2017.
 */

public interface TableScreenView extends BaseMainView {
    void showTable(UserBean users);
}
