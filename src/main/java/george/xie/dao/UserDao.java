package george.xie.dao;

import george.xie.entity.UserEntity;


public interface UserDao {
    public void add();

    /**
     * 登陆验证
     * @param userEntity
     * @return
     */
    public UserEntity login(UserEntity userEntity);
}
