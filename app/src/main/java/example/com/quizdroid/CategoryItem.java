package example.com.quizdroid;

public class CategoryItem {

    int mBgColor;
    String mCategoryTitle;
    String mCategoryID;

    public CategoryItem(int imageId, String categoryTitle, String categoryID) {
        this.mBgColor = imageId;
        this.mCategoryTitle = categoryTitle;
        this.mCategoryID = categoryID;
    }

    public int getmBgColor() {
        return mBgColor;
    }

    public String getmCategoryTitle() {
        return mCategoryTitle;
    }

    public String getmCategoryID() {
        return mCategoryID;
    }
}
