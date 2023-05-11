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
import javax.swing.JComboBox;
/**
 *
 * @author Broxt
 */
public class AddNewItemWindow extends JFrame{
    //public final JLabel newItemNameLbl;
    //public final JTextField newItemNameTxt;
    private final JButton submitBtn;
    private final JButton cancelBtn;
    private final JLabel[] allLabels;
    private final JTextField[] allTextFields;
    
    private ButtonGroup radioGrp;
    private JRadioButton traditionalBtn;
    private JRadioButton onlineBtn;
    
    //private JCheckBox[] checkBoxes;
    
    public Program newProgram;
    public Student newStudent;
    public Instructor newInstructor;
    public Course newCourse;
    
    //New Program
    public AddNewItemWindow(Program program){
        super("Add New Program");
        FlowLayout fl = new FlowLayout();
        setLayout(fl);
        
        newProgram = program;
        
        allLabels = new JLabel[4];
        allTextFields = new JTextField[3];
        
        String[] lblText = {"New Program Name", "College", "Total Number of Credits", "Type:"};
        
        for (int i = 0; i < allLabels.length; i++){
            allLabels[i] = new JLabel(lblText[i]);
            Font myFont = new Font("Serif", Font.BOLD, 14);
            allLabels[i].setFont(myFont);
            add(allLabels[i]);
            
            if (i == 3){
                traditionalBtn = new JRadioButton("Traditional");
                add(traditionalBtn);
                onlineBtn = new JRadioButton("Online");
                add(onlineBtn);
                
                radioGrp = new ButtonGroup();
                radioGrp.add(traditionalBtn);
                radioGrp.add(onlineBtn);
                
            }
            else{
                allTextFields[i] = new JTextField(10);
                allTextFields[i].setFont(myFont);
                add(allTextFields[i]); 
            }
            
        }
        
        submitBtn = new JButton("Add");
        add(submitBtn);
        submitBtn.addMouseListener(new btnMouseHandler(2));
        
        cancelBtn = new JButton("Cancel");
        add(cancelBtn);
        cancelBtn.addMouseListener(new btnMouseHandler(1));
    }
    
    //New Student
    public AddNewItemWindow(Student student){
        super("Add New Student");
        FlowLayout fl = new FlowLayout();
        setLayout(fl);
        
        newStudent = student;
        
        allLabels = new JLabel[5];
        allTextFields = new JTextField[5];
        String[] lblText = {"New Student Name","Date of Birth", "Program", "Start Date", "Advisor"};
        
        for (int i = 0; i < allLabels.length; i++){
            allLabels[i] = new JLabel(lblText[i]);
            Font myFont = new Font("Serif", Font.BOLD, 14);
            allLabels[i].setFont(myFont);
            add(allLabels[i]);
        
            allTextFields[i] = new JTextField(10);
            allTextFields[i].setFont(myFont);
            add(allTextFields[i]);
        }
        
        submitBtn = new JButton("Add");
        add(submitBtn);
        submitBtn.addMouseListener(new btnMouseHandler(3));
        
        cancelBtn = new JButton("Cancel");
        add(cancelBtn);
        cancelBtn.addMouseListener(new btnMouseHandler(1));
    }
    
    //New Instructor
    public AddNewItemWindow(Instructor instructor){
        super("Add New Instructor");
        FlowLayout fl = new FlowLayout();
        setLayout(fl);
        
        newInstructor = instructor;
        
        allLabels = new JLabel[3];
        allTextFields = new JTextField[3];
        String[] lblText = {"New Instructor Name", "Date of Birth", "Program"};
        
        for (int i = 0; i < allLabels.length; i++){
            allLabels[i] = new JLabel(lblText[i]);
            Font myFont = new Font("Serif", Font.BOLD, 14);
            allLabels[i].setFont(myFont);
            add(allLabels[i]);
        
            allTextFields[i] = new JTextField(10);
            allTextFields[i].setFont(myFont);
            add(allTextFields[i]);
        }
        
        submitBtn = new JButton("Add");
        add(submitBtn);
        submitBtn.addMouseListener(new btnMouseHandler(4));
        
        cancelBtn = new JButton("Cancel");
        add(cancelBtn);
        cancelBtn.addMouseListener(new btnMouseHandler(1));
    }
    
