// Update package name as neededpackage edu.cs3700.courseregistrationsystem;

/**
 * Author: Rebekah Albrecht
 */
public class Instructor extends Person {
    // Variable declaration
    public Student[] advisees;
    
    // Full constructor
    public Instructor(String name, Date dateOfBirth, Program program, Course[] courseList, Student[] studentList) {
        super(name, dateOfBirth, program, courseList);
        advisees = studentList;
    } // End constructor
    
    // Constructor with only person attributes
    public Instructor(String name, Date dateOfBirth, Program program, Course[] courseList) {
        this(name, dateOfBirth, program, courseList, null);
    } // End constructor
    
    // Name, date of birth constructor
    public Instructor(String name, Date dateOfBirth) {
        this(name, dateOfBirth, null, null, null);
    } // End constructor
    
    // Default constructor
    public Instructor() {
        this("Unknown", null, null, null, null);
    } // End constructor
    
    // Method to add a course
    public void addCourse(Course course) {
        Course[] temp = new Course[CourseList.Count + 1];
        CourseList = temp;
    } // End method addCourse
    
    // Method to add an advissee
    public void addAdvisee(Student student) {
        Student[] temp = new Student[advisees.Count + 1];
        advisees = temp;
    } // End method addAdvisee
}
