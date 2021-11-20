package com.example.minnmrprojekt2semester.repository;
import com.example.minnmrprojekt2semester.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class BookingRepository implements CRUDrepository<Booking> {

        @Autowired
        private JdbcTemplate jdbcTemplate; //opretter instans af jdbc hver gang det benyttes


        //metoderne
        public List<Booking> readAll() {
            String sqlStatement="SELECT * FROM booking";
            RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
            List<Booking> bookings = jdbcTemplate.query(sqlStatement,rowMapper);
            System.out.println(bookings.get(0));
            return bookings;
        }

        public void create(Booking booking) {
            String sqlStatement="INSERT into booking(booked_at, returned_at, km_driven, is_half_full, is_clean, employee_id," +
                    "customer_id, motorhome_id)" +
                    "VALUES(?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sqlStatement, booking.getBooked_at(),booking.getReturned_at(),booking.getKm_driven(),
                    booking.isIs_half_full(), booking.isIs_clean(), booking.getEmployee_id(), booking.getCustomer_id(), booking.getMotorhome_id());
        }

        public Booking read(int id) {
            String sqlStatement="SELECT * FROM booking WHERE id = ?";
            RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
            return jdbcTemplate.queryForObject(sqlStatement,rowMapper, id);

        }

    public void update (Booking booking) {
        String sqlStatement= "UPDATE booking SET " +
                "booked_at=?, returned_at =?, km_driven=?, is_half_full=?, is_clean=?, employee_id=?, customer_id=?, " +
                "motorhome_id=?, WHERE id=?";
        jdbcTemplate.update(sqlStatement,booking.getBooked_at(),booking.getReturned_at(),booking.getKm_driven(),booking.isIs_half_full(),
                booking.isIs_clean(),booking.getEmployee_id(),booking.getCustomer_id(),booking.getMotorhome_id(), booking.getId());
    }

        public void delete (Booking booking) {
            String sqlStatement= "DELETE FROM booking WHERE id =?"; //Delete VED PÅ FORHÅND at det hele rækken der skal slettes
            jdbcTemplate.update(sqlStatement, booking.getId());
        }




}
