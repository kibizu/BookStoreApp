package com.example.android.bookstoreapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.android.bookstoreapp.data.BookContract.BookEntry;
import com.example.android.bookstoreapp.data.BookDbHelper;

import java.sql.Blob;


public class CatalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        displayDatabaseInfo();

        // Create and/or open a database to read from it
        //SQLiteDatabase db = mDbHelper.getReadableDatabase();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    private void insertBook(){

        BookDbHelper mDbHelper = new BookDbHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(BookEntry.COLUMN_PRODUCT_NAME, "Harry Potter e la pietra filosofale");
        values.put(BookEntry.COLUMN_PRODUCT_PRICE, 1100);
        values.put(BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME,"SALANI");
        values.put(BookEntry.COLUMN_PRODUCT_AUTHOR, "J.K. Rowling");

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(BookEntry.TABLE_NAME, null, values);

        values.clear();

        values = new ContentValues();

        values.put(BookEntry.COLUMN_PRODUCT_NAME, "Harry Potter e la camera dei segreti");
        values.put(BookEntry.COLUMN_PRODUCT_PRICE, 1400);
        values.put(BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME,"SALANI");
        values.put(BookEntry.COLUMN_PRODUCT_AUTHOR, "J.K. Rowling");

        // Insert the new row, returning the primary key value of the new row
        newRowId = db.insert(BookEntry.TABLE_NAME, null, values);

        values.clear();

        values = new ContentValues();

        values.put(BookEntry.COLUMN_PRODUCT_NAME, "Harry Potter e il prigioniero di Azkaban");
        values.put(BookEntry.COLUMN_PRODUCT_PRICE, 1600);
        values.put(BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME,"SALANI");
        values.put(BookEntry.COLUMN_PRODUCT_AUTHOR, "J.K. Rowling");

        // Insert the new row, returning the primary key value of the new row
        newRowId = db.insert(BookEntry.TABLE_NAME, null, values);

        values.clear();

        values = new ContentValues();

        values.put(BookEntry.COLUMN_PRODUCT_NAME, "Harry Potter e il calice di fuoco");
        values.put(BookEntry.COLUMN_PRODUCT_PRICE, 1500);
        values.put(BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME,"SALANI");
        values.put(BookEntry.COLUMN_PRODUCT_AUTHOR, "J.K. Rowling");

        // Insert the new row, returning the primary key value of the new row
        newRowId = db.insert(BookEntry.TABLE_NAME, null, values);

        values.clear();

        values = new ContentValues();

        values.put(BookEntry.COLUMN_PRODUCT_NAME, "Harry Potter e l'ordine della fenice");
        values.put(BookEntry.COLUMN_PRODUCT_PRICE, 1700);
        values.put(BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME,"SALANI");
        values.put(BookEntry.COLUMN_PRODUCT_AUTHOR, "J.K. Rowling");

        // Insert the new row, returning the primary key value of the new row
        newRowId = db.insert(BookEntry.TABLE_NAME, null, values);

        values.clear();

        values = new ContentValues();

        values.put(BookEntry.COLUMN_PRODUCT_NAME, "Harry Potter e il principe Mezzosabgue");
        values.put(BookEntry.COLUMN_PRODUCT_PRICE, 1700);
        values.put(BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME,"SALANI");
        values.put(BookEntry.COLUMN_PRODUCT_AUTHOR, "J.K. Rowling");

        // Insert the new row, returning the primary key value of the new row
        newRowId = db.insert(BookEntry.TABLE_NAME, null, values);

        values.clear();

        values = new ContentValues();

        values.put(BookEntry.COLUMN_PRODUCT_NAME, "Harry Potter e i doni della morte");
        values.put(BookEntry.COLUMN_PRODUCT_PRICE, 1900);
        values.put(BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME,"SALANI");
        values.put(BookEntry.COLUMN_PRODUCT_AUTHOR, "J.K. Rowling");

        // Insert the new row, returning the primary key value of the new row
        newRowId = db.insert(BookEntry.TABLE_NAME, null, values);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                insertBook();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                //Do nothing for now
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Temporary helper method to display information in the onscreen TextView about the state of
     * the books database.
     */
    private void displayDatabaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        BookDbHelper mDbHelper = new BookDbHelper(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                BookEntry.COLUMN_PRODUCT_NAME,
                BookEntry.COLUMN_PRODUCT_PRICE,
                BookEntry.COLUMN_PRODUCT_QUANTITY,
                BookEntry.COLUMN_PRODUCT_AUTHOR,
                BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME,
                BookEntry.COLUMN_PRODUCT_SUPPLIER_PHONE_NUMBER
        };

        Cursor cursor = db.query(
                BookEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        TextView displayView = (TextView) findViewById(R.id.text_view_book);

        try {

            int idColumnIndex = cursor.getColumnIndex(BookEntry._ID);
            int productNameColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_PRODUCT_NAME);
            int priceColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_PRODUCT_PRICE);
            int quantityColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_PRODUCT_QUANTITY);
            int authorColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_PRODUCT_AUTHOR);
            int supplierNameColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME);
            int supplierPhoneNumberColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_PRODUCT_SUPPLIER_PHONE_NUMBER);

            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // books table in the database).

            displayView.setText("Number of rows in Books database table: " + cursor.getCount() + "\n");

            displayView.append("\n" + BookEntry._ID + " - " + BookEntry.COLUMN_PRODUCT_NAME + " - " + BookEntry.COLUMN_PRODUCT_PRICE + " - "
                    + BookEntry.COLUMN_PRODUCT_QUANTITY + " - " + BookEntry.COLUMN_PRODUCT_AUTHOR + " - "
                    + BookEntry.COLUMN_PRODUCT_SUPPLIER_NAME + " - " + BookEntry.COLUMN_PRODUCT_SUPPLIER_PHONE_NUMBER + "\n");

            while (cursor.moveToNext()){

                int currentId = cursor.getInt(idColumnIndex);
                String currentProductName = cursor.getString(productNameColumnIndex);
                int currentPrice = cursor.getInt(priceColumnIndex);
                int currentQuantity = cursor.getInt(quantityColumnIndex);
                String currentAuthor = cursor.getString(authorColumnIndex);
                String currentSupplierName = cursor.getString(supplierNameColumnIndex);
                int currentSupplierPhoneNumber = cursor.getInt(supplierPhoneNumberColumnIndex);

                displayView.append("\n" + currentId
                        + " - " + currentProductName
                        + " - " + currentPrice
                        + " - " + currentQuantity
                        + " - " + currentAuthor
                        + " - " + currentSupplierName
                        + " - " + currentSupplierPhoneNumber);

            }

        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

}
