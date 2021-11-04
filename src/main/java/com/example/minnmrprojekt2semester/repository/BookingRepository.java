package com.example.minnmrprojekt2semester.repository;
import com.example.minnmrprojekt2semester.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookingRepository {

        @Autowired
        private JdbcTemplate jdbcTemplate; //opretter instans af jdbc hver gang det benyttes


        //metoderne
        public List<Booking> readAllBookings () {
            String sqlStatement="SELECT * FROM booking";
            RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
            List<Booking> bookings = jdbcTemplate.query(sqlStatement,rowMapper);
            System.out.println(bookings.get(0));
            return bookings;
        }

        public void createBooking(Booking booking) {
            String sqlStatement="INSERT into booking(booked_at, returned_at, km_driven, is_half_full, is_clean, employee_id," +
                    "customer_id, motorhome_id)" +
                    "VALUES(?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sqlStatement, booking.getBookedAt(),booking.getReturnedAt(),booking.getKmDriven(),
                    booking.isHalfFull(), booking.isClean(), booking.getEmployeeId(), booking.getCustomerId(), booking.getMotorhomeId());
        }

        public Booking readOneBooking (int id) {
            String sqlStatement="SELECT * FROM booking WHERE id = ?";
            RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
            return jdbcTemplate.queryForObject(sqlStatement,rowMapper, id);

        }

        public void deleteBooking (int id) {
            String sqlStatement= "DELETE FROM booking WHERE id =?"; //Delete VED PÅ FORHÅND at det hele rækken der skal slettes
            jdbcTemplate.update(sqlStatement, id);
        }




}