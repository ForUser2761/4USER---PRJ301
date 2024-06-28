/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Coaches {

    private String CoachID;
    private String CoachName;
    private String Position;
    private int Salary;
    private int TeamID;

    public Coaches() {
    }

    public Coaches(String CoachID, String CoachName, String Position, int Salary, int TeamID) {
        this.CoachID = CoachID;
        this.CoachName = CoachName;
        this.Position = Position;
        this.Salary = Salary;
        this.TeamID = TeamID;
    }

    public String getCoachID() {
        return CoachID;
    }

    public void setCoachID(String CoachID) {
        this.CoachID = CoachID;
    }

    public String getCoachName() {
        return CoachName;
    }

    public void setCoachName(String CoachName) {
        this.CoachName = CoachName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int TeamID) {
        this.TeamID = TeamID;
    }
    
    
}
