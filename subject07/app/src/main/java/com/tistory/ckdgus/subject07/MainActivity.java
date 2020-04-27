package com.tistory.ckdgus.subject07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    TextView textView1, textView2;
    CalendarView calendarView;
    EditText editText;
    File file;
    static int year1, month1, dayOfMonth1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
        calendarView = findViewById(R.id.calender_main);

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DATE);

        showDate(year, month, dayOfMonth);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MODE_PRIVATE);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                year1 = year;
                month1 = month;
                dayOfMonth1 = dayOfMonth;

                showDate(year, month, dayOfMonth);

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setDate(year1, month1, dayOfMonth1);

                showDate(year1, month1, dayOfMonth1);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.INVISIBLE);
                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);

                editText.setText(textView1.getText());

            }
        });
    }

    public void setDate(int year, int month, int dayOfMonth) {

        String fileTitle = year + "_" + (month + 1) + "_" + dayOfMonth + ".txt";
        file = new File(Environment.getExternalStorageDirectory(), fileTitle);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, false);
            String str = editText.getText().toString();
            writer.write(str);
            writer.close();
        } catch (IOException e) {

        }

    }

    public void showDate(int year, int month, int dayOfMonth) {

        String fileTitle = year + "_" + (month + 1) + "_" + dayOfMonth + ".txt";
        file = new File(Environment.getExternalStorageDirectory(), fileTitle);

        try {
            if (file.length() == 0) {
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.INVISIBLE);
                textView1.setText("일정이 없습니다.");
                textView2.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);
                editText.setText("");
            } else {

                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.INVISIBLE);

                BufferedReader reader = new BufferedReader(new FileReader(file));
                String result = "";
                String line;
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
                textView1.setText(result);
                reader.close();
            }
        } catch (FileNotFoundException e1) {

        } catch (IOException e2) {

        }


    }


}
