package com.example.android.bookstoreapp.data;

import android.provider.BaseColumns;

public class BookContract {

    private BookContract(){

    }

    public final static class BookEntry implements BaseColumns{

        public final static String TABLE_NAME = "books";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PRODUCT_NAME = "product_name";
        public final static String COLUMN_PRODUCT_PRICE = "price";
        public final static String COLUMN_PRODUCT_QUANTITY = "quantity";
        public final static String COLUMN_PRODUCT_SUPPLIER_NAME = "supplier_name";
        public final static String COLUMN_PRODUCT_SUPPLIER_PHONE_NUMBER = "supplier_phone_number";
        public final static String COLUMN_PRODUCT_AUTHOR = "author";

    }

}
