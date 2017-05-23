package com.study;

import com.study.persistence.BookDao;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class BookLauncher {
    public static void main(String[] args){
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DataSource dataSource = context.getBean(DataSource.class);
        BookDao dao = new BookDao(dataSource);
        int count = dao.countBooks();
        System.out.println(count);
    }
}