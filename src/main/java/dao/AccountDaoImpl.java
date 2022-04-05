package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void deposit() {
        String sql = "update t_account set money = money-? where username=?";
        jdbcTemplate.update(sql,100,"lucy");
    }
    @Override
    public void withdraw() {
        String sql = "update t_account set money = money+? where username=?";
        jdbcTemplate.update(sql,100,"mary");
    }

}
