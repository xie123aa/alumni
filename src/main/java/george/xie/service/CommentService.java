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
       return commentDao.save(comment);

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
     * 删除评论
     * @param id
     */
    public void delete(int id ){
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
