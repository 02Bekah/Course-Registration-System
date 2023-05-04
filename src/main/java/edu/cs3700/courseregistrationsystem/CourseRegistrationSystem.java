// Update package name as needed
package edu.cs3700.courseregistrationsystem;

import javax.swing.JFrame;

/*
 * Author:  
 */

public class CourseRegistrationSystem {
    // Instructor array
    public static Instructor[] instructors = new Instructor[100];

    public static void main(String[] args) {
        MainWindow mWindow = new MainWindow();
        mWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mWindow.setSize(900, 900);
        mWindow.setVisible(true);
    }
    
    public void populateInstructor() {
        instructors[0] = new Instructor("Jackson Blakely", new Date(05,1,1990));
        instructors[1] = new Instructor("Clementine Blakely", new Date(22,2,1992));
        instructors[2] = new Instructor("Joshua Clark", new Date(18,9,1950));
        instructors[3] = new Instructor("Ashley Miller", new Date(30,12,1969));
    }
}
