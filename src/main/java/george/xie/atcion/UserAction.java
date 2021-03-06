package george.xie.atcion;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import george.xie.entity.UserEntity;
import george.xie.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class UserAction extends ActionSupport {
    private ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
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


    public String register() throws Exception {

        userService.add(userEntity);

        return SUCCESS;
    }

    /**
     *
     * @return
     */
    public String login() {
        Map session = (Map) ActionContext.getContext().getSession();
//        UserEntity user= (UserEntity) session.get("userInfo");

        UserEntity user = userService.login(userEntity);
        if (user == null||userEntity.getUsername()==null) {
            this.addActionError("用户名或密码不正确");
            return "relogin";
        } else {

            session.put("userInfo", user);
            return SUCCESS;
        }
    }
    public String logout(){
        Map session = (Map) ActionContext.getContext().getSession();
        request.getSession().invalidate();
        return "logout";

    }
}
