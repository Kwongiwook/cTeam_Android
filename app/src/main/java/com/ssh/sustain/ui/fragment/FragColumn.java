package com.ssh.sustain.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ssh.sustain.R;
import com.ssh.sustain.ui.activity.MainActivity;

public class FragColumn extends Fragment {
    MainActivity activity;
    ImageButton columnImgBtn;
    Fragment fragColumnMyPage;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //프래그먼트랑 xml랑 합쳐주는 역할  ViewGroup rootView
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.column, container,false);

        //프래그먼트 이동을 위한 객체 생성
        fragColumnMyPage = new FragColumnMyPage();

        //위젯 찾기
        columnImgBtn = rootView.findViewById(R.id.columnImgBtn);



        //이미지 버튼 눌렀을때 fragColumnMyPage 이동
          columnImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //fragColumnMyPage로 이동
                activity = (MainActivity) getActivity();
                activity.fragmentChange(fragColumnMyPage);
            }//onClick
        });//setOnClickListener




        return rootView;
    }//onCreateView

}//FragColumn
