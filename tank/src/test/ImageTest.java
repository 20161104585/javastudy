package test;


import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import static org.junit.Assert.assertNotNull;

/**
 * @Description:
 * @Author: haole
 * @Date: 2021/7/10 14:48
 */
public class ImageTest {
    @Test
    public void test1() {
        //fail("Not yet implemented");
        try {
            //BufferedImage image = ImageIO.read(new File("123"));
            //assertNotNull(image);

            BufferedImage image2 = ImageIO.read(this.getClass().getClassLoader().
                    getResourceAsStream("images/tankD.gif"));
            assertNotNull(image2);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
