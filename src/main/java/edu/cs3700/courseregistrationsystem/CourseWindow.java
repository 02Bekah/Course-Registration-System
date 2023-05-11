/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cs3700.courseregistrationsystem;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author jdcummings01_indt
 */
public class CourseWindow extends JFrame{
    /*
    private final JTextField text1;
    private final JTextField text2;
    private final JTextField text3;
*/
    
    private static JLabel nameTitle;
    private static JLabel programTitle;
    private static JLabel instructorTitle;
    private static JLabel prerequisiteTitle;
    private static JLabel studentsTitle;
    private static JLabel[] names;
    private static JLabel[] programs;
    private static JLabel[] instructors;
    private static JLabel[] prerequisites;
    private static JLabel[] students;
    
    //private final JButton b;
    
    private Font plainFont;
    private Font boldFont;
    private Font italicFont;    
    
    public CourseWindow() {
        super("Display COurse Window");
        FlowLayout fl = new FlowLayout();
        setLayout(fl);
        
        boldFont = new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        plainFont = new Font("Serif", Font.PLAIN, 14);
    }
            
    public CourseWindow(Course[] courseSearchResults){
        this();
       
        // Array of JLabels for names
        JLabel[] names = new JLabel[courseSearchResults.length];
        // Array of JLabels for programs
        JLabel[] programs = new JLabel[courseSearchResults.length];
        // Array of JLabels for instructors
        JLabel[] instructors = new JLabel[courseSearchResults.length];
        // Array of JLabels for prerequisites
        JLabel[] prerequisites = new JLabel[courseSearchResults.length];
        // Array of JLabels for students
        JLabel[] students = new JLabel[courseSearchResults.length];
        
        nameTitle = new JLabel("Name of Course:");
        //text1 = new JTextField(20);
        programTitle = new JLabel("Program:");
        //text2 = new JTextField(20);
        instructorTitle = new JLabel("Instrutor:");
        //text3 = new JTextField(20);
        //b = new JButton("Submit");
        prerequisiteTitle = new JLabel("Prerequisites:");
        studentsTitle = new JLabel("Students:");
        
        add(nameTitle);
        //add(text1);
        add(programTitle);
        //add(text2);
        add(instructorTitle);
        //add(text3);
        add(prerequisiteTitle);
        add(studentsTitle);
        
        for (int i=0; i<courseSearchResults.length; i++) {
            if (courseSearchResults[i].getname() != null) {
                names[i] = new JLabel(courseSearchResults[i].getname());
                add(names[i]);
            }
            
            if (courseSearchResults[i].Program != null) {
                programs[i] = new JLabel(courseSearchResults[i].Program.Name);
                add(programs[i]);
            }
            
            if (courseSearchResults[i].Instructor != null) {
                instructors[i] = new JLabel(courseSearchResults[i].Instructor.toString());
                add(instructors[i]);
            }
            
            prerequisites[i] = new JLabel(courseSearchResults[i].coursePrerequisitesToString());
            add(prerequisites[i]);
            
            students[i] = new JLabel(courseSearchResults[i].courseStudentsRegisteredToString());
            add(students[i]);
            
        }
    }
    
            
            
}
