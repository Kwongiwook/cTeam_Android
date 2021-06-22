package com.ssh.sustain.ui.presenter;

public interface MainContract {

    interface View {

        void showResult(int result);

    }

    interface Presenter {

        void addNums(int input1, int input2);

        void saveData(int data);
    }
}
