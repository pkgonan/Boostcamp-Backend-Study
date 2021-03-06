package com.study.persistence;

import com.study.domain.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private static final String COUNT_BOOK = "SELECT COUNT(*) FROM BOOK";
    private static final String SELECT_BY_ID = "SELECT id, title, author, pages FROM book where id = :id";
    private static final String DELETE_BY_ID = "DELETE FROM BOOK WHERE id= :id";
    private static final String UPDATE = "UPDATE book SET\n" + "title = :title," + "author = :author," + "pages = :pages\n" + "WHERE id = :id";
    private static final String SELECT_ALL = "SELECT id, title, author, pages FROM BOOK";
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

    public Integer insert(Book book){
        SqlParameterSource params = new BeanPropertySqlParameterSource(book);
        return insertAction.executeAndReturnKey(params).intValue();
    }

    public int deleteById(Integer id){
        Map<String, ?> params = Collections.singletonMap("id",id);
        return jdbc.update(DELETE_BY_ID, params);
    }

    public List<Book> selectAll(){
        Map<String, Object> params = Collections.emptyMap();
        return jdbc.query(SELECT_ALL, params, rowMapper);
    }

    public int update(Book book){
        SqlParameterSource params = new BeanPropertySqlParameterSource(book);
        return jdbc.update(UPDATE, params);
    }

    public BookDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("BOOK")
                .usingGeneratedKeyColumns("id");
    }
}