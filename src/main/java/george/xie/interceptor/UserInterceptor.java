package george.xie.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor {
    /**
     * 拦截器业务处理方法
     * @param invocation
     * @return
     * @throws Exception
     */
    public String intercept(ActionInvocation invocation) throws Exception {
        //拿到当前执行的方法名：判断，只有当方法名不是login，就进行验证
        //先获取ActionContext对象
        ActionContext ac=invocation.getInvocationContext();
        //拿到Action代理对象
        ActionProxy proxy=invocation.getProxy();
        //获取当前执行的方法名
        String methodName=proxy.getMethod();
        //判断
        if(!"login".equals(methodName)){
            Object obj=ac.getSession().get("userInfo");
            if(obj==null){
                //没有登陆
                return  "login";
            }else{
                //当前用户已登陆
                return invocation.invoke();//直接返回
            }

        }else{
            //当前用户正在登陆
            return invocation.invoke();
        }
    }
}
