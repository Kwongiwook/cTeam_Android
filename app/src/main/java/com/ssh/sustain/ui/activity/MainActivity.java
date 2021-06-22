package com.ssh.sustain.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ssh.sustain.R;
import com.ssh.sustain.ui.presenter.MainContract;
import com.ssh.sustain.ui.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    /*
    아 존나 빠르네 시발 진짜 ㅋㅋㅋㅋ
     */

    MainContract.Presenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        mainPresenter = new MainPresenter(this);
        initListener();
    }

    private void initListener() {
        findViewById(R.id.button_submit).setOnClickListener(v -> mainPresenter.addNums(1,2));
    }

    @Override
    public void showResult(int result) {
        //Todo logic
        ((TextView)findViewById(R.id.email_input)).setText(Integer.toString(result));
    }
}
