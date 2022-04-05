package example;

import aopAnnoTest.aopAnno.User;
import aopAnnoTest.aopAnno.dept_emp.Employees;
import jdbcTemplateTest.entity.Book;
import jdbcTemplateTest.entity.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

import java.util.ArrayList;
import java.util.List;


public class testAno {
    @Test
     public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("a_ioc/bean1.xml");
        User user = context.getBean("user",User.class);
        user.add();
     }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("a_ioc/bean2.xml");
        Employees emp = (Employees) context.getBean("emp","Employees.class");
        emp.test1();
    }
    @Test
    public void test3JDBCTeplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("a_ioc/bean3.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
//        book.setUser_id("01");
//        book.setUsername("Jason123");
//        book.setUstatus("good123");
        List<Object[]> bookList= new ArrayList<>();
        Object[] o1 = {"Jason","111","01"};
        Object[] o2 = {"Andy","2222","02"};
        Object[] o3 = {"Alex","333","03"};
        bookList.add(o1);
        bookList.add(o2);
        bookList.add(o3);
//        Object[] o1 = {"3"};
//        bookList.add(o1);
        //bookService.addBook(book);
        //bookService.deleteBook("2");
        //bookService.updateBook(book);
        //bookService.selectCount();
        //List book1 = bookService.findAll();
        bookService.updateMoreBatch(bookList);
    }
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("a_ioc/bean4.xml");
        AccountService accountService = context.getBean("accountService",AccountService.class);
        accountService.transform();
    }
}
