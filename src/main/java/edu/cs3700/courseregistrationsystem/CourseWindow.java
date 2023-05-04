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

/**
 *
 * @author jdcummings01_indt
 */
public class CourseWindow extends JFrame{
    private final JTextField text1;
    private final JTextField text2;
    private final JTextField text3;
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;
    private final JButton b;
    private Font plainFont;
    private Font boldFont;
    private Font italicFont;    
            
            public CourseWindow(){
            super("Add Course Window");
            FlowLayout fl = new FlowLayout();
            setLayout(fl);
        
        boldFont = new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        plainFont = new Font("Serif", Font.PLAIN, 14);
       
        label1 = new JLabel("Name of Course:");
        text1 = new JTextField(20);
        label2 = new JLabel("Program:");
        text2 = new JTextField(20);
        label3 = new JLabel("Instrutor:");
        text3 = new JTextField(20);
        b = new JButton("Submit");
            }
}
