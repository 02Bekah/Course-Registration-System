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
    //TODO (Bekah):
    // Add Program
    // Add Course list
    // Add Student list
    // Clean up output
    
    
    public InstructorWindow() {
        super("Search for Instructor");
        
        FlowLayout instructorFL = new FlowLayout();
        setLayout(instructorFL);
        
        instructorInfoFont = new Font("Serif", Font.PLAIN, 14);
        instructorTitleFont = new Font("Serif", Font.BOLD,14);
    }
    
    
    public InstructorWindow(Instructor[] searchResults) {
        this();
        
        // Array of JLabels for instructor names
        JLabel[] instructorNameLbls = new JLabel[searchResults.length];
        // Array of JLabels for instructor date of births
        JLabel[] instructorDOBLbls = new JLabel[searchResults.length];
        
        // Initialize title labels
        instructorNameTitleLbl = new JLabel("Name: ");
        instructorNameTitleLbl.setFont(instructorTitleFont);
        instructorDOBTitleLbl = new JLabel("Date of Birth: ");
        instructorDOBTitleLbl.setFont(instructorTitleFont);
        
        for (int i=0; i<searchResults.length; i++) {
            // Name title label
            add(instructorNameTitleLbl);
            // Initialize instructor name label
            instructorNameLbls[i] = new JLabel(searchResults[i].Name, SwingConstants.CENTER);
            instructorNameLbls[i].setFont(instructorInfoFont);
            add(instructorNameLbls[i]);
            // Date of birth title label
            add(instructorDOBTitleLbl);
            // Initialize instructor date of birth label
            instructorDOBLbls[i] = new JLabel(searchResults[i].DateOfBirth.toString(),SwingConstants.CENTER);
            instructorDOBLbls[i].setFont(instructorInfoFont);
            add(instructorDOBLbls[i]);
        }
    }
}
