package george.xie.service;

import george.xie.dao.ContentDaoImpl;
import george.xie.entity.Content;
import george.xie.utils.Page;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Transactional
public class ContentService {
    private ContentDaoImpl contentDaoImp;


    public void setContentDaoImp(ContentDaoImpl contentDaoImp) {
        this.contentDaoImp = contentDaoImp;
    }
    public void addContent(Content content){
        Timestamp d = new Timestamp(System.currentTimeMillis());
        content.setCreatTime(d);
        content.setClickCount(0);
        content.setTotalComment(0);
        contentDaoImp.add(content);

    }
    public Page<Content> getContents(int pageNum, int pageSize){

        Page page=new Page(pageNum,pageSize,contentDaoImp.queryTotal());
        page.setList(contentDaoImp.queryByPage(pageNum,pageSize));
        return page;
    }
    public Content getContentByID(int id){
        return contentDaoImp.getContentByID(id);

    }
    /**
     * 更新content，cilck加一
     * @param id
     */

    public void addClick( int id ){
        contentDaoImp.updateContent(id);
    }
     public  List<Content> getAllContentByID(int id) {
        return contentDaoImp.getAllContentByUID(id);
    }
    /**
     * 删除评论
     * @param id
     */
    public void delete(int id ){
        contentDaoImp.delete(id);
    }
    public Page<Content> getAllcontentByUid(int uid,int pageNum,int pageSize ){
        Page page=new Page(pageNum,pageSize,contentDaoImp.getAllContentByUID(uid).size());
        page.setList(contentDaoImp.getAllContentByUid(uid,pageNum,pageSize));
        return page;
    }


}
