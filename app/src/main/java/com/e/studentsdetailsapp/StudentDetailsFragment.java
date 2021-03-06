package com.e.studentsdetailsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class StudentDetailsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        return view;
    }

    // обновление текстового поля
    public void setText(String item) {
        TextView view = getView().findViewById(R.id.contentTV);
        view.setText(item);
    }
}
