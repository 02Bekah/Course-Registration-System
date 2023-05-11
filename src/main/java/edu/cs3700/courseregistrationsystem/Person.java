/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cs3700.courseregistrationsystem;

/**
 *
 * @author Broxt
 */
public class Person {
    public String Name;
    public Date DateOfBirth;
    public Program CurrentProgram;
    public Course[] CourseList;
    
    public Person(){
        
    }
    
    public Person(String name, Date dob, Program program){
        Name = name;
        DateOfBirth = dob;
        CurrentProgram = program;
    }
    
    public Person(String name, Date dob, Program currentProgram, Course[] courseList){
        Name = name;
        DateOfBirth = dob;
        CurrentProgram = currentProgram;
        CourseList = courseList;
    }
    
    
}
