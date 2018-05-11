package example.com.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    private GridView mGridView;
    private CategoryAdapter mCategoryAdapter;
    private ArrayList<CategoryItem> mCategoryItems;
    private int[] mColors;
    private String[] mCategoryTitles;
    private String[] mCategoryID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        setUpCategoryItems();

        mGridView = findViewById(R.id.categories_list);
        mCategoryAdapter = new CategoryAdapter(this, R.layout.grid_view_item, mCategoryItems);
        mGridView.setAdapter(mCategoryAdapter);

    }

    private void setUpCategoryItems() {
        mCategoryItems = new ArrayList<>();
        mCategoryTitles = getResources().getStringArray(R.array.category_title);
        mCategoryID = getResources().getStringArray(R.array.category_ID);

        mColors = getResources().getIntArray(R.array.colors);

        for(int i = 0; i< mCategoryTitles.length; i++) {
            mCategoryItems.add(new CategoryItem(mColors[i], mCategoryTitles[i], mCategoryID[i]));
            Log.d("TAG", "Title\t" + mCategoryTitles[i] + "\tID\t" + mCategoryID[i]);
        }
    }
}
