package george.xie.dao;

import george.xie.entity.Content;

import java.util.List;

public interface ContentDao {
    public void add(Content content);
    public List<Content> queryByPage(int pageNum, int pagesize);
    public List<Content>queryRencently();
    public int queryTotal();
    public Content getContentByID(int id);

}
