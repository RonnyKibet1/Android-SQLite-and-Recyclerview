package info.codestart.androidsqlitedatabase.Utils;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import info.codestart.androidsqlitedatabase.R;
import info.codestart.androidsqlitedatabase.UpdateRecordActivity;
import info.codestart.androidsqlitedatabase.model.Person;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private List<Person> mPeopleList;
    private Context mContext;
    private RecyclerView mRecyclerV;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView personNameTxtV;
        public TextView personAgeTxtV;
        public TextView personOccupationTxtV;
        public ImageView personImageImgV;


        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            personNameTxtV = (TextView) v.findViewById(R.id.name);
            personAgeTxtV = (TextView) v.findViewById(R.id.age);
            personOccupationTxtV = (TextView) v.findViewById(R.id.occupation);
            personImageImgV = (ImageView) v.findViewById(R.id.image);




        }
    }

    public void add(int position, Person person) {
        mPeopleList.add(position, person);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mPeopleList.remove(position);
        notifyItemRemoved(position);
    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public PersonAdapter(List<Person> myDataset, Context context, RecyclerView recyclerView) {
        mPeopleList = myDataset;
        mContext = context;
        mRecyclerV = recyclerView;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.single_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final Person person = mPeopleList.get(position);
        holder.personNameTxtV.setText("Name: " + person.getName());
        holder.personAgeTxtV.setText("Age: " + person.getAge());
        holder.personOccupationTxtV.setText("Occupation: " + person.getOccupation());
        Picasso.with(mContext).load(person.getImage()).placeholder(R.mipmap.ic_launcher).into(holder.personImageImgV);

        //listen to single view layout click
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Choose option");
                builder.setMessage("Update or delete user?");
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    //go to update activity
                        goToUpdateActivity(person.getId());

                    }
                });
                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PersonDBHelper dbHelper = new PersonDBHelper(mContext);
                        dbHelper.deletePersonRecord(person.getId(), mContext);

                        mPeopleList.remove(position);
                        mRecyclerV.removeViewAt(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, mPeopleList.size());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });


    }

    private void goToUpdateActivity(long personId){
        Intent goToUpdate = new Intent(mContext, UpdateRecordActivity.class);
        goToUpdate.putExtra("USER_ID", personId);
        mContext.startActivity(goToUpdate);
    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mPeopleList.size();
    }



}