package com.example.cecs453project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements onButtonPressedListener {

    private int[] animals = {R.drawable.animal13,
                                R.drawable.animal14,
                                R.drawable.animal15,
                                R.drawable.animal16,
                                R.drawable.animal17,
                                R.drawable.animal18};

    private PhotosFragment photosFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photosFrag = PhotosFragment.newInstance();
        photosFrag = (PhotosFragment)getSupportFragmentManager().findFragmentById(R.id.fragPhotos);
    }

    @Override
    public void onButtonPressed(String control) {
        if(photosFrag != null) {
            switch(control) {
                case "prev":
                    if(photosFrag.getCurrImg() != animals[0]) {
                        photosFrag.changeImage(photosFrag.getCurrImg()-1);
                    }
                    break;
                case "next":
                    if(photosFrag.getCurrImg() != animals[animals.length-1]) {
                        photosFrag.changeImage(photosFrag.getCurrImg()+1);
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
}