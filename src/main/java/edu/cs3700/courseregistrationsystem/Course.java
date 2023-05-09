// Update package name as needed
package edu.cs3700.courseregistrationsystem;

/**
* Author: Justin Cummings
*/

// Course Class for Project
import java.util.Scanner;
public class Course {
    String name;
    public Program Program;
    public Course CourseList[];
    public Instructor Instructor;
    public Student StudentList[];

    public Course(String n, Program p, Instructor i){
        setName(n);
        Program = p;
        Instructor = i;
    }
    public String getname(){
            return (name);
    }
    private void setName(String n){
            name = n;
    }    
    
         public void addCourse(Course course) {
        if (CourseList != null) {
            // Increase size by creating temp array
            Course[] temp = new Course[CourseList.length + 1];
            // Copy into temp array
            for (int i=0; i<CourseList.length; i++) {
                temp[i] = CourseList[i];
            }
            // Add new course to temp array
            temp[CourseList.length] = course;
            // Set temp as CourseList
            CourseList = temp;
        } else {
            CourseList = new Course[] {course};
        }
    } // End method addCourse

    
    public void listStudent(int list){
        for(int i = 0; i <list; i++ )
        System.out.println("Students: " + StudentList[i]);
    }
    public void listCourse(int list){
        for(int index = 0; index < list;index++)
            System.out.println("Courses: " + CourseList[index]);
    }
}



