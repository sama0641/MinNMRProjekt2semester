package com.example.minnmrprojekt2semester.repository;
import com.example.minnmrprojekt2semester.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.Statement;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired //opretter instans af jdbc hver gang det benyttes
    JdbcTemplate jdbcTemplate;

    public List<Customer> getAllCustomers () {
        String sqlStatement="SELECT * FROM customers";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return jdbcTemplate.query(sqlStatement,rowMapper);
    }

    //Create customer
    public void createCustomer (Customer customer) {
        String sqlStatement="INSERT into customers(customer_name,customer_phone_number,customer_mail)" +
                "VALUES(?,?,?)";
        jdbcTemplate.update(sqlStatement, customer.getCustomer_name(),customer.getCustomer_phone_number(),
                customer.getCustomer_mail());
    }

    //read only one customer
    public Customer readOneCustomer (int id) { //se linje 49 SELECT * ved at det er hele rækken UDFRA id
        String sqlStatement="SELECT * FROM customers WHERE id = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return jdbcTemplate.queryForObject(sqlStatement,rowMapper,id);
    }

    //update en kunde
    public void updateCustomer (Customer customer, int id) {
        String sqlStatement= "UPDATE customers SET " +
                "customer_name=?, customer_phone_number =?, customer_mail=? WHERE id=?";
        jdbcTemplate.update(sqlStatement,customer.getCustomer_name(),customer.getCustomer_phone_number(),
        customer.getCustomer_mail(), id);
    }

    //slette en kunde
    public void deleteCustomer (int id) { //id'et sepcificerer hvilken kunde
        String sqlStatement= "DELETE FROM customers WHERE id =?"; //Delete VED PÅ FORHÅND at det hele rækken der skal slettes
        jdbcTemplate.update(sqlStatement, id);
    }


}
