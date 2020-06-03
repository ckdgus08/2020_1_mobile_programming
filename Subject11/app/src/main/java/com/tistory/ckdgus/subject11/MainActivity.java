package com.tistory.ckdgus.subject11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText editText;

    public static ArrayList<Todo> list = new ArrayList<>();
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = DBHelper.getInstance(getApplicationContext());
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        editText = findViewById(R.id.editText);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = dbHelper.getAll();

        final CchAdapter adapter = new CchAdapter(list);
        recyclerView.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todo = editText.getText().toString();
                Todo newTodo = new Todo(todo);
                list.add(newTodo);
                adapter.notifyDataSetChanged();
                editText.setText(null);
                dbHelper.insert(newTodo);
            }
        });
    }

}
