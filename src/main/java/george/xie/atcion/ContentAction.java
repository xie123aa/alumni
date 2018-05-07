package george.xie.atcion;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import george.xie.entity.Comment;
import george.xie.entity.Content;
import george.xie.entity.UserEntity;
import george.xie.service.CommentService;
import george.xie.service.ContentService;
import george.xie.utils.Page;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.struts2.ServletActionContext;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentAction extends ActionSupport {
    private Content content=new Content();
    private ContentService contentService;
    private CommentService commentService;

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }

    public void setContent(Content content) {
        this.content = content;
    }
    private ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);

    /**
     * 保存图片内容
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        Map session = (Map) context.getSession();
        UserEntity user= (UserEntity) session.get("userInfo");
        HttpServletRequest request = ServletActionContext.getRequest();
        String url=request.getParameter("imgurl");
        String description=request.getParameter("description");
        content.setUserEntity(user);
        content.setDescription(description);
        content.setImgurl("upload/" +url);
        contentService.addContent(content);
        //发送本地图片到服务器
        Client cilent=new Client();
        String ur="http://localhost:8088/web-image/save/"+url;
        //取得本地文件
        String path = ServletActionContext.getServletContext().getRealPath("/upload");
        File imgFile=new File(path+"/"+url);
        //发送文件
        WebResource resource=cilent.resource(ur);
        resource.put(String.class,imgFile);
        //发送缩略图
        setThumbnail(url,imgFile);
        return "publish";
    }

    /**
     * 展示所有图片
     * @return
     */
    public String showAll(){
        int pageSize=5;//分页器显示大小，即在数据库中查询的记录数目
        int pageNum=1;//当前页面的页数
        ActionContext context = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
        if(request.getParameter("pageNum")!=null){
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        Page<Content> page=contentService.getContents(pageNum,pageSize);

        List url=new ArrayList();
        for(Content content : page.getList()) {
            String name=content.getImgurl();
            String fileName=name.substring(0,name.lastIndexOf("."));
            url.add(fileName);

        }
        page.setUrlList(url);
        request.setAttribute("page", page);


        return SUCCESS;
    }

    /**
     * 发送缩略图方法
     * @param name
     * @param file
     */
    public void setThumbnail( String name,File file){
        //保存图片到本地
        String path = ServletActionContext.getServletContext().getRealPath("/upload");
        //获得文件名
        String fileName=name.substring(0,name.lastIndexOf("."));

        try {
            Thumbnails.of(file.getPath()).size(500, 500).toFile(path+"/thum/"+fileName+".jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File thumbnail=new File(path+"/thum/"+fileName+".jpg");
        String filename=thumbnail.getName();
        String fileEx = filename.substring(filename.indexOf("."), filename.length());
        Client cilent=new Client();
        String url="http://localhost:8088/web-image/thumbnai/upload/"+fileName+fileEx;
        WebResource resource=cilent.resource(url);
        resource.put(String.class,thumbnail);
        //删除生成的缩略图。
        thumbnail.delete();

        //删除本地文件
        file.delete();

//在驱壳中填充灵魂
    }
    public String manage(){
        return "manage";
    }

    /**
     * 展示单个文章和评论
     * @return
     */
    public String showSingle(){

        int id=Integer.parseInt(request.getParameter("id"));
        if(request.getParameter("click")!=null){//用户点击加一，用cilck参数区分是否是点击
            contentService.addClick(id);
        }
        Content content=contentService.getContentByID(id);
        request.setAttribute("content",content);
        int pageNum=1;
        if(request.getParameter("pageNum")!=null){
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        int pageSize=10;
        Page<Comment> list=commentService.getComments(pageNum,pageSize,id);
        request.setAttribute("page",list);

        return "showsingle";
    }
    public String showAllByComment(){
        int pageSize=5;//分页器显示大小，即在数据库中查询的记录数目
        int pageNum=1;//当前页面的页数
        ActionContext context = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
        if(request.getParameter("pageNum")!=null){
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        Page<Content> page=contentService.getContentsByComment(pageNum,pageSize);

        List url=new ArrayList();
        for(Content content : page.getList()) {
            String name=content.getImgurl();
            String fileName=name.substring(0,name.lastIndexOf("."));
            url.add(fileName);

        }
        page.setUrlList(url);
        request.setAttribute("page", page);


        return "showAllByComment" ;
    }

    public String showAllByCilck(){
        int pageSize=5;//分页器显示大小，即在数据库中查询的记录数目
        int pageNum=1;//当前页面的页数
        ActionContext context = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
        if(request.getParameter("pageNum")!=null){
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        Page<Content> page=contentService.getContentsByClick(pageNum,pageSize);

        List url=new ArrayList();
        for(Content content : page.getList()) {
            String name=content.getImgurl();
            String fileName=name.substring(0,name.lastIndexOf("."));
            url.add(fileName);

        }
        page.setUrlList(url);
        request.setAttribute("page", page);


        return "showAllByCilck";
    }

}
