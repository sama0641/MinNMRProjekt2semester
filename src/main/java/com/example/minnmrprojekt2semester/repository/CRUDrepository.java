package com.example.minnmrprojekt2semester.repository;
import com.example.minnmrprojekt2semester.model.Customer;
import java.util.List;

public interface CRUDrepository<T> { //hvis klasse>implements  + fx <List> som kan være int, String mm.
                                  //T for en generisk type, vores tilfælde er det models/entities
    //Create
    void create (T t);

    //Read
    T read (int ID);

    //Read all
    List<T> readAll ();    //Collection kaldes og skal indeholde T + hvis parameter er tomt er default ufilteret dvs alt

    //Update
    void update (T t);

    //Delete
    void delete (T t);

}
