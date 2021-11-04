package com.example.minnmrprojekt2semester.services;
import com.example.minnmrprojekt2semester.model.Booking;
import com.example.minnmrprojekt2semester.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CancellationCalculator {

    @Autowired
    private BookingRepository bookingRepository;



  public void cancellationCharge (int bookingId) {
        //Find booking
        Booking tempCustomerBooking = bookingRepository.readOneBooking(bookingId);//bookingobjekt=customerBooking > den ved hvilken ID det er grundet metoden
        String dateToString = tempCustomerBooking.getBookedAt();

      //Charge customer


      //Change motorhome status to available


      //Delete booking
    }


}
