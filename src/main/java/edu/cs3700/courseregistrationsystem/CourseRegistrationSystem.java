// Update package name as needed
package edu.cs3700.courseregistrationsystem;

import javax.swing.JFrame;

/*
 * Author:  
 */

public class CourseRegistrationSystem {
    // Instructor array
    public static Instructor[] instructors = new Instructor[100];
    public static Student[] students = new Student[100];
    public static Course[] courses = new Course[100];
    public static Program[] programs = new Program[100];
    public static int instructorCount = 5;
    public static int studentCount = 2;
    public static int courseCount = 4;
    public static int programCount = 2;

    public static void main(String[] args) {
        MainWindow mWindow = new MainWindow();
        mWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mWindow.setSize(900, 900);
        mWindow.setVisible(true);
        
        // Add sample data
        populateProgram();
        populateCourse();
        populateInstructor();
        populateStudent();
        
    }
    
    public static void populateInstructor() {
        instructors[0] = new Instructor("Jackson Blakely", new Date(05,1,1990), programs[0]);
        instructors[1] = new Instructor("Clementine Blakely", new Date(22,2,1992), programs[1]);
        instructors[2] = new Instructor("Joshua Clark", new Date(18,9,1950), programs[1], new Course[] {courses[3]});
        instructors[3] = new Instructor("Ashley Miller", new Date(30,12,1969), programs[0], new Course[] {courses[0]});
        instructors[4] = new Instructor("Ashley Miller", new Date(01,9,1985), programs[1]);
    }
    
    public static void populateStudent() {
        Course[] clist1 = {courses[2], courses[3]};
        Course[] clist2 = {courses[0], courses[1]};
        
        students[0] = new Student("Jacob Wilde", new Date(02,1,2004), programs[1], clist1, new Date(8,19,2022), instructors[1] );
        students[1] = new Student("Ariana Baker", new Date(15,6,2002), programs[0], clist2, new Date(8,17,2020), instructors[3] );
    }
    
    public static void populateCourse() {
        courses[0] = new Course("Object Orientation", programs[0], instructors[0]);
        courses[1] = new Course("Database Systems", programs[0], instructors[3]);
        courses[2] = new Course("Engineering Communication", programs[1], instructors[4]);
        courses[3] = new Course("Interpretation of Fiction", programs[1], instructors[1]);
    }
    
    public static void populateProgram() {
        programs[0] = new Program("Computer Science", "Computer Science & Engineering", "Traditional", 160);
        programs[1] = new Program("English", "Arts & Sciences", "Traditional", 150);
    }
    
    public static Instructor[] searchForInstructor(String name) {
        // Array of instructors that could match the search name
        Instructor[] searchResults = new Instructor[instructors.length];
        // Counter for instructorSearchResults
        int co = 0;
        
        for(Instructor inst: instructors) {
            if (inst instanceof Instructor && inst.Name.contains(name)) {
                // Add instructor to list of search results
                searchResults[co] = inst;
                // Update counter
                co += 1;
            }
        }
        
        // Create a condensed Instructor array without excess space
        Instructor[] instructorSearchResults = new Instructor[co];
        // Copy search results into instructorSearchResults
        for (int i=0; i<co; i++) {
            instructorSearchResults[i] = searchResults[i];
        }
        return instructorSearchResults;
        
    } // End method searchForInstructor
    
    public static Course[] searchForCourse(String name) {
        // Array of courses that could match the search name
        Course[] searchResults = new Course[courses.length];
        // Counter for courseSearchResults
        int co = 0;
        
        for(Course inst: courses) {
            if (inst instanceof Course && inst.name.contains(name)) {
                // Add course to list of search results
                searchResults[co] = inst;
                // Update counter
                co += 1;
            }
        }
        
        // Create a condensed Course array without excess space
        Course[] courseSearchResults = new Course[co];
        // Copy search results into courseSearchResults
        System.arraycopy(searchResults, 0, courseSearchResults, 0, co);
        
        return courseSearchResults;
    } // End method searchForCourse
        
    public static Student[] searchForStudent(String name) {
        // Array of instructors that could match the search name
        Student[] searchResults = new Student[students.length];
        // Counter for instructorSearchResults
        int co = 0;
        
        for(Student inst: students) {
            if (inst instanceof Student && inst.Name.contains(name)) {
                // Add student to list of search results
                searchResults[co] = inst;
                // Update counter
                co += 1;
            }
        }
        
        // Create a condensed Student array without excess space
        Student[] studentSearchResults = new Student[co];
        // Copy search results into studenSearchResults
        for (int i=0; i<co; i++) {
            studentSearchResults[i] = searchResults[i];
        }
        
        return studentSearchResults;
    } // End method searchForStudent
    
    public static void updateStudentList(Student newStudent){
        students[studentCount] = newStudent;
        studentCount++;
        
    }
    
    public static void updateProgramList(Program newProgram){
        programs[programCount] = newProgram;
        programCount++;
    }
    public static void updateCourseList(Course newCourse){
        courses[courseCount] = newCourse;
        courseCount++;
        
    }
    public static void updateInstructorList(Instructor newInstructor){
        instructors[instructorCount] = newInstructor;
        instructorCount++;
        
    }
} // End class CourseRegistrationSystem
