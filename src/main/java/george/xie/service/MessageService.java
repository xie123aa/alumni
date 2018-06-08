package george.xie.service;

import george.xie.dao.MessageDaoImpl;
import george.xie.entity.Message;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class MessageService {
    private MessageDaoImpl messageDao;

    public void setMessageDao(MessageDaoImpl messageDao) {
        this.messageDao = messageDao;
    }

    public void save(Message message){
        messageDao.save(message);

    }
    public List<Message> getByUid(int uid){
        return messageDao.getByUid(uid);
    }

    /**
     * 用户查看后更新为已看过
     * @param message
     */
    public void update(Message message){
        messageDao.update(message);

    }
    public Message getById(int id){
        return messageDao.getById(id);
    }

}
