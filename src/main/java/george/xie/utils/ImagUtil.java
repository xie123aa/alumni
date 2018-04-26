package george.xie.utils;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

public class ImagUtil {
    /**
     * @param standardImgPath 原图片path
     * @param thumName 缩略图path
     */
    public static File storeThumbnail(String standardImgPath, String thumName) {
        File file = new File(standardImgPath);
        if(file!=null&&file.isFile()){
            try {
                File outFIle = new File(thumName);
                Thumbnails.of(file).size(100, 150).toFile(outFIle);
                return outFIle;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
