package edu.nju.song.catchcat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by song on 16-7-1.
 * <p/>
 * 背景绘制
 */
public class PlayGround extends SurfaceView {

    /**
     * 棋盘对象
     */
    private Modal modal;

    /**
     * 圆形直径
     */
    private final int diameter = 100;

    public PlayGround(Context context) {
        super(context);
        getHolder().addCallback(callback);

        modal = new Modal();
    }


    private void redraw() {
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(Color.LTGRAY);

        Paint paint = new Paint();
        // 消除锯齿
        paint.setAntiAlias(true);

        Dot temp;
        for (int i = 0; i < Modal.row; i++) {
            for (int j = 0; j < Modal.column; j++) {
                temp = modal.getDot(i, j);
                switch (temp.getStatus()) {
                    case Dot.STATUS_EMPTY:
                        paint.setColor(Color.BLUE);
                        break;
                    case Dot.STATUS_BLOCK:
                        paint.setColor(Color.CYAN);
                        break;
                    case Dot.STATUS_CAT:
                        paint.setColor(Color.YELLOW);
                        break;
                    default:
                        break;
                }

                if (j % 2 == 0) {
                    canvas.drawOval(i * diameter, j * diameter,
                            (i + 1) * diameter, (j + 1) * diameter, paint);
                } else {
                    canvas.drawOval(i * diameter + diameter / 2, j * diameter,
                            (i + 1) * diameter + diameter / 2, (j + 1) * diameter, paint);
                }
            }
        }

        getHolder().unlockCanvasAndPost(canvas);
    }

    SurfaceHolder.Callback callback = new SurfaceHolder.Callback() {

        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            redraw();
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

        }
    };
}
