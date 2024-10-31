package com.example.progresscheckerforcbc;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.progresscheckerforcbc.model.students;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "student_ratings_db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "pp2rating";
    private static final String TABLE_NAME2 = "students";
    // below variable is for our id column.
    private static final String ID_COL = "id";
    private static final String ID_COL2 = "id";
    // below variable is for our course name column
    private static final String  NAME_COL = "name";
    private static final String  NAME_COL2 = "students_name";
      // below variable id for our course duration column.
    private static final String SUBJECT_COL = "subject";

    // below variable for our course description column.
    private static final String TOPIC_COL = "topic";

    // below variable is for our course tracks column.
    private static final String RATING_COL = "rating";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase dbe) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + SUBJECT_COL+ " TEXT,"
                + TOPIC_COL + " TEXT,"
                + RATING_COL + " TEXT)";

        String query2 = "CREATE TABLE " + TABLE_NAME2+"("
                + ID_COL2 + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME_COL2 + "TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        dbe.execSQL(query);
        dbe.execSQL(query2);

    }

    // this method is use to add new course to our sqlite database.
    public void addRating(String student_Name, String subject, String topic, String rating) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase dbe = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, student_Name);
        values.put(SUBJECT_COL, subject);
        values.put(TOPIC_COL, topic);
        values.put(RATING_COL, rating);

        // after adding all values we are passing
        // content values to our table.
        dbe.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        dbe.close();
    }
    public ArrayList<String> readRating(String idd) {

        SQLiteDatabase dbe = this.getReadableDatabase();

            String query = "SELECT * FROM pp2rating WHERE EXISTS ( SELECT 1 from pp2rating WHERE name = ?) ";
            String[] selectionArgs = {idd};

            Cursor cursorCourses = dbe.rawQuery(query, selectionArgs);

            // on below line we are creating a new array list.
            ArrayList<String> student_details = new ArrayList<>();



       if (cursorCourses.moveToFirst()) {
           do {
               // on below line we are adding the data from cursor to our array list.

               student_details.add(cursorCourses.getString(3)); //0 topic
               student_details.add(cursorCourses.getString(4));//1 rating
               student_details.add(cursorCourses.getString(1));//2  name
               student_details.add(cursorCourses.getString(2));//3 subject


           } while (cursorCourses.moveToNext());
           // moving our cursor to next.
       }
       // at last closing our cursor
       // and returning our array list.
       cursorCourses.close();
       return student_details;
    }

    public void addStudent(String student_Name) {

        SQLiteDatabase dbe = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COL2, student_Name);

        dbe.insert(TABLE_NAME2, null, values);


        dbe.close();
    }

public ArrayList<students> read_student() {
    SQLiteDatabase dbe = this.getReadableDatabase();
    ArrayList<students> s_list = new ArrayList<>();
    String query = "SELECT * FROM students WHERE EXISTS ( SELECT * from pp2rating) ";
    Cursor cursorCourses = dbe.rawQuery(query, null);
    if (cursorCourses.moveToFirst()) {
        do {
            // on below line we are adding the data from cursor to our array list.

            s_list.add(new students(cursorCourses.getString(1)));


        } while (cursorCourses.moveToNext());
    }
    cursorCourses.close();
    return s_list;
}







    @Override
    public void onUpgrade(SQLiteDatabase dbe, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        dbe.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(dbe);
    }
}