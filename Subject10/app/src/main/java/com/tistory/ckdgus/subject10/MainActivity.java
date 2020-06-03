package com.tistory.ckdgus.subject10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.goToJoin);
        email = findViewById(R.id.email_main);
        password = findViewById(R.id.password_main);

        Intent intent = getIntent();
        if (intent != null) {
            String data1 = intent.getStringExtra("Email");
            String data2 = intent.getStringExtra("Password");
            email.setText(data1);
            password.setText(data2);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });
    }

}
