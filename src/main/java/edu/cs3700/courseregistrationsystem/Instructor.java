// Update package name as needed
package edu.cs3700.courseregistrationsystem;

/**
 * Author: Rebekah Albrecht
 */
public class Instructor extends Person {
    // Declare variables
    public Student[] advisees;
    
    // Full constructor
    public Instructor(String name, Date dateOfBirth, Program program, Course[] courseList, Student[] studentList) {
        super(name, dateOfBirth, program, courseList);
        advisees = studentList;
    } // End constructor
    
    // Constructor with only person attributes
    public Instructor(String name, Date dateOfBirth, Program program, Course[] courseList) {
        this(name, dateOfBirth, program, courseList, null);
    }
    
    // Name, date of birth constructor
    public Instructor(String name, Date dateOfBirth, Program program) {
        this(name, dateOfBirth, program, null, null);
    } // End constructor
    
    // Default constructor
    public Instructor() {
        this("Unknown", null, null, null, null);
    } // End constructor
    
    // Method to add a course
    public void addCourse(Course course) {
        if (CourseList != null) {
            // Increase size by creating temp array
            Course[] temp = new Course[CourseList.length + 1];
            // Copy into temp array
            for (int i=0; i<CourseList.length; i++) {
                temp[i] = CourseList[i];
            }
            // Add new course to temp array
            temp[CourseList.length] = course;
            // Set temp as CourseList
            CourseList = temp;
        } else {
            CourseList = new Course[] {course};
        }
    } // End method addCourse
    
    // Method to add an advissee
    public void addAdvisee(Student student) {
        if (advisees != null) {
            // Increase size by creating temp array
            Student[] temp = new Student[advisees.length + 1];
            // Copy into temp array
            for (int i=0; i<advisees.length; i++) {
                temp[i] = advisees[i];
            }
            // Add new course to temp array
            temp[advisees.length] = student;
            // Set temp as CourseList
            advisees = temp;
        } else {
            advisees = new Student[] {student};
        }
    } // End method addAdvisee
    
    // toString method used to select individual instructor from search results
    @Override
    public String toString() {
        return Name + ", DOB: " + DateOfBirth.toString();
    }
    
    public String instructorCoursesToString() {
        if (CourseList == null) {
            return "N/A";
        } else {
            // Get names of all courses
            String str = "";
            for (Course inst: CourseList) {
                if (inst instanceof Course) {
                    str += inst.getname() + ", ";
                }
            }

            // Trim comma from end
            //str = str.substring(0, (CourseList.length-2));
            return str;
        }
    }
    
    public String instructorAdviseesToString() {
        if (advisees == null) {
            return "N/A";
        } else {
            // Get names of all advisees
            String str = "";
            for (Student inst: advisees) {
                if (inst instanceof Student) {
                    str += inst.toString() + ", ";
                }
            }

            // Trim comma from end
            //str = str.substring(0, advisees.length-2);
            return str;
        }
    }
    
}
