/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cs3700.courseregistrationsystem;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Rebekah
 */
public class StudentWindow extends JFrame{
    Font studentInfoFont;
    Font studentTitleFont;
    
    private static JLabel[] studentNameLbls;
    private static JLabel studentNameTitleLbl;
    private static JLabel[] studentDOBLbls;
    private static JLabel studentDOBTitleLbl;
    private static JLabel[] studentProgramLbls;
    private static JLabel studentProgramTitleLbl;
    private static JLabel[] studentCoursesLbls;
    private static JLabel studentCourseTitleLbl;
    private static JLabel[] studentStartDateLbls;
    private static JLabel studentStartDateTitleLbl;
    private static JLabel[] studentAdvisorLbls;
    private static JLabel studentAdvisorTitleLbl;
            
    public StudentWindow() {
        super("Search for Student");
        
        FlowLayout instructorFL = new FlowLayout();
        setLayout(instructorFL);
        
        studentInfoFont = new Font("Serif", Font.PLAIN, 14);
        studentTitleFont = new Font("Serif", Font.BOLD,14);
    }
    
    public StudentWindow(Student[] searchResults) {
        this();
        
        // Array of JLabels for names
        JLabel[] studentNameLbls = new JLabel[searchResults.length];
        // Array of JLabels for date of births
        JLabel[] studentDOBLbls = new JLabel[searchResults.length];
        // Array of JLabels for programs
        JLabel[] studentProgramLbls = new JLabel[searchResults.length];
        // Array of JLabels for courses
        JLabel[] studentCoursesLbls = new JLabel[searchResults.length];
        // Array of JLabels for start date
        JLabel[] studentStartDateLbl = new JLabel[searchResults.length];
        // Array of Jlabels for advisors
        JLabel[] studentAdvisorLbls = new JLabel[searchResults.length];
        
        /*
        // Initialize title labels
        studentNameTitleLbl = new JLabel("Name");
        studentNameTitleLbl.setFont(studentTitleFont);
        studentDOBTitleLbl = new JLabel("Date of Birth:");
        studentDOBTitleLbl.setFont(studentTitleFont);
        studentProgramTitleLbl = new JLabel("Programs:");
        studentProgramTitleLbl.setFont(studentTitleFont);
        studentCourseTitleLbl = new JLabel("Courses:");
        studentCourseTitleLbl.setFont(studentTitleFont);
        studentStartDateTitleLbl = new JLabel("Start Date:");
        studentStartDateTitleLbl.setFont(studentTitleFont);
        studentAdvisorTitleLbl = new JLabel("Advior:");
        studentAdvisorTitleLbl.setFont(studentTitleFont);
        
        add(studentNameTitleLbl);
        add(studentDOBTitleLbl);
        add(studentProgramTitleLbl);
        add(studentCourseTitleLbl);
        add(studentStartDateTitleLbl);
        add(studentAdvisorTitleLbl);
        */
        
        for (int i=0; i<searchResults.length; i++) {
            // Initialize instructor name label
            studentNameLbls[i] = new JLabel("Name: " + searchResults[i].Name);
            studentNameLbls[i].setFont(studentInfoFont);
            add(studentNameLbls[i]);
            
            // Initialize instructor date of birth label
            studentDOBLbls[i] = new JLabel("Date of Birth: " + searchResults[i].DateOfBirth.toString());
            studentDOBLbls[i].setFont(studentInfoFont);
            add(studentDOBLbls[i]);
            
            // Initialize instructor program label
            studentProgramLbls[i] = new JLabel("Program: " + searchResults[i].CurrentProgram.Name);
            studentProgramLbls[i].setFont(studentInfoFont);
            add(studentProgramLbls[i]);
            
            // Initialize instructor courses label
            studentCoursesLbls[i] = new JLabel("Courses: " + searchResults[i].studentCoursesToString());
            studentCoursesLbls[i].setFont(studentInfoFont);
            add(studentCoursesLbls[i]);
            
            // Initialize intrsuctor advisees label
            studentAdvisorLbls[i] = new JLabel("Advisor: " + searchResults[i].advisor.toString());
            studentAdvisorLbls[i].setFont(studentInfoFont);
            add(studentAdvisorLbls[i]);
        }
    }
}
