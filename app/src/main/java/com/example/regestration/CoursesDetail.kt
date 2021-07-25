package com.example.regestration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoursesDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses_detail)


            var rvCourse = findViewById<RecyclerView>(R.id.rvCourse)

            var courseList = listOf(
                Courses(
                    "POP21",
                    "Backend Development",
                    "Introduction to Backend development with python",
                    "James"
                ),
                Courses(
                    "TYR34",
                    "Fronted Development",
                    "Introduction to fronted development with javascript",
                    "Purity"
                ),
                Courses(
                    "NYJ10",
                    "Navigating your journey",
                    "Introduction to navigating your journey",
                    "Veronicah"
                ),
                Courses("101",
                    "ux/ui Development",
                    "Introduction to web development with html and css",
                    "Stella"),
            )
            var coursesAdapter = CoursesAdapter(courseList)
            rvCourse.layoutManager = LinearLayoutManager(baseContext)
            rvCourse.adapter = coursesAdapter
        }

}