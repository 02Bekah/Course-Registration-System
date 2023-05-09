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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Broxt
 */
public class MainWindow extends JFrame{
    //private final JTextField titleTxt;
    private final JButton addProgramBtn;
    private final JButton addStudentBtn;
    private final JButton addInstructorBtn;
    private final JButton addCourseBtn;
    private final JButton searchStudentBtn;
    private final JButton searchInstructorBtn;
    private final JButton searchCourseBtn;
    private final JButton registerStudentBtn;
    private final JButton registerInstructorBtn;
    private final JButton assignAdvisorBtn;
    private Font plainFont;
    private Font boldFont;
    private Font italicFont;
    
    public MainWindow(){
        super("Course Registration System");
        FlowLayout fl = new FlowLayout();
        setLayout(fl);
        
        boldFont = new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        plainFont = new Font("Serif", Font.PLAIN, 14);
        
        addProgramBtn = new JButton("Add Program");
        add(addProgramBtn);
        addProgramBtn.addMouseListener(new btnMouseHandler(1));
        
        addStudentBtn = new JButton("Add Student");
        add(addStudentBtn);
        addStudentBtn.addMouseListener(new btnMouseHandler(2));
        
        addInstructorBtn = new JButton("Add Instructor");
        add(addInstructorBtn);
        addInstructorBtn.addMouseListener(new btnMouseHandler(3));
        
        addCourseBtn = new JButton("Add Course");
        add(addCourseBtn);
        addCourseBtn.addMouseListener(new btnMouseHandler(4));
        
        searchStudentBtn = new JButton("Search for Student");
        add(searchStudentBtn);
        searchStudentBtn.addMouseListener(new btnMouseHandler(5));
        
        searchInstructorBtn = new JButton("Search for Instructor");
        add(searchInstructorBtn);
        searchInstructorBtn.addMouseListener(new btnMouseHandler(6));
        
        searchCourseBtn = new JButton("Search for Course");
        add(searchCourseBtn);
        searchCourseBtn.addMouseListener(new btnMouseHandler(7));
        
        registerStudentBtn = new JButton("Register a Student For a Course");
        add(registerStudentBtn);
        registerStudentBtn.addMouseListener(new btnMouseHandler(8));
        
        registerInstructorBtn = new JButton("Register an Instructor For a Course");
        add(registerInstructorBtn);
        registerInstructorBtn.addMouseListener(new btnMouseHandler(9));
        
        assignAdvisorBtn = new JButton("Assign an Advisor To a Student");
        add(assignAdvisorBtn);
        assignAdvisorBtn.addMouseListener(new btnMouseHandler(10));
    }
    
    private class btnMouseHandler implements MouseListener{
        private int btnClickedNum;
        
