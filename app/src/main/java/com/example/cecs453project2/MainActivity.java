package com.example.cecs453project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements onButtonPressedListener {

    public static int[] ANIMALS = {R.drawable.animal13,
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

        photosFrag = PhotosFragment.newInstance();
    }

    @Override
    public void onButtonPressed(String control) {
        switch(control) {
            case "prev":
                System.out.println("PREV BUTTON PRESSED");
                break;
            case "next":
                System.out.println("NEXT BUTTON PRESSED");
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