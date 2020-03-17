package com.e.studentsdetailsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.ListFragment;
import java.util.ArrayList;

public class TitlesFragment extends ListFragment {
    public interface onItemClickListener {
        public void itemClick(int position);
    }

    private ArrayList<Student> studentsList;
    private ListView lvItems;
    private TextView testTV;
    private ArrayAdapter<Student> adapterItems;

    private onItemClickListener listener;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        studentsList = new ArrayList<>();
        fillStudentsList();
        ArrayAdapter<Student> adapter = new StudentAdapter(getActivity(), R.layout.student_list_item,studentsList);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate view
        View view = inflater.inflate(R.layout.fragment_items_list, null, false);
        // Bind adapter to ListView

        //fillStudentsList();
/*        lvItems = view.findViewById(R.id.lvItems);
        lvItems.setAdapter(adapterItems);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View item, int position, long rowId) {
                // Retrieve item based on position
                Student i = adapterItems.getItem(position);
                // Fire selected event for item
                listener.itemClick(position);
            }
        });*/
        return view;
    }

    public void setActivateOnItemClick(boolean activateOnItemClick) {
        // When setting CHOICE_MODE_SINGLE, ListView will automatically
        // give items the 'activated' state when touched.
        lvItems.setChoiceMode(activateOnItemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
    }

    public void fillStudentsList(){
        studentsList.add(new Student("Igor", "Popov", "RT234",true));
        studentsList.add(new Student("Petr", "Kriptov", "RT234",true));
        studentsList.add(new Student("Oleg", "Vinnik", "ZT138",true));
        studentsList.add(new Student("Svetlana", "Kardoba", "RT222",false));
        studentsList.add(new Student("Olga", "Petrova", "ET210",false));
        studentsList.add(new Student("Semen", "Ischenko", "KT210",true));
    }
}
