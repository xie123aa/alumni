package george.xie.atcion;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import george.xie.dao.MessageDaoImpl;
import george.xie.entity.Comment;
import george.xie.entity.Content;
import george.xie.entity.Message;
import george.xie.entity.UserEntity;
import george.xie.service.CommentService;
import george.xie.service.ContentService;
import george.xie.service.MessageService;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.Map;

public class CommentAction extends ActionSupport {
    private CommentService commentService;
    private ContentService contentService;
    private  MessageService messageService;

    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
    private ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);


    public String execute() throws Exception {
        String comment=request.getParameter("comment");
        System.out.println(comment);
        JSONObject js=new JSONObject();
        js.put("comment",comment);
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(js.toString());
        int id =Integer.parseInt(request.getParameter("id"));
        Map session = (Map) context.getSession();
        UserEntity user= (UserEntity) session.get("userInfo");
//
//        String comments=URLDecoder.decode(comment, "UTF-8");
        Comment newcomment=commentService.save(id,comment,user);

        Message message=new Message();
        message.setUserEntity(user);
        message.setCuid(contentService.getContentByID(id).getUserEntity());
        message.setComment(newcomment);
        message.setCreattime(newcomment.getCreatTime());
        message.setContent(contentService.getContentByID(id));
        int i=0;
        message.setLook((byte) i);
        messageService.save(message);

                return null;
    }
}
