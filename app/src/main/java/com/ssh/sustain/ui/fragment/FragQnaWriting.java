package com.ssh.sustain.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ssh.sustain.R;
import com.ssh.sustain.ui.activity.MainActivity;

public class FragQnaWriting extends Fragment {
MainActivity activity;
Button QnaWrAddBtn, QnaWrCanBtn;
Fragment fragQnaScreen,fragQna;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //프레그먼트 이동을 위한 객체 생성
        fragQnaScreen = new FragQnaScreen();
        fragQna = new FragQna();

        //프래그먼트랑 xml랑 합쳐주는 역할  ViewGroup rootView
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.qna_writing, container,false);

        //레이아웃 아이디 찾기
        QnaWrAddBtn = rootView.findViewById(R.id.QnaWrAddBtn);
        QnaWrCanBtn = rootView.findViewById(R.id.QnaWrCanBtn);

        //등록 버튼 누르면 FragQnaScreen 이동
        QnaWrAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = (MainActivity) getActivity();
                activity.fragmentChange(fragQnaScreen);
            }
        });

        //취소 버튼 누르면 FragQna 이동
        QnaWrCanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = (MainActivity) getActivity();
                activity.fragmentChange(fragQna);
            }
        });


        return rootView;
    }//onCreateView

}//FragQnaWriting
