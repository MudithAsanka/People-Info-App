package dev.mudithasanka.infoapp;

import android.app.Person;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "PersonInfo.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "person";
    private static final String ID = "_id";
    private static final String H_NO = "person_h_no";
    private static final String NAME = "person_name";
    private static final String NIC = "person_nic";
    private static final String GENDER = "person_gender";
    private static final String SUB_NO = "person_sub_no";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        H_NO + " TEXT, " +
                        NAME + " TEXT, " +
                        NIC + " TEXT, " +
                        GENDER + " TEXT, " +
                        SUB_NO + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addPerson(String h_no, String name, String nic, String gender, Integer sub_no){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(H_NO, h_no);
        cv.put(NAME, name);
        cv.put(NIC, nic);
        cv.put(GENDER, gender);
        cv.put(SUB_NO, sub_no);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }


}
