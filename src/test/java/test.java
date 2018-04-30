
import george.xie.entity.Content;
import george.xie.service.ContentService;
import george.xie.utils.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.List;
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class test extends AbstractJUnit4SpringContextTests {


        //注入
        @Autowired
        private ContentService contentService;

        /**
         * 执行测试，就会执行有@Test注解的方法，相当于普通java类的main方法
         * 该实例中可以直接调用spring已经注入的bean即sysRoleService
         */
        @Test
        public void testGetSysRoleByUserId() {
//                Page<Content> list=contentService.getContents(1,5);
//                for(Content content : list.getList()) {
//                        System.out.println(content.getImgurl());
//                }
//            System.out.println(list);
//                System.out.println("dadada");
                Content content=contentService.getContentByID(21);
                System.out.println(content.getImgurl());
        }
}
