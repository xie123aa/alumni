package george.xie.service;

import george.xie.dao.ContentDaoImpl;
import george.xie.entity.Content;

import javax.transaction.Transactional;
import java.sql.Timestamp;
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
}
