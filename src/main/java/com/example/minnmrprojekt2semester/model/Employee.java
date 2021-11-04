package com.example.minnmrprojekt2semester.model;

public class Employee {
    //private således at set kun kan ændre værdi, kun get kan hente værdi (indkapsulering husk det med klasser)
    private int id;
    private String jobtitle;
    private String employee_name;

    //contructor giver værdi til dens fields ved oprettelse af emmplyoee
    public Employee (int id, String jobTitle, String name) {
        this.id = id;
        this.jobtitle = jobTitle;
        this.employee_name = name;

    }

    public Employee() {

    }


    public int getId() { //hente er nødvendigt
        return id;
    }
    public void setId(int id) { //ændre om nødvendig
        this.id = id;
    }

    public String getJobtitle() { //hente er nødvendigt
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) { //ændre om nødvendig
        this.jobtitle = jobtitle;
    }

    public String getEmployee_name() { //hente er nødvendigt
        return employee_name;
    }

    public void setEmployee_name(String name) { //ændre om nødvendig
        this.employee_name = name;
    }

    @Override
    public String toString () {
        return "Employee id: "+ getId()+ "Job title "+ getJobtitle()+ "Employee name: "+ getEmployee_name();
    }



}
