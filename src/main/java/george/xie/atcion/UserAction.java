package george.xie.atcion;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import george.xie.entity.UserEntity;
import george.xie.service.UserService;

import java.util.Map;

public class UserAction extends ActionSupport {
    private UserEntity userEntity=new UserEntity();
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
        Map session = (Map) ActionContext.getContext().getSession();
        userEntity.setPassword(password);
        userEntity.setUsername(username);
        UserEntity user = userService.login(userEntity);
        if (user == null) {
            this.addActionMessage("用户名或密码不正确");
            return ERROR;
        } else {
            session.put("userInfo", user);
            return SUCCESS;
        }
    }
}
