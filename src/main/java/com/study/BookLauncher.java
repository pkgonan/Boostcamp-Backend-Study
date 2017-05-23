package com.study;

import com.study.domain.Book;
import com.study.persistence.BookDao;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookLauncher {
    public static void main(String[] args){
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BookDao dao = context.getBean(BookDao.class);
        int count = dao.countBooks();
        System.out.println(count);

        Book book = dao.selectById(1);
        System.out.println(book);

        Book book2 = new Book("네이버 Java", "김강산", 512);
        Integer newId = dao.insert(book2);
        System.out.println(newId);
        System.out.print(dao.selectById(newId));
    }
}