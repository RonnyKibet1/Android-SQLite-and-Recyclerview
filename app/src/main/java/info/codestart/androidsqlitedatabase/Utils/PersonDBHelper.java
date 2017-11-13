package info.codestart.androidsqlitedatabase.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import info.codestart.androidsqlitedatabase.model.Person;

/**
 * Created by Ronsoft on 9/16/2017.
 */

public class PersonDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "people.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "People";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PERSON_NAME = "name";
    public static final String COLUMN_PERSON_AGE = "age";
    public static final String COLUMN_PERSON_OCCUPATION = "occupation";
    public static final String COLUMN_PERSON_IMAGE = "image";


    public PersonDBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PERSON_NAME + " TEXT NOT NULL, " +
                COLUMN_PERSON_AGE + " TEXT NOT NULL, " +
                COLUMN_PERSON_OCCUPATION + " TEXT NOT NULL, " +
                COLUMN_PERSON_IMAGE + " TEXT NOT NULL);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // you can implement here migration process
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public void saveNewPerson(Person person) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PERSON_NAME, person.getName());
        values.put(COLUMN_PERSON_AGE, person.getAge());
        values.put(COLUMN_PERSON_OCCUPATION, person.getOccupation());
        values.put(COLUMN_PERSON_IMAGE, person.getImage());

        // insert
        db.insert(TABLE_NAME,null, values);
        db.close();
    }

    public List<Person> peopleList() {

        List<Person> personLinkedList = new LinkedList<>();
        String query = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Person person;

        if (cursor.moveToFirst()) {
            do {
                person = new Person();

                person.setName(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_NAME)));
                person.setAge(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_AGE)));
                person.setOccupation(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_OCCUPATION)));
                person.setImage(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_IMAGE)));
                personLinkedList.add(person);
            } while (cursor.moveToNext());
        }


        return personLinkedList;
    }



    public void deleteWeightData(long id, Context context, PersonAdapter adapter) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
// /      db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE id='"+id+"'");
//        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();
//
//        List<WeightData> newItems = weightDataList();
//        Collections.reverse(newItems);
//        adapter.clear();
//        adapter.addAll(newItems);
//        adapter.notifyDataSetChanged();


    }

    public void updateWeightData(long jobId, Context context, PersonAdapter adapter, View view) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        db.execSQL("UPDATE  "+TABLE_NAME+" SET weight ='"+newWeight+"', diff ='"+weightDiff+"'  WHERE id='"+id+"'");
//        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
//
//        if(weightDiff == 0){
//            TextView text = (TextView)view.findViewById(R.id.weightGainOrLooseTextView);
//            text.setTextColor(Color.parseColor("#808080"));
//            text.setText("0 lb");
//        }
//
//
//
//        List<WeightData> newItems = weightDataList();
//        Collections.reverse(newItems);
//        adapter.clear();
//        adapter.addAll(newItems);
//        adapter.notifyDataSetChanged();
//        db.close();


    }


}
