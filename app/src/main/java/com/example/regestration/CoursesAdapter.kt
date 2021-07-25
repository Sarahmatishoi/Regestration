package com.example.regestration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class CoursesAdapter(var courseList: List<Courses>):RecyclerView.Adapter<CoursesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.course_list_item, parent, false)
        return CoursesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        var currentCourse = courseList.get(position)
        holder.tvCourseName.text = currentCourse.courseName
        holder.tvdescription.text = currentCourse.description
        holder.tvinstructor.text = currentCourse.instruction
        holder.tvcoursecode.text = currentCourse.courseCode

    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}


class CoursesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvCourseName=itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvdescription=itemView.findViewById<TextView>(R.id.tvdescription)
    var tvinstructor=itemView.findViewById<TextView>(R.id.tvinstructor)
    var tvcoursecode=itemView.findViewById<TextView>(R.id.tvcoursecode)
}