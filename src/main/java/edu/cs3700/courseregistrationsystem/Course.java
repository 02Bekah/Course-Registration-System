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

    public Course(String n, String p, String i){
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
    
    public void addCourse(int index){
        CourseList = new Course[index];
        Scanner input = new Scanner(System.in);
        System.out.println("Course Name: ");
        String n = input.nextLine();
        System.out.println("Course Program: ");
        String p = input.nextLine();
        System.out.println("Course Instructor: ");
        String i = input.nextLine();
        CourseList[index] = new Course(n,p,i);
    }
    public void listStudent(int list){
        for(int i = 0; i <list; i++ )
        System.out.println("Students: " + Student[i]);
    }
    public void listCourse(int list){
        for(int index = 0; index < list;index++)
            System.out.println("Courses: " + CourseList[index]);
    }
}



