package info.codestart.androidsqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import info.codestart.androidsqlitedatabase.Utils.PersonDBHelper;
import info.codestart.androidsqlitedatabase.model.Person;

public class AddRecordActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mAgeEditText;
    private EditText mOccupationEditText;
    private EditText mImageEditText;

    private PersonDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        //init
        mNameEditText = (EditText)findViewById(R.id.userName);
        mAgeEditText = (EditText)findViewById(R.id.userAge);
        mOccupationEditText = (EditText)findViewById(R.id.userOccupation);
        mImageEditText = (EditText)findViewById(R.id.userProfileImageLink);

        //call the save person method
        savePerson();
    }

    private void savePerson(){
        String name = mNameEditText.getText().toString().trim();
        String age = mAgeEditText.getText().toString().trim();
        String occupation = mOccupationEditText.getText().toString().trim();
        String image = mImageEditText.getText().toString().trim();
        dbHelper = new PersonDBHelper(this);

        if(name.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a name", Toast.LENGTH_SHORT).show();
        }

        if(age.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter an age", Toast.LENGTH_SHORT).show();
        }

        if(occupation.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter an occupation", Toast.LENGTH_SHORT).show();
        }

        if(image.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter an image link", Toast.LENGTH_SHORT).show();
        }

        //create new person
        Person person = new Person(name, age, occupation, image);
        dbHelper.saveNewPerson(person);

    }
}
