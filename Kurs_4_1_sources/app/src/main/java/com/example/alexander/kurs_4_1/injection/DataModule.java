package com.example.alexander.kurs_4_1.injection;

import com.example.alexander.kurs_4_1.domain.entry.EntryDataProvider;
import com.example.alexander.kurs_4_1.domain.entry.EntryDataProviderImpl;
import com.example.alexander.kurs_4_1.domain.form.SelectionDataProvider;
import com.example.alexander.kurs_4_1.domain.form.SelectionDataProviderImpl;
import com.example.alexander.kurs_4_1.domain.table.TableDataProvider;
import com.example.alexander.kurs_4_1.domain.table.TableDataProviderImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexander on 17.11.2016.
 */

@Module
public class DataModule {

    @Singleton
    @Provides
    public SelectionDataProvider selectionDataProvider() {
        return new SelectionDataProviderImpl();
    }

    @Singleton
    @Provides
    public TableDataProvider tableDataProvider() {
        return new TableDataProviderImpl();
    }
    @Singleton
    @Provides
    public EntryDataProvider entryDataProvider() {
        return new EntryDataProviderImpl();
    }
}
