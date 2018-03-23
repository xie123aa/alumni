package george.xie.dao;

import george.xie.entity.User;
import george.xie.entity.UserEntity;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class UserDaoImpl implements UserDao{
    //得到hibernateTempelate对象
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
//添加操作
    public void add() {
        //调用sava方法
        UserEntity user=new UserEntity();
        user.setUsername("xie123aa");
        user.setPassword("6863559");
         hibernateTemplate.save(user);

    }
}
