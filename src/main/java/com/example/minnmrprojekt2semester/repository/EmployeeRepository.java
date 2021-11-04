package com.example.minnmrprojekt2semester.repository;
import com.example.minnmrprojekt2semester.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired //opretter instans af jdbc hver gang det benyttes
    JdbcTemplate jdbcTemplate;

    public List<Employee> readAllEmployees () {
        String sqlStatement="SELECT * FROM employee";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return jdbcTemplate.query(sqlStatement,rowMapper);
    }


    //Create employee
    public void createEmployee (Employee employee) {
        String sqlStatement="INSERT into employee(jobtitle, employee_name)" +
                "VALUES(?,?)";
        jdbcTemplate.update(sqlStatement, employee.getEmployee_name(),employee.getJobtitle());

    }


    //read only one employee
    public Employee readOneEmployee (int id) {
        String sqlStatement="SELECT * FROM employee WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return jdbcTemplate.queryForObject(sqlStatement,rowMapper,id);
    }

    //update employee
    public void updateEmployee (Employee employee) {
        String sqlStatement= "UPDATE employee SET " +
                "jobtitle=?, employee_name =?";
        jdbcTemplate.update(sqlStatement,employee.getJobtitle(),employee.getEmployee_name());
    }
}
