package george.xie.dao;

import george.xie.entity.UserEntity;
import george.xie.entity.UserEntity_;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

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

    public UserEntity login(UserEntity userEntity) {
//       List <UserEntity> list=(List<UserEntity>)hibernateTemplate.find("from UserEntity where username=? and password=?",userEntity.getUsername(),userEntity.getPassword());
//       userEntity=list.get(1);
        List<UserEntity> list=hibernateTemplate.findByExample(userEntity);
       if (list.size()!=0){
           userEntity=list.get(0);
           return userEntity;
       }
       else {
           return null;
       }
    }
}
