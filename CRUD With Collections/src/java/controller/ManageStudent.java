/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ManageStudent {

    public static List<Student> list = new ArrayList<>();

    public List<Student> getList() {
        return list;
    }
    
    public void add(Student student) {
        list.add(student);
    }
}
