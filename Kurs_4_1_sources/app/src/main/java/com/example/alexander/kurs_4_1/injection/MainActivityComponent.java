package com.example.alexander.kurs_4_1.injection;

import com.example.alexander.kurs_4_1.main.entryScreen.EntryScreenFragment;
import com.example.alexander.kurs_4_1.main.formScreen.SelectionScreenFragment;
import com.example.alexander.kurs_4_1.main.mainScreen.MainScreenFragment;
import com.example.alexander.kurs_4_1.main.tableScreen.TableScreenFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alexander on 17.11.2016.
 */

@Singleton
@Component(modules = {DomainModule.class, DataModule.class})
public interface MainActivityComponent {
    void inject(SelectionScreenFragment selectionScreenFragment);

    void inject(TableScreenFragment tableScreenFragment);

    void inject(MainScreenFragment mainScreenFragment);

    void inject(EntryScreenFragment entryScreenFragment);
}
