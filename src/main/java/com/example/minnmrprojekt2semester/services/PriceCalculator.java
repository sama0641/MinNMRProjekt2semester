package com.example.minnmrprojekt2semester.services;

import com.example.minnmrprojekt2semester.model.Booking;
import com.example.minnmrprojekt2semester.repository.BookingRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PriceCalculator {


    public static void calculateCancellationPrice (Booking booking) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date startDate = null;
        try {
            startDate = dateFormat.parse(booking.getBooked_at());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date today = new Date();

        long millisBetween = startDate.getTime() - today.getTime();
        long daysBetween = millisBetween / ( 1000 * 60 * 60 * 24 );

        if (daysBetween >= 50){

            if ( booking.getPrice() * 0.2 > 500 ){

                booking.setPrice( booking.getPrice() * 0.2 );

            } else {

                booking.setPrice( 500 );

            }

        } else if ( daysBetween >= 15 ){

            booking.setPrice( booking.getPrice() * 0.5 );

        } else if ( daysBetween > 0 ){

            booking.setPrice( booking.getPrice() * 0.8 );

        } else if ( daysBetween == 0 ){

            booking.setPrice( booking.getPrice() * 0.95 );

        } else {

            //Too late to cancel

        }

    }


}
