package service;

import aopJDKTest.UserDao;
import dao.AccountDao;
import dao.AccountDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

    //注入dao
    @Autowired
    private AccountDao accountDao;

    public void transform(){
        try {
            accountDao.deposit();
            accountDao.withdraw();
        }//无异常，提交事务
        catch (Exception e) {
            //出现异常，回滚
            e.printStackTrace();
        }
    }
}
