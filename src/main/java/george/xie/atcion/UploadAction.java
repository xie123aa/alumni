package george.xie.atcion;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import george.xie.utils.ImagUtil;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;


import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
        //图片名称生成策略
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        //图片名称一部分
        String format = df.format(new Date());

         //随机三位数
        Random r = new Random();
        // n 1000   0-999   99
          for(int i=0 ; i<3 ;i++){
            format += r.nextInt(10);
             }
    String fileEx = picFileName.substring(picFileName.indexOf("."),
            picFileName.length());
    String path = format + fileEx;
        String url="http://localhost:8088/web-image/upload/"+path;
        WebResource resource=cilent.resource(url);

        resource.put(String.class,pic);
//生成缩略图并发送到服务器

    // 获取上传的目录路径，以目录作为一个对象

    String imgPath = ServletActionContext.getServletContext().getRealPath("/upload");

// 创建目标文件对象，将获取的文件放在当前目录
    File destFile = new File(imgPath,picFileName);//这仅仅是一个驱壳，需要将临时文件（files）导入

// 把上传的文件，拷贝到目标文件中

    try {
        FileUtils.copyFile(pic, destFile);
        destFile.renameTo(new File(imgPath+"/"+format+fileEx));
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(destFile.getName());
    JSONObject js=new JSONObject();
    js.put("url",url);
    js.put("path",path);
    HttpServletResponse response=ServletActionContext.getResponse();
    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().write(js.toString());

        return null;

    }



}
