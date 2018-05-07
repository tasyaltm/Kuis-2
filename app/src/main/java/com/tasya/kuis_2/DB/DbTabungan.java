package com.tasya.kuis_2.DB;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Tasya on 5/7/2018.
 */

public class DbTabungan {
    private SQLiteDatabase db;
    private final DbOpenHelper dbOH;
    public DbTabungan(Context ctx){
        dbOH = new DbOpenHelper(ctx);
    }

    public void open() {
        db = dbOH.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

}
