package cn.wycclub.domain;

import java.awt.image.BufferedImage;

/**
 * 验证码对象
 *
 * @author WuYuchen
 * @date 2017-10-27 14:34
 */

public class CheckCode {
    private String code;
    private BufferedImage image;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }


}
