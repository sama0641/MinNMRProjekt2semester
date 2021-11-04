package com.example.minnmrprojekt2semester.model;

import com.example.minnmrprojekt2semester.repository.BookingRepository;
import com.example.minnmrprojekt2semester.services.CancellationCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MotorhomeTest {

    @Autowired
    BookingRepository bookingRepository;

    @Test
    void determinePriceBySeason() {
        Motorhome motorhome = new Motorhome(true, 100, "peak", "m", //arrange
                "Mercedes", "deluxe");

        motorhome.setIs_Available(false);   //act


        assertEquals(false,motorhome.isIs_Available());
        assertEquals(1600,motorhome.getMotorhomePrice()); //assert


        //Doesn't work!!
        assertEquals(450, bookingRepository.readOneBooking(1).getKmDriven());





    }

    @Test
    void determinePriceBySize() {
    }
}