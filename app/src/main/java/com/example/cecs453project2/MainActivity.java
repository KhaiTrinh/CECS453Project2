package com.example.cecs453project2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity implements onButtonPressedListener {

    private int[] animals = {R.drawable.animal13,
                                R.drawable.animal14,
                                R.drawable.animal15,
                                R.drawable.animal16,
                                R.drawable.animal17,
                                R.drawable.animal18};

    private int currImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currImg = animals[0];

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Sets status & action bar to a color the professor might like
        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.emerald));
        ColorDrawable colorDrawable = new ColorDrawable(getColor(R.color.emerald));
        actionBar.setBackgroundDrawable(colorDrawable);

        PhotosFragment photosFrag = PhotosFragment.newInstance(currImg);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragPhotos, photosFrag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onButtonPressed(String control) {
        switch(control) {
            case "prev":
                if(currImg > animals[0]) {
                    PhotosFragment prev = PhotosFragment.newInstance(--currImg);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
                    transaction.replace(R.id.fragPhotos, prev);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                break;
            case "next":
                if(currImg < animals[animals.length-1]) {
                    PhotosFragment next = PhotosFragment.newInstance(++currImg);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                    transaction.replace(R.id.fragPhotos, next);
                    transaction.addToBackStack(null);
                    transaction.commit();
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