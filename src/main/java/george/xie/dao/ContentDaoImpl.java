package george.xie.dao;

import george.xie.entity.Comment;
import george.xie.entity.Content;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class ContentDaoImpl implements ContentDao{
    private HibernateTemplate hibernateTemplate;
    private PageHibernateCallback<Content> hibernateCallBackCutePageImpl;
    //注入回调类

    public void setHibernateCallBackCutePageImpl(PageHibernateCallback hibernateCallBackCutePageImpl) {
        this.hibernateCallBackCutePageImpl = hibernateCallBackCutePageImpl;
    }


    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void add(Content content) {

        hibernateTemplate.save(content);

    }
    public List<Content> queryByPage(int pageNum, int pagesize){
        String hql="from Content art order by art.creatTime desc";
        pageNum=(pageNum-1)*pagesize;
        hibernateCallBackCutePageImpl.init(hql, pageNum, pagesize);//该回调类对象已经通过Spring注入到当前测试类里面了。
        List<Content> results= (List<Content>) hibernateTemplate.execute(hibernateCallBackCutePageImpl);

        return results;
    }

    public List<Content> queryRencently() {
        String hql="from Content art order by art.creatTime desc";
        hibernateCallBackCutePageImpl.init(hql, 1, 5);//该回调类对象已经通过Spring注入到当前测试类里面了。
        List<Content> results= (List<Content>) hibernateTemplate.execute(hibernateCallBackCutePageImpl);

        return results;
    }

    public int queryTotal() {
        List<Content> list= (List<Content>) hibernateTemplate.find("from Content art order by art.creatTime desc");
        return list.size();
    }

    public Content getContentByID(int id) {
        return hibernateTemplate.get(Content.class,id);
    }
    public void updateContent(int id ){
       Content content=getContentByID(id);
       content.setClickCount(content.getClickCount()+1);
       hibernateTemplate.update(content);

    }

    public  List<Content> getAllContentByUID(int id) {
        List<Content> list= (List<Content>) hibernateTemplate.find("from Content art where art.userEntity.id=? order by art.creatTime desc",id);
        return list;
    }

    public void delete(int id) {
        Content content=getContentByID(id);
        hibernateTemplate.delete(content);

    }

    /**
     * 分页获得当前用户的文章
     * @param uid
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Content> getAllContentByUid(int uid, int pageNum, int pageSize) {
        pageNum=(pageNum-1)*pageSize;
        String hql="from Content art where art.userEntity.id="+uid+"order by art.creatTime desc";
        hibernateCallBackCutePageImpl.init(hql, pageNum, pageSize);//该回调类对象已经通过Spring注入到当前测试类里面了。
        List<Content> results= (List<Content>) hibernateTemplate.execute(hibernateCallBackCutePageImpl);
        return results;
    }

    public List<Content> queryByPageComment(int pageNum, int pagesize) {
        String hql="from Content art order by art.totalComment desc";
        pageNum=(pageNum-1)*pagesize;
        hibernateCallBackCutePageImpl.init(hql, pageNum, pagesize);//该回调类对象已经通过Spring注入到当前测试类里面了。
        List<Content> results= (List<Content>) hibernateTemplate.execute(hibernateCallBackCutePageImpl);

        return results;
    }

    public List<Content> queryByPageCilck(int pageNum, int pagesize) {
        String hql="from Content art order by art.clickCount desc";
        pageNum=(pageNum-1)*pagesize;
        hibernateCallBackCutePageImpl.init(hql, pageNum, pagesize);//该回调类对象已经通过Spring注入到当前测试类里面了。
        List<Content> results= (List<Content>) hibernateTemplate.execute(hibernateCallBackCutePageImpl);

        return results;
    }
    public void update(Content content){
        hibernateTemplate.update(content);

    }


}
