package jdbcTemplateTest.entity.service;

import jdbcTemplateTest.entity.dao.BookDao;
import jdbcTemplateTest.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    //注入dao
    @Autowired
    private BookDao bookDao;

    //添加的方法
    public void addBook(Book book){
        bookDao.add(book);
    }
    //删除的方法
    public void deleteBook(String id){
        bookDao.delete(id);
    }
    //修改的方法
    public void updateBook(Book book){
        bookDao.update(book);
    }
    //查询的方法
    public void selectCount(){
        bookDao.selectCount();
  }
    //查询对象
    public Book selectObject(String id){
       return bookDao.selectObject(id);
    }
    //查询所有对象
    public List<Book> findAll(){
        return bookDao.findAll();
    }
    //批量添加
    public void addMoreBatch(List<Object[]> book){
        bookDao.addMoreBook(book);
    }
    //批量修改
    public void updateMoreBatch(List<Object[]> book){
        bookDao.updateMoreBatchBook(book);
    }
    //批量删除
    public void deleteMoreBatch(List<Object[]> book){
        bookDao.deleteMoreBatchBook(book);
    }
}

