package com.example.cecs453project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity implements onButtonPressedListener {

    private int[] animals = {R.drawable.animal13,
                                R.drawable.animal14,
                                R.drawable.animal15,
                                R.drawable.animal16,
                                R.drawable.animal17,
                                R.drawable.animal18};

    private int currImg;

    FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currImg = 0;

        PhotosFragment photosFrag = PhotosFragment.newInstance(animals[currImg]);
        manager.beginTransaction().add(R.id.fragPhotos, photosFrag).commit();
    }

    @Override
    public void onButtonPressed(String control) {
        switch(control) {
            case "prev":
                System.out.println("PREV BUTTON PRESSED");
                if(currImg > 0) {
                    PhotosFragment prev = PhotosFragment.newInstance(animals[currImg-1]);
                    System.out.println("PREV PROCESSED");
                }
                break;
            case "next":
                System.out.println("NEXT BUTTON PRESSED");
                if(currImg < animals.length-1) {
                    PhotosFragment next = PhotosFragment.newInstance(animals[currImg+1]);
                    manager.beginTransaction().replace(R.id.fragPhotos, next).commit();
                    System.out.println("NEXT PROCESSED");
                }
                break;
            case "slide":
                System.out.println("SLIDE BOX CHECKED");
                break;
            default:
                System.out.println("SOMETHING WENT WRONG IDK");
                break;
        }
    }
}