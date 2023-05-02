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
        CurrentProgram = program;
        CourseList = courses;
        startDate = sDate;
        advisor = adv;
    }
    //Quick constructor
    public Student(String name, Program program, Instructor adv){
        Name = name;
        CurrentProgram = program;
        advisor = adv;
    }
    //Empty constructor
    public Student(){
        this("Unknown", null, null, null, null, null);
    }
    
    //Add Course
    public void addCourse(Course course){
        Course[] c = new Course[CourseList.length + 1];
        c = CourseList;
    }
    //Add Start Date
    public void addStartDate(Date date){
        startDate = date;
    }
    //Add Advisor
    public void addAdvisor(Instructor instructor){
        advisor = instructor;
    }
}
