package george.xie.dao;

import george.xie.entity.Message;
import org.springframework.orm.hibernate5.HibernateTemplate;


import java.util.List;


public class MessageDaoImpl implements MessageDao {
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    private HibernateTemplate hibernateTemplate;
    public void save(Message message) {
        hibernateTemplate.save(message);
    }

    public List<Message> getByUid(int uid) {
        List<Message> list= (List<Message>) hibernateTemplate.find("from Message art where art.cuid.id=? order by art.creattime desc",uid);
        return list;
    }

    public void update(Message message) {
        hibernateTemplate.update(message);
    }
}
