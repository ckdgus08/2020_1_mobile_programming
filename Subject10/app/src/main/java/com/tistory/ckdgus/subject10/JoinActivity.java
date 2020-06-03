package com.tistory.ckdgus.subject10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class JoinActivity extends Activity {

    EditText email, password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        submit = findViewById(R.id.submit);
        email = findViewById(R.id.email_join);
        password = findViewById(R.id.password_join);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("Email", email.getText().toString());
                intent.putExtra("Password", password.getText().toString());
                startActivityForResult(intent, 0);
            }
        });
    }
}
