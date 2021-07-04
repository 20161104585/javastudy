package main.java.com.game.tank;

import java.awt.*;

/**
 * @Description: 子弹实体类
 * @Author: haole
 * @Date: 2021/7/4 14:00
 */
public class Bullect {
    private static final int SPEED = 10;
    private static final int WIDTH = 20, HEIGHT = 20;

    private int x, y;
    private Dir dir;

    public Bullect(int x, int y, Dir dir) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);
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
    }
}
