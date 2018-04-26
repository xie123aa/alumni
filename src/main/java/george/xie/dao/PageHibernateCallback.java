package george.xie.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;


public class PageHibernateCallback<T> implements HibernateCallback {
    //当我们用这个类来分页查询的时候，我们都会在不同的dao中注入该对象，比如UserDao,BookDao等等。
//也就是说不同的dao里面就可以有不同的类型，为了更面向对象，所以我就对返回值加了个泛型
    private String hql;
    private int pageNum,pageSize;
    private Object [] args;

    public void setHql(String hql) {
        this.hql = hql;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //初始化参数
    public void init(String hql,int pageNum,int pageSize,Object ...args){
        setHql(hql);
       setPageNum(pageNum);
       setPageSize(pageSize);
        this.args=args;
    }
    //重写接口的方法
    public List<T> doInHibernate(Session session) throws HibernateException {
        Query<T> query=session.createQuery(hql);
        //给hql里面的绑定参数赋值
        int len=args.length;
        for(int i=0;i<len;i++){
            query.setParameter(i, args[i]);
        }
        //实现分页
        query.setFirstResult(pageNum).setMaxResults(pageSize);
        //把结果返回
        return query.list();
    }
}
