package com.example.cecs453project2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PhotosFragment extends Fragment {

    private ImageView ivAnimal;

    private int currImg;

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
        ivAnimal = root.findViewById(R.id.iv_animals);
        currImg = R.drawable.animal13;
        return root;
    }

    public void changeImage(int id) {
        ivAnimal.setImageResource(id);
        currImg = id;
    }

    public int getCurrImg() {
        return currImg;
    }
}