package in.alaoui.horizontalinsideverticalrecyclerview;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import in.alaoui.horizontalinsideverticalrecyclerview.adapters.VerticalAdapter;
import in.alaoui.horizontalinsideverticalrecyclerview.models.ParentItem;


public class MainActivity extends ActionBarActivity {
    /**
     * Contains the String used as a tag for the Log.d
     */
    private static final String TAG = MainActivity.class.getSimpleName();

    public static int APP_WIDTH;
    public static int APP_HEIGHT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getScreenSize();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        List<ParentItem> myDataset = createItems();
        RecyclerView.Adapter mAdapter = new VerticalAdapter(this, myDataset, APP_WIDTH);
        mRecyclerView.setAdapter(mAdapter);
    }


    /**
     * Creates List of item to populate the parent Vertical RecyclerView
     * @return List of ParentItem
     */
    private List<ParentItem> createItems() {
        List<ParentItem> myDataset = new ArrayList<>();
        for(int i=0; i < 9; i++) {
            myDataset.add(new ParentItem("Number "+i));
        }
        return myDataset;
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


