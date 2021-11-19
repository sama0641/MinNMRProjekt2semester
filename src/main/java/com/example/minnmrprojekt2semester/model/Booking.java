package com.example.minnmrprojekt2semester.model;

public class Booking {
    private int id;
    private String booked_at;
    private String returned_at;
    private int km_driven;
    private boolean is_half_full;
    private boolean is_clean;
    private int employee_id;
    private int customer_id;
    private int motorhome_id;
    private double price;


    public Booking() {

    }


    public Booking(String booked_at, String returned_at, int km_driven, boolean is_half_full, boolean is_clean,
                   int employee_id, int customer_id, int motorhome_id) {
        this.booked_at = booked_at;
        this.returned_at = returned_at;
        this.km_driven = km_driven;
        this.is_half_full = is_half_full;
        this.is_clean = is_clean;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.motorhome_id = motorhome_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id;}

    public String getBooked_at() {
        return booked_at;
    }

    public void setBooked_at(String booked_at) {
        this.booked_at = booked_at;
    }

    public String getReturned_at() {
        return returned_at;
    }

    public void setReturned_at(String returned_at) {
        this.returned_at = returned_at;
    }

    public int getKm_driven() {
        return km_driven;
    }

    public void setKm_driven(int km_driven) {
        this.km_driven = km_driven;
    }

    public boolean isIs_half_full() {
        return is_half_full;
    }

    public void setIsHalfFull(boolean halfFull) {
        this.is_half_full = halfFull;
    }

    public boolean isIs_clean() {
        return is_clean;
    }

    public void setIsClean(boolean clean) {
        this.is_clean = clean;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getMotorhome_id() {
        return motorhome_id;
    }

    public void setMotorhome_id(int motorhome_id) {
        this.motorhome_id = motorhome_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " Booking id: "+ getId()+ " Booked at: "+ getBooked_at()+ " Returned at "+ getReturned_at()+
                "Total km driven: "+ getKm_driven()+ " Tank is half full: "+ isIs_half_full()+ " Motorhome is clean "+ isIs_clean()+
                " Order assigned to employee: "+ getEmployee_id()+ " Customer id: "+ getCustomer_id()+ " Motorhome id: "+ getMotorhome_id();
    }






}


