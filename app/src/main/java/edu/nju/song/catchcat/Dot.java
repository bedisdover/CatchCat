package edu.nju.song.catchcat;

/**
 * Created by song on 16-7-1.
 * <p/>
 * 点对象
 */
public class Dot {

    /**
     * 空状态（猫可移动至此点，也可设置路障）
     */
    public static final int STATUS_EMPTY = 1;

    /**
     * 已经设置路障
     */
    public static final int STATUS_BLOCK = 2;

    /**
     * 猫所在的位置
     */
    public static final int STATUS_CAT = 3;

    /**
     * 行，列
     */
    int x, y;

    /**
     * 状态
     */
    int status;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;

        status = STATUS_EMPTY;
    }

    public int getStatus() {
        return status;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
