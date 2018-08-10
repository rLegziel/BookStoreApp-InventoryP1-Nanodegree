package com.example.android.bookstoreapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.bookstoreapp.data.BookContract.BookEntry;
import com.example.android.bookstoreapp.data.BookDbHelper;

public class MainActivity extends AppCompatActivity {

    private BookDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new BookDbHelper(this);

        Button button =(Button) findViewById(R.id.insert_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertBook();
                displayData();
            }
        });
    }

    private void insertBook() {

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BookEntry.COLUMN_BOOK_NAME, "Slaughterhouse-5");
        values.put(BookEntry.COLUMN_BOOK_PRICE, 15);
        values.put(BookEntry.COLUMN_BOOK_QUANTITY, 5);
        values.put(BookEntry.COLUMN_BOOK_SUPPLIER, "Penguin Books");
        values.put(BookEntry.COLUMN_BOOK_PHONE_SUPPLIER, "01223344556");

        long rowId = db.insert(BookEntry.TABLE_NAME, null, values);

    }

    private void displayData(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                BookEntry._ID,
                BookEntry.COLUMN_BOOK_NAME,
                BookEntry.COLUMN_BOOK_PRICE,
                BookEntry.COLUMN_BOOK_QUANTITY,
                BookEntry.COLUMN_BOOK_SUPPLIER,
                BookEntry.COLUMN_BOOK_PHONE_SUPPLIER
        };

        TextView displayView = (TextView) findViewById(R.id.data_view);

        Cursor cursor = db.query(BookEntry.TABLE_NAME,projection,null,null,null,null,null);

        int idColumnIndex = cursor.getColumnIndex(BookEntry._ID);
        int nameColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_NAME);
        int priceColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_PRICE);
        int quantityColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_QUANTITY);
        int supplierColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_SUPPLIER);
        int phoneSupplierColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_PHONE_SUPPLIER);

        try {

            while (cursor.moveToNext()) {

                int currentId = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                int currentPrice = cursor.getInt(priceColumnIndex);
                int currentQuantity = cursor.getInt(quantityColumnIndex);
                String currentSupplierName = cursor.getString(supplierColumnIndex);
                int currentSupplierNumber = cursor.getInt(phoneSupplierColumnIndex);

                displayView.append(currentId +" "
                        + currentName + " "
                                + currentPrice + " "
                                + currentQuantity + " "
                                + currentSupplierName + " "
                                + currentSupplierNumber
                );

            }

        } finally{
            cursor.close();
        }




    }
}
