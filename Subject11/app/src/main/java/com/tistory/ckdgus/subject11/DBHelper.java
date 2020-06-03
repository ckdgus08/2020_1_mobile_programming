package com.tistory.ckdgus.subject11;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "todo_db";
    public static final int DB_VERSION = 1;

    private static volatile DBHelper instance;
    private SQLiteDatabase db;

    public static DBHelper getInstance(Context context) {
        if( instance == null) {
            synchronized (DBHelper.class) {
                if(instance==null) {
                    instance = new DBHelper(context);
                }
            }
        }
        return instance;
    }

    private DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if(db == null) {
            db = getWritableDatabase();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TodoDBContract.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL((TodoDBContract.SQL_DROP_TABLE));
        onCreate(db);
    }

    public void insert(Todo todo) {
        db.execSQL("INSERT OR REPLACE INTO " + TodoDBContract.TABLE_TODO + " (" + TodoDBContract.COL_TITLE +") VALUES " + "(" + '"' + todo.getTodo()+ '"' + ")");
    }

    public void delete(Todo todo) {
        db.execSQL("DELETE FROM " + TodoDBContract.TABLE_TODO + " WHERE " + TodoDBContract.COL_TITLE + " = \"" + todo.getTodo() +"\"" );
    }

    public ArrayList<Todo> getAll() {
        ArrayList<Todo> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(TodoDBContract.SQL_SELECT, null);

            while (cursor.moveToNext()) {
                String tel = cursor.getString(0);
                list.add(new Todo(tel));
            }

        return list;
    }

}

