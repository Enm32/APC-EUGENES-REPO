package com.example.parents_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.parents_app.models.student_class;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {



    private static final String DB_NAME = "students_list_db";


    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "students";

    private static final String ID_COL = "id";

    private static final String  NAME_COL = "student_name";

    private static final String GRADE_COL = "student_grade";


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase dbe) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + GRADE_COL+ " TEXT)";

        dbe.execSQL(query);

    }

    // this method is use to add new course to our sqlite database.
    public void addStudent(String student_Name, String studentGrade) {

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
        values.put(GRADE_COL, studentGrade);


        // after adding all values we are passing
        // content values to our table.
        dbe.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        dbe.close();
    }
    public ArrayList<student_class> getStudents() {

        SQLiteDatabase dbe = this.getReadableDatabase();

//        String query = "SELECT * FROM students WHERE EXISTS ( SELECT * from students WHERE student_name = ?) ";
        String query = "SELECT * FROM students ";
//        String[] selectionArgs = {Sname};

        Cursor cursorCourses = dbe.rawQuery(query,null);

        // on below line we are creating a new array list.
        ArrayList<student_class> student_details = new ArrayList<>();



        if (cursorCourses.moveToFirst()) {
            do {


                student_details.add(new student_class(cursorCourses.getString(1),cursorCourses.getString(2)));//2  name



            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return student_details;
    }










    @Override
    public void onUpgrade(SQLiteDatabase dbe, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        dbe.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(dbe);
    }



}
