package jdbcTemplateTest.entity.dao;

import jdbcTemplateTest.entity.Book;

import java.util.List;

public interface BookDao {
    //添加的方法
    void add(Book book);

    void delete(String id);

    void update(Book book);

    void selectCount();

    Book selectObject(String id);

    List<Book> findAll();

    void addMoreBook(List<Object[]> book);

    void updateMoreBatchBook(List<Object[]> book);

    void deleteMoreBatchBook(List<Object[]> book);
}
