package com.ssh.sustain.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.ssh.sustain.R;
import com.ssh.sustain.ui.fragment.FragColumn;
import com.ssh.sustain.ui.fragment.FragColumnList;
import com.ssh.sustain.ui.fragment.FragColumnMyPage;
import com.ssh.sustain.ui.fragment.FragCommunity;
import com.ssh.sustain.ui.fragment.FragCommunityComments;
import com.ssh.sustain.ui.fragment.FragCommunityModify;
import com.ssh.sustain.ui.fragment.FragCommunityScreen;
import com.ssh.sustain.ui.fragment.FragCommunityWriting;
import com.ssh.sustain.ui.fragment.FragNotQna;
import com.ssh.sustain.ui.fragment.FragQna;
import com.ssh.sustain.ui.fragment.FragQnaScreen;
import com.ssh.sustain.ui.fragment.FragQnaWriting;
import com.ssh.sustain.ui.fragment.FragShopMap;
import com.ssh.sustain.ui.fragment.FragShopMenu;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
FragColumnList fragColumnList;
FragCommunity fragCommunity;
FragQna fragQna;
FragColumn fragColumn;
FragColumnMyPage fragColumnMyPage;
FragCommunityComments fragCommunityComments;
FragCommunityModify fragCommunityModify;
FragCommunityScreen fragCommunityScreen;
FragCommunityWriting fragCommunityWriting;
FragNotQna fragNotQna;
FragQnaScreen fragQnaScreen;
FragQnaWriting fragQnaWriting;
FragShopMap fragShopMap;
FragShopMenu fragShopMenu;
Fragment change = null;





Button mainMemoBtn, mainCommuBtn,  mainQnaBtn, mainRsvBtn;
TextView mainMoreTv;
RecyclerView mainPageRecyclerview;

    /* -------------------배너 부분 시작-----------------------*/
    private ViewPager2 sliderViewPager;
    private LinearLayout layoutIndicator;
    private int[] images = new int[]{
            R.drawable.slider_hair1,
            R.drawable.slider_hair2,
            R.drawable.slider_hair3,
            R.drawable.slider_hair4jpg
    };
    private int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; //
     //----------------배너 부분 끝-----------------------------



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Fragment 객체 생성
        fragCommunity = new FragCommunity();
        fragQna = new FragQna();
        fragColumnList = new FragColumnList();
        fragColumn = new FragColumn();
        fragColumnMyPage = new FragColumnMyPage();
        fragCommunityComments = new FragCommunityComments();
        fragCommunityModify = new FragCommunityModify();
        fragCommunityScreen = new FragCommunityScreen();
        fragCommunityWriting = new FragCommunityWriting();
        fragNotQna = new FragNotQna();
        fragQnaScreen = new FragQnaScreen();
        fragQnaWriting = new FragQnaWriting();
        fragShopMap = new FragShopMap();
        fragShopMenu = new FragShopMenu();


        //여기서 써야할 레이아웃 찾아주기
        mainCommuBtn = findViewById(R.id.mainCommuBtn);
        mainMemoBtn = findViewById(R.id.mainMemoBtn);
        mainQnaBtn = findViewById(R.id.mainQnaBtn);
        mainRsvBtn = findViewById(R.id.mainRsvBtn);
        mainMoreTv = findViewById(R.id.mainMoreTv);
        mainPageRecyclerview = findViewById(R.id.mainPageRecyclerview);



        //-------------------------------배너부분 시작----------------------------
        sliderViewPager = findViewById(R.id.sliderViewPager);
        layoutIndicator = findViewById(R.id.layoutIndicators);
        sliderViewPager.setOffscreenPageLimit(1);
        sliderViewPager.setAdapter(new ImageSliderAdapter(this, images));

        sliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });

        setupIndicators(images.length);


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(images.length == currentPage) {
                    currentPage = 0;
                }
                sliderViewPager.setCurrentItem(currentPage++, true);
            }
        }, DELAY_MS, PERIOD_MS);
        //----------배너 끝 -------------------


        //게시판 기록 누르면 FragCommunity 창으로 이동
        mainCommuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragCommunity).addToBackStack(null). commit();
            }//onClick
        });//mainCommuBtn.setOnClickListener

        //QnA 누르면 FragQna 창으로 이동
        mainQnaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragQna).addToBackStack(null). commit();
            }//onClick
        });//mainQnaBtn.setOnClickListener mainRsvBtn


        //더보기 누르면 fragColumnList 창으로 이동
        mainMoreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragColumnList).addToBackStack(null).commit();
            }//onClick
        });//mainMoreTv.setOnClickListener






    }//onCreate


//-------------------프래그먼트 간의 이동 -------------------------
    public void fragmentChange(Fragment change){
        if(change.equals(fragCommunityWriting)){
        }else if(change.equals(fragCommunityScreen)){
        }else if(change.equals(fragCommunity)){
        }else if(change.equals(fragCommunityModify)){
        }else if(change.equals(fragQnaWriting)){
        }else if(change.equals(fragQnaScreen)){
        }else if(change.equals(fragQna)){
        }else if(change.equals(fragColumn)){
        }else if(change.equals(fragColumnMyPage)){
        }
        // if~else if {} 끝
        getSupportFragmentManager().beginTransaction().replace(R.id.container, change ).addToBackStack(null).commit();
    }//fragmentChange ---------------프래그먼트 간 이동 끝----------------------------------


















    //-------------------------배너 시작-------------------------------
    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this,
                    R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);
            layoutIndicator.addView(indicators[i]);
        }
        setCurrentIndicator(0);
    }

    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        this,
                        R.drawable.bg_indicator_active
                ));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        this,
                        R.drawable.bg_indicator_inactive
                ));
            }
        }
    }
    //  -------------------------배너 끝 ---------------------------------





}//MainActivity
