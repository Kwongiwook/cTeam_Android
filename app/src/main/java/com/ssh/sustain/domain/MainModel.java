package com.ssh.sustain.domain;

import com.ssh.sustain.ui.presenter.MainContract;

public class MainModel {
    MainContract.Presenter presenter;

    public MainModel(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void saveData(int data) {
        //Todo

    }
}
