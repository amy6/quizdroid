package example.com.quizdroid;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<CategoryItem> {

    static final String CATEGORY_COLOR = "CategoryColor";
    static final String CATEGORY_ID = "CategoryID";
    private Context mContext;
    private ArrayList<CategoryItem> mCategoryItems;

    CategoryAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CategoryItem> categoryItems) {
        super(context, resource, categoryItems);
        this.mContext = context;
        this.mCategoryItems = categoryItems;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        CategoryViewHolder categoryViewHolder;
        final CategoryItem categoryItem = mCategoryItems.get(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.grid_view_item, parent, false);
            categoryViewHolder = new CategoryViewHolder(convertView);
            convertView.setTag(categoryViewHolder);
        }
        categoryViewHolder = (CategoryViewHolder) convertView.getTag();
        categoryViewHolder.categoryImage.setBackgroundColor(categoryItem.getmBgColor());
        categoryViewHolder.categoryTitle.setText(categoryItem.getmCategoryTitle());
        categoryViewHolder.categoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent questionIntent = new Intent(mContext, QuestionActivity.class);
                questionIntent.putExtra(CATEGORY_ID, categoryItem.getmCategoryID());
                questionIntent.putExtra(CATEGORY_COLOR, categoryItem.getmBgColor());
                mContext.startActivity(questionIntent);
            }
        });
        return convertView;
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder{

        ImageView categoryImage;
        TextView categoryTitle;

        CategoryViewHolder(View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.category_image);
            categoryTitle = itemView.findViewById(R.id.category_title);
        }
    }
}
