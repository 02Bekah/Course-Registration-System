// Update package name as needed
package edu.cs3700.courseregistrationsystem;

/**
* Author: Justin Cummings
*/

// Course Class for Project
import java.util.Scanner;
class Course {
    private String name;
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
            n = name;
    }    
    
         public void addCourse(Course course) {
        Course[] temp = new Course[CourseList.Count + 1];
        CourseList = temp;
         }
    
    public void listStudent(int list){
        for(int i = 0; i <list; i++ )
        System.out.println("Students: " + StudentList[i]);
    }
    public void listCourse(int list){
        for(int index = 0; index < list;index++)
            System.out.println("Courses: " + CourseList[index]);
    }
}



