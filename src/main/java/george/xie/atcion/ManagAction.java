package george.xie.atcion;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import george.xie.entity.Comment;
import george.xie.entity.Content;
import george.xie.entity.UserEntity;
import george.xie.service.CommentService;
import george.xie.service.ContentService;
import george.xie.utils.Page;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ManagAction extends ActionSupport {
    private CommentService commentService;
    private ContentService contentService;
    private ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }

    /**
     * 展示评论
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        Map session = (Map) context.getSession();
        UserEntity user= (UserEntity) session.get("userInfo");
        int pageNum=1;
        int pageSize=20;
        if(request.getParameter("pageNum")!=null){
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        Page<Comment> page=commentService.getAllcommentByUid(user.getUid(),pageNum,pageSize);
        request.setAttribute("page",page);
        System.out.println(page.getPageNum());
        System.out.println(page.getTotalPage());
        System.out.println("***************************");

        return SUCCESS;
    }

    /**
     * 展示文章
     * @return
     */
    public String contentMange(){
        Map session = (Map) context.getSession();
        UserEntity user= (UserEntity) session.get("userInfo");
        int pageNum=1;
        int pageSize=10;
        if(request.getParameter("pageNum")!=null){
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        Page<Content> page=contentService.getAllcontentByUid(user.getUid(),pageNum,pageSize);
        request.setAttribute("page",page);
        List url=new ArrayList();
        for(Content content : page.getList()) {
            String name=content.getImgurl();
            String fileName=name.substring(0,name.lastIndexOf("."));
            url.add(fileName);

        }
        page.setUrlList(url);

        return "contentMange";
    }

    /**
     * 删除文章
     * @return
     */
    public String deleteContent(){
        int id =Integer.parseInt(request.getParameter("id"));
        contentService.delete(id);

        return "deleteContent";
    }
    /**
     * 删除评论
     */
    public String deleteComment(){
        int id =Integer.parseInt(request.getParameter("id"));
        commentService.delete(id);

        return "deleteComment";
    }
}
