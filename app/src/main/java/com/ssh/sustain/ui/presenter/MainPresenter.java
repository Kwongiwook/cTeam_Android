package com.ssh.sustain.ui.presenter;

import com.ssh.sustain.domain.MainModel;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View mainView;
    MainModel mainModel;

    public MainPresenter(MainContract.View mainView) {
        this.mainView = mainView;

        mainModel = new MainModel(this);
    }

    @Override
    public void addNums(int input1, int input2) {
        mainView.showResult(input1 + input2);
    }

    @Override
    public void saveData(int data) {
        mainModel.saveData(data);
    }
}
