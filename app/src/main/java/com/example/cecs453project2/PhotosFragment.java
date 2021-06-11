package com.example.cecs453project2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PhotosFragment extends Fragment {

    private int[] animals;

    private ImageView ivAnimal;

    public PhotosFragment() {
        // Required empty public constructor
    }

    public static PhotosFragment newInstance() {
        PhotosFragment fragment = new PhotosFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_photos, container, false);
        animals = MainActivity.ANIMALS;
        ivAnimal = root.findViewById(R.id.iv_animals);
        //ivAnimal.setImageResource(animals[5]);
        return root;
    }
}