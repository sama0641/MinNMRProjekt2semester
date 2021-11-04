package com.example.minnmrprojekt2semester.model;

public class Motorhome {
    private int id; //max -128 op til +127 = 128 inkl. 0 (1byte int4byte)
    private boolean is_Available; //primitiv datatype ifh plads ej et objekt
    private double pricePerDay;
    private String season;
    private String size_category;
    private String brand_name;
    private String model_name;
    private double motorhomePrice;

    public Motorhome (boolean is_Available, double pricePerDay, String season, String size_category,
                      String motorhome_brand, String model_name) {

        this.is_Available = is_Available;
        this.pricePerDay = pricePerDay;
        this.season = season;
        this.size_category = size_category;
        this.brand_name = motorhome_brand;
        this.model_name = model_name;
        determinePriceBySize();//kalder metoden inde i constrocturen og til sidst tjekker og afgør, hvad pricebysize er for MH
        determinePriceBySeason();
    }

    public Motorhome() { //default cosntructor

    }

    public void determinePriceBySeason () {
        if (this.season.equalsIgnoreCase("Low")) {
            this.motorhomePrice = motorhomePrice * 1;
        }

        else if (this.season.equalsIgnoreCase("Middle")) {
            this.motorhomePrice = motorhomePrice * 1.3;
        }

        else if (this.season.equalsIgnoreCase("Peak")) {
            this.motorhomePrice = motorhomePrice * 1.6;
        }

    }

    public void determinePriceBySize () {

        if (this.size_category.equalsIgnoreCase("S")) {
            this.motorhomePrice = 500;
        }

        else if (this.size_category.equalsIgnoreCase("M")) {
            this.motorhomePrice = 1000;
        }

        else if (this.size_category.equalsIgnoreCase("L")) {
            this.motorhomePrice = 1500;
        }

        else {
            this.motorhomePrice = 0;
        }
    }

    public double getMotorhomePrice() {
        return motorhomePrice;
    }

    public void setMotorhomePrice(double motorhomePrice) {
        this.motorhomePrice = motorhomePrice;
    }

    public boolean isIs_Available() {
        return is_Available;
    } //getter

    public void setIs_Available(boolean is_Available) { this.is_Available = is_Available; }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getSize_category() {
        return size_category;
    }

    public void setSize_category(String size_category) {
        this.size_category = size_category;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String motorhome_brand) {
        this.brand_name = motorhome_brand;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String motorhome_model) {
        this.model_name = motorhome_model;
    }

    @Override
    public String toString () {
        return "id: "+ getId()+ " is it available? "+ isIs_Available()+ " price per day: "+ getPricePerDay()+ " size: "+
                getSize_category()+ " season: "+ getSeason()+ " brand: "+ getBrand_name()+ " model: "+ getModel_name();
    }

}


