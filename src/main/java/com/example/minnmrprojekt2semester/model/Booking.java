package com.example.minnmrprojekt2semester.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
    private int id;
    private String bookedAt;
    private String returnedAt;
    private int kmDriven;
    private boolean isHalfFull;
    private boolean isClean;
    private int employeeId;
    private int customerId;
    private int motorhomeId;

    public Booking() {

    }


    public Booking(String bookedAt, String returnedAt, int kmDriven, boolean isHalfFull, boolean isClean,
                   int employeeId, int customerId, int motorhomeId) {
        this.bookedAt = bookedAt;
        this.returnedAt = returnedAt;
        this.kmDriven = kmDriven;
        this.isHalfFull = isHalfFull;
        this.isClean = isClean;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.motorhomeId = motorhomeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id;}

    public String getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(String bookedAt) {
        this.bookedAt = bookedAt;
    }

    public String getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(String returnedAt) {
        this.returnedAt = returnedAt;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }

    public boolean isHalfFull() {
        return isHalfFull;
    }

    public void setIsHalfFull(boolean halfFull) {
        this.isHalfFull = halfFull;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setIsClean(boolean clean) {
        this.isClean = clean;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMotorhomeId() {
        return motorhomeId;
    }

    public void setMotorhomeId(int motorhomeId) {
        this.motorhomeId = motorhomeId;
    }

    @Override
    public String toString() {
        return " Booking id: "+ getId()+ " Booked at: "+getBookedAt()+ " Returned at "+ getReturnedAt()+
                "Total km driven: "+getKmDriven()+ " Tank is half full: "+ isHalfFull()+ " Motorhome is clean "+isClean()+
                " Order assigned to employee: "+getEmployeeId()+ " Customer id: "+ getCustomerId()+ " Motorhome id: "+getMotorhomeId();
    }






}


