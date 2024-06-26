/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Courses {
    private int CourseID;
    private String CourseName;
    private int CreditHours;
    private int ManageByInstructorID;

    public Courses() {
    }

    public Courses(int CourseID, String CourseName, int CreditHours, int ManageByInstructorID) {
        this.CourseID = CourseID;
        this.CourseName = CourseName;
        this.CreditHours = CreditHours;
        this.ManageByInstructorID = ManageByInstructorID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public int getCreditHours() {
        return CreditHours;
    }

    public void setCreditHours(int CreditHours) {
        this.CreditHours = CreditHours;
    }

    public int getManageByInstructorID() {
        return ManageByInstructorID;
    }

    public void setManageByInstructorID(int ManageByInstructorID) {
        this.ManageByInstructorID = ManageByInstructorID;
    }

    @Override
    public String toString() {
        return "Courses{" + "CourseID=" + CourseID + ", CourseName=" + CourseName + ", CreditHours=" + CreditHours + ", ManageByInstructorID=" + ManageByInstructorID + '}';
    }
    
    
}
