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

public class FragCommunityWriting extends Fragment {
MainActivity activity;
Button commuWrAddBtn, commuWrCanBtn;
Fragment fragCommunityScreen, fragCommunity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //프레그먼트 이동을 위한 객체 생성
        fragCommunityScreen = new FragCommunityScreen();
        fragCommunity = new FragCommunity();

        //프래그먼트랑 xml랑 합쳐주는 역할  ViewGroup rootView
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.community_writing, container,false);

        //레이아웃 아이디값 찾기
        commuWrAddBtn = rootView.findViewById(R.id.commuWrAddBtn);
        commuWrCanBtn = rootView.findViewById(R.id.commuWrCanBtn);

        // 등록 버튼 누르면 FragCommunityWriting 이동
        commuWrAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = (MainActivity) getActivity();
                activity.fragmentChange(fragCommunityScreen);
            }//onClick
        });//commuWrAddBtn.setOnClickListener

        //취소 버튼 누르면 Community 이동
        commuWrCanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = (MainActivity) getActivity();
                activity.fragmentChange(fragCommunity);
            }//onClick
        });//commuWrCanBtn.setOnClickListener


        return rootView;
    }//onCreateView

}//FragCommunityWriting


