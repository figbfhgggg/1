package com.example.alexander.kurs_4_1.domain.form;

import com.example.alexander.kurs_4_1.common.CallbackApi;

import javax.inject.Inject;

/**
 * Created by Alexander on 17.11.2016.
 */
public class GetSelectionInteractor {
    private final SelectionDataProvider selectionDataProvider;

    @Inject
    protected GetSelectionInteractor(SelectionDataProvider selectionDataProvider) {
        this.selectionDataProvider = selectionDataProvider;
    }

    public void getSelections(CallbackApi<SelectionBean> callbackApi){
        selectionDataProvider.getAllSelection(callbackApi);
    }
}
