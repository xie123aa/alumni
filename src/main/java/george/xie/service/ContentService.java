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

}
