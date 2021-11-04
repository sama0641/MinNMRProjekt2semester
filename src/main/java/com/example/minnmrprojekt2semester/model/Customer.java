package com.example.minnmrprojekt2semester.model;

public class Customer {
    private int id;
    private String customer_name;
    private String customer_phone_number;
    private String customer_mail;

    public Customer(String name, String mail, String phoneNumber) {
        this.customer_name = name;
        this.customer_mail = mail;
        this.customer_phone_number = phoneNumber;

    } //tom constructer beacuse.. idk why

    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone_number() {
        return customer_phone_number;
    }

    public void setCustomer_phone_number(String customer_phone_number) {
        this.customer_phone_number = customer_phone_number;
    }

    public String getCustomer_mail() {
        return customer_mail;
    }

    public void setCustomer_mail(String customer_mail) {
        this.customer_mail = customer_mail;
    }

    @Override
    public String toString () {
        return "Customer id: "+ getId()+ "Customer name: "+getCustomer_name()+ "Customer phone number: "+ getCustomer_phone_number()+
                "Customer email: "+getCustomer_mail ();
    }


}

