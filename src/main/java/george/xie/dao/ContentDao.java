package george.xie.dao;

import george.xie.entity.Content;
import george.xie.utils.Page;

import java.util.List;

public interface ContentDao {
    public void add(Content content);
    public List<Content> queryByPage(int pageNum, int pagesize);
    public List<Content>queryRencently();
    public int queryTotal();
    public Content getContentByID(int id);
    public void updateContent(int id );
    public List<Content> getAllContentByUID(int id);
    public  void delete (int id );
    public List<Content> getAllContentByUid(int uid ,int pageNum,int Pagesize );

}
