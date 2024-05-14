/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Subjects {
    private String SubjectID;
    private String SubjectName;

    public Subjects() {
    }

    public Subjects(String SubjectID, String SubjectName) {
        this.SubjectID = SubjectID;
        this.SubjectName = SubjectName;
    }

    public String getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(String SubjectID) {
        this.SubjectID = SubjectID;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }

    @Override
    public String toString() {
        return "Subjects{" + "SubjectID=" + SubjectID + ", SubjectName=" + SubjectName + '}';
    }
    
    
}
