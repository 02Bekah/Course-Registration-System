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
            switch(btnClickedNum){
                case 1:
                    return "Program Added";
                case 2:
                    return "Student Added";
                case 3:
                    return "Instructor Added";
                case 4:
                    return "Course Added";
                default:
                    return "How did you get this message";
            }
        }
    }
}
