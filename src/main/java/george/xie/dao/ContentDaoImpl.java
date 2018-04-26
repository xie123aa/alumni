package george.xie.dao;

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
}
