package george.xie.jersey;

/**
 * 发送图片到另一台tomcat服务器
 */

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;

public class jerseyDemo {
    public static void main(String[] args) throws IOException {
        Client cilent=new Client();
        String url="http://localhost:8088/web-image/upload/qqqqq.jpg";
        WebResource resource=cilent.resource(url);
        String path="O:\\照片\\a1\\51b0929a37a7e21aa11e3886d3018200_r.jpg";
            byte[] readFileToByteArray=FileUtils.readFileToByteArray(new File(path));

        resource.put(String.class,readFileToByteArray);
        System.out.println("发送完毕");
    }
}
