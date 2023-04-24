// Update package name as needed
package edu.cs3700.courseregistrationsystem;

/**
* Author: Justin Cummings
*/

// Course Class for Project
import java.util.Scanner;
class Course {
    private String name;
    public String Program;
    public int Prereq[] CourseList;
    public String Instructor;
    public int StudentList[] Student;

    public Course(String n, String p, String i){
        setName(n);
        Program = p;
        Instructor = i;
    }
    public String getname(){
            return (name);
    }
    public void setName(String n){
            n = name;
    }    
    
    public void addCourse(int index){
        Scanner input = new Scanner(System.in);
        System.out.println("Course Name: ");
        name = input.Next();
        System.out.println("Course Program: ");
        Program = input.Next();
        System.out.println("Course Instructor: ");
        Instructor = input.Next();
        CourseList[index] = new Course(name,Program,Instructor);
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



