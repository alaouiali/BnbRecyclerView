package in.alaoui.horizontalinsideverticalrecyclerview;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import in.alaoui.horizontalinsideverticalrecyclerview.models.ParentItem;


public class MainActivity extends ActionBarActivity {
    /**
     * Contains the String used as a tag for the Log.d
     */
    private static final String TAG = MainActivity.class.getSimpleName();

    public static int APP_WIDTH;
    public static int APP_HEIGHT;

    private List<ParentItem> myDataset = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private VerticalAdapter mAdapter;

    private boolean loadingFromServer = false;
    private int itemsListSize;
    private int lastVisibleItem;

    private List<Integer> childPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getScreenSize();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        myDataset = createMoreItems();
        mAdapter = new VerticalAdapter(this, myDataset, APP_WIDTH);
        mRecyclerView.setAdapter(mAdapter);

    }


    /**
     * Creates List of item to populate the parent Vertical RecyclerView
     * @return List of ParentItem
     */
    private List<ParentItem> createMoreItems() {

        List<ParentItem> dataset = new ArrayList<>();
        for(int i=0; i < 8; i++) {
            dataset.add(new ParentItem("Number "+i));
        }


        return dataset;
    }

    /**
     * Retrieves the window width and height
     */
    public void getScreenSize() {
        WindowManager w = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            Point size = new Point();
            w.getDefaultDisplay().getSize(size);
            APP_WIDTH = size.x;
            APP_HEIGHT = size.y;
        } else {
            Display d = w.getDefaultDisplay();
            APP_WIDTH = d.getWidth();
            APP_HEIGHT = d.getHeight();
        }
    }

}


