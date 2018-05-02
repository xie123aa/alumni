package george.xie.dao;

import george.xie.entity.Message;

import java.util.List;

public interface MessageDao {
    public void save(Message message);
    public List<Message> getByUid(int uid);
    public void update(Message message);
}
