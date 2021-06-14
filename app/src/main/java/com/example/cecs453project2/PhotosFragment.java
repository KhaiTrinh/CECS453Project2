package com.example.cecs453project2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PhotosFragment extends Fragment {

    private static final String IMAGE = "image";

    private int imageId;

    private ImageView ivAnimal;

    public PhotosFragment() {
        // Required empty public constructor
    }

    public static PhotosFragment newInstance(int id) {
        PhotosFragment fragment = new PhotosFragment();
        Bundle args = new Bundle();
        args.putInt(IMAGE, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageId = getArguments().getInt(IMAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_photos, container, false);
        ivAnimal = root.findViewById(R.id.iv_animals);
        ivAnimal.setImageResource(imageId);
        return root;
    }

    public int getImageId() {
        return imageId;
    }
}