package main.java.com.game.tank;

import java.awt.*;

/**
 * @Description: 坦克大战主函数
 * @Author: haole
 * @Date: 2021/7/4 7:43
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        for (int i = 0; i < 5; i++) {
            tf.tankList.add(new Tank(50 +i*50,50,Dir.DOWN,Group.BAD,tf));
        }
        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
