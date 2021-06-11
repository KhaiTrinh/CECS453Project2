package com.example.cecs453project2;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class ControlsFragment extends Fragment {

    private Button btnPrev, btnNext;
    private CheckBox cbSlide;

    private onButtonPressedListener buttonListener;

    public ControlsFragment() {
        // Required empty public constructor
    }

    public static ControlsFragment newInstance() {
        ControlsFragment fragment = new ControlsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_controls, container, false);

        btnPrev = root.findViewById(R.id.btnPrev);
        btnNext = root.findViewById(R.id.btnNext);
        cbSlide = root.findViewById(R.id.cb_slide);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonListener.onButtonPressed("prev");
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonListener.onButtonPressed("next");
            }
        });

        cbSlide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    buttonListener.onButtonPressed("slide");
                }
            }
        });

        return root;
    }

    @Override
    public void onAttach(Context contex){
        super.onAttach(contex);
        buttonListener =  (onButtonPressedListener)getActivity();
    }
}