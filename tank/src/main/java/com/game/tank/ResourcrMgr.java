package main.java.com.game.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Description: 资源加载类
 * @Author: haole
 * @Date: 2021/7/10 15:46
 */
public class ResourcrMgr {
    public static BufferedImage tankL, tankU, tankR, tankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;

    static {
        try {
            tankL = ImageIO.read(ResourcrMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankU = ImageIO.read(ResourcrMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankR = ImageIO.read(ResourcrMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankD = ImageIO.read(ResourcrMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));

            bulletL = ImageIO.read(ResourcrMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletU = ImageIO.read(ResourcrMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletR = ImageIO.read(ResourcrMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletD = ImageIO.read(ResourcrMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
