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
        
        public void findInstructors() {
            String instructorName;
            Instructor[] instructorSearchResults;
            
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
                instructorWindow.setSize(195, 400);
                instructorWindow.setVisible(true);
            }
        }
        
        public Instructor findInstructor() {
            String instructorName;
            Instructor[] instructorSearchResults;
            Instructor instructor = null;
            int selection;
            
            // Get search name from user
            instructorName = JOptionPane.showInputDialog("Type an Instructor's Name: ");
            // Get array of possible instructors matching the search name
            instructorSearchResults = CourseRegistrationSystem.searchForInstructor(instructorName);
                    
            switch(instructorSearchResults.length) {
                case 0:
                    // No results were found
                    JOptionPane.showMessageDialog(rootPane, instructorName + " was not found.", "Instructor Search", JOptionPane.WARNING_MESSAGE);
                    break;
                case 1:
                    // If only one instructor matches the search name, set instructor
                    instructor = instructorSearchResults[0];
                    break;
                default:
                    // If multiple instructors match the search name, ask the user to pick one
                    selection = JOptionPane.showOptionDialog(null, "Select one of the following instructors: ", "Instructor Search", WIDTH, HEIGHT, null, instructorSearchResults,null);
                    instructor = instructorSearchResults[selection];
            }
            
            return instructor;
        }
        
        public void findCourses() {
            String courseName;
            Course[] courseSearchResults;
            
            // Get search name from user
            courseName = JOptionPane.showInputDialog("Type a Course Name: ");
            // Get array of possible courses matching the search name
            courseSearchResults = CourseRegistrationSystem.searchForCourse(courseName);
                    
            if (courseSearchResults.length == 0) {
                // No results were found
                JOptionPane.showMessageDialog(rootPane, courseName + " was not found", "Course Search", JOptionPane.WARNING_MESSAGE);
            } else {
                // Open InstructorWindow as courseSearchResults[0]
                CourseWindow CourseWindow = new CourseWindow(courseSearchResults);
                // Open Course Window to display information
                // NOTE: Set JFrame.DISPOSE_ON_CLOSE instead of JFRAME.EXIT_ON_CLOSE to avoid exiting program
                CourseWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                CourseWindow.setSize(195, 400);
                CourseWindow.setVisible(true);
            }
        }
        
        public Course findCourse() {
            String courseName;
            Course[] courseSearchResults;
            Course course = null;
            int selection;
            
            // Get course name from user
            courseName = JOptionPane.showInputDialog("Type the Name of a Course: ");
            // Get array of possible courses matching the search name
            courseSearchResults = CourseRegistrationSystem.searchForCourse(courseName);
            
            switch(courseSearchResults.length) {
                case 0:
                    // No results were found
                    JOptionPane.showMessageDialog(null, courseName + " was not found", "Course Search", JOptionPane.WARNING_MESSAGE);
                    break;
                case 1:
                    // If only one course matches the search name, set course
                    course = courseSearchResults[0];
                    break;
                default:
                    // If multiple courses match the search name, ask the user to pick one
                    selection = JOptionPane.showOptionDialog(null, "Select one of the following courses: ", "Course Search", WIDTH, HEIGHT, null, courseSearchResults,null);
                    course = courseSearchResults[selection];
            }
            
            return course;
        }
        
        public void findStudents() {
            String studentName;
            Student[] studentSearchResults;
            
            // Get search name from user
            studentName = JOptionPane.showInputDialog("Type The Student's Name: ");
            // Get array of possible students matching the search name
            studentSearchResults = CourseRegistrationSystem.searchForStudent(studentName);
                    
            if (studentSearchResults.length == 0) {
                // No results were found
                JOptionPane.showMessageDialog(null, studentName + " was not found", "Student Search", JOptionPane.WARNING_MESSAGE);
            } else {
                // Open studentWindow as studentSearchResults[0]
                StudentWindow StudentWindow = new StudentWindow(studentSearchResults);
                // Open student Window to display information
                // NOTE: Set JFrame.DISPOSE_ON_CLOSE instead of JFRAME.EXIT_ON_CLOSE to avoid exiting program
                StudentWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                StudentWindow.setSize(195, 400);
                StudentWindow.setVisible(true);
            }
        }
        
        public Student findStudent() {
            String studentName;
            Student[] studentSearchResults;
            Student student = null;
            int selection;
            
            // Get student name from user
            studentName = JOptionPane.showInputDialog("Type the Name of a Student: ");
            // Get array of possible students matching the search name
            studentSearchResults = CourseRegistrationSystem.searchForStudent(studentName);
            
            switch(studentSearchResults.length) {
                case 0:
                    // No results were found
                    JOptionPane.showMessageDialog(null, studentName + " was not found", "Course Search", JOptionPane.WARNING_MESSAGE);
                    break;
                case 1:
                    // If only one student matches the search name, set student
                    student = studentSearchResults[0];
                    break;
                default:
                    // If multiple students match the search name, ask the user to pick one
                    selection = JOptionPane.showOptionDialog(null, "Select one of the following students: ", "Student Search", WIDTH, HEIGHT, null, studentSearchResults,null);
                    student = studentSearchResults[selection];
            }
            
            return student;
        }
        
        private String getMessageText(){
            // Initialize variables with default values
            Instructor instructor = null;
            Course course = null;
            Student student = null;
        
            switch(btnClickedNum){
                case 1:
                    Program newProgram = new Program();
                    AddNewItemWindow addNewProgramWindow = new AddNewItemWindow(newProgram);
                    
                    addNewProgramWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    addNewProgramWindow.setSize(900,300);
                    addNewProgramWindow.setVisible(true);
                    return "";
                case 2:
                    Student newStudent = new Student();
                    AddNewItemWindow addNewStudentWindow = new AddNewItemWindow(newStudent);
                    
                    addNewStudentWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    addNewStudentWindow.setSize(1000,300);
                    addNewStudentWindow.setVisible(true);
                    return "";
                case 3:
                    Instructor newInstructor = new Instructor();
                    AddNewItemWindow addNewInstructorWindow = new AddNewItemWindow(newInstructor);
                    
                    addNewInstructorWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    addNewInstructorWindow.setSize(1000, 300);
                    addNewInstructorWindow.setVisible(true);
                    return "";
                case 4:
                    Course newCourse = new Course();
                    AddNewItemWindow addNewCourseWindow = new AddNewItemWindow(newCourse);
                    
                    addNewCourseWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    addNewCourseWindow.setSize(1000, 300);
                    addNewCourseWindow.setVisible(true);
                    return "";
                case 5:
                    findStudents();
                    return "Student Search Completed";
                case 6:
                    findInstructors();
                    return "Instructor Search Completed";
                case 7:
                     findCourses();
                    return "Course Search Completed";
                case 8:
                    student = findStudent();
                    course = findCourse();
                    
                    if (student != null && course != null) {
                        try {
                            // Add course to student courseList
                            student.addCourse(course);
                            // Add student to course studentList
                            course.addStudent(student);
                            
                            return student.Name + " was successfully registered for " + course.getname();
                        }
                        catch(Exception e) {
                            return "Something went wrong. Please try again.";
                        }
                    } else {
                        return "Something went wrong. Please try again.";
                    }
                case 9:
                    // Register an instructor with a course
                    
                    instructor = findInstructor();
                    course = findCourse();
                    if (instructor != null && course != null) {
                        try {
                            // Add course to instructor courseList
                            instructor.addCourse(course);
                            // Set instructor as Instructor for course
                            course.Instructor=instructor;
                            
                            return instructor.Name + " was successfully registered as the instructor for " + course.getname();
                        }
                        catch(Exception e) {
                            return "Something went wrong. Please try again.";
                        } 
                    } else {
                        return "Something went wrong. Please try again.";
                    }
                case 10:
                    // Assign advisee
                    instructor = findInstructor();
                    student = findStudent();
                    
                    if (instructor != null && student != null) {
                        try {
                            // Add student to list of instructor advisees
                            instructor.addAdvisee(student);
                            
                            // Set instructor as advisor for student
                            student.advisor=instructor;
                            
                            return instructor.Name + " was successfully added as an advisor for " + student.Name;
                            }
                            catch(Exception e) {
                                return "Something went wrong. Please try again.";
                            }
                        }
                default:
                    return "How did you get this message";
            }
        }
    }
}
