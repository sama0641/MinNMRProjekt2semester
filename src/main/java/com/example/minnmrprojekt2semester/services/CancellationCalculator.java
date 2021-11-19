package com.example.minnmrprojekt2semester.services;
import com.example.minnmrprojekt2semester.model.Booking;
import com.example.minnmrprojekt2semester.repository.BookingRepository;
import com.example.minnmrprojekt2semester.repository.MotorhomeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CancellationCalculator {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MotorhomeRepository motorhomeRepository;


  public void cancellationCharge (int bookingId) {
        //Find booking
        Booking tempCustomerBooking = bookingRepository.readOneBooking(bookingId);//bookingobjekt=customerBooking > den ved hvilken ID det er grundet metoden
        PriceCalculator.calculateCancellationPrice(tempCustomerBooking);

        //vis den nye pris

       //Change motorhome status to available
       int motorhome = tempCustomerBooking.getMotorhome_id();
       motorhomeRepository.readOneMotorhome(motorhome).setIs_Available(true);

       //Delete booking
       bookingRepository.deleteBooking(bookingId);

    }


}
