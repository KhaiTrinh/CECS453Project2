package com.example.cecs453project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int[] animals = {R.drawable.animal13,
                                R.drawable.animal14,
                                R.drawable.animal15,
                                R.drawable.animal16,
                                R.drawable.animal17,
                                R.drawable.animal18};

    private PhotosFragment photosFrag;
    private ControlsFragment controlsFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}