    //New Course
    public AddNewItemWindow(Course course){
        super("Add New Course");
        FlowLayout fl = new FlowLayout();
        setLayout(fl);
        
        newCourse = course;
        
        allLabels = new JLabel[2];
        allTextFields = new JTextField[2];
        String[] lblText = {"New Course Name", "Program"};
        
        for (int i = 0; i < allLabels.length; i++){
            allLabels[i] = new JLabel(lblText[i]);
            Font myFont = new Font("Serif", Font.BOLD, 14);
            allLabels[i].setFont(myFont);
            add(allLabels[i]);
        
            allTextFields[i] = new JTextField(10);
            allTextFields[i].setFont(myFont);
            add(allTextFields[i]);
        }
        
        submitBtn = new JButton("Add");
        add(submitBtn);
        submitBtn.addMouseListener(new btnMouseHandler(5));
        
        cancelBtn = new JButton("Cancel");
        add(cancelBtn);
        cancelBtn.addMouseListener(new btnMouseHandler(1));
    }
    
    private void closeWindow(){
        this.dispose();
    }
    
    private class btnMouseHandler implements MouseListener{
        private final int btnClickedNum;
        
        public btnMouseHandler(int clickedBtnNum){
            btnClickedNum = clickedBtnNum;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (btnClickedNum){
                case 1:
                    closeWindow();
                    break;
                case 2:
                    String newProgramName = allTextFields[0].getText();
                    if (newProgramName.isBlank() || newProgramName.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Must enter a name for the program.");
                        break;
                    }
                    newProgram.Name = newProgramName;
                    
                    String collegeName = allTextFields[1].getText();
                    if (collegeName.isBlank() || collegeName.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Must enter a college name.");
                        break;
                    }
                    newProgram.College = collegeName;
                    
                    String selectedType = "";
                    if (traditionalBtn.isSelected()){
                        selectedType = traditionalBtn.getText();
                    }
                    if (onlineBtn.isSelected()){
                        selectedType = onlineBtn.getText();
                    }
                    
                    if (!selectedType.isEmpty()){
                        newProgram.setType(selectedType);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Please select a program type.");
                    }
                    
                    String enteredNumOfCredits = allTextFields[2].getText();
                    if (enteredNumOfCredits.isEmpty() || enteredNumOfCredits.isBlank()){
                        JOptionPane.showMessageDialog(null, "Please enter number of credits.");
                    }
                    int numOfCredits = Integer.parseInt(enteredNumOfCredits);
                    
                    newProgram.setNum_credits(numOfCredits);
                    
                    var tempProgramList = new Program[CourseRegistrationSystem.programs.length + 1];
                    
                    for (int i = 0; i < CourseRegistrationSystem.programs.length; i++){
                        tempProgramList[i] = CourseRegistrationSystem.programs[i];
                    }
                    
                    tempProgramList[tempProgramList.length-1] = newProgram;
                    
                    CourseRegistrationSystem.updateProgramList(tempProgramList); 
                    
                    JOptionPane.showMessageDialog(null, "Program added.");
                    closeWindow();
                    break;
                case 3:
                    
                    newStudent.Name = allTextFields[0].getText();
                    
                    var advisors = CourseRegistrationSystem.searchForInstructor(allTextFields[4].getText());
                    if (advisors.length < 1){
                        JOptionPane.showMessageDialog(null, allTextFields[4].getText() + " is not an advisor, please enter an existing advisor.");
                        break;
                    }
                    newStudent.advisor = advisors[0];
                    
                    String date = allTextFields[1].getText();
                    var splitDate = date.split("/");
                    
                    int month = Integer.parseInt(splitDate[0]);
                    int day = Integer.parseInt(splitDate[1]);
                    int year = Integer.parseInt(splitDate[2]);
                    
                    newStudent.DateOfBirth = new Date(day, month, year);
                    
                    var programs = CourseRegistrationSystem.programs;
                    var enteredProgram = allTextFields[2].getText();
                    for (Program program: programs){
                        if (program.Name.contains(enteredProgram) || program.Name.equals(enteredProgram)){
                            newStudent.CurrentProgram = program;
                            break;
                        }
                    }
                    if (newStudent.CurrentProgram.Name.isEmpty() || newStudent.CurrentProgram.Name.isBlank()) {
                        JOptionPane.showMessageDialog(rootPane, enteredProgram + " is not a program, please enter an existing program.");
                        break;
                    }
                    
                    date = allTextFields[3].getText();
                    splitDate = date.split("/");
                    month = Integer.parseInt(splitDate[0]);
                    day = Integer.parseInt(splitDate[1]);
                    year = Integer.parseInt(splitDate[2]);
                    newStudent.startDate = new Date(day, month, year);
                    
                    var newStudentList = new Student[CourseRegistrationSystem.students.length + 1];
                    
                    for (int i = 0; i<CourseRegistrationSystem.students.length; i++){
                        newStudentList[i] = CourseRegistrationSystem.students[i];
                    }
                    
                    newStudentList[newStudentList.length-1] = newStudent;
                    
                    CourseRegistrationSystem.updateStudentList(newStudentList);
                    
                    for (var student: CourseRegistrationSystem.students){
                        System.out.println(student.Name);
                    }
                    
                    JOptionPane.showMessageDialog(rootPane, newStudent.Name + " has been added.");
                    closeWindow();
                    break;
                case 4:
                    String enteredInstructorName = allTextFields[0].getText();
                    if (enteredInstructorName.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter a name for the instructor.");
                        break;
                    }
                    newInstructor.Name = enteredInstructorName;
                    
                    String enteredDOB = allTextFields[1].getText();
                    if (enteredDOB.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter DOB in MM/DD/YYYY format");
                        break;
                    }
                    String[] dateSplit = enteredDOB.split("/");
                    int newMonth = Integer.parseInt(dateSplit[0]);
                    int newDay = Integer.parseInt(dateSplit[1]);
                    int newYear = Integer.parseInt(dateSplit[2]);
                    newInstructor.DateOfBirth = new Date(newDay, newMonth, newYear);
                    
                    var storedPrograms = CourseRegistrationSystem.programs;
                    var programEntered = allTextFields[2].getText();
                    for (Program program: storedPrograms){
                        if (program.Name.contains(programEntered) || program.Name.equals(programEntered)){
                            newInstructor.CurrentProgram = program;
                            break;
                        }
                    }
                    
                    if (newInstructor.CurrentProgram.Name.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter an already existing program.");
                        break;
                    }
                    
                    var tempInstructorList = new Instructor[CourseRegistrationSystem.instructors.length +1];
                    for (int i = 0; i < CourseRegistrationSystem.instructors.length; i++){
                        tempInstructorList[i] = CourseRegistrationSystem.instructors[i];
                    }
                    
                    tempInstructorList[tempInstructorList.length-1] = newInstructor;
                    
                    CourseRegistrationSystem.updateInstructorList(tempInstructorList);
                    
                    JOptionPane.showMessageDialog(null, "Instructor Added.");
                    
                    closeWindow();
                    break;
                case 5:
                    String enteredCourseName = allTextFields[0].getText();
                    if (enteredCourseName.isEmpty() || enteredCourseName.isBlank()){
                        JOptionPane.showMessageDialog(null, "Please enter a name for the course");
                        break;
                    }
                    newCourse.name = enteredCourseName;
                    
                    var currentPrograms = CourseRegistrationSystem.programs;
                    var enteredProgramName = allTextFields[1].getText();
                    for (Program program: currentPrograms){
                        if (program.Name.contains(enteredProgramName) || program.Name.equals(enteredProgramName)){
                            newCourse.Program = program;
                            break;
                        }
                    }
                    
                    if (newCourse.Program.Name.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter an already existing program.");
                        break;
                    }
                    
                    var tempCourseList = new Course[CourseRegistrationSystem.courses.length + 1];
                    
                    for (int i = 0; i < CourseRegistrationSystem.courses.length; i++){
                        tempCourseList[i] = CourseRegistrationSystem.courses[i];
                    }
                    
                    tempCourseList[tempCourseList.length -1] = newCourse;
                    
                    CourseRegistrationSystem.updateCourseList(tempCourseList);
                    
                    closeWindow();
                    break;
            }
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
    }
    
}
