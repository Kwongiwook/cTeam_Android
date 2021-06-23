package com.ssh.sustain.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.ssh.sustain.R;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    /*
    툴 바(액션바)를 사용하는 건 좋지만 매번 xml에 적어주는건 정말 심각하게 귀찮은 짓입니다. 그렇기 때문에
    이 BaseActivity가 기본적으로 툴 바를 사용하게 한 뒤 타 액티비티들이 이 액티비티를 상속받도록 합니다.

    물론 우리는 액티비티의 사용을 최소화 할 생각이지만 앞으로 어떻게 될지 모르니까, 확장성을 고려하여 만들었
    읍
    니
    다.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    public void setContentView(int layoutResID) {
        DrawerLayout baseView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout baseContent = (FrameLayout) baseView.findViewById(R.id.baseContent);
        getLayoutInflater().inflate(layoutResID, baseContent, true);

        super.setContentView(layoutResID);

        Toolbar baseToolbar = (Toolbar) findViewById(R.id.baseToolbar);

        if (useToolbar()) {
            setSupportActionBar(baseToolbar);
            setTitle("Example");
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        } else {
            baseToolbar.setVisibility(View.GONE);
        }
    }

    protected boolean useToolbar() {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        return false;
    }
}