package info.codestart.androidsqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import info.codestart.androidsqlitedatabase.Utils.PersonAdapter;
import info.codestart.androidsqlitedatabase.Utils.PersonDBHelper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private PersonDBHelper dbHelper;
    private PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize the variables
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //populate recyclerview
        populaterecyclerView();
    }

    private void populaterecyclerView(){
        dbHelper = new PersonDBHelper(this);
        adapter = new PersonAdapter(dbHelper.peopleList(), this);
        mRecyclerView.setAdapter(adapter);
    }
}
