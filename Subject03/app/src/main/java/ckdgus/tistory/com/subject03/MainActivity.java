package ckdgus.tistory.com.subject03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView, imageView1;
    Button button;
    CheckBox checkBox;
    RadioGroup radioGroup;
    RadioButton radioButton1,radioButton2,radioButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkBox);
        imageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(!b) {
                    button.setVisibility(View.GONE);
                    radioButton1.setVisibility(View.GONE);
                    radioButton2.setVisibility(View.GONE);
                    radioButton3.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                    imageView1.setVisibility(View.GONE);
                    textView.setText("16100415 최창현");
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.samuel_oak));

                } else {
                    button.setVisibility(View.VISIBLE);
                    textView.setText("스타팅 포켓몬을 선택하세요!");
                    radioButton1.setVisibility(View.VISIBLE);
                    radioButton2.setVisibility(View.VISIBLE);
                    radioButton3.setVisibility(View.VISIBLE);
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.GONE);
                }

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioButton1:
                        imageView1.setVisibility(View.VISIBLE);
                        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.chikorita));
                        break;
                    case R.id.radioButton2:
                        imageView1.setVisibility(View.VISIBLE);
                        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.cyndaquil));
                        break;
                    case R.id.radioButton3:
                        imageView1.setVisibility(View.VISIBLE);
                        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.totodile));
                        break;
                }
            }
        });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(radioButton1.isChecked()) {
                        Toast.makeText(getApplicationContext(), "치코리타! 너로 정했다!", Toast.LENGTH_LONG).show();
                        imageView1.setVisibility(View.VISIBLE);
                        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.ash_ketchum));
                    } else if(radioButton2.isChecked()) {
                        Toast.makeText(getApplicationContext(), "브케인! 너로 정했다!", Toast.LENGTH_LONG).show();
                        imageView1.setVisibility(View.VISIBLE);
                        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.ash_ketchum));
                    }else if(radioButton3.isChecked()) {
                        Toast.makeText(getApplicationContext(), "리아코! 너로 정했다!", Toast.LENGTH_LONG).show();
                        imageView1.setVisibility(View.VISIBLE);
                        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.ash_ketchum));
                    }
                }
            });
    }
}
