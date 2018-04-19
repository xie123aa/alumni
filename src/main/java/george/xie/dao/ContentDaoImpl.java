package george.xie.dao;

import george.xie.entity.Content;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class ContentDaoImpl implements ContentDao{
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void add(Content content) {

        hibernateTemplate.save(content);

    }
}
