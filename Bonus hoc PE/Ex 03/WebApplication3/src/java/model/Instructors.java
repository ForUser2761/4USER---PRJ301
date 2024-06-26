/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Instructors {
    private int InstructorID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Phone;
    private String Gender;
    private Date BirthDate;

    public Instructors() {
    }

    public Instructors(int InstructorID, String FirstName, String LastName, String Email, String Phone, String Gender, Date BirthDate) {
        this.InstructorID = InstructorID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Phone = Phone;
        this.Gender = Gender;
        this.BirthDate = BirthDate;
    }

    public int getInstructorID() {
        return InstructorID;
    }

    public void setInstructorID(int InstructorID) {
        this.InstructorID = InstructorID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    @Override
    public String toString() {
        return "Instructors{" + "InstructorID=" + InstructorID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", Phone=" + Phone + ", Gender=" + Gender + ", BirthDate=" + BirthDate + '}';
    }
    
    
}
