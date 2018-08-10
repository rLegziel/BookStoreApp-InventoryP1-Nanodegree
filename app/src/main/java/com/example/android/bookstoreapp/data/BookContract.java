package com.example.android.bookstoreapp.data;

import android.provider.BaseColumns;

/**
 * Created by roix on 8/10/18.
 */

public class BookContract {

    public static final class BookEntry implements BaseColumns{

        //name of the table
        public static final String TABLE_NAME = "books";

        //name of columns
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_BOOK_NAME  = "Product_Name";
        public static final String COLUMN_BOOK_PRICE = "Price";
        public static final String COLUMN_BOOK_QUANTITY = "Quantity";
        public static final String COLUMN_BOOK_SUPPLIER = "Supplier_Name";
        public static final String COLUMN_BOOK_PHONE_SUPPLIER = "Suppliers_Phone_Number";

    }
}
