package main.java.com.game.tank;

import java.awt.*;
import java.util.Random;

/**
 * @Description: 坦克实体类
 * @Author: haole
 * @Date: 2021/7/4 13:23
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    public static final int WIDTH = ResourcrMgr.tankD.getWidth(),
            HEIGHT = ResourcrMgr.tankD.getHeight();
    private boolean living = true;
    private boolean moving = true;
    private Random random = new Random();
    private TankFrame tf = null;
    private Group group = Group.BAD;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.tankList.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourcrMgr.tankL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourcrMgr.tankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourcrMgr.tankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourcrMgr.tankD, x, y, null);
                break;
        }

        move();
    }

    private void move() {
        if (!moving) {
            return;
        }
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
        if (random.nextInt(10) > 8) {
            this.fire();
        }
    }


    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullect.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullect.HEIGHT / 2;
        tf.bullectList.add(new Bullect(bX, bY, this.dir, this.group, this.tf));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void die() {
        this.living = false;
    }
}
