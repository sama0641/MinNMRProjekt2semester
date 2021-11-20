package com.example.minnmrprojekt2semester.services;
import com.example.minnmrprojekt2semester.model.Booking;
import com.example.minnmrprojekt2semester.model.Motorhome;
import com.example.minnmrprojekt2semester.repository.BookingRepository;
import com.example.minnmrprojekt2semester.repository.MotorhomeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CancellationCalculator {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MotorhomeRepository motorhomeRepository;


  public void cancelBooking (int bookingId) {
        //Find booking
        Booking tempCustomerBooking = bookingRepository.read(bookingId);//bookingobjekt=customerBooking > den ved hvilken ID det er grundet metoden
      //kalde metoden og vise den nye pris
        PriceCalculator priceCalculator = new PriceCalculator(); //opretter en isntans af Priceklassen
        priceCalculator.calculateCancellationPrice(tempCustomerBooking); //kalder metoden på instansen i stedet for klassen
                                                                         //for at undgå static (den samme sted i hukkommelse)

       //Change motorhome status to available
       int motorhomeID = tempCustomerBooking.getMotorhome_id();
       Motorhome motorhome = motorhomeRepository.read(motorhomeID);
       motorhome.setIs_Available(true); //true=tilgængelig
       //gemme data til sqldatabase dvs opdatere den nye status for tilgængelighed
       motorhomeRepository.update(motorhome);
       //Delete booking
       bookingRepository.delete(tempCustomerBooking);

    }


}
//TJEK GENVEJ FOR REFACTOR