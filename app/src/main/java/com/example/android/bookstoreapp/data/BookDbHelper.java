package com.example.android.bookstoreapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.bookstoreapp.data.BookContract.BookEntry;

/**
 * Created by roix on 8/10/18.
 */

public class BookDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = BookDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "bookstore.db";

    private static final int DATABASE_VERSION = 1 ;

    public BookDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_BOOKS_TABLE =  "CREATE TABLE " + BookEntry.TABLE_NAME + " ("
                + BookEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BookEntry.COLUMN_BOOK_NAME + " TEXT NOT NULL, "
                + BookEntry.COLUMN_BOOK_PRICE + " INT, "
                + BookEntry.COLUMN_BOOK_QUANTITY + " INT NOT NULL, "
                + BookEntry.COLUMN_BOOK_SUPPLIER + " TEXT NOT NULL, "
                + BookEntry.COLUMN_BOOK_PHONE_SUPPLIER + " INT);";

         db.execSQL(SQL_CREATE_BOOKS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
