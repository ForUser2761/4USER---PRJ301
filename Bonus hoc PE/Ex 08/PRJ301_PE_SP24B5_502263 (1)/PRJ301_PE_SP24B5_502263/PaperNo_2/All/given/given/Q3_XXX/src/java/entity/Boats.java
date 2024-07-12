/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class Boats {
    private String BoatID;
    private String BoatName;
    private int Seat;
    private int Booked;
    private int DepartPlaceID;
    private int TicketID;

    public Boats() {
    }

    public Boats(String BoatID, String BoatName, int Seat, int Booked, int DepartPlaceID, int TicketID) {
        this.BoatID = BoatID;
        this.BoatName = BoatName;
        this.Seat = Seat;
        this.Booked = Booked;
        this.DepartPlaceID = DepartPlaceID;
        this.TicketID = TicketID;
    }

    public String getBoatID() {
        return BoatID;
    }

    public void setBoatID(String BoatID) {
        this.BoatID = BoatID;
    }

    public String getBoatName() {
        return BoatName;
    }

    public void setBoatName(String BoatName) {
        this.BoatName = BoatName;
    }

    public int getSeat() {
        return Seat;
    }

    public void setSeat(int Seat) {
        this.Seat = Seat;
    }

    public int getBooked() {
        return Booked;
    }

    public void setBooked(int Booked) {
        this.Booked = Booked;
    }

    public int getDepartPlaceID() {
        return DepartPlaceID;
    }

    public void setDepartPlaceID(int DepartPlaceID) {
        this.DepartPlaceID = DepartPlaceID;
    }

    public int getTicketID() {
        return TicketID;
    }

    public void setTicketID(int TicketID) {
        this.TicketID = TicketID;
    }

    @Override
    public String toString() {
        return "Boats{" + "BoatID=" + BoatID + ", BoatName=" + BoatName + ", Seat=" + Seat + ", Booked=" + Booked + ", DepartPlaceID=" + DepartPlaceID + ", TicketID=" + TicketID + '}';
    }
    
    
}
