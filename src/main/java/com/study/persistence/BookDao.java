package com.study.persistence;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Collections;
import java.util.Map;

public class BookDao {
    private NamedParameterJdbcTemplate jdbc;
    private final static String COUNT_BOOK = "SELECT COUNT(*) FROM BOOK";

    public int countBooks(){
        Map<String, Object> params = Collections.emptyMap();
        return jdbc.queryForObject(COUNT_BOOK, params, Integer.class);
    }

    public BookDao(DriverManagerDataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
}