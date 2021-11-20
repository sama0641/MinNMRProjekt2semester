package com.example.minnmrprojekt2semester.model;
import com.example.minnmrprojekt2semester.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //Den skal initialisere sig selv, hver gang fremfor Autowried
class MotorhomeTest {


    @Autowired
    JdbcTemplate jdbcTemplate;
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
        assertEquals(450,bookingRepository.read(1).getKm_driven());





    }

    @Test
    void determinePriceBySize() {
    }
}