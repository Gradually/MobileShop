package cn.wycclub.domain;

/**
 * 商品图片Bean
 *
 * @author WuYuchen
 * @date 2017-10-31 10:20
 */

public class ProductImageBean {
    private int ImageID;
    private final String main = "/main";
    private final String desc = "/desc";
    private final String outPath = "/product";
    private String descPath;
    private String mainPath;

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    public String getDescPath() {
        return descPath;
    }

    public void setPath(String path) {
        this.descPath = path + this.outPath + this.desc;
        this.mainPath = path + this.outPath + this.main;
    }

    public String getMainPath() {
        return mainPath;
    }

}
