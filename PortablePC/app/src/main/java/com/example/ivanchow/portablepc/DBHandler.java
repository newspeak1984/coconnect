package com.example.ivanchow.portablepc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



public class DBHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 13;
    public static final String DATABASE_NAME = "portableDB.db";
    public static final String TABLE_STORYBOARD = "storyboard";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    //public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_ARTICLE = "article";
    public static final String COLUMN_CATEGORY = "category";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version ) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_STORYBOARD + "( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                //COLUMN_TITLE + " TEXT, " + COLUMN_AUTHOR +" TEXT, " +
                COLUMN_IMAGE + " BLOB, " + COLUMN_ARTICLE + " TEXT, "+ COLUMN_CATEGORY +" TEXT );";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STORYBOARD + ";");
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STORYBOARD  + ";");
        onCreate(db);
    }

    public void addNewsStory(NewsStory story){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, story.getTitle());
        //values.put(COLUMN_AUTHOR, story.getAuthor());
        values.put(COLUMN_IMAGE, bitmapUtil.getBytes(story.getTitleImage()));
        values.put(COLUMN_ARTICLE, story.getArticle());
        values.put(COLUMN_CATEGORY, story.getCategory());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_STORYBOARD, null, values);
        db.close();
    }

    public void deleteNewsStory(String story){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_STORYBOARD + " WHERE " + COLUMN_TITLE + "=\""+ story +"\";");
    }
    public ArrayList<NewsStory> databaseStories(String category){
        ArrayList<NewsStory> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query;
        if(category == "All News") {
             query = "SELECT * FROM " + TABLE_STORYBOARD + " WHERE 1;";
        }else{
             query = "SELECT * FROM " + TABLE_STORYBOARD + " WHERE " + COLUMN_CATEGORY + " = '" +category +"';";
        }

        Cursor recordSet = db.rawQuery(query, null);
        recordSet.moveToFirst();

        while(!recordSet.isAfterLast()){
            {
                list.add(new NewsStory(recordSet.getString(recordSet.getColumnIndex("title")), bitmapUtil.getImage(recordSet.getBlob(recordSet.getColumnIndex("image"))),recordSet.getString(recordSet.getColumnIndex("article")),recordSet.getString(recordSet.getColumnIndex("category"))));
            }
            recordSet.moveToNext();
        }
        db.close();
        return list;
    }
    public NewsStory getDB(String title){
        NewsStory news;
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_STORYBOARD + " WHERE " + COLUMN_TITLE + " = '" +title +"';";

        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results
        while (!recordSet.isAfterLast()) {
            // null could happen if we used our empty constructor
            {
                news = new NewsStory(recordSet.getString(recordSet.getColumnIndex("title")), bitmapUtil.getImage(recordSet.getBlob(recordSet.getColumnIndex("image"))),recordSet.getString(recordSet.getColumnIndex("article")),recordSet.getString(recordSet.getColumnIndex("category")));
                db.close();
                return news;
            }

        }


        return null;
    }
}



