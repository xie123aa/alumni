package george.xie.dao;

import george.xie.entity.UserEntity;


public interface UserDao {
    public void add();
    /**
     * 登陆验证
     */
    public UserEntity login(UserEntity userEntity);
}
