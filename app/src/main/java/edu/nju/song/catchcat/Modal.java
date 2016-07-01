package edu.nju.song.catchcat;

import java.util.Random;

/**
 * Created by song on 16-7-1.
 * <p/>
 * 整个棋盘面
 */
public class Modal {

    /**
     * 行，列
     */
    public static final int row = 10;
    public static final int column = 10;

    /**
     * 默认路障数量
     */
    private static final int blocks = 10;

    /**
     * 储存所有点，构成点阵
     */
    private Dot dots[][];

    /**
     * 猫所在的点
     */
    private Dot cat;

    private Random random = new Random();

    public Modal() {
        initModal();
        initCat();
        initBlocks();
    }

    /**
     * 初始化棋盘
     */
    private void initModal() {
        dots = new Dot[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dots[i][j] = new Dot(i, j);
                dots[i][j].setStatus(Dot.STATUS_EMPTY);
            }
        }
    }

    /**
     * 初始化猫
     */
    private void initCat() {
        // 猫初始位置
        int cat_x = 0, cat_y = 0;

        while ((cat_x + cat_y) == 0) {
            cat_x = random.nextInt(row - 2);
            cat_y = random.nextInt(column - 2);
        }

        cat = new Dot(cat_x, cat_y);
        dots[cat_x][cat_y].setStatus(Dot.STATUS_CAT);
    }

    /**
     * 初始化路障
     */
    private void initBlocks() {
        int temp_x, temp_y;

        for (int i = 0; i < blocks; ) {
            temp_x = random.nextInt(row);
            temp_y = random.nextInt(column);

            if (dots[temp_x][temp_y].getStatus() == Dot.STATUS_EMPTY) {
                dots[temp_x][temp_y].setStatus(Dot.STATUS_BLOCK);
                i++;
            }
        }
    }

    public Dot getDot(int x, int y) {
        return dots[y][x];
    }

    public Dot getCat() {
        return cat;
    }
}
