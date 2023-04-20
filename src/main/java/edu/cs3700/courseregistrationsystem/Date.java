/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cs3700.courseregistrationsystem;

/**
 * Author: Rebekah Albrecht
 */
public class Date {
    // Variable declaration
    private int day; 
    private int month;
    private int year;
    
    // Full constructor
    public Date(int day, int month, int year) {
        setMonth(month);
        setYear(year);
        setDay(day);

    } // End constructor
    
    // Month, year constructor
    public Date(int month, int year) {
        this(1, month, year);
    } // End constructor
    
    // Year constructor
    public Date(int year) {
        this(1,1,year);
    } // End constructor
    
    // Default constructor
    public Date() {
        this(1,1,2000);
    }
    
    // Set and get methods
    public int setMonth(int month) {
        // month validation
        if (month >= 1 && month <= 12) {
            this.month = month;
            return 0;
        } else {
            return 1;
        }
    } // End method setMonth
    
    public int getMonth() {
        return month;
    } // End method getMonth
    
    public int setDay(int day) {
        //Check if month was successfully set
        if (setMonth(month) == 0) {
            // Day validation
            switch(month) {
                // February
                case 2:
                    // Check if year was successfuly set
                    if (setYear(year) == 0) {
                        // February has 29 days on leap years and 28 days otherwise
                        if ((year%4 == 0 && month > 29) || month > 28) {
                            return 1;
                        }
                    } else {
                        // If year was not successfuly set, days in February cannot be validated
                        return 1;
                    }
                        
                    // Exit switch statement
                    break;
                    
                // Months with 31 days
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day > 31) {
                        return 1;
                    }
                    
                    // Exit switch statement
                    break;
                    
                // All other months have 30 days
                default:
                    if (day > 30) {
                        return 1;
                    }
            } // End switch(month)
            
            // If switch statement did not result in exiting the function, day is validated
            this.day = day;
            return 0;
        } else {
            // If month was not successfully set, day cannot be successfuly set
            return 1;
        }
    } // End method setDay
    
    public int getDay() {
        return day;
    } // End method getDay
    
    public int setYear(int year) {
        // year validation
        // Assumes years before 2000 are irrelevant and the system will be used indefinitely far in the future
        if (year >= 2000) {
            this.year = year;
            return 0;
        } else {
            return 1;
        }
    } // End method setYear
    
    public int getYear() {
        return year;
    } // End method getYear
}
