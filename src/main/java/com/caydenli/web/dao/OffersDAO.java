package com.caydenli.web.dao;

import com.caydenli.web.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Cayden on 16/6/18.
 */
@Component("offersDao")
public class OffersDAO {

    private NamedParameterJdbcTemplate jdbc;

    public OffersDAO() {
        
    }

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    public List<Offer> getOffers() {
        return jdbc.query("select * from offers", new RowMapper<Offer>() {

            public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Offer offer = new Offer();

                offer.setId(rs.getInt("id"));
                offer.setName(rs.getString("name"));
                offer.setText(rs.getString("text"));
                offer.setEmail(rs.getString("email"));

                return offer;

            }
        });
    }
}
