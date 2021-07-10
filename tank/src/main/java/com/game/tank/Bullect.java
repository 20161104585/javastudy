package main.java.com.game.tank;

import java.awt.*;

/**
 * @Description: 子弹实体类
 * @Author: haole
 * @Date: 2021/7/4 14:00
 */
public class Bullect {
    private static final int SPEED = 15;
    public static final int WIDTH = ResourcrMgr.bulletD.getWidth(),
            HEIGHT = ResourcrMgr.bulletD.getHeight();

    private boolean live = true;
    private int x, y;
    private Dir dir;
    TankFrame tf = null;

    public Bullect(int x, int y, Dir dir, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if(!live){
            tf.bullectList.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourcrMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourcrMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourcrMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourcrMgr.bulletD, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;

        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }
}
