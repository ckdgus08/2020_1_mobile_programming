package ckdgus.tistory.com.subject05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button button1, button2, button3, button4, button5;
    ScrollView scrollView;
    MainActivity mainActivity;
    static long temp;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = this;
        chronometer = findViewById(R.id.chronometer);
        scrollView = findViewById(R.id.scrollView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {

                    case R.id.button1:
                        chronometer.setBase(SystemClock.elapsedRealtime());
                        chronometer.start();
                        button1.setVisibility(View.GONE);
                        button2.setVisibility(View.VISIBLE);
                        button3.setVisibility(View.VISIBLE);
                        break;

                    case R.id.button2:
                        chronometer.stop();
                        temp = SystemClock.elapsedRealtime();
                        button2.setVisibility(View.GONE);
                        button3.setVisibility(View.GONE);
                        button4.setVisibility(View.VISIBLE);
                        button5.setVisibility(View.VISIBLE);
                        break;

                    case R.id.button4:

                        long time = chronometer.getBase() + (SystemClock.elapsedRealtime() - temp);
                        chronometer.setBase(time);
                        chronometer.start();

                        button4.setVisibility(View.GONE);
                        button5.setVisibility(View.GONE);
                        button2.setVisibility(View.VISIBLE);
                        button3.setVisibility(View.VISIBLE);
                        break;

                    case R.id.button3:

                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.setMargins(10, 10, 10, 10);

                        TextView markText = new TextView(mainActivity);
                        markText.setLayoutParams(params);
                        markText.setGravity(Gravity.CENTER);
                        markText.setText(chronometer.getText());
                        markText.setTextSize(25);

                        LinearLayout layout;

                        if (scrollView.getChildCount() == 0) {
                            layout = new LinearLayout(mainActivity);
                            layout.setOrientation(LinearLayout.VERTICAL);
                        } else {
                            layout = (LinearLayout) scrollView.getChildAt(0);
                        }

                        layout.addView(markText, 0);
                        scrollView.removeAllViews();
                        scrollView.addView(layout);

                        break;

                    case R.id.button5:
                        scrollView.removeAllViews();
                        chronometer.setBase(SystemClock.elapsedRealtime());
                        chronometer.stop();
                        button1.setVisibility(View.VISIBLE);
                        button4.setVisibility(View.GONE);
                        button5.setVisibility(View.GONE);
                        break;


                }


            }
        };

        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);


    }


}
