package com.e.studentsdetailsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private LayoutInflater inflater;
    private int layout;
    private List<Student> students;

    StudentAdapter(Context context, int resource, List<Student> students) {
        super(context, resource, students);
        this.students = students;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Student student = students.get(position);

        viewHolder.imageView.setImageResource(student.getAvatar());
        viewHolder.firstNameView.setText(student.getFirstName());
        viewHolder.secondNameView.setText(student.getSecondName());
        viewHolder.groupeView.setText(student.getGroupeNumber());

        viewHolder.isCheckedCB.setOnCheckedChangeListener(myCheckChangeList);
        viewHolder.isCheckedCB.setTag(position);
        viewHolder.isCheckedCB.setChecked(student.getIsChecked());
        return convertView;
    }
    private class ViewHolder {
        final ImageView imageView;
        final TextView firstNameView, secondNameView, groupeView;
        final CheckBox isCheckedCB;
        ViewHolder(View view){
            imageView = view.findViewById(R.id.studentPhoto);
            firstNameView = view.findViewById(R.id.firstName);
            secondNameView = view.findViewById(R.id.secondName);
            groupeView = view.findViewById(R.id.group);
            isCheckedCB = view.findViewById(R.id.isChecked);
        }
    }

    OnCheckedChangeListener myCheckChangeList = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int index = (Integer)buttonView.getTag();
            students.get(index).setIsChecked(isChecked);
        }
    };
}
