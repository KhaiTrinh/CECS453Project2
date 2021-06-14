package com.example.cecs453project2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class MainActivity extends AppCompatActivity implements onButtonPressedListener {
    private static final int TIME_DELAY = 2000; // millisecond delay for the slide show
    private Thread thread; // used for the slide show
    private boolean exit; // used to exit from the slide show thread

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
                if (currImg > animals[0]) {
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
                if (currImg < animals[animals.length - 1]) {
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
                this.exit = false;
                thread = new Thread(){ // creates a new thread surrounding the while loop (I had an issue where I tried to put the thread.sleep within the while loop by itself, and it wouldn't work because the while loop thread was still running, so I instead made a thread for the while loop so that I can put that to sleep as well)
                    public void run(){
                        while(currImg < animals[animals.length - 1] && !exit){
                            Log.d("Main Activity", "Current Control: " + control);
                            onButtonPressed("next");
                            try {
                                Thread.sleep(TIME_DELAY);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                thread.start();
                break;
            case "stop_slide":
                this.exit = true;
                break;
            default:
                System.out.println("SOMETHING WENT WRONG IDK");
                break;
        }
    }
}