package com.tistory.ckdgus.cchsubject09;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.View;

public class Draw extends View {

    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float satur = 1;

    public Draw(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.pikachu);
        int w = (this.getWidth() - picture.getWidth()) / 2;
        int h = (this.getHeight() - picture.getHeight()) / 2;

        canvas.scale(scaleX, scaleY, this.getWidth() / 2, this.getHeight() / 2);
        canvas.rotate(angle, this.getWidth() / 2, this.getHeight() / 2);
        Paint paint = new Paint();
        float[] array = {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0};
        ColorMatrix cm = new ColorMatrix(array);
        cm.setSaturation(satur);
        paint.setColorFilter(new ColorMatrixColorFilter(cm));
        canvas.drawBitmap(picture, w, h, paint);
        picture.recycle();

    }

}
