package com.tistory.ckdgus.subject11;

public class TodoDBContract {

    private TodoDBContract() {

    }

    public static final String TABLE_TODO = "todo";
    public static final String COL_TITLE = "todo_title";
    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_TODO + " (" + COL_TITLE + " CHAR(20) PRIMARY KEY )";
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_TODO;
    public static final String SQL_SELECT = "SELECT * FROM " + TABLE_TODO;
    public static final String SQL_INSERT = "INSERT OR REPLACE INTO " + TABLE_TODO + " (" + COL_TITLE + ") VALUES" ;
    public static final String SQL_DELETED = "DELETE FROM " + TABLE_TODO + " WHERE " + COL_TITLE + " = ";

}
