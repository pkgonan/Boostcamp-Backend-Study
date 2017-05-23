package com.study;

import com.study.persistence.BookDao;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class BookLauncher {
    public static void main(String[] args){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/javaweb/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        BookDao dao = new BookDao(dataSource);
        int count = dao.countBooks();
        System.out.println(count);
    }
}