package in.alaoui.horizontalinsideverticalrecyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import in.alaoui.horizontalinsideverticalrecyclerview.models.ChildItem;
import in.alaoui.horizontalinsideverticalrecyclerview.models.ParentItem;
import in.alaoui.horizontalinsideverticalrecyclerview.R;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {
    /**
     * Contains the String used as a tag for the Log.d
     */
    private static final String TAG = HorizontalAdapter.class.getSimpleName();
    private Context mContext;
    private List<ChildItem> mDataset;

    private static int mAppWidth;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView mImageView;
        public ViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.image);
            mImageView.getLayoutParams().width = (mAppWidth);
            mImageView.getLayoutParams().height = (mAppWidth);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public HorizontalAdapter(Context context, List<ChildItem> myDataset, int appWidth) {
        mDataset = myDataset;
        mContext = context;
        mAppWidth = appWidth;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HorizontalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element



        Log.d(TAG, "getText: " + mDataset.get(position).getText());
        Log.d(TAG, "getUrl: " + mDataset.get(position).getUrl());

        Picasso.with(mContext)
                .load(mDataset.get(position).getUrl())
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.place_holder_error)
                .into(holder.mImageView);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}