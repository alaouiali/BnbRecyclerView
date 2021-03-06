package in.alaoui.horizontalinsideverticalrecyclerview;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
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

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {
    /**
     * Contains the String used as a tag for the Log.d
     */
    private static final String TAG = VerticalAdapter.class.getSimpleName();
    private Context mContext;
    private String[] urls = {
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTqBvZfp5vUzdECuxydMqzkHbv8Io9kc_sGDh6Lb8t58ZEuTWfObw",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcR6YRCpLYw6EAsJ8R3HsV5PzmJwVrmA1vZH9eX6-KEPVgbvnmp1VA",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTK3k3Mlj_RJQjUU3obJ2K-jAVTS4z-7elTaDxT1k9Q70Kg3Msd",

            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSnD7v4HtlKQb2BWUoujS6W0T9I0NFcc9FjL9n7J2HnPcHszpUY",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSX_yWO9qRV-tDPJ6dw17tzGFX3hrzJ47gclEkCnNZBzh-CLIgBTw",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQFSLufkwkiJbh9Wds3iCmljxxCFjngOsiKh7Ru_G-gJkMZ1dK_",

            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_SJdCkLzFz-AM4hmj8fwQWLBbQ8uIe3C923IZAO2mcNdE8dCw",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjXskxWSam8FyCWND63SigsB6pMUg3GKfmPOJEWteahUexrPSB",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwGWksKf3P4nuVBOet_L75b_hgan_pnx-CNsuwOchVgZ-p2XGm",

            "https://c4.staticflickr.com/4/3366/4612778012_9c051789bf_b.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoG9_j2RwXoUZFERhNz-lkQyHCUOgEvoDDVMky9yOaj88Lsc44",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRxpM_iLl1d-MVOq5YT2LtHoxIqeU_H3_cDlkIVmAOYf0gVnV7g",

            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRLtZHrzluGj-EZcosXVni-Zmflqe4Fu1jGFSMVQAAzsdnS_2MeXw",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTKiUjsY-piPSuTA3mHfXAd7Zsg04m3lTw1IA1zKkJqnwKACiStwg",
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcROhycG7nOgvDzDOP2lBG37sk6wbHaYPbFX_pBx4FlbxtSM7Z2u",

            "https://c2.staticflickr.com/6/5099/5513125478_89d1729e3c_b.jpg",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTybyiNsOZrASdwsbcyl5SDh8aZyJdfVCjEJphTKA4Yf43dAfdknw",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTI7n06M_AHBFBkSwh7SLnC5OjEE6j0uSz-3mr5u_s8QA5SWjkk",

            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQUGJXi8BNyMSTEJcQHYqdl_8ABHd_ucuS0qeze8demczkzGUHbtA",
            "https://c3.staticflickr.com/7/6016/5984105136_7d5fa946b0_b.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYPbn6L7Hw2_Lw01e5biRojnlFiviS566cqEuiY9H_7Y_Kr2VxeQ",

            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcS-b3zNErmvMlbun8iDHOC4cZ6QC0sBchBIx6PsfFov_JSsMa4l",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGcl15mygqfmdcgCmPlxr00-a87LJvTuEWuFp2xg_XI82fhfC-WQ",
            "https://c2.staticflickr.com/8/7251/6904099452_939e1ac5f2_b.jpg",

            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmz_u5DklKmUN4zbHiWWuGz46g8avWA7ajMgoDdicB9JF3lmAA",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcR_lGkmwloEs9xZwJzzPZ7KlSp0oY5jTN-OtamC7rlEY8IhvGYO",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRuzn6Ke_rwtWvktu8NTnMw1q-RlnR3SKevN0ITO_q2mWsv9i0G"
    };
    private List<ChildItem> createChildItems(int firstItem, int lastItem) {
        List<ChildItem> myDataset = new ArrayList<>();
        for(int i=firstItem; i < lastItem; i++) {
            //Log.d(TAG, "firstItem: "+firstItem+" i: "+i+" lastItem: "+lastItem);
            myDataset.add(new ChildItem("Number "+i, urls[i]));
        }
        return myDataset;
    }

    private static int mAppWidth;

    private List<ParentItem> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewPager mViewPager;
        public ViewHolder(View v, Context context) {
            super(v);
            //Log.d(TAG, "ViewHolder");
            mTextView = (TextView) v.findViewById(R.id.text_bottom);
            mViewPager = (ViewPager) v.findViewById(R.id.view_pager);
            int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, v.getResources().getDisplayMetrics());
            mViewPager.getLayoutParams().height = (mAppWidth - px);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public VerticalAdapter(Context context, List<ParentItem> myDataset, int appWidth) {
        //Log.d(TAG, "VerticalAdapter");
        mDataset = myDataset;
        mContext = context;
        mAppWidth = appWidth;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public VerticalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        //Log.d(TAG, "onCreateViewHolder");
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertical_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v, mContext);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Log.d(TAG, "onBindViewHolder/position: " + position);

        holder.mTextView.setText(mDataset.get(position).getText());
        List<ChildItem> mChildDataset = createChildItems(0, 3);
        ImagePagerAdapter adapter = new ImagePagerAdapter(mChildDataset);

        holder.mViewPager.setAdapter(adapter);
        holder.mViewPager.setCurrentItem(mDataset.get(position).getPosition());
        holder.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int positionPager) {
                mDataset.get(position).setPosition(positionPager);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    /**
     * ImagePagerAdapter to display images
     */
    private class ImagePagerAdapter extends PagerAdapter {

        List<ChildItem> mData;

        public ImagePagerAdapter(List<ChildItem> data) {
            mData = data;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Context context = mContext;
            ImageView mImageView = new ImageView(context);
            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            Picasso.with(context)
                    .load(mData.get(position).getUrl())
                    .placeholder(R.drawable.place_holder)
                    .error(R.drawable.place_holder_error)
                    .into(mImageView);

            ((ViewPager) container).addView(mImageView, 0);
            return mImageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((ImageView) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((ImageView) object);
        }

        @Override
        public int getCount() {
            return mData.size();
        }
    }


    public class ItemPosition {
        int position;

        public int getPosition() {
            return position;
        }
        public void setPosition(int pos) {
            this.position = pos;
        }
    }


}