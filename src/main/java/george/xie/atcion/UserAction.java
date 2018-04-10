package george.xie.atcion;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import george.xie.entity.UserEntity;
import george.xie.service.UserService;

import java.util.Map;

public class UserAction extends ActionSupport {
    private UserEntity userEntity=new UserEntity();

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("*******************action");
        userService.add();
        return NONE;
    }

    /**
     *
     * @return
     */
    public String login() {

        UserEntity user = userService.login(userEntity);
        if (user == null||userEntity.getUsername()==null) {
            this.addActionError("用户名或密码不正确");
            return "relogin";
        } else {
            Map session = (Map) ActionContext.getContext().getSession();
            session.put("userInfo", user);
            return SUCCESS;
        }
    }
}
