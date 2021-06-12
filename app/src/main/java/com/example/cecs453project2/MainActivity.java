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
                                R.drawable.animal18}; // length = 6 max index = 5

    private int currImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currImg = 0;

        PhotosFragment photosFrag = PhotosFragment.newInstance(animals[currImg]);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragPhotos, photosFrag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onButtonPressed(String control) {
        switch(control) {
            case "prev":
                System.out.println("PREV BUTTON PRESSED");
                if(currImg > 0) {
                    PhotosFragment prev = PhotosFragment.newInstance(animals[--currImg]);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragPhotos, prev);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    System.out.println("PREV PROCESSED");
                }
                break;
            case "next":
                System.out.println("NEXT BUTTON PRESSED");
                if(currImg < animals.length-1) {
                    PhotosFragment next = PhotosFragment.newInstance(animals[++currImg]);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragPhotos, next);
                    transaction.addToBackStack(null);
                    transaction.commit();
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
        System.out.println("CURRIMG = " + currImg);
    }
}