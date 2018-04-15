package george.xie.atcion;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;


import java.io.File;
import java.io.IOException;

public class UploadAction extends ActionSupport {
// 对应表单：<input type="file" name="file1">
private File pic;
// 文件名
private String picFileName;
// 文件的类型(MIME)
private String picContentType;
 public void setPic(File pic) {
        this.pic= pic;
        }
public void setPicFileName(String picFileName) {
        this.picFileName = picFileName;
        }
public void setPicContentType(String picContentType) {
        this.picContentType =picContentType;
        }
public String upload() throws Exception{

    System.out.println("upload()..........");
        /******拿到上传的文件，进行处理******/
        //上传图片到另一台服务器
        Client cilent=new Client();
        String url="http://localhost:8088/web-image/upload/qqqqq.jpg";
        WebResource resource=cilent.resource(url);

        resource.put(String.class,pic);

        return SUCCESS;

    }


}
