package com.tasya.kuis_2.DB;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Tasya on 5/7/2018.
 */

public class DbOpenHelper extends SQLiteOpenHelper {
    private static final String LOG = "DbOpenHelper";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user_db.db";
    private static final String CREATE_TABLE_TABUNGAN =
            "CREATE TABLE TABUNGAN (user_id INTEGER PRIMARY KEY, " +
    "nama_user TEXT NOT NULL, " + "koin INTEGER NOT NULL)";

    public DbOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_TABUNGAN);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il){
        db.execSQL("DROP TABLE IF EXISTS TABUNGAN");
        onCreate(db);
    }
}
