package com.example.minnmrprojekt2semester.repository;
import com.example.minnmrprojekt2semester.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository implements CRUDrepository <Employee> {

    @Autowired //opretter instans af jdbc hver gang det benyttes
    JdbcTemplate jdbcTemplate;

    public List<Employee> readAll() {
        String sqlStatement = "SELECT * FROM employee";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return jdbcTemplate.query(sqlStatement, rowMapper);
    }


    //Create employee
    public void create (Employee employee) {
        String sqlStatement = "INSERT into employee(jobtitle, employee_name)" +
                "VALUES(?,?)";
        jdbcTemplate.update(sqlStatement, employee.getEmployee_name(), employee.getJobtitle());

    }


    //read only one employee
    public Employee read(int id) {
        String sqlStatement = "SELECT * FROM employee WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return jdbcTemplate.queryForObject(sqlStatement, rowMapper, id);
    }

    //update employee
    public void update (Employee employee) {
        String sqlStatement = "UPDATE employee SET " +
                "jobtitle=?, employee_name =?";
        jdbcTemplate.update(sqlStatement, employee.getJobtitle(), employee.getEmployee_name());
    }
    //slette en ansat
    public void delete (Employee employee) { //id'et sepcificerer hvilken medarbejder
        String sqlStatement = "DELETE FROM employee WHERE id =?"; //Delete VED PÅ FORHÅND at det hele rækken der skal slettes
        jdbcTemplate.update(sqlStatement, employee.getId());
    }

}
