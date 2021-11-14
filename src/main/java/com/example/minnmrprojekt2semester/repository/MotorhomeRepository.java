package com.example.minnmrprojekt2semester.repository;
import com.example.minnmrprojekt2semester.model.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MotorhomeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate; //opretter instans af jdbc hver gang det benyttes

    //metoderne
    public List<Motorhome> readAllMotorhomes () {
        String sqlStatement="SELECT * FROM motorhomes";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        List<Motorhome> motorhomes = jdbcTemplate.query(sqlStatement,rowMapper);
        return motorhomes;
    }

    public void createMotorhome (Motorhome motorhome) {
        String sqlStatement="INSERT into motorhomes(is_available, price_per_day, season, size_category, brand_name, model_name)" +
                "VALUES(?,?,?,?)";
        jdbcTemplate.update(sqlStatement, motorhome.isIs_Available(),motorhome.getPricePerDay(),motorhome.getSeason(),
                motorhome.getSize_category(), motorhome.getModel_name(), motorhome.getBrand_name());
    }

    //read only one motorhome
    public Motorhome readOneMotorhome (int id) {
        String sqlStatement="SELECT * FROM motorhome WHERE id = ?";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return jdbcTemplate.queryForObject(sqlStatement,rowMapper,id);
    }


    //redigere/update en motorhome
    public void updateMotorhome (Motorhome motorhome, int id) {
        String sqlStatement= "UPDATE motorhomes SET " +
                "is_available=?, price_per_day =?, season=?, size_category=?, brand_name=?, model_name=? WHERE id=?";
        jdbcTemplate.update(sqlStatement,motorhome.isIs_Available(),motorhome.getPricePerDay(),motorhome.getSeason(),
                motorhome.getSize_category(),motorhome.getBrand_name(),motorhome.getModel_name(), id);
    }

    public void deleteMotorhome (int id) { //id'et sepcificerer hvilken MH
        String sqlStatement = "DELETE FROM motorhomes WHERE id =?"; //Delete VED PÅ FORHÅND at det hele rækken der skal slettes
        jdbcTemplate.update(sqlStatement, id);


    }


}
