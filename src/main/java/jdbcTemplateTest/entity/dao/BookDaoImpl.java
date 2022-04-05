package jdbcTemplateTest.entity.dao;

import jdbcTemplateTest.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void add(Book book){
        String sql = "insert into t_book values(?, ?, ?)";
        Object []args = {book.getUser_id(),book.getUsername(),book.getUstatus()};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void delete(String id) {
        String sql = "delete from t_book where user_id=?";
        int delete = jdbcTemplate.update(sql,id);
        System.out.println(delete);
    }

    @Override
    public void update(Book book) {
        String sql =  "update t_book set user_id=?,username=?,ustatus=?";
        Object []args = {book.getUser_id(),book.getUsername(),book.getUstatus()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    @Override
    public void selectCount() {
        String sql =  "select count(*) from t_book";
        Integer count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }

    @Override
    public Book selectObject(String id) {
        String sql = "select * from t_book where user_id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class),id);
        return book;
    }

    @Override
    public List<Book> findAll() {
        String sql = "select * from t_book";
        List<Book> bookList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    @Override
    public void addMoreBook(List<Object[]> book) {
        String sql = "insert into t_book values(?, ?, ?)";
        int[] ints =  jdbcTemplate.batchUpdate(sql,book);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void updateMoreBatchBook(List<Object[]> book) {
        String sql = "update t_book set username=?,ustatus=? where user_id=?";
        int []ints = jdbcTemplate.batchUpdate(sql,book);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void deleteMoreBatchBook(List<Object[]> book) {
        String sql = "delete from t_book where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql,book);
        System.out.println(Arrays.toString(ints));

    }
}
