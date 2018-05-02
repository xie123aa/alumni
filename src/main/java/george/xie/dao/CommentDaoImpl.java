package george.xie.dao;

import george.xie.entity.Comment;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    private HibernateTemplate hibernateTemplate;
    private PageHibernateCallback<Comment> hibernateCallBackCutePageImpl;

    public void setHibernateCallBackCutePageImpl(PageHibernateCallback<Comment> hibernateCallBackCutePageImpl) {
        this.hibernateCallBackCutePageImpl = hibernateCallBackCutePageImpl;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public Comment save(Comment comment) {
        hibernateTemplate.save(comment);
        return comment;
    }

    public List<Comment> getByTopic(int topicId) {
        List<Comment> list= (List<Comment>) hibernateTemplate.find("from Comment art where art.content1.id=? order by art.creatTime desc",topicId);
        return list;

    }

    /**
     * 分页查询该文章所有评论
     * @param pageNum
     * @param pagesize
     * @param id
     * @return
     */
    public List<Comment> queryByPage(int pageNum, int pagesize, int id) {
        String hql="from Comment art where  art.content1 =" +id+ "order by art.creatTime desc";
        pageNum=(pageNum-1)*pagesize;
        hibernateCallBackCutePageImpl.init(hql, pageNum, pagesize);//该回调类对象已经通过Spring注入到当前测试类里面了。
        List<Comment> results= (List<Comment>) hibernateTemplate.execute(hibernateCallBackCutePageImpl);

        return results;
    }

    /**
     * 查询该文章所有评论
     * @param cid
     * @return
     */
    public int queryTotal(int cid ) {
        List<Comment> list= (List<Comment>) hibernateTemplate.find("from Comment art where art.content1.id=? order by art.creatTime desc",cid);
        return list.size();
    }

    /**
     * 通过该评论Id获取评论实体
     * @param id
     * @return
     */
    public Comment getCommentByID(int id) {
        return hibernateTemplate.get(Comment.class,id);
    }

    /**
     * 分页查询该用户所有评论
     * @param id
     * @param pageNum
     * @return
     */
    public List<Comment> getAllComment(int id, int pageNum,int pageSize) {
        String hql="from Comment art where art.userEntity.id="+id+" order by art.creatTime desc";
        pageNum=(pageNum-1)*pageSize;
        hibernateCallBackCutePageImpl.init(hql, pageNum,pageSize);//该回调类对象已经通过Spring注入到当前测试类里面了。
        List<Comment> list= (List<Comment>) hibernateTemplate.execute(hibernateCallBackCutePageImpl);
        return list;
    }

    /**
     * 通过该评论ID删除该评论
     * @param id
     */
    public void deleteById(int id) {
       Comment content=getCommentByID(id);
        hibernateTemplate.delete(content);

    }
    /**
     *获取当前用户的所有评论
     */
    public List<Comment> queryAllCommentByUid(int uid){
        List<Comment> list= (List<Comment>) hibernateTemplate.find("from Comment art where art.userEntity.id=? order by art.creatTime desc",uid);
        return list;

    }

}
