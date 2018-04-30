package com.example.alexander.kurs_4_1.main.formScreen;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alexander.kurs_4_1.R;

/**
 * Created by Alexander on 07.01.2017.
 */

public class SelectionAdapter extends RecyclerView.Adapter<SelectionAdapter.ViewHolder> {
    private String[] mDataset;
    private Listener listener;
    private Context mContext;
    private String lastSelect;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public LinearLayout contaner;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.textView);
            contaner = (LinearLayout) v.findViewById(R.id.contaner);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SelectionAdapter(Context context, String[] myDataset) {
        mContext = context;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SelectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_for_list_selection, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        if(mDataset[position].equals(lastSelect)){
            holder.contaner.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.mTextView.setTextColor(Color.WHITE);
        } else {
            holder.contaner.setBackgroundColor(mContext.getResources().getColor(android.R.color.white));
            holder.mTextView.setTextColor(Color.BLACK);
        }

        holder.mTextView.setText(mDataset[position]);
        holder.contaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(mDataset[holder.getAdapterPosition()]);
                lastSelect = mDataset[holder.getAdapterPosition()];
                notifyDataSetChanged();
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    public interface Listener{
        void onClick(String level);
    }
}
