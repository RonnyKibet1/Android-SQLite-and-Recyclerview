package info.codestart.androidsqlitedatabase.Utils;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import info.codestart.androidsqlitedatabase.R;
import info.codestart.androidsqlitedatabase.model.Person;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private List<Person> mPeopleList;
    private Context mContext;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mJObIdTxtV;
        public TextView mPositionTitleTxtV;
        public TextView mOrganizationNameTxtV;


        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            mJObIdTxtV = (TextView) v.findViewById(R.id.userName);
            mPositionTitleTxtV = (TextView) v.findViewById(R.id.userAge);
            mOrganizationNameTxtV = (TextView) v.findViewById(R.id.userOccupation);


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
    public PersonAdapter(List<Person> myDataset, Context context) {
        mPeopleList = myDataset;
        mContext = context;
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
         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

        final Person job = mPeopleList.get(position);
        holder.mJObIdTxtV.setText(job.getName());
        holder.mPositionTitleTxtV.setText(job.getAge());
        holder.mOrganizationNameTxtV.setText(job.getOccupation());





    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mPeopleList.size();
    }



}