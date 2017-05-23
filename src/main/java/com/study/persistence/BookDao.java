package com.study.persistence;

import com.study.domain.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookDao {
    private NamedParameterJdbcTemplate jdbc;
    private static final String COUNT_BOOK = "SELECT COUNT(*) FROM BOOK";
    private static final String SELECT_BY_ID = "SELECT id, title, author, pages FROM book where id = :id";
    private RowMapper<Book> rowMapper = BeanPropertyRowMapper.newInstance(Book.class);

    public int countBooks(){
        Map<String, Object> params = Collections.emptyMap();
        return jdbc.queryForObject(COUNT_BOOK, params, Integer.class);
    }

    public Book selectById(Integer id){
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
    }

    public BookDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
}