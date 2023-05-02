// Update package name as needed
package edu.cs3700.courseregistrationsystem;

import javax.swing.JFrame;

/*
 * Author:  
 */

public class CourseRegistrationSystem {

    public static void main(String[] args) {
        MainWindow mWindow = new MainWindow();
        mWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mWindow.setSize(900, 900);
        mWindow.setVisible(true);
    }
}
