package george.xie.service;

import george.xie.dao.CommentDaoImpl;
import george.xie.dao.ContentDaoImpl;
import george.xie.dao.MessageDaoImpl;
import george.xie.entity.Comment;
import george.xie.entity.Content;
import george.xie.entity.Message;
import george.xie.entity.UserEntity;
import george.xie.utils.Page;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Transactional
public class CommentService {
private CommentDaoImpl commentDao;
private ContentDaoImpl contentDao;


    public void setContentDao(ContentDaoImpl contentDao) {
        this.contentDao = contentDao;
    }

    public void setCommentDao(CommentDaoImpl commentDao) {
        this.commentDao = commentDao;
    }

    /**
     * 保存评论
     * @param topicId
     * @param content
     * @param userEntity
     */
    public Comment save(int topicId, String content, UserEntity userEntity){
        Comment comment=new Comment();
        comment.setContent(content);

        comment.setUserEntity(userEntity);

        comment.setContent1(contentDao.getContentByID(topicId));
        Timestamp d = new Timestamp(System.currentTimeMillis());
        comment.setCreatTime(d);
       Comment comment2=commentDao.save(comment);
      Content content1=comment2.getContent1();
      content1.setTotalComment(content1.getTotalComment()+1);
      content1.setFinalComments(d);//设置最后回复时间
      contentDao.updateContent(content1.getId());
       return comment2;

    }

    /**
     * 获取评论
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<Comment> getComments(int pageNum, int pageSize,int topicId){

        Page page=new Page(pageNum,pageSize,commentDao.queryTotal(topicId));
        page.setList(commentDao.queryByPage(pageNum,pageSize,topicId));
        return page;
    }

    /**
     * 删除评论并将评论数减1
     * @param id
     */
    public void delete(int id ){

        Comment comment=commentDao.getCommentByID(id);
        Content content=comment.getContent1();
        content.setTotalComment(content.getTotalComment()-1);
        contentDao.update(content);
        commentDao.deleteById(id);
    }

    /**
     * 获取全部评论
     * @param uid
     * @return
     */
    public Page<Comment> getAllcommentByUid(int uid,int pageNum,int pageSize ){
      Page page=new Page(pageNum,pageSize,commentDao.queryAllCommentByUid(uid).size());
      page.setList(commentDao.getAllComment(uid,pageNum,pageSize));
        return page;
    }


}
