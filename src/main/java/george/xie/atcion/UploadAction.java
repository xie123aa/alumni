package george.xie.atcion;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


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
        // 把文件上传到upload目录

        // 获取上传的目录路径，以目录作为一个对象

        String path = ServletActionContext.getServletContext().getRealPath("/upload");

        // 创建目标文件对象，将获取的文件放在当前目录
        File destFile = new File(path,picFileName);//这仅仅是一个驱壳，需要将临时文件（files）导入

        // 把上传的文件，拷贝到目标文件中

        try {
            FileUtils.copyFile(pic, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //在驱壳中填充灵魂
        System.out.println(destFile.getName());

        return SUCCESS;

    }


}
