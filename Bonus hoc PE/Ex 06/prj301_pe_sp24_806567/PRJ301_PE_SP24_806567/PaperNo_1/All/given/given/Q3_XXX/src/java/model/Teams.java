/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Teams {
    private int TeamID;
    private String TeamName;

    public Teams() {
    }

    public Teams(int TeamID, String TeamName) {
        this.TeamID = TeamID;
        this.TeamName = TeamName;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int TeamID) {
        this.TeamID = TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String TeamName) {
        this.TeamName = TeamName;
    }
    
    
}
