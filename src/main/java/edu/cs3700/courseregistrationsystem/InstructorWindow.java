/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cs3700.courseregistrationsystem;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Rebekah
 */
public class InstructorWindow extends JFrame{
    private final Font instructorInfoFont;
    private final Font instructorTitleFont;
    private static JLabel[] instructorNameLbls;
    private static JLabel instructorNameTitleLbl;
    private static JLabel[] instructorDOBLbls;
    private static JLabel instructorDOBTitleLbl;
    private static JLabel[] instructorProgramLbls;
    private static JLabel instrutorProgramTitleLbl;
    private static JLabel[] instructorCoursesLbls;
    private static JLabel instrutorCourseTitleLbl;
    private static JLabel[] instructorAdviseesLbls;
    private static JLabel instrutorAdviseeTitleLbl;
    
    
    public InstructorWindow() {
        super("Search for Instructor");
        
        FlowLayout instructorFL = new FlowLayout();
        setLayout(instructorFL);
        
        instructorInfoFont = new Font("Serif", Font.PLAIN, 14);
        instructorTitleFont = new Font("Serif", Font.BOLD,14);
    }
    
    
    public InstructorWindow(Instructor[] searchResults) {
        this();
        
        // Array of JLabels for names
        JLabel[] instructorNameLbls = new JLabel[searchResults.length];
        // Array of JLabels for date of births
        JLabel[] instructorDOBLbls = new JLabel[searchResults.length];
        // Array of JLabels for programs
        JLabel[] instructorProgramLbls = new JLabel[searchResults.length];
        // Array of JLabels for courses
        JLabel[] instructorCoursesLbls = new JLabel[searchResults.length];
        // Array of JLabels for advisees
        JLabel[] instructorAdviseesLbls = new JLabel[searchResults.length];
        
        
        // Initialize title labels
        instructorNameTitleLbl = new JLabel("Name");
        instructorNameTitleLbl.setFont(instructorTitleFont);
        instructorDOBTitleLbl = new JLabel("Date of Birth:");
        instructorDOBTitleLbl.setFont(instructorTitleFont);
        instrutorProgramTitleLbl = new JLabel("Programs:");
        instrutorProgramTitleLbl.setFont(instructorTitleFont);
        instrutorCourseTitleLbl = new JLabel("Courses:");
        instrutorCourseTitleLbl.setFont(instructorTitleFont);
        instrutorAdviseeTitleLbl = new JLabel("Advisees");
        instrutorAdviseeTitleLbl.setFont(instructorTitleFont);
        
        
        add(instructorNameTitleLbl);
        add(instructorDOBTitleLbl);
        add(instrutorProgramTitleLbl);
        add(instrutorCourseTitleLbl);
        add(instrutorAdviseeTitleLbl);
        
        for (int i=0; i<searchResults.length; i++) {
            // Initialize instructor name label
            instructorNameLbls[i] = new JLabel(searchResults[i].Name);
            instructorNameLbls[i].setFont(instructorInfoFont);
            add(instructorNameLbls[i]);
            
            // Initialize instructor date of birth label
            instructorDOBLbls[i] = new JLabel(searchResults[i].DateOfBirth.toString());
            instructorDOBLbls[i].setFont(instructorInfoFont);
            add(instructorDOBLbls[i]);
            
            // Initialize instructor program label
            instructorProgramLbls[i] = new JLabel(searchResults[i].CurrentProgram.Name);
            instructorProgramLbls[i].setFont(instructorInfoFont);
            add(instructorProgramLbls[i]);
            
            // Initialize instructor courses label
            instructorCoursesLbls[i] = new JLabel(searchResults[i].instructorCoursesToString());
            instructorCoursesLbls[i].setFont(instructorInfoFont);
            add(instructorCoursesLbls[i]);
            
            // Initialize intrsuctor advisees label
            instructorAdviseesLbls[i] = new JLabel(searchResults[i].instructorAdviseesToString());
            instructorAdviseesLbls[i].setFont(instructorInfoFont);
            add(instructorAdviseesLbls[i]);
        }
    }
}
