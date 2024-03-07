/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Instructor {
    private String insid;
    private String name;
    private Date dob;
    private int gender;
    private String subid;

    public Instructor() {
    }

    public Instructor(String insid, String name, Date dob, int gender, String subid) {
        this.insid = insid;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.subid = subid;
    }

    public String getInsid() {
        return insid;
    }

    public void setInsid(String insid) {
        this.insid = insid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getSubid() {
        return subid;
    }

    public void setSubid(String subid) {
        this.subid = subid;
    }
    
}
