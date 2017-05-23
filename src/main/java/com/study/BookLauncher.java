package com.study;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Collections;
import java.util.Map;

public class BookLauncher {
    public static void main(String[] args){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/javaweb/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(dataSource);
        String sql = "SELECT COUNT(*) FROM BOOK";
        Map<String, Object> params = Collections.emptyMap();
        Integer count = jdbc.queryForObject(sql, params, Integer.class);
        System.out.println(count);
    }
}