        public btnMouseHandler(int clickedBtnNum){
            btnClickedNum = clickedBtnNum;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            var sender = e.getComponent();
            
            String msg = getMessageText();
            JOptionPane.showMessageDialog(sender, msg);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
        
        private String getMessageText(){
            // Initialize variables with default values
            String instructorName = "", courseName = "";
            int selection = 0;
            Instructor[] instructorSearchResults = null;
            Course[] courseSearchResults = null;
            Instructor instructor = null;
            Course[] courseResults = null;
            Course course = null;
        
            switch(btnClickedNum){
                case 1:
                    return "Program Added";
                case 2:
                    return "Student Added";
                case 3:
                    return "Instructor Added";
                case 4:
                    return "Course Added";
                case 5:
                    return "Student found";
                case 6:
                    // Get search name from user
                    instructorName = JOptionPane.showInputDialog("Type an Instructor's Name: ");
                    // Get array of possible instructors matching the search name
                    instructorSearchResults = CourseRegistrationSystem.searchForInstructor(instructorName);
                    
                    if (instructorSearchResults.length == 0) {
                        // No results were found
                        JOptionPane.showMessageDialog(rootPane, instructorName + " was not found.", "Instructor Search", JOptionPane.WARNING_MESSAGE);
                    } else {
                        // Open InstructorWindow as instructorSearchResults[0]
                        InstructorWindow instructorWindow = new InstructorWindow(instructorSearchResults);
                        // Open InstructorWindow to display information
                        // NOTE: Set JFrame.DISPOSE_ON_CLOSE instead of JFRAME.EXIT_ON_CLOSE to avoid exiting program
                        instructorWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        instructorWindow.setSize(900, 900);
                        instructorWindow.setVisible(true);
                    }
                    
                    return "";
                    
                case 7:
                     // Get search name from user
                    courseName = JOptionPane.showInputDialog("Type a Course Name: ");
                    // Get array of possible courses matching the search name
                    courseSearchResults = CourseRegistrationSystem.searchForCourse(courseName);
                    
                    if (courseSearchResults.length == 0) {
                        // No results were found
                        JOptionPane.showMessageDialog(rootPane, courseName);
                    } else {
                        // Open InstructorWindow as courseSearchResults[0]
                        CourseWindow CourseWindow = new CourseWindow(courseSearchResults);
                        // Open Course Window to display information
                        // NOTE: Set JFrame.DISPOSE_ON_CLOSE instead of JFRAME.EXIT_ON_CLOSE to avoid exiting program
                        CourseWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        CourseWindow.setSize(900, 900);
                        CourseWindow.setVisible(true);
                    }
                    
                    return "";
                    
                case 8:
                    return "Student registered";
                case 9:
                    // Register an instructor with a course
                    // Get instructor name from user
                    instructorName = JOptionPane.showInputDialog("Type an Instructor's Name: ");
                    // Get array of possible instructors matching the search name
                    instructorSearchResults = CourseRegistrationSystem.searchForInstructor(instructorName);
                    
                    if (instructorSearchResults.length == 0) {
                        // No results were found
                        JOptionPane.showMessageDialog(rootPane, instructorName + " was not found.", "Instructor Search", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (instructorSearchResults.length > 1) {
                            // If multiple instructors match the search name, ask the user to pick one
                            selection = JOptionPane.showOptionDialog(null, "Select one of the following instructors: ", "Instructor Search", WIDTH, HEIGHT, null, instructorSearchResults,null);
                            instructor = instructorSearchResults[selection];
                        } else {
                            // If only one instructor matches the search name, set instructor
                            instructor = instructorSearchResults[0];
                        }
                        
                        // Get course name from user
                        courseName = JOptionPane.showInputDialog("Type the Name of a Course: ");
                        // Get array of possible courses matching the search name
                        courseSearchResults = CourseRegistrationSystem.searchForCourse(courseName);

                        if (courseSearchResults.length == 0) {
                            // No results were found
                            JOptionPane.showMessageDialog(null, courseName + " was not found.");
                        } else {
                            if (courseSearchResults.length > 1) {
                                // If multiple courses match the search name, ask the user to pick one
                                selection = JOptionPane.showOptionDialog(null, "Select one of the following instructors: ", "Instructor Search", WIDTH, HEIGHT, null, instructorSearchResults,null);
                                course = courseSearchResults[selection];
                            } else {
                                // If only one course matches the search name, set course
                                course = courseSearchResults[0];
                            }
                        }
                        
                        if (courseSearchResults.length >= 1)
                        try {
                            // Add course to instructor courseList
                            instructor.addCourse(course);
                            // Set instructor as Instructor for course
                            course.Instructor=instructor;
                            JOptionPane.showMessageDialog(null, instructor.Name + " was successfully registered as an instructor for " + course.getname());
                        }
                        catch(Exception e) {
                            JOptionPane.showMessageDialog(null, "Something went wrong. Please try again.", "Course Registration", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    
                    return "";
                case 10:
                    // Get search name from user
                    instructorName = JOptionPane.showInputDialog("Type an Instructor's Name: ");
                    // Get array of possible instructors matching the search name
                    instructorSearchResults = CourseRegistrationSystem.searchForInstructor(instructorName);
                    
                    if (instructorSearchResults.length == 0) {
                        // No results were found
                        JOptionPane.showMessageDialog(rootPane, instructorName + " was not found.", "Instructor Search", JOptionPane.WARNING_MESSAGE);
                    } 
                    
                    
                default:
                    return "How did you get this message";
            }
        }
    }
}
