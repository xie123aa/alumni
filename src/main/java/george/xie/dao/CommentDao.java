package george.xie.dao;

import george.xie.entity.Comment;
import george.xie.entity.Content;

import java.util.List;

public interface CommentDao {
    public Comment save(Comment comment);
    public List<Comment> getByTopic(int topicId);//嵌套查询
    public List<Comment> queryByPage(int pageNum, int pagesize,int id );
    public int queryTotal(int id );
    public List<Comment> getAllComment(int id ,int pageNum,int Pagesize );
    public  void deleteById(int id );
    public Comment getCommentByID(int commentId);

}
