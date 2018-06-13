package cn.wycclub.utils;

import cn.wycclub.domain.CheckCode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 生成验证码的工具
 *
 * @author WuYuchen
 * @date 2017-10-27 14:40
 */

public class CheckCodeUtils {
    /**
     * 验证码长宽
     * */
    private static final int WIDTH = 120;
    private static final int HEIGHT = 25;
    /**
     * 验证码图像缓冲区
     * */
    private static BufferedImage image;
    /**
     * 图像画笔
     * */
    private static Graphics g;
    /**
     * 验证码bean
     * */
    private static CheckCode checkCode;

    /**
     * 获取验证码
     * @return 验证码实例
     * */
    public static CheckCode getCheckCode() {
        //实例化验证码图像缓冲区
        image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);

        //获取可在验证码图像上画图的画笔
        g = image.getGraphics();

        //设置背景色
        setBackGround(g);

        //画干扰线
        drawRandomLine(g);

        //写随机数
        String code = drawRandomNum(g);

        //验证码Bean实例化
        checkCode = new CheckCode();
        checkCode.setCode(code);
        checkCode.setImage(image);
        return checkCode;
    }

    /**
     * 生成随机数
     * @return 随机数对应的数字
     * */
    private static String drawRandomNum(Graphics g) {
        //设置画笔颜色
        g.setColor(Color.BLUE);
        //设置画笔文字字体
        g.setFont(new Font("宋体",Font.BOLD,25));
        //设置验证码可以包含的参数
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        //在验证码包含的参数中加入大写英文
        str = str + str.toUpperCase();
        //设置第一个文字距离左边框的距离
        int x = 10;
        //字符串缓冲区
        StringBuilder code = new StringBuilder();
        for (int i = 0 ; i < 4 ; i++) {
            //从验证码参数中随机获取一个字符
            String ch = String.valueOf(str.charAt(new Random().nextInt(str.length())));
            //将获取到的字符画在验证码图片上
            g.drawString(ch, x,20);
            //将x轴向右移动30
            x += 30;
            //将获取到的字符存在字符串缓冲区中
            code.append(ch);
        }
        return code.toString();
    }

    /**
     * 画验证码干扰线
     * */
    private static void drawRandomLine(Graphics g) {
        g.setColor(Color.RED);
        for (int i = 0 ; i < 5 ; i++) {
            //在验证码区域内找两个点（x1, y1） (x2, y2) ，并将两点连接起来
            int x1 = new Random().nextInt(WIDTH);
            int y1 = new Random().nextInt(HEIGHT);
            int x2 = new Random().nextInt(WIDTH);
            int y2 = new Random().nextInt(HEIGHT);
            g.drawLine( x1, y1, x2, y2);
        }
    }

    /**
     * 设置验证码背景色
     * */
    private static void setBackGround(Graphics backGround) {
        g.setColor(new Color(238,238,238));
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }
}
