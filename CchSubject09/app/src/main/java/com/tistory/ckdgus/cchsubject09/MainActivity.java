package com.tistory.ckdgus.cchsubject09;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton button1, button2, button3, button4;
    static LinearLayout layout;
    Draw draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setTitle("16100415 최창현");
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        layout = findViewById(R.id.layout);
        draw = new Draw(this);
        layout.addView(draw);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Draw.scaleX += 0.2f;
                Draw.scaleY += 0.2f;
                layout.removeAllViews();
                draw();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Draw.scaleX -= 0.2f;
                Draw.scaleY -= 0.2f;
                layout.removeAllViews();
                draw();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Draw.angle += 20;
                layout.removeAllViews();
                draw();

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Draw.satur == 1) {
                    Draw.satur = 0;
                } else {
                    Draw.satur = 1;
                }
                layout.removeAllViews();
                draw();

            }
        });

    }



    public void draw() {
        draw = new Draw(this);
        layout.addView(draw);
    }

}
