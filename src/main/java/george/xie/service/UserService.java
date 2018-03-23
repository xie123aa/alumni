package george.xie.service;

import george.xie.dao.UserDao;

import javax.transaction.Transactional;

@Transactional
public class UserService {
    //注入dao对象,写接口，注入实现类
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void add(){
        System.out.println("service*******");
        userDao.add();
    }
}
