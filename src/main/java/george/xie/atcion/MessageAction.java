package george.xie.atcion;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import george.xie.entity.Content;
import george.xie.entity.Message;
import george.xie.entity.UserEntity;
import george.xie.service.MessageService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class MessageAction extends ActionSupport {
    private MessageService messageService;
    private ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public String execute() throws Exception {
        Map session = (Map) context.getSession();
        UserEntity user= (UserEntity) session.get("userInfo");
        List<Message> list=messageService.getByUid(user.getUid());
        request.setAttribute("list",list);
        return SUCCESS;
    }
    public  String review(){
       int id= Integer.parseInt(request.getParameter("id"));
        Message message=messageService.getById(id);
        request.setAttribute("content",message.getContent().getId());


        return "review";
    }
}
