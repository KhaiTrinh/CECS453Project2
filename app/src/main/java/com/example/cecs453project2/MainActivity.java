package com.example.cecs453project2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity implements onButtonPressedListener {

    // An array of all the id of the images
    private int[] animals = {R.drawable.animal13,
                                R.drawable.animal14,
                                R.drawable.animal15,
                                R.drawable.animal16,
                                R.drawable.animal17,
                                R.drawable.animal18};
    // Keeps track of the current image in use
    private int currImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currImg = animals[0];

        // Sets status & action bar to a color the professor might like
        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.gray));
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(getColor(R.color.gray));
        actionBar.setBackgroundDrawable(colorDrawable);

        // Creating the initial fragment with the first image
        PhotosFragment initialFragment = PhotosFragment.newInstance(currImg);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragPhotos, initialFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onButtonPressed(String control) {
        switch(control) {
            case "prev":
                // Previous button is disabled when the first image is in view
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
                // Next button is disabled when the last image is in view
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