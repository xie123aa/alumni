package george.xie.atcion;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import george.xie.entity.Content;
import george.xie.entity.UserEntity;
import george.xie.service.ContentService;
import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ContentAction extends ActionSupport {
    private Content content=new Content();
    private ContentService contentService;

    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().getSession();
        UserEntity user= (UserEntity) session.get("userInfo");
        HttpServletRequest request = ServletActionContext.getRequest();
        String url=request.getParameter("imgurl");
        System.out.println(url);
        String de=request.getParameter("description");
        System.out.println(de);
        content.setUserEntity(user);
        content.setDescription(de);
        content.setImgurl(url);
        contentService.addContent(content);


        return null;
    }
}
