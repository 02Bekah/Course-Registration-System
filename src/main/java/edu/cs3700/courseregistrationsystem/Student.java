/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.cs3700.courseregistrationsystem;

/**
 *
 * @author Nathan Durham
 */
public class Student extends Person {
    public Date startDate;
    public Instructor advisor;
    
    //Full constructor
    public Student(String name, Date dob, Program program, Course[] courses, Date sDate, Instructor adv){
        Name = name;
        DateOfBirth = dob;
        Program.Name = program;
        CourseList = courses;
        startDate = sDate;
        advisor = adv;
    }
    //Quick constructor
    public Student(String name, Program program, Instructor adv){
        Name = name;
        Program.Name = program;
        advisor = adv;
    }
    //Empty constructor
    public Student(){
        this("Unknown", null, null, null, null, null);
    }
    
    //Add Course
    public void addCourse(Course course){
        Course[] c = new Course[CourseList.length + 1];
        CourseList = c;
    }
    //Add Start Date
    public void addStartDate(Date date){
        Date d = new Date();
        startDate = d;
    }
    //Add Advisor
    public void addAdvisor(Instructor instructor){
        Instructor i = new Instructor();
        advisor = i;
    }
